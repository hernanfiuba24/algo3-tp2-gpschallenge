package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fiuba.algo3.modelo.puntaje.Puntaje;
import fiuba.algo3.persistencia.JuegoPersistencia;

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
		Ganaste.setBounds(65, 11, 359, 108);
		getContentPane().add(Ganaste);

		JLabel BanderaGif = new JLabel(new ImageIcon(
				VentanaGano.class
						.getResource("/fiuba/algo3/vista/imagenes/flags.gif")));
		BanderaGif.setBounds(10, 130, 269, 157);
		getContentPane().add(BanderaGif);

		JButton btnMenuPrincipal = new JButton("Menu");
		btnMenuPrincipal.setLocation(324, 152);
		btnMenuPrincipal.setSize(100, 32);
//		btnMenuPrincipal.setBorder(BorderFactory.createEmptyBorder());
//		btnMenuPrincipal.setContentAreaFilled(false);
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPpal unaVentanaPpal = new VentanaPpal();
				unaVentanaPpal.setVisible(true);
			}
		});
		getContentPane().add(btnMenuPrincipal);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setLocation(324, 239);
		btnSalir.setSize(100, 32);
//		btnSalir.setBorder(BorderFactory.createEmptyBorder());
//		btnSalir.setContentAreaFilled(false);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			};
		});
		getContentPane().add(btnSalir);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.setBounds(324, 195, 100, 32);
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
