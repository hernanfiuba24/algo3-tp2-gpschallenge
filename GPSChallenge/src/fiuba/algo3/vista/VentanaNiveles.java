package fiuba.algo3.vista;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.BevelBorder;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class VentanaNiveles extends JFrame {
	
	private Menu barraMenu;

	/**
	 * Create the panel.
	 */
	public VentanaNiveles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		barraMenu = new Menu();
		setJMenuBar(barraMenu);
		
		JButton btnFacil = new JButton(new ImageIcon(
				VentanaJuego.class
				.getResource("/fiuba/algo3/vista/imagenes/botonFacil.png")));
		btnFacil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaJuego unaVentanaJuego = null;
				try {
					unaVentanaJuego = new VentanaJuego();
				} catch (ExcepcionEsquinaInvalida exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				}
				unaVentanaJuego.setVisible(true);
				dispose();
			}
		});
		btnFacil.setBorder(BorderFactory.createEmptyBorder());
		btnFacil.setContentAreaFilled(false);
		btnFacil.setBounds(141, 38, 153, 55);
		getContentPane().add(btnFacil);
		
		JButton btnIntermedio = new JButton(new ImageIcon(
				VentanaJuego.class
				.getResource("/fiuba/algo3/vista/imagenes/botonIntermedio.png")));
		btnIntermedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaJuego unaVentanaJuego = null;
				try {
					unaVentanaJuego = new VentanaJuego();
				} catch (ExcepcionEsquinaInvalida exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				}
				unaVentanaJuego.setVisible(true);
				dispose();
			}
		});
		btnIntermedio.setBorder(BorderFactory.createEmptyBorder());
		btnIntermedio.setContentAreaFilled(false);
		btnIntermedio.setBounds(141, 104, 153, 55);
		getContentPane().add(btnIntermedio);
		
		JButton btnDificil = new JButton(new ImageIcon(
				VentanaJuego.class
				.getResource("/fiuba/algo3/vista/imagenes/botonDificil.png")));
		btnDificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaJuego unaVentanaJuego = null;
				try {
					unaVentanaJuego = new VentanaJuego();
				} catch (ExcepcionEsquinaInvalida exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				}
				unaVentanaJuego.setVisible(true);
				dispose();
			}
		});
		btnDificil.setBorder(BorderFactory.createEmptyBorder());
		btnDificil.setContentAreaFilled(false);
		btnDificil.setBounds(141, 170, 153, 55);
		getContentPane().add(btnDificil);
		
		JButton btnVolver = new JButton(new ImageIcon(
				VentanaJuego.class
				.getResource("/fiuba/algo3/vista/imagenes/botonVolver.png")));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaPpal ventanaJuego = new VentanaPpal();
				ventanaJuego.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBorder(BorderFactory.createEmptyBorder());
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBounds(379, 211, 55, 50);
		getContentPane().add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPpal.class.getResource("/fiuba/algo3/vista/imagenes/FondoBandera.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		getContentPane().add(lblNewLabel);
		
		
		
	}
}
