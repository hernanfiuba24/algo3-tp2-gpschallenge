package fiuba.algo3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;

import fiuba.algo3.controlador.ControladorJuego;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.persistencia.JuegoPersistencia;
public class VentanaJuego extends JFrame implements KeyListener, Observer {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Menu barraMenu;
	private VentanaMapa ventanaMapa;
	private JPanel panelObstaculos;
	private PanelInformacion panelInformacion;
	private boolean seGuardoJuego = false;
	private ControladorJuego unControladorJuego;
	private Juego unJuego;


	/**
	 * Create the frame.
	 * 
	 * @throws ExcepcionEsquinaInvalida
	 */
	public VentanaJuego(String unNombreDeJugador, Juego juego)
			throws ExcepcionEsquinaInvalida {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge");
		setBounds(100, 100, 881, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setFocusable(true);
		this.unJuego = juego;
		this.unJuego.addObserver(this);
		contentPane.setLayout(null);
		
		ventanaMapa = new VentanaMapa(this.unJuego.devolverMapa(), this.unJuego);
		ventanaMapa.setBounds(10, 5, 660, 695);
		contentPane.add(ventanaMapa);
		ventanaMapa.setLayout(null);

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
				VentanaPrincipal unaVentanaPpal = new VentanaPrincipal();
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
					System.exit(0);
				}

			}
		});
		btnSalirMapa.setBounds(19, 632, 151, 58);
		panelInformacion.add(btnSalirMapa);
		btnMenuMapa.setBounds(19, 569, 151, 62);
		panelInformacion.add(btnMenuMapa);

		JButton btnGuardarMapa = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonGuardarMapa.png")));
		btnGuardarMapa.setBorder(BorderFactory.createEmptyBorder());
		btnGuardarMapa.setContentAreaFilled(false);
		final String tipoJuego = "C:\\"
				+ juego.devolverJugador().devolverNombre() + ".xml";

		btnGuardarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					JuegoPersistencia.guardarGpsChallenge(tipoJuego, unJuego);
				} catch (DOMException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (ExcepcionEsquinaInvalida e) {
					e.printStackTrace();
				}

				seGuardoJuego = true;
				JOptionPane.showMessageDialog(null, "Partida Guardada");
			}
		});
		btnGuardarMapa.setBounds(19, 510, 151, 50);
		panelInformacion.add(btnGuardarMapa);

	
		barraMenu = new Menu(this);
		setJMenuBar(barraMenu);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			this.ventanaMapa.dibujarExtras();
		} catch (ExcepcionEsquinaInvalida e) {
			e.printStackTrace();
		}
		this.ventanaMapa.dibujarVisibilidad(
				(((Jugador) arg).devolverPosicionXVehiculo()- 1)
						* (40 + 35), ((((Jugador) arg).devolverPosicionYVehiculo() - 1) * (40 + 42)));
		this.panelInformacion.actualizarMovimientos(((Jugador) arg)
				.devolverMovimientosHechos());
		this.panelInformacion.actualizarMovimientosRestantes(this.unJuego.devolverMovimientosRestantes());
		this.panelInformacion.actualizarVehiculo(((Jugador) arg)
				.devolverVehiculo());
		if (this.unJuego.seTermino()) {
			this.ventanaMapa.visualizarMapaEntero();
			JuegoPersistencia.cargarPuntajes("C:\\Ranking.xml");
			JuegoPersistencia.guardarPuntajes(this.unJuego);
			TreeMap<Integer, String> puntajesTotales = JuegoPersistencia.devolverRankingPuntajes();

			VentanaGano ventanaGano = new VentanaGano(puntajesTotales, this);
			ventanaGano.setVisible(true);
		}
		if (this.unJuego.perdio() == true){
			this.ventanaMapa.visualizarMapaEntero();
			VentanaPerdio ventanaPerdio = new VentanaPerdio(this);
			ventanaPerdio.setVisible(true);
		}

	}
	
	public void guardarJuego(){
		final String tipoJuego = "C:\\"
				+ this.unJuego.devolverNombreJugador() + ".xml";

		try {
			JuegoPersistencia.guardarGpsChallenge(tipoJuego, unJuego);
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (ExcepcionEsquinaInvalida e) {
			e.printStackTrace();
		}
		seGuardoJuego = true;
		JOptionPane.showMessageDialog(null, "Partida Guardada");
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
