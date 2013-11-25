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
import java.awt.GridLayout;

public class PanelMapa extends JPanel /* implements KeyListener */{

	private JLabel auto;
	// private ImageIcon bgImage;
	private int posX = 0;
	private int posY = 0;

	public PanelMapa(int dimensionFila, int dimensionColumna){
		setLayout(new GridLayout(0, 1, 0, 0));
		// addKeyListener(this);
		// setFocusable(true);
		// setFocusTraversalKeysEnabled(false);

		auto = new JLabel("");
		auto.setIcon(new ImageIcon(PanelMapa.class
				.getResource("/fiuba/algo3/vista/imagenes/car.png")));
		auto.setBackground(new Color(0, 0, 139));
		add(auto);
		
		this.dibujarMapa(dimensionFila, dimensionColumna);

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
				btnEsquina.setRolloverEnabled(false);
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
