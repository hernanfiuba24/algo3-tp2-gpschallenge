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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Dimension;

public class VentanaJuego extends JFrame implements KeyListener, Observer {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private VentanaMapa ventanaMapa;
	private JPanel panelObstaculos;
	private PanelInformacion panelInformacion;
	// private final Action action = new SwingAction();
	private boolean seGuardoJuego = false;
	private ControladorJuego unControladorJuego;
	private Juego unJuego;

	// private VistaVisibilidad unaVistaVisibilidad;

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
		contentPane.setLayout(null);

		setFocusable(true);
		this.unJuego = juego;
		this.unJuego.addObserver(this);
		// this.unaVistaVisibilidad = new
		// VistaVisibilidad((unJuego.devolverJugador().devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionFila()-1)*(40+35),((unJuego.devolverJugador().devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionColumna()-1)*(40+42)));

		ventanaMapa = new VentanaMapa(this.unJuego.devolverMapa(), this.unJuego);
		ventanaMapa.setBounds(5, 5, 660, 730);
		contentPane.add(ventanaMapa);
		ventanaMapa.setLayout(null);

		// ObservadorDeVehiculos observadorDeVehiculos = new
		// ObservadorDeVehiculos(this.panelMapa);
		// this.unJuego.devolverJugador().devolverVehiculo().agregarObservador(observadorDeVehiculos);

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
					// JOptionPane.showMessageDialog(null,
					// "Saliendo del GPSChallenge...");
					System.exit(0);
				}

			}
		});
		btnSalirMapa.setBounds(19, 644, 151, 58);
		panelInformacion.add(btnSalirMapa);
		btnMenuMapa.setBounds(19, 571, 151, 62);
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
		
		JLabel etiquetaLeyenda = new JLabel("Leyenda");
		etiquetaLeyenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		etiquetaLeyenda.setBounds(10, 278, 71, 14);
		panelInformacion.add(etiquetaLeyenda);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(10, 303, 120, 143);
		panelInformacion.add(panel);
		
		JLabel leyendaSorpresa = new JLabel("Sorpresa");
		leyendaSorpresa.setPreferredSize(new Dimension(100, 30));
		leyendaSorpresa.setBounds(new Rectangle(6, 0, 0, 0));
		leyendaSorpresa.setHorizontalAlignment(SwingConstants.LEFT);
		leyendaSorpresa.setVerticalAlignment(SwingConstants.BOTTOM);
		leyendaSorpresa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		leyendaSorpresa.setIcon(new ImageIcon(VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png")));
		panel.add(leyendaSorpresa);
		
		JLabel leyendaPiquete = new JLabel("Piquete");
		leyendaPiquete.setPreferredSize(new Dimension(100, 30));
		leyendaPiquete.setIcon(new ImageIcon(VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/piquete.png")));
		leyendaPiquete.setVerticalAlignment(SwingConstants.BOTTOM);
		leyendaPiquete.setHorizontalAlignment(SwingConstants.LEFT);
		leyendaPiquete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(leyendaPiquete);
		
		JLabel leyendaPolicia = new JLabel("Policia");
		leyendaPolicia.setPreferredSize(new Dimension(100, 30));
		leyendaPolicia.setIcon(new ImageIcon(VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/policia.png")));
		leyendaPolicia.setVerticalAlignment(SwingConstants.BOTTOM);
		leyendaPolicia.setHorizontalAlignment(SwingConstants.LEFT);
		leyendaPolicia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(leyendaPolicia);
		
		JLabel leyendaPozo = new JLabel("Pozo");
		leyendaPozo.setPreferredSize(new Dimension(100, 30));
		leyendaPozo.setIcon(new ImageIcon(VentanaJuego.class.getResource("/fiuba/algo3/vista/imagenes/pozo.png")));
		leyendaPozo.setVerticalAlignment(SwingConstants.BOTTOM);
		leyendaPozo.setHorizontalAlignment(SwingConstants.LEFT);
		leyendaPozo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(leyendaPozo);
	}

	/*
	 * private class SwingAction extends AbstractAction { public SwingAction() {
	 * putValue(NAME, "SwingAction"); putValue(SHORT_DESCRIPTION,
	 * "Some short description"); }
	 * 
	 * public void actionPerformed(ActionEvent e) { } }
	 */

	@Override
	public void update(Observable o, Object arg) {
		try {
			this.ventanaMapa.dibujarExtras();
		} catch (ExcepcionEsquinaInvalida e) {
			e.printStackTrace();
		}
		// this.panelMapa.dibujarVehiculo(((Jugador)arg).devolverVehiculo());
		this.ventanaMapa.dibujarVisibilidad(
				(((Jugador) arg).devolverVehiculo().devolverEsquina()
						.devolverPosicion().devolverPosicionColumna() - 1)
						* (40 + 35), ((((Jugador) arg).devolverVehiculo()
						.devolverEsquina().devolverPosicion()
						.devolverPosicionFila() - 1) * (40 + 42)));
		this.panelInformacion.actualizarMovimientos(((Jugador) arg)
				.devolverMovimientosHechos());
		this.panelInformacion.actualizarVehiculo(((Jugador) arg)
				.devolverVehiculo());
		if (this.unJuego.seTermino()) {
			this.ventanaMapa.visualizarMapaEntero();
			JuegoPersistencia.cargarPuntajes("C:\\Ranking.xml");
			JuegoPersistencia.guardarPuntajes(this.unJuego);
			
			TreeMap<Integer, String> puntajesTotales = JuegoPersistencia.devolverRankingPuntajes();

			VentanaGano ventanaGano = new VentanaGano(puntajesTotales);
			ventanaGano.setVisible(true);
			// JOptionPane.showMessageDialog(null, "Ganaste", "GpsChallenge",
			// 1);
			dispose();
		}

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
