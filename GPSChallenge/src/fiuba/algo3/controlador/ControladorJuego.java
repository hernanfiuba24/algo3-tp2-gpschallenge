package fiuba.algo3.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.juego.Juego;

public class ControladorJuego {
	
	private Juego GPSChallenge;
	
	public ControladorJuego(Juego unGPSChallenge) throws ExcepcionEsquinaInvalida{
		this.GPSChallenge = unGPSChallenge;		
		GPSChallenge.setearPosicionInicial();
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
					GPSChallenge.jugar(new Arriba());
					break;
				case KeyEvent.VK_DOWN:
					GPSChallenge.jugar(new Abajo());
					break;
				case KeyEvent.VK_RIGHT:
					GPSChallenge.jugar(new Derecha());
					break;
				case KeyEvent.VK_LEFT:
					GPSChallenge.jugar(new Izquierda());
					break;
				}
		
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
		
			}
		};
	}
}

