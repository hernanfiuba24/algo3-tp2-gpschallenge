package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.randomizador.RandomizadorImplementacion;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class VentanaSeleccionVehiculo extends JFrame {

	private static final long serialVersionUID = 1L;

	private Menu barraMenu;
	private String nombreJugador;
	private JTextField txtSelccioneElVehiculo;

	public VentanaSeleccionVehiculo(String nombre){
		this.nombreJugador = nombre;
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gps Challenge");
		setBounds(100, 100, 490, 350);
		getContentPane().setLayout(null);
		
		final RandomizadorImplementacion unRandomizador = new RandomizadorImplementacion();
		
		barraMenu = new Menu();
		barraMenu.deshabilitarGuardar();
		setJMenuBar(barraMenu);
		
		JButton lblAuto = new JButton();
		lblAuto.setIcon(new ImageIcon(VentanaSeleccionVehiculo.class.getResource("/fiuba/algo3/vista/imagenes/autoGrande.png")));
		lblAuto.setBounds(10, 89, 169, 102);
		lblAuto.setBorder(BorderFactory.createEmptyBorder());
		lblAuto.setContentAreaFilled(false);
		lblAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int posicionInicialVehiculo = unRandomizador
						.obtenerNumeroEntre(1, 3);
				Auto unAuto = new Auto(new Esquina(new Posicion(
						posicionInicialVehiculo, 3)));
				iniciarVentanaNiveles(unAuto, nombreJugador);
			}
		});
		getContentPane().add(lblAuto);
		
		JButton lblMoto = new JButton();
		lblMoto.setIcon(new ImageIcon(VentanaSeleccionVehiculo.class.getResource("/fiuba/algo3/vista/imagenes/motoGrande.png")));
		lblMoto.setBounds(189, 89, 101, 102);
		lblMoto.setBorder(BorderFactory.createEmptyBorder());
		lblMoto.setContentAreaFilled(false);
		lblMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int posicionInicialVehiculo = unRandomizador
						.obtenerNumeroEntre(1, 3);
				Moto unaMoto = new Moto(new Esquina(new Posicion(
						posicionInicialVehiculo, 3)));
				iniciarVentanaNiveles(unaMoto, nombreJugador);
			}
		});
		getContentPane().add(lblMoto);
		
		JButton lblCamioneta = new JButton();
		lblCamioneta.setIcon(new ImageIcon(VentanaSeleccionVehiculo.class.getResource("/fiuba/algo3/vista/imagenes/camionetaGrande.png")));
		lblCamioneta.setBounds(300, 89, 153, 102);
		lblCamioneta.setBorder(BorderFactory.createEmptyBorder());
		lblCamioneta.setContentAreaFilled(false);
		lblCamioneta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int posicionInicialVehiculo = unRandomizador
						.obtenerNumeroEntre(1, 3);
				Camioneta unaCamioneta = new Camioneta(new Esquina(new Posicion(
						posicionInicialVehiculo, 3)));
				iniciarVentanaNiveles(unaCamioneta, nombreJugador);
			}
		});
		getContentPane().add(lblCamioneta);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaSeleccionVehiculo.class.getResource("/fiuba/algo3/vista/imagenes/FondoBandera.jpg")));
		label.setBounds(0, 0, 474, 290);
		getContentPane().add(label);
	}

	public void iniciarVentanaNiveles(Vehiculo unVehiculo, String nombreJugador) {
		VentanaNiveles ventanaNivel = new VentanaNiveles(unVehiculo, nombreJugador);
		ventanaNivel.setVisible(true);
		dispose();
	}
}
