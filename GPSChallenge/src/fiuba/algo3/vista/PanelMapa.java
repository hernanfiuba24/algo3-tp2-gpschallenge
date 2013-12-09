package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.modelo.Esquina;
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
import fiuba.algo3.vista.observadorDeObjetos.ObservadorDeVehiculos;

public class PanelMapa extends JLayeredPane {

	private JLabel vehiculo;
	private JPanel panelObstaculos;
	private JPanel panelBandera;
	private JPanel panelVehiculo;
	private Mapa unMapa;
	private int cantidadFilas;
	private int cantidadColumnas;
	private VistaVisibilidad unaVistaVisibilidad;
	
	private HashMap<String, ImageIcon> ListaDeImagenes;
	
	ImageIcon imagenPozo = new ImageIcon(PanelMapa.class.getResource("/fiuba/algo3/vista/imagenes/pozo.png"));
	ImageIcon imagenPiquete = new ImageIcon(PanelMapa.class.getResource("/fiuba/algo3/vista/imagenes/piquete.png"));
	ImageIcon imagenControlPolicial = new ImageIcon(PanelMapa.class.getResource("/fiuba/algo3/vista/imagenes/policia.png"));
	ImageIcon imagenBandera = new ImageIcon(PanelMapa.class.getResource("/fiuba/algo3/vista/imagenes/bandera.png"));
	ImageIcon imagenCambioDeVehiculo = new ImageIcon(PanelMapa.class.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png"));
	ImageIcon imagenDesfavorable = new ImageIcon(PanelMapa.class.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png"));
	ImageIcon imagenFavorable = new ImageIcon(PanelMapa.class.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png"));
	
	
	public PanelMapa(Mapa unMapa, Juego unJuego) {
		this.unMapa = unMapa;
		this.cantidadFilas = unMapa.devolverAlto();
		this.cantidadColumnas = unMapa.devolverAncho();

		int posicionXVisibilidad = unJuego.obtenerPosicionXVehiculo();
		int posicionYVisibilidad = unJuego.obtenerPosicionYVehiculo();
		this.unaVistaVisibilidad = new VistaVisibilidad(posicionXVisibilidad,
				posicionYVisibilidad);

		setLayout(new GridLayout(0, 1, 0, 0));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.cargarListaDeImagenes();
		
//		CORREGIR ESTAS LLAMADAS PARA NO ROMPER ENCAPSULAMIENTO		
//--------------------------------------------------------------------------------------------------------		
		
		ObservadorDeVehiculos observadorDeVehiculos = new ObservadorDeVehiculos(this);
		unJuego.devolverJugador().devolverVehiculo().agregarObservador(observadorDeVehiculos);
		
//		ObervadorDeSorpresas observadorDeSorpresas = new ObservadorDeSorpresas(this);
//		unJuego.devolverJugador().devolverVehiculo().devolverEsquina().devolverSorpresa().agregarObservador(observadorDeSorpresas);
		
// --------------------------------------------------------------------------------------------------------			
			
			
		this.crearPanelObstaculos();
		this.crearPanelBandera();
		this.crearPanelVehiculo();		

		this.dibujarMapa(cantidadFilas, cantidadColumnas);

	}
	
//	CREO Y SETEO LOS PANELES
//	--------------------------------------------------------------------------------------- //
	
	private void setearPanel(JPanel unPanel, int posicionDelPanel){		
		unPanel.setOpaque(false);
		unPanel.setBounds(0, 0, 660, 730);
		unPanel.setLayout(null);
		this.add(unPanel, new Integer(posicionDelPanel));
	}
	
	private void crearPanelObstaculos(){
		panelObstaculos = new JPanel();
		this.setearPanel(panelObstaculos, 1);
	}
	
	private void crearPanelBandera(){
		panelBandera = new JPanel();
		this.setearPanel(panelBandera, 3);	
	}
	
	private void crearPanelVehiculo(){
		panelVehiculo = new JPanel();
		this.setearPanel(panelVehiculo, 4);	
		vehiculo = new JLabel("");
		vehiculo.setBackground(new Color(0, 0, 139));
		panelVehiculo.add(vehiculo);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	
	public void cargarListaDeImagenes(){
		ListaDeImagenes = new HashMap<String,ImageIcon>();
		ListaDeImagenes.put("fiuba.algo3.modelo.obstaculo.Pozo", imagenPozo);
		ListaDeImagenes.put("fiuba.algo3.modelo.obstaculo.Piquete", imagenPiquete);
		ListaDeImagenes.put("fiuba.algo3.modelo.obstaculo.ControlPolicial", imagenControlPolicial);
		ListaDeImagenes.put("fiuba.algo3.modelo.obstaculo.Bandera", imagenBandera);
		ListaDeImagenes.put("fiuba.algo3.modelo.sorpresa.Favorable", imagenFavorable);
		ListaDeImagenes.put("fiuba.algo3.modelo.sorpresa.Desfavorable", imagenDesfavorable);
		ListaDeImagenes.put("fiuba.algo3.modelo.sorpresa.CambioDeVehiculo", imagenCambioDeVehiculo);
		
	}

//	--------------------------------------------------------------------------------------- //	
	
	public void dibujarMapa(int dimensionFila, int dimensionColumna) {
		int tamanioEsquina = 40;
		int anchoVehiculo = 35;
		int altoVehiculo = 40;

		for (int fila = 0; fila < dimensionFila - 1; fila++) {
			for (int columna = 0; columna < dimensionColumna - 1; columna++) {
				JLabel btnEsquina = new JLabel("");
				btnEsquina.setOpaque(true);
				btnEsquina.setBackground(new Color(50, 205, 50));
				btnEsquina.setBounds((tamanioEsquina * fila)
						+ (anchoVehiculo * (fila + 1)),
						(tamanioEsquina * columna)
								+ (altoVehiculo * (columna + 1)),
						tamanioEsquina, tamanioEsquina);
				add(btnEsquina, new Integer(0));
			}
		}
	}

	public void dibujarVehiculo(Vehiculo unVehiculo) {
		/*
		 * int fila =
		 * unVehiculo.devolverEsquina().devolverPosicion().devolverPosicionFila
		 * (); int columna =
		 * unVehiculo.devolverEsquina().devolverPosicion().devolverPosicionColumna
		 * ();
		 * 
		 * if (unVehiculo instanceof Auto){ vehiculo.setBounds(
		 * (columna-1)*(40+35), (fila-1)*(40+42), 40, 17); vehiculo.setIcon(new
		 * ImageIcon(PanelMapa.class
		 * .getResource("/fiuba/algo3/vista/imagenes/car.png"))); }else{ if
		 * (unVehiculo instanceof Moto){ vehiculo.setBounds(
		 * (columna-1)*(40+34), (fila-1)*(40+40), 40, 30); vehiculo.setIcon(new
		 * ImageIcon(PanelMapa.class
		 * .getResource("/fiuba/algo3/vista/imagenes/moto.png"))); } else{ if
		 * (unVehiculo instanceof Camioneta){ vehiculo.setBounds(
		 * (columna-1)*(40+35), (fila-1)*(40+42), 40, 21); vehiculo.setIcon(new
		 * ImageIcon(PanelMapa.class
		 * .getResource("/fiuba/algo3/vista/imagenes/camioneta.png"))); } } }
		 * panelVehiculo.add(vehiculo); repaint();
		 */
	}

	public void dibujarExtras() throws ExcepcionEsquinaInvalida {
		panelObstaculos.removeAll();
		for (int i = 1; i <= cantidadFilas; i++) {
			for (int j = 1; j <= cantidadColumnas; j++) {
				if (unMapa.existeEsquina(new Posicion(i, j))){
					Esquina unaEsquina = this.unMapa.devolverUnaEsquina(new Posicion(i, j));
					if (unaEsquina.tieneObstaculo()){
						Obstaculo unObstaculo = unaEsquina.devolverObstaculo();
						String clave = unObstaculo.getClass().getName();
						if (ListaDeImagenes.containsKey(clave)){
							JLabel iconoObstaculo = new JLabel(ListaDeImagenes.get(clave));
							iconoObstaculo.setBounds((j - 1) * (40 + 35),
									(i - 1) * (40 + 40), 35, 35);
							panelObstaculos.add(iconoObstaculo, new Integer(1));
						}
					}
					if (unaEsquina.tieneSorpresa()){
						Sorpresa unaSorpresa = unaEsquina.devolverSorpresa();
						String clave = unaSorpresa.getClass().getName();
						if (ListaDeImagenes.containsKey(clave)){
							JLabel iconoSorpresa = new JLabel(ListaDeImagenes.get(clave));
							iconoSorpresa.setBounds((j - 1) * (40 + 35),
									(i - 1) * (40 + 40), 35, 35);
							panelObstaculos.add(iconoSorpresa, new Integer(1));
						}
					}
				}
				
				/*try {
					if (unMapa.devolverUnaEsquina(new Posicion(i, j))
							.tieneExtras()) {
						Obstaculo unObstaculo = unMapa.devolverUnaEsquina(
								new Posicion(i, j)).devolverObstaculo();
						if (unObstaculo instanceof Pozo) {
							JLabel iconoObstaculo = new JLabel();
							iconoObstaculo
									.setIcon(new ImageIcon(
											PanelMapa.class
													.getResource("/fiuba/algo3/vista/imagenes/pozo.png")));
							iconoObstaculo.setBounds((j - 1) * (40 + 36),
									(i - 1) * (40 + 40), 35, 35);
							panelObstaculos.add(iconoObstaculo, new Integer(1));
						} else {
							if (unObstaculo instanceof ControlPolicial) {
								JLabel iconoObstaculo = new JLabel();
								iconoObstaculo
										.setIcon(new ImageIcon(
												PanelMapa.class
														.getResource("/fiuba/algo3/vista/imagenes/policia.png")));
								iconoObstaculo.setBounds((j - 1) * (40 + 35),
										(i - 1) * (40 + 40), 35, 35);
								panelObstaculos.add(iconoObstaculo,
										new Integer(1));
							} else {
								if (unObstaculo instanceof Piquete) {
									JLabel iconoObstaculo = new JLabel();
									iconoObstaculo
											.setIcon(new ImageIcon(
													PanelMapa.class
															.getResource("/fiuba/algo3/vista/imagenes/piquete.png")));
									iconoObstaculo.setBounds((j - 1)
											* (40 + 36), (i - 1) * (40 + 40),
											35, 35);
									panelObstaculos.add(iconoObstaculo,
											new Integer(1));
								} else {
									if (unObstaculo instanceof Bandera) {
										JLabel iconoObstaculo = new JLabel();
										iconoObstaculo
												.setIcon(new ImageIcon(
														PanelMapa.class
																.getResource("/fiuba/algo3/vista/imagenes/bandera.png")));
										iconoObstaculo.setBounds((j - 1)
												* (40 + 35), (i - 1)
												* (40 + 40), 35, 35);
										panelBandera.add(iconoObstaculo);
									}
								}
							}
						}
						Sorpresa unaSorpresa = unMapa.devolverUnaEsquina(
								new Posicion(i, j)).devolverSorpresa();
						if (unaSorpresa instanceof Desfavorable) {
							JLabel iconoSorpresa = new JLabel();
							iconoSorpresa
									.setIcon(new ImageIcon(
											PanelMapa.class
													.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png")));
							iconoSorpresa.setBounds((j - 1) * (40 + 36),
									(i - 1) * (40 + 40), 35, 35);
							panelObstaculos.add(iconoSorpresa, new Integer(1));
						} else {
							if (unaSorpresa instanceof Favorable) {
								JLabel iconoSorpresa = new JLabel();
								iconoSorpresa
										.setIcon(new ImageIcon(
												PanelMapa.class
														.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png")));
								iconoSorpresa.setBounds((j - 1) * (40 + 36),
										(i - 1) * (40 + 40), 35, 35);
								panelObstaculos.add(iconoSorpresa, new Integer(
										1));
							} else {
								if (unaSorpresa instanceof CambioDeVehiculo) {
									JLabel iconoSorpresa = new JLabel();
									iconoSorpresa
											.setIcon(new ImageIcon(
													PanelMapa.class
															.getResource("/fiuba/algo3/vista/imagenes/sorpresa.png")));
									iconoSorpresa.setBounds(
											(j - 1) * (40 + 36), (i - 1)
													* (40 + 40), 35, 35);
									panelObstaculos.add(iconoSorpresa,
											new Integer(1));
								}
							}
						}
					}
				} catch (ExcepcionEsquinaInvalida e) {
				}*/
			}
		}
		repaint();
	}

	public void dibujarVisibilidad(int x, int y) {
		this.remove(this.unaVistaVisibilidad);
		this.unaVistaVisibilidad = new VistaVisibilidad(x, y);
		this.unaVistaVisibilidad.setOpaque(false);
		this.unaVistaVisibilidad.setForeground(Color.gray);
		this.unaVistaVisibilidad.setBounds(1, 1, 658, 728);
		add(unaVistaVisibilidad, new Integer(2));
		this.unaVistaVisibilidad.repaint();
	}

	public void dibujarAuto(Posicion unaPosicion) {
				
		vehiculo.setBounds((unaPosicion.devolverPosicionColumna() - 1)
				* (40 + 35), (unaPosicion.devolverPosicionFila() - 1)
				* (40 + 42), 40, 17);
		vehiculo.setIcon(new ImageIcon(PanelMapa.class
				.getResource("/fiuba/algo3/vista/imagenes/car.png")));
//		panelVehiculo.add(vehiculo);

	}

	public void dibujarMoto(Posicion unaPosicion) {
		
		vehiculo.setBounds((unaPosicion.devolverPosicionColumna() - 1)
				* (40 + 34), (unaPosicion.devolverPosicionFila() - 1)
				* (40 + 40), 40, 30);
		vehiculo.setIcon(new ImageIcon(PanelMapa.class
				.getResource("/fiuba/algo3/vista/imagenes/moto.png")));
	}

	public void dibujarCamioneta(Posicion unaPosicion) {
				
		vehiculo.setBounds((unaPosicion.devolverPosicionColumna() - 1)
				* (40 + 34), (unaPosicion.devolverPosicionFila() - 1)
				* (40 + 40), 40, 30);
		vehiculo.setIcon(new ImageIcon(PanelMapa.class
				.getResource("/fiuba/algo3/vista/imagenes/camioneta.png")));
	}
}
