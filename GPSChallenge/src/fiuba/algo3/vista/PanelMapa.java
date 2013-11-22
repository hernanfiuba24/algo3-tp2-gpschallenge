package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMapa extends JPanel /* implements KeyListener */{

	private JLabel auto;
	// private ImageIcon bgImage;
	private int posX = 0;
	private int posY = 0;

	public PanelMapa(int dimensionFila, int dimensionColumna){

		setLayout(null);
		// addKeyListener(this);
		// setFocusable(true);
		// setFocusTraversalKeysEnabled(false);

		auto = new JLabel("");
		auto.setIcon(new ImageIcon(PanelMapa.class
				.getResource("/fiuba/algo3/vista/imagenes/car.png")));
		auto.setBackground(new Color(0, 0, 139));
		auto.setBounds(0, 0, 32, 38);
		add(auto);
		
		this.dibujarMapa(dimensionFila, dimensionColumna);

//		JButton btnNewButton = new JButton("");
//		btnNewButton.setBackground(new Color(50, 205, 50));
//		btnNewButton.setBounds(50, 35, 89, 80);
//		add(btnNewButton);
//
//		JButton button = new JButton("");
//		button.setBackground(new Color(50, 205, 50));
//		button.setBounds(194, 35, 89, 80);
//		add(button);
//
//		JButton button_1 = new JButton("");
//		button_1.setBackground(new Color(50, 205, 50));
//		button_1.setBounds(482, 35, 89, 80);
//		add(button_1);
//
//		JButton button_2 = new JButton("");
//		button_2.setBackground(new Color(50, 205, 50));
//		button_2.setBounds(338, 35, 89, 80);
//		add(button_2);
//
//		JButton button_3 = new JButton("");
//		button_3.setBackground(new Color(50, 205, 50));
//		button_3.setBounds(482, 155, 89, 80);
//		add(button_3);
//
//		JButton button_4 = new JButton("");
//		button_4.setBackground(new Color(50, 205, 50));
//		button_4.setBounds(338, 155, 89, 80);
//		add(button_4);
//
//		JButton button_5 = new JButton("");
//		button_5.setBackground(new Color(50, 205, 50));
//		button_5.setBounds(194, 155, 89, 80);
//		add(button_5);
//
//		JButton button_6 = new JButton("");
//		button_6.setBackground(new Color(50, 205, 50));
//		button_6.setBounds(50, 155, 89, 80);
//		add(button_6);
//
//		JButton button_7 = new JButton("");
//		button_7.setBackground(new Color(50, 205, 50));
//		button_7.setBounds(482, 275, 89, 80);
//		add(button_7);
//
//		JButton button_8 = new JButton("");
//		button_8.setBackground(new Color(50, 205, 50));
//		button_8.setBounds(338, 275, 89, 80);
//		add(button_8);
//
//		JButton button_9 = new JButton("");
//		button_9.setBackground(new Color(50, 205, 50));
//		button_9.setBounds(194, 275, 89, 80);
//		add(button_9);
//
//		JButton button_10 = new JButton("");
//		button_10.setBackground(new Color(50, 205, 50));
//		button_10.setBounds(50, 275, 89, 80);
//		add(button_10);
//
//		JButton button_11 = new JButton("");
//		button_11.setBackground(new Color(50, 205, 50));
//		button_11.setBounds(50, 395, 89, 80);
//		add(button_11);
//
//		JButton button_12 = new JButton("");
//		button_12.setBackground(new Color(50, 205, 50));
//		button_12.setBounds(194, 395, 89, 80);
//		add(button_12);
//
//		JButton button_13 = new JButton("");
//		button_13.setBackground(new Color(50, 205, 50));
//		button_13.setBounds(338, 395, 89, 80);
//		add(button_13);
//
//		JButton button_14 = new JButton("");
//		button_14.setBackground(new Color(50, 205, 50));
//		button_14.setBounds(482, 395, 89, 80);
//		add(button_14);

	}

	public void paintComponent(Graphics g) {
		// Dimension tamanio = getSize();
		// this.bgImage = new
		// ImageIcon(getClass().getResource("/Images/mapa.jpg"));
		// g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
		// setOpaque(false);
		super.paintComponent(g);
		auto.setBounds(posX, posY, 32, 38);
		// g.fillRect(posX, posY, 20, 20);
	}

	public void moverArriba() {
		posY -= 80;
		repaint();
	}

	public void moverAbajo() {
		posY += 80;
		repaint();
	}

	public void moverDerecha() {
		posX += 75;
		repaint();
	}

	public void moverIzquierda() {
		posX -= 75;
		repaint();
	}

	public void dibujarMapa(int dimensionFila, int dimensionColumna) {
		int tamanioEsquina = 40;
		int anchoVehiculo = 35;
		int altoVehiculo = 40;

		for (int fila = 0; fila < dimensionFila; fila++) {
			for (int columna = 0; columna < dimensionColumna; columna++) {
				JButton btnEsquina = new JButton("");
				btnEsquina.setBackground(new Color(50, 205, 50));
				btnEsquina.setBounds((tamanioEsquina*fila) + (anchoVehiculo*(fila+1)),
						(tamanioEsquina*columna) + (altoVehiculo*(columna+1)), tamanioEsquina,
						tamanioEsquina);
				add(btnEsquina);
			}
		}
	}

	/*
	 * @Override public void keyPressed(KeyEvent arg0) {
	 * 
	 * }
	 * 
	 * @Override public void keyReleased(KeyEvent arg0) { switch
	 * (arg0.getKeyCode()){ case KeyEvent.VK_RIGHT: moverDerecha(); } }
	 * 
	 * @Override public void keyTyped(KeyEvent arg0) {
	 * 
	 * }
	 */
}
