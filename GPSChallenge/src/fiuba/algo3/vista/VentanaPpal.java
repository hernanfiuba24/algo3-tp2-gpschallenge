package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import javax.swing.JLabel;

public class VentanaPpal extends JFrame {

	private Image fondo;
	private JPanel contentPane;
	private Menu barraMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPpal frame = new VentanaPpal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		barraMenu = new Menu();
		setJMenuBar(barraMenu);

		JButton btnJugar = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonJugar.png")));
		btnJugar.setBorder(BorderFactory.createEmptyBorder());
		btnJugar.setContentAreaFilled(false);
		btnJugar.setBounds(141, 38, 153, 55);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaNiveles ventanaNivel = new VentanaNiveles();
				ventanaNivel.setVisible(true);
				/*VentanaJuego unaVentanaJuego = null;
				try {
					unaVentanaJuego = new VentanaJuego();
				} catch (ExcepcionEsquinaInvalida e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				unaVentanaJuego.setVisible(true);*/
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
		btnContinuarPartidaGuarda.setBounds(141, 104, 153, 55);
		btnContinuarPartidaGuarda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnContinuarPartidaGuarda);

		JButton btnSalir = new JButton(
				new ImageIcon(
						VentanaJuego.class
								.getResource("/fiuba/algo3/vista/imagenes/botonSalir.png")));
		btnSalir.setBorder(BorderFactory.createEmptyBorder());
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(141, 170, 153, 55);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPpal.class.getResource("/fiuba/algo3/vista/imagenes/FondoBandera.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
		
	}
}
