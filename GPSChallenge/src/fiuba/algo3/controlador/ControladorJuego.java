package fiuba.algo3.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.juego.Juego;

public class ControladorJuego {
	
	private Juego GPSChallenge;
	
	public ControladorJuego(Juego unGPSChallenge) throws ExcepcionEsquinaInvalida{
		this.GPSChallenge = unGPSChallenge;		
		this.GPSChallenge.actualizar();
	}
	
	public int devolverDimensionMapaFila() {
		int dimensionFila = this.GPSChallenge.devolverMapaFila();
		return dimensionFila;
	}
	
	public int devolverDimensionMapaColumna(){
		int dimensionColumna = this.GPSChallenge.devolverMapaColumna();
		return dimensionColumna;
	}
	
	public KeyListener getKeyListener(){
		
		return new KeyListener() {
			
			@Override
		    public void keyPressed(KeyEvent e) {  
			    
		    }
		    
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					try {
						GPSChallenge.jugar(new Arriba());
					} catch (ExcepcionJugadorYaAsignadoAlVehiculo e1) {
						e1.printStackTrace();
					}
					break;
				case KeyEvent.VK_DOWN:
					try {
						GPSChallenge.jugar(new Abajo());
					} catch (ExcepcionJugadorYaAsignadoAlVehiculo e1) {
						e1.printStackTrace();
					}
					break;
				case KeyEvent.VK_RIGHT:
					try {
						GPSChallenge.jugar(new Derecha());
					} catch (ExcepcionJugadorYaAsignadoAlVehiculo e1) {
						e1.printStackTrace();
					}
					break;
				case KeyEvent.VK_LEFT:
					try {
						GPSChallenge.jugar(new Izquierda());
					} catch (ExcepcionJugadorYaAsignadoAlVehiculo e1) {
						e1.printStackTrace();
					}
					break;
				}
		
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
		
			}
		};
	}
}

