package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.ControlPolicial;
import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.obstaculo.Piquete;
import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.sorpresa.Desfavorable;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.sorpresa.Sorpresa;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class PanelMapa extends JPanel /* implements KeyListener */{

	private JLabel vehiculo;
	private JPanel panelObstaculos;
	private Mapa unMapa;
	private int cantidadFilas;
	private int cantidadColumnas;

	public PanelMapa(Mapa unMapa){
		this.unMapa = unMapa;
		this.cantidadFilas = unMapa.devolverFilas();
		this.cantidadColumnas = unMapa.devolverColumnas();
		
		//this.setBackground(new Color(4));
		setLayout(new GridLayout(0, 1, 0, 0));
		// addKeyListener(this);
		// setFocusable(true);
		// setFocusTraversalKeysEnabled(false);
		

		panelObstaculos = new JPanel();
		panelObstaculos.setOpaque(false);
		panelObstaculos.setBounds(0, 0, 660, 730);
        panelObstaculos.setLayout(null);
        //panelObstaculos.setComponentZOrder(panelObstaculos, 1);
		this.add(panelObstaculos, new Integer(1));
		
		vehiculo = new JLabel("");
		vehiculo.setBackground(new Color(0, 0, 139));
		this.add(vehiculo);
		
		this.dibujarMapa(cantidadFilas, cantidadColumnas);

	}

	public void paintComponent(Graphics g) {
		// Dimension tamanio = getSize();
		// this.bgImage = new
		// ImageIcon(getClass().getResource("/Images/mapa.jpg"));
		// g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
		// setOpaque(false);
		super.paintComponent(g);
		//auto.setBounds(posX, posY, 32, 38);
		// g.fillRect(posX, posY, 20, 20);
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

	public void dibujarVehiculo(Jugador unJugador){
		Vehiculo unVehiculo = unJugador.devolverVehiculo();
		int fila = unJugador.devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionFila();
		int columna = unJugador.devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionColumna();
		
		if (unVehiculo instanceof Auto){
			vehiculo.setBounds( (columna-1)*(40+35), (fila-1)*(40+42), 40, 17);
			vehiculo.setIcon(new ImageIcon(PanelMapa.class
					.getResource("/fiuba/algo3/vista/imagenes/car.png")));
		}else{
			if (unVehiculo instanceof Moto){
				vehiculo.setBounds( (columna-1)*(40+34), (fila-1)*(40+40), 40, 30);
				vehiculo.setIcon(new ImageIcon(PanelMapa.class
						.getResource("/fiuba/algo3/vista/imagenes/moto.png")));
			}
			else{
				if (unVehiculo instanceof Camioneta){
					vehiculo.setBounds( (columna-1)*(40+35), (fila-1)*(40+42), 40, 21);
					vehiculo.setIcon(new ImageIcon(PanelMapa.class
							.getResource("/fiuba/algo3/vista/imagenes/camioneta.png")));
				}
			}
		}
		add(vehiculo);
		repaint();
	}
	
	public void dibujarExtras() {		
		panelObstaculos.removeAll();              
        for(int i = 1; i <= cantidadFilas; i++) {
        	for(int j = 1; j <= cantidadColumnas; j++) {
        		try {
					if(unMapa.devolverUnaEsquina(new Posicion(i,j)).tieneExtras()){
						Obstaculo unObstaculo = unMapa.devolverUnaEsquina(new Posicion(i,j)).devolverObstaculo();
						if (unObstaculo instanceof Pozo){
							JLabel iconoObstaculo = new JLabel();
							iconoObstaculo.setIcon(new ImageIcon(PanelMapa.class
									.getResource("/fiuba/algo3/vista/imagenes/pozo.png")));  
							iconoObstaculo.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
					        panelObstaculos.add(iconoObstaculo);
						}else{
							if (unObstaculo instanceof ControlPolicial){
								JLabel iconoObstaculo = new JLabel();
								iconoObstaculo.setIcon(new ImageIcon(PanelMapa.class
										.getResource("/fiuba/algo3/vista/imagenes/policia.png")));  
								iconoObstaculo.setBounds((j-1)*(40+35), (i-1)*(40+40), 35, 35);        
						        panelObstaculos.add(iconoObstaculo);
							}
							else{
								if (unObstaculo instanceof Piquete){
									JLabel iconoObstaculo = new JLabel();
									iconoObstaculo.setIcon(new ImageIcon(PanelMapa.class
											.getResource("/fiuba/algo3/vista/imagenes/piquete.png")));  
									iconoObstaculo.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
								    panelObstaculos.add(iconoObstaculo);
								}
							}
						}
						Sorpresa unaSorpresa = unMapa.devolverUnaEsquina(new Posicion(i,j)).devolverSorpresa();
						if (unaSorpresa instanceof Desfavorable){
							JLabel iconoSorpresa = new JLabel();
							iconoSorpresa.setIcon(new ImageIcon(PanelMapa.class
									.getResource("/fiuba/algo3/vista/imagenes/desfavorable.png")));  
							iconoSorpresa.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
					        panelObstaculos.add(iconoSorpresa);
						}else{
							if (unaSorpresa instanceof Favorable){
								JLabel iconoSorpresa = new JLabel();
								iconoSorpresa.setIcon(new ImageIcon(PanelMapa.class
										.getResource("/fiuba/algo3/vista/imagenes/favorable.png")));  
								iconoSorpresa.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
						        panelObstaculos.add(iconoSorpresa);
							}
							else{
								if (unaSorpresa instanceof CambioDeVehiculo){
									JLabel iconoSorpresa = new JLabel();
									iconoSorpresa.setIcon(new ImageIcon(PanelMapa.class
											.getResource("/fiuba/algo3/vista/imagenes/cambioVehiculo.png")));  
									iconoSorpresa.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
								    panelObstaculos.add(iconoSorpresa);
								}
							}
						}
					}
				} catch (ExcepcionEsquinaInvalida e) {
				}        	
        	}
        }
        repaint();
	}
	
	//actualizarVista
	//dibujar vehiculo
	//actualizar puntuacion
	//actualizar movimientos
	//tengo que tener lista de obstaculos en panel mapa
	
}
