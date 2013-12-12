package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPerdio extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaJuego ventanaACerrar;
	
	public VentanaPerdio(VentanaJuego ventanaParaCerrar) {
		this.ventanaACerrar = ventanaParaCerrar;
		
		getContentPane().setLayout(null);
		setBackground(Color.BLACK);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge");
		setBounds(100, 100, 490, 350);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VentanaPerdio.class.getResource("/fiuba/algo3/vista/imagenes/gameover.jpg")));
		lblNewLabel.setBounds(71, 11, 300, 52);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaPerdio.class.getResource("/fiuba/algo3/vista/imagenes/mecanico.png")));
		lblNewLabel_1.setBounds(10, 74, 275, 197);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnMenuPrincipal = new JButton(new ImageIcon(
				VentanaGano.class
				.getResource("/fiuba/algo3/vista/imagenes/botonMenu.png")));
		btnMenuPrincipal.setLocation(309, 104);
		btnMenuPrincipal.setSize(155, 60);
		btnMenuPrincipal.setBorder(BorderFactory.createEmptyBorder());
		btnMenuPrincipal.setContentAreaFilled(false);
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaACerrar.dispose();
				dispose();
				VentanaPrincipal unaVentanaPpal = new VentanaPrincipal();
				unaVentanaPpal.setVisible(true);
			}
		});
		getContentPane().add(btnMenuPrincipal);
		
		JButton btnSalir = new JButton(new ImageIcon(
				VentanaGano.class
				.getResource("/fiuba/algo3/vista/imagenes/botonSalir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalir.setLocation(309, 164);
		btnSalir.setSize(155, 60);
		btnSalir.setBorder(BorderFactory.createEmptyBorder());
		btnSalir.setContentAreaFilled(false);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			};
		});
		getContentPane().add(btnSalir);
	}


}
