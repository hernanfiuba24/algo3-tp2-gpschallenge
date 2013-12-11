package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fiuba.algo3.modelo.puntaje.Puntaje;

public class VentanaRanking extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	
	public VentanaRanking(List<Puntaje> puntajes) {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ranking");
		setBounds(100, 100, 490, 350);
		getContentPane().setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(375, 230, 89, 23);
		getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPpal unaVentanaPpal = new VentanaPpal();
				unaVentanaPpal.setVisible(true);
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(375, 264, 89, 23);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 29, 320, 258);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		ModeloTabla tabla = new ModeloTabla();
		for(int i = 0; i<puntajes.size(); i++){
	    tabla.agregarFila(Arrays.asList(puntajes.get(i).devolverNombre(), new Integer(puntajes.get(i).devolverValor()).toString()));
		}
		
		table = new JTable(tabla);
		scrollPane.setViewportView(table);
		
	}
}
