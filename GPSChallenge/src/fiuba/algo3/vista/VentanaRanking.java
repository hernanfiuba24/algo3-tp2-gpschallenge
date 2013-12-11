package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		btnMenu.setBounds(357, 204, 89, 23);
		getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal unaVentanaPpal = new VentanaPrincipal();
				unaVentanaPpal.setVisible(true);
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(357, 238, 89, 23);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 320, 258);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		ModeloTabla tabla = new ModeloTabla();
		for(int i = 0; i<puntajes.size(); i++){
	    tabla.agregarFila(Arrays.asList(puntajes.get(i).devolverNombre(), new Integer(puntajes.get(i).devolverValor()).toString()));
		}
		
		table = new JTable(tabla);
		scrollPane.setViewportView(table);
		
		JLabel imagenAnimada = new JLabel("");
		imagenAnimada.setIcon(new ImageIcon(VentanaRanking.class.getResource("/fiuba/algo3/vista/imagenes/imagenParaRanking1.gif")));
		imagenAnimada.setBounds(340, 77, 124, 59);
		getContentPane().add(imagenAnimada);
		
		JLabel imagenFondo = new JLabel("New label");
		imagenFondo.setIcon(new ImageIcon(VentanaRanking.class.getResource("/fiuba/algo3/vista/imagenes/background_flag_color.jpg")));
		imagenFondo.setBounds(0, 0, 474, 312);
		getContentPane().add(imagenFondo);		
	}
}
