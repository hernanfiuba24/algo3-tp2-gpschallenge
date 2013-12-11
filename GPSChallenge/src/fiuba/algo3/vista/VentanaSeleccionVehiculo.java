package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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

	public VentanaSeleccionVehiculo(){
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
		
		JLabel lblAuto = new JLabel("");
		lblAuto.setIcon(new ImageIcon(VentanaSeleccionVehiculo.class.getResource("/fiuba/algo3/vista/imagenes/autoGrande.png")));
		lblAuto.setBounds(10, 89, 169, 102);
		getContentPane().add(lblAuto);
		
		JLabel lblMoto = new JLabel("");
		lblMoto.setIcon(new ImageIcon(VentanaSeleccionVehiculo.class.getResource("/fiuba/algo3/vista/imagenes/motoGrande.png")));
		lblMoto.setBounds(189, 89, 101, 102);
		getContentPane().add(lblMoto);
		
		JLabel lblCamioneta = new JLabel("");
		lblCamioneta.setIcon(new ImageIcon(VentanaSeleccionVehiculo.class.getResource("/fiuba/algo3/vista/imagenes/camionetaGrande.png")));
		lblCamioneta.setBounds(300, 89, 153, 102);
		getContentPane().add(lblCamioneta);
		
		JButton btnAuto = new JButton("Auto");
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int posicionInicialVehiculo = unRandomizador
						.obtenerNumeroEntre(1, 3);
				Auto unAuto = new Auto(new Esquina(new Posicion(
						posicionInicialVehiculo, 3)));
				iniciarVentanaNiveles(unAuto);
			}
		});
		btnAuto.setBounds(45, 202, 89, 23);
		getContentPane().add(btnAuto);
		
		JButton btnMoto = new JButton("Moto");
		btnMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int posicionInicialVehiculo = unRandomizador
						.obtenerNumeroEntre(1, 3);
				Moto unaMoto = new Moto(new Esquina(new Posicion(
						posicionInicialVehiculo, 3)));
				iniciarVentanaNiveles(unaMoto);
			}
		});
		btnMoto.setBounds(199, 202, 89, 23);
		getContentPane().add(btnMoto);
		
		JButton btnCamioneta = new JButton("Camioneta");
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int posicionInicialVehiculo = unRandomizador
						.obtenerNumeroEntre(1, 3);
				Camioneta unaCamioneta = new Camioneta(new Esquina(new Posicion(
						posicionInicialVehiculo, 3)));
				iniciarVentanaNiveles(unaCamioneta);
			}
		});
		btnCamioneta.setBounds(335, 202, 89, 23);
		getContentPane().add(btnCamioneta);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaSeleccionVehiculo.class.getResource("/fiuba/algo3/vista/imagenes/FondoBandera.jpg")));
		label.setBounds(0, 0, 474, 290);
		getContentPane().add(label);
	}

	public void iniciarVentanaNiveles(Vehiculo unVehiculo) {
		VentanaNiveles ventanaNivel = new VentanaNiveles(unVehiculo);
		ventanaNivel.setVisible(true);
		dispose();
	}
}
