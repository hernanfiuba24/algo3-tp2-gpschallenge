package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.obstaculo.Bandera;
import fiuba.algo3.modelo.obstaculo.ControlPolicial;
import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.obstaculo.Piquete;
import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.sorpresa.Desfavorable;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.sorpresa.Sorpresa;
import fiuba.algo3.modelo.vehiculo.Vehiculo;
import fiuba.algo3.vista.vehiculo.VistaAuto;
import fiuba.algo3.vista.vehiculo.VistaMoto;

public class PanelMapa extends JLayeredPane {

	private JLabel vehiculo;
	private JPanel panelObstaculos;
	private JPanel panelBandera;
	private JPanel panelVehiculo;
	private Mapa unMapa;
	private int cantidadFilas;
	private int cantidadColumnas;
	private VistaVisibilidad unaVistaVisibilidad;

	public PanelMapa(Mapa unMapa,Juego unJuego){
		this.unMapa = unMapa;
		this.cantidadFilas = unMapa.devolverAlto();
		this.cantidadColumnas = unMapa.devolverAncho();
		
		int posicionXVisibilidad = unJuego.obtenerPosicionXVehiculo();
		int posicionYVisibilidad = unJuego.obtenerPosicionYVehiculo();
		this.unaVistaVisibilidad = new VistaVisibilidad(posicionXVisibilidad,posicionYVisibilidad);
		
		setLayout(new GridLayout(0, 1, 0, 0));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));		
		
		//VistaVehiculo unaVista = new VistaVehiculo(this);
		VistaAuto vistaAuto = new VistaAuto(this);
		VistaMoto vistaMoto = new VistaMoto(this);
		//VistaCamioneta vistaCamioneta = new VistaCamioneta();
		unJuego.devolverJugador().devolverVehiculo().addObserver(vistaAuto);
		unJuego.devolverJugador().devolverVehiculo().addObserver(vistaMoto);
		//unJuego.devolverJugador().devolverVehiculo().addObserver(vistaCamioneta);

		panelObstaculos = new JPanel();
		panelObstaculos.setOpaque(false);
		panelObstaculos.setBounds(0, 0, 660, 730);
        panelObstaculos.setLayout(null);
		this.add(panelObstaculos, new Integer(1));
		
		panelBandera = new JPanel();
		panelBandera.setOpaque(false);
		panelBandera.setBounds(0, 0, 660, 730);
		panelBandera.setLayout(null);
		this.add(panelBandera, new Integer(3));
		
		panelVehiculo = new JPanel();
		panelVehiculo.setOpaque(false);
		panelVehiculo.setBounds(0, 0, 660, 730);
		panelVehiculo.setLayout(null);
		this.add(panelVehiculo, new Integer(4));
		
		vehiculo = new JLabel("");
		vehiculo.setBackground(new Color(0, 0, 139));
		panelVehiculo.add(vehiculo);
		
		this.dibujarMapa(cantidadFilas, cantidadColumnas);
        
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	public void dibujarMapa(int dimensionFila, int dimensionColumna) {
		int tamanioEsquina = 40;
		int anchoVehiculo = 35;
		int altoVehiculo = 40;

		for (int fila = 0; fila < dimensionFila -1; fila++) {
			for (int columna = 0; columna < dimensionColumna -1 ; columna++) {
				JLabel btnEsquina = new JLabel("");
				btnEsquina.setOpaque(true);
				btnEsquina.setBackground(new Color(50, 205, 50));
				btnEsquina.setBounds((tamanioEsquina*fila) + (anchoVehiculo*(fila+1)),
						(tamanioEsquina*columna) + (altoVehiculo*(columna+1)), tamanioEsquina,
						tamanioEsquina);
				add(btnEsquina, new Integer(0));
			}
		}
	}

	public void dibujarVehiculo(Vehiculo unVehiculo){
		/*int fila = unVehiculo.devolverEsquina().devolverPosicion().devolverPosicionFila();
		int columna = unVehiculo.devolverEsquina().devolverPosicion().devolverPosicionColumna();
		
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
		panelVehiculo.add(vehiculo);
		repaint();*/
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
					        panelObstaculos.add(iconoObstaculo, new Integer(1));
						}else{
							if (unObstaculo instanceof ControlPolicial){
								JLabel iconoObstaculo = new JLabel();
								iconoObstaculo.setIcon(new ImageIcon(PanelMapa.class
										.getResource("/fiuba/algo3/vista/imagenes/policia.png")));  
								iconoObstaculo.setBounds((j-1)*(40+35), (i-1)*(40+40), 35, 35);        
						        panelObstaculos.add(iconoObstaculo, new Integer(1));
							}
							else{
								if (unObstaculo instanceof Piquete){
									JLabel iconoObstaculo = new JLabel();
									iconoObstaculo.setIcon(new ImageIcon(PanelMapa.class
											.getResource("/fiuba/algo3/vista/imagenes/piquete.png")));  
									iconoObstaculo.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
								    panelObstaculos.add(iconoObstaculo, new Integer(1));
								}
								else{
									if (unObstaculo instanceof Bandera){
										JLabel iconoObstaculo = new JLabel();
										iconoObstaculo.setIcon(new ImageIcon(PanelMapa.class
												.getResource("/fiuba/algo3/vista/imagenes/bandera.png")));  
										iconoObstaculo.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
									    panelBandera.add(iconoObstaculo);
									}
								}
							}
						}
						Sorpresa unaSorpresa = unMapa.devolverUnaEsquina(new Posicion(i,j)).devolverSorpresa();
						if (unaSorpresa instanceof Desfavorable){
							JLabel iconoSorpresa = new JLabel();
							iconoSorpresa.setIcon(new ImageIcon(PanelMapa.class
									.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png")));  
							iconoSorpresa.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
					        panelObstaculos.add(iconoSorpresa, new Integer(1));
						}else{
							if (unaSorpresa instanceof Favorable){
								JLabel iconoSorpresa = new JLabel();
								iconoSorpresa.setIcon(new ImageIcon(PanelMapa.class
										.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png")));  
								iconoSorpresa.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
						        panelObstaculos.add(iconoSorpresa, new Integer(1));
							}
							else{
								if (unaSorpresa instanceof CambioDeVehiculo){
									JLabel iconoSorpresa = new JLabel();
									iconoSorpresa.setIcon(new ImageIcon(PanelMapa.class
											.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png")));  
									iconoSorpresa.setBounds((j-1)*(40+36), (i-1)*(40+40), 35, 35);        
								    panelObstaculos.add(iconoSorpresa, new Integer(1));
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
	
	public void dibujarVisibilidad(int x, int y){
		this.remove(this.unaVistaVisibilidad);
		this.unaVistaVisibilidad = new VistaVisibilidad(x, y);
		this.unaVistaVisibilidad.setOpaque(false);
        this.unaVistaVisibilidad.setForeground(Color.gray);
        this.unaVistaVisibilidad.setBounds(1, 1, 658, 728);
		add(unaVistaVisibilidad, new Integer(2));
		this.unaVistaVisibilidad.repaint();
	}

	public void dibujarAuto(Posicion unaPosicion) {
		vehiculo.setBounds( (unaPosicion.devolverPosicionColumna()-1)*(40+35), (unaPosicion.devolverPosicionFila()-1)*(40+42), 40, 17);
		vehiculo.setIcon(new ImageIcon(PanelMapa.class
				.getResource("/fiuba/algo3/vista/imagenes/car.png")));
		panelVehiculo.add(vehiculo);
		
	}

	public void dibujarMoto(Posicion unaPosicion) {
		vehiculo.setBounds( (unaPosicion.devolverPosicionColumna()-1)*(40+34), (unaPosicion.devolverPosicionFila()-1)*(40+40), 40, 30);
		vehiculo.setIcon(new ImageIcon(PanelMapa.class
				.getResource("/fiuba/algo3/vista/imagenes/moto.png")));
		
	}
	
}
