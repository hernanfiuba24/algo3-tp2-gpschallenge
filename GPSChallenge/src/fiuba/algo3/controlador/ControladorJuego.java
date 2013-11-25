package fiuba.algo3.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Abajo;
import fiuba.algo3.modelo.direccion.Arriba;
import fiuba.algo3.modelo.direccion.Derecha;
import fiuba.algo3.modelo.direccion.Izquierda;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.vista.PanelMapa;

public class ControladorJuego implements Observer {
	
	private Juego GPSChallenge;
	private PanelMapa panelMapa;
	
	public ControladorJuego(Juego unGPSChallenge, PanelMapa unPanelMapa) throws ExcepcionEsquinaInvalida{
		this.GPSChallenge = unGPSChallenge;
		this.panelMapa = unPanelMapa;
		this.GPSChallenge.addObserver(this);
		
		GPSChallenge.setearPosicionInicial();
	}
	
	/*private class EscuchaBotonDerecha implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GPSChallenge.jugar(new Derecha());
//			try {
//				GPSChallenge.devolverJugador().jugar(GPSChallenge.devolverMapa());
//			} catch (ExcepcionEsquinaInvalida e1) {
//			}
		}
	}
	
	public ActionListener getListenerBotonDerecha() {
		return new EscuchaBotonDerecha();
	}
	
	private class EscuchaBotonArriba implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GPSChallenge.jugar(new Arriba());
		}
	}
	
	public ActionListener getListenerBotonArriba() {
		return new EscuchaBotonArriba();
	}
	
	private class EscuchaBotonIzquierda implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GPSChallenge.jugar(new Izquierda());
		}
	}
	
	public ActionListener getListenerBotonIzquierda() {
		return new EscuchaBotonIzquierda();
	}
	
	private class EscuchaBotonAbajo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GPSChallenge.jugar(new Abajo());
		}
	}
	
	public ActionListener getListenerBotonAbajo() {
		return new EscuchaBotonAbajo();
	}*/

	public int devolverDimensionMapaFila() {
		int dimensionFila = this.GPSChallenge.devolverMapaFila();
		return dimensionFila;
	}
	
	public int devolverDimensionMapaColumna(){
		int dimensionColumna = this.GPSChallenge.devolverMapaColumna();
		return dimensionColumna;
	}

	@Override
	public void update(Observable o, Object arg) {
		//actualizarVista
		//hacer observable a obstaculo y sorpresa
			this.panelMapa.dibujarVehiculo((Posicion) arg);
	}
	
}
