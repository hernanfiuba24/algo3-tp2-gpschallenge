package fiuba.algo3.vista;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class VistaVisibilidad extends JPanel{

	int posX, posY;
	BasicStroke grosor = new BasicStroke(800);
	int diametro = 1100;
	int corrimiento = diametro / 2 - 10;

	public VistaVisibilidad(int unaPosX, int unaPosY) {
		this.posX = unaPosX - corrimiento;
		this.posY = unaPosY - corrimiento;
	}
	
	public void paintComponent(Graphics g) {
		((Graphics2D) g).setStroke(grosor);
		g.drawOval(this.posX, this.posY, diametro, diametro);
	}

}