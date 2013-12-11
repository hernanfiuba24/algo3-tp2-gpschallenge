package fiuba.algo3.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.juego.JuegoDificil;
import fiuba.algo3.modelo.juego.JuegoFacil;
import fiuba.algo3.modelo.juego.JuegoIntermedio;
import fiuba.algo3.modelo.randomizador.RandomizadorImplementacion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class VentanaNiveles extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Menu barraMenu;
	private String nombreDeJugador;


	public VentanaNiveles(final Vehiculo unVehiculo, String nombreJugador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge");
		setBounds(100, 100, 490, 350);
		getContentPane().setLayout(null);

		final RandomizadorImplementacion unRandomizador = new RandomizadorImplementacion();

		barraMenu = new Menu();
		barraMenu.deshabilitarGuardar();
		setJMenuBar(barraMenu);

		this.nombreDeJugador = nombreJugador;
//		while (nombreJugador.equalsIgnoreCase("")) {
//			nombreJugador = JOptionPane.showInputDialog("Ingrese su nombre:");
//		}

		JButton btnFacil = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonFacil.png")));
		btnFacil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaJuego unaVentanaJuego = null;
				try {
					int posicionInicialVehiculo = unRandomizador
							.obtenerNumeroEntre(1, 3);
					int posicionInicialBandera = unRandomizador
							.obtenerNumeroEntre(1, 3);
					unVehiculo.setearEsquina(new Esquina(new Posicion(posicionInicialVehiculo, 1)));
					unaVentanaJuego = new VentanaJuego(nombreDeJugador,
							new JuegoFacil(nombreDeJugador, 3, new Posicion(
									posicionInicialBandera, 1), unVehiculo));
				} catch (ExcepcionEsquinaInvalida exc) {
					exc.printStackTrace();
				} catch (ExcepcionJugadorYaAsignadoAlVehiculo e1) {
					e1.printStackTrace();
				}
				unaVentanaJuego.setVisible(true);
				dispose();
			}
		});
		btnFacil.setBorder(BorderFactory.createEmptyBorder());
		btnFacil.setContentAreaFilled(false);
		btnFacil.setBounds(165, 47, 153, 55);
		getContentPane().add(btnFacil);

		JButton btnIntermedio = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonIntermedio.png")));
		btnIntermedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaJuego unaVentanaJuego = null;
				try {
					int posicionInicialVehiculo = unRandomizador
							.obtenerNumeroEntre(1, 5);
					int posicionInicialBandera = unRandomizador
							.obtenerNumeroEntre(1, 5);
					unVehiculo.setearEsquina(new Esquina(new Posicion(posicionInicialVehiculo, 1)));
					unaVentanaJuego = new VentanaJuego(nombreDeJugador,
							new JuegoIntermedio(nombreDeJugador, 5, new Posicion(posicionInicialBandera, 5), unVehiculo));
				} catch (ExcepcionEsquinaInvalida exc) {
					exc.printStackTrace();
				} catch (ExcepcionJugadorYaAsignadoAlVehiculo e1) {
					e1.printStackTrace();
				}
				unaVentanaJuego.setVisible(true);
				dispose();
			}
		});
		btnIntermedio.setBorder(BorderFactory.createEmptyBorder());
		btnIntermedio.setContentAreaFilled(false);
		btnIntermedio.setBounds(165, 113, 153, 55);
		getContentPane().add(btnIntermedio);

		JButton btnDificil = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonDificil.png")));
		btnDificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaJuego unaVentanaJuego = null;
				try {
					int posicionInicialVehiculo = unRandomizador
							.obtenerNumeroEntre(1, 8);
					int posicionInicialBandera = unRandomizador
							.obtenerNumeroEntre(1, 8);
					unVehiculo.setearEsquina(new Esquina(new Posicion(posicionInicialVehiculo, 1)));
					unaVentanaJuego = new VentanaJuego(nombreDeJugador,
							new JuegoDificil(nombreDeJugador, 8, new Posicion(
									posicionInicialBandera, 8), unVehiculo));
				} catch (ExcepcionEsquinaInvalida exc) {
					exc.printStackTrace();
				} catch (ExcepcionJugadorYaAsignadoAlVehiculo e1) {
					e1.printStackTrace();
				}
				unaVentanaJuego.setVisible(true);
				dispose();
			}
		});
		btnDificil.setBorder(BorderFactory.createEmptyBorder());
		btnDificil.setContentAreaFilled(false);
		btnDificil.setBounds(165, 179, 153, 55);
		getContentPane().add(btnDificil);

		JButton btnVolver = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonVolver.png")));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaPrincipal ventanaJuego = new VentanaPrincipal();
				ventanaJuego.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBorder(BorderFactory.createEmptyBorder());
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBounds(409, 228, 55, 50);
		getContentPane().add(btnVolver);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class
				.getResource("/fiuba/algo3/vista/imagenes/FondoBandera.jpg")));
		lblNewLabel.setBounds(0, 0, 474, 289);
		getContentPane().add(lblNewLabel);

	}
}
