package fiuba.algo3.vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class VentanaRanking extends JFrame {
	
	public VentanaRanking() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ranking");
		setBounds(100, 100, 490, 350);
		getContentPane().setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(375, 230, 89, 23);
		getContentPane().add(btnMenu);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(375, 264, 89, 23);
		getContentPane().add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 357, 290);
		getContentPane().add(scrollPane);
		
	}
}
