package fiuba.algo3.controlador;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.vista.PanelInformacion;
import fiuba.algo3.vista.PanelMapa;

public class ControladorJuego implements Observer {
	
	private Juego GPSChallenge;
	private PanelMapa panelMapa;
	private PanelInformacion panelInformacion;
	
	public ControladorJuego(Juego unGPSChallenge, PanelMapa unPanelMapa, PanelInformacion panelInformacion) throws ExcepcionEsquinaInvalida{
		this.GPSChallenge = unGPSChallenge;
		this.panelMapa = unPanelMapa;
		this.panelInformacion = panelInformacion;
		this.GPSChallenge.addObserver(this);
		
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

	@Override
	public void update(Observable o, Object arg) {
		//actualizarVista
		//hacer observable a obstaculo y sorpresa
		this.panelMapa.dibujarExtras();
		this.panelMapa.dibujarVehiculo(((Jugador)arg).devolverVehiculo());
		this.panelMapa.dibujarVisibilidad((this.GPSChallenge.devolverJugador().devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionColumna()-1)*(40+35),((this.GPSChallenge.devolverJugador().devolverVehiculo().devolverEsquina().devolverPosicion().devolverPosicionFila()-1)*(40+42)));
		this.panelInformacion.actualizarMovimientos(((Jugador)arg).devolverMovimientos());
		this.panelInformacion.actualizarVehiculo(((Jugador)arg).devolverVehiculo());
	}
}

