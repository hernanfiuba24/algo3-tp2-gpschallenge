package fiuba.algo3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.controlador.ControladorJuego;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.juego.Juego;

public class VentanaJuego extends JFrame implements KeyListener, Observer {

	private JPanel contentPane;
	private PanelMapa panelMapa;
	private JPanel panelObstaculos;
	private PanelInformacion panelInformacion;
	//private final Action action = new SwingAction();
	private boolean seGuardoJuego = false;
	private ControladorJuego unControladorJuego;
	private Juego unJuego;

	// private VistaVisibilidad unaVistaVisibilidad;

	/**
	 * Create the frame.
	 * 
	 * @throws ExcepcionEsquinaInvalida
	 */
	public VentanaJuego(String unNombreDeJugador, Juego unJuego) throws ExcepcionEsquinaInvalida {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge");
		setBounds(100, 100, 881, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setFocusable(true);
		this.unJuego = unJuego;
		this.unJuego.addObserver(this);
		// this.unaVistaVisibilidad = new
		// VistaVisibilidad((unJuego.devolverJugador().devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionFila()-1)*(40+35),((unJuego.devolverJugador().devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionColumna()-1)*(40+42)));

		panelMapa = new PanelMapa(this.unJuego.devolverMapa(), this.unJuego);
		panelMapa.setBounds(5, 5, 660, 730);
		contentPane.add(panelMapa);
		panelMapa.setLayout(null);

		panelObstaculos = new JPanel();
		panelObstaculos.setOpaque(false);
		panelObstaculos.setBounds(5, 5, 660, 730);

		panelInformacion = new PanelInformacion();
		panelInformacion.setBounds(675, 5, 180, 713);
		panelInformacion.setNombreJugador(unNombreDeJugador);
		contentPane.add(panelInformacion);
		panelInformacion.setLayout(null);

		this.unControladorJuego = new ControladorJuego(this.unJuego);		
		this.addKeyListener(unControladorJuego.getKeyListener());

		JButton btnMenuMapa = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonMenuMapa.png")));
		btnMenuMapa.setBorder(BorderFactory.createEmptyBorder());
		btnMenuMapa.setContentAreaFilled(false);
		btnMenuMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPpal unaVentanaPpal = new VentanaPpal();
				unaVentanaPpal.setVisible(true);
			}
		});

		JButton btnSalirMapa = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonSalirMapa.png")));
		btnSalirMapa.setBorder(BorderFactory.createEmptyBorder());
		btnSalirMapa.setContentAreaFilled(false);
		btnSalirMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int eleccion = 0;
				if (!seGuardoJuego) {
					eleccion = JOptionPane.showConfirmDialog(null,
							"Desea salir sin guardar?");
				}
				if (eleccion == 0) {
					// JOptionPane.showMessageDialog(null,
					// "Saliendo del GPSChallenge...");
					System.exit(0);
				}

			}
		});
		btnSalirMapa.setBounds(19, 644, 151, 58);
		panelInformacion.add(btnSalirMapa);
		btnMenuMapa.setBounds(19, 510, 151, 62);
		panelInformacion.add(btnMenuMapa);

		JButton btnGuardarMapa = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonGuardarMapa.png")));
		btnGuardarMapa.setBorder(BorderFactory.createEmptyBorder());
		btnGuardarMapa.setContentAreaFilled(false);
		btnGuardarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// EN ESTA PARTE SE LLAMARIA AL METODO QUE SE ENCARGA DE LA
				// PERSISITENCIA
				seGuardoJuego = true;
				JOptionPane.showMessageDialog(null, "Guardando partida...");
			}
		});
		btnGuardarMapa.setBounds(19, 583, 151, 50);
		panelInformacion.add(btnGuardarMapa);
	}

	/*private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}*/

	@Override
	public void update(Observable o, Object arg) {
		this.panelMapa.dibujarExtras();
		//this.panelMapa.dibujarVehiculo(((Jugador)arg).devolverVehiculo());
		this.panelMapa.dibujarVisibilidad((((Jugador)arg).devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionColumna()-1)*(40+35),((((Jugador)arg).devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionFila()-1)*(40+42)));
		this.panelInformacion.actualizarMovimientos(((Jugador)arg).devolverMovimientosHechos());
		this.panelInformacion.actualizarVehiculo(((Jugador)arg).devolverVehiculo());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
