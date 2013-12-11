package fiuba.algo3.vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
		btnAuto.setBounds(45, 202, 89, 23);
		getContentPane().add(btnAuto);
		
		JButton btnMoto = new JButton("Moto");
		btnMoto.setBounds(199, 202, 89, 23);
		getContentPane().add(btnMoto);
		
		JButton btnCamioneta = new JButton("Camioneta");
		btnCamioneta.setBounds(335, 202, 89, 23);
		getContentPane().add(btnCamioneta);
	}
}
