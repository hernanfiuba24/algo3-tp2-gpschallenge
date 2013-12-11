package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.persistencia.JuegoPersistencia;

public class VentanaPrincipal extends JFrame {


	private static final long serialVersionUID = 1L;
	
	private Image fondo;
	private JPanel contentPane;
	private Menu barraMenu;

	/**
	 * Lanza la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge");
		setBounds(100, 100, 490, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		barraMenu = new Menu();
		barraMenu.deshabilitarGuardar();
		setJMenuBar(barraMenu);

		JButton btnJugar = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonJugar.png")));
		btnJugar.setBorder(BorderFactory.createEmptyBorder());
		btnJugar.setContentAreaFilled(false);
		btnJugar.setBounds(165, 47, 153, 55);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreJugador = ingresoDeNombreJugador();
				VentanaSeleccionVehiculo ventanaSeleccionVehiculo = new VentanaSeleccionVehiculo(nombreJugador);
				ventanaSeleccionVehiculo.setVisible(true);
				dispose();

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnJugar);

		JButton btnContinuarPartidaGuarda = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonContinuarPartida.png")));
		btnContinuarPartidaGuarda.setBorder(BorderFactory.createEmptyBorder());
		btnContinuarPartidaGuarda.setContentAreaFilled(false);
		btnContinuarPartidaGuarda.setBounds(165, 113, 153, 55);
		btnContinuarPartidaGuarda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreJugador = JOptionPane
						.showInputDialog("Ingrese su nombre:");
				String ruta = "c:\\" + nombreJugador + ".xml";
				VentanaJuego unaVentanaJuego = null;
				Juego unJuego = null;
				try {
					unJuego = JuegoPersistencia.cargarGpsChallenge(ruta);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ExcepcionEsquinaInvalida e1) {
					e1.printStackTrace();
				} catch (ExcepcionJugadorYaAsignadoAlVehiculo e1) {
					e1.printStackTrace();
				}
				if (unJuego != null) {
					try {
						unaVentanaJuego = new VentanaJuego(nombreJugador,
								unJuego);
					} catch (ExcepcionEsquinaInvalida e) {
						e.printStackTrace();
					}
					unaVentanaJuego.setVisible(true);
					dispose();
				}
			}
		});
		contentPane.add(btnContinuarPartidaGuarda);

		JButton btnSalir = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonSalir.png")));
		btnSalir.setBorder(BorderFactory.createEmptyBorder());
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(165, 179, 153, 55);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class
				.getResource("/fiuba/algo3/vista/imagenes/FondoBandera.jpg")));
		lblNewLabel.setBounds(0, 0, 474, 289);
		contentPane.add(lblNewLabel);

	}
	
	public String ingresoDeNombreJugador(){
		String nombreJugador = "";
		while (nombreJugador.equalsIgnoreCase("")) {
			nombreJugador = JOptionPane.showInputDialog("Ingrese su nombre:");
		}
		return nombreJugador;
	}
}
