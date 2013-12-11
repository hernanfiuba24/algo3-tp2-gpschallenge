package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fiuba.algo3.modelo.puntaje.Puntaje;
import fiuba.algo3.persistencia.JuegoPersistencia;
import javax.swing.SwingConstants;

public class VentanaGano extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaGano(TreeMap<Integer, String> puntajesTotales) {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GPS Challenge");
		setBounds(100, 100, 490, 350);
		getContentPane().setLayout(null);

		JLabel Ganaste = new JLabel(
				new ImageIcon(VentanaGano.class
						.getResource("/fiuba/algo3/vista/imagenes/ganaste.png")));
		Ganaste.setBounds(103, 0, 279, 108);
		getContentPane().add(Ganaste);

		JLabel BanderaGif = new JLabel(new ImageIcon(
				VentanaGano.class
						.getResource("/fiuba/algo3/vista/imagenes/flags.gif")));
		BanderaGif.setBounds(10, 102, 289, 185);
		getContentPane().add(BanderaGif);

		JButton btnMenuPrincipal = new JButton(new ImageIcon(
				VentanaGano.class
				.getResource("/fiuba/algo3/vista/imagenes/botonMenu.png")));
		btnMenuPrincipal.setLocation(309, 121);
		btnMenuPrincipal.setSize(155, 60);
		btnMenuPrincipal.setBorder(BorderFactory.createEmptyBorder());
		btnMenuPrincipal.setContentAreaFilled(false);
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnSalir.setLocation(309, 222);
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
		
		JButton btnRanking = new JButton(new ImageIcon(VentanaGano.class.getResource("/fiuba/algo3/vista/imagenes/botonRanking.png")));
		btnRanking.setBounds(304, 171, 165, 60);
		btnRanking.setBorder(BorderFactory.createEmptyBorder());
		btnRanking.setContentAreaFilled(false);
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				List<Puntaje> puntajes = JuegoPersistencia.devolverPuntajes();
				VentanaRanking unaVentanaRanking = new VentanaRanking(puntajes);
				unaVentanaRanking.setVisible(true);
			}
		});
		getContentPane().add(btnRanking);

	}
}
