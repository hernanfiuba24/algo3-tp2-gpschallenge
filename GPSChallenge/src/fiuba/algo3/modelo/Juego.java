package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Auto;

public class Juego extends Observado {

	private Mapa unMapa;
	private Jugador unJugador;

	public Juego() throws ExcepcionEsquinaInvalida {
		this.unMapa = new Mapa(8, 8);
		this.unJugador = new Jugador(new Auto(this.unMapa));
	}

	public Mapa devolverMapa() {
		return this.unMapa;
	}

	public Jugador devolverJugador() {
		return this.unJugador;
	}

	public int devolverMapaFila() {
		return this.unMapa.devolverFilas();
	}
	
	public int devolverMapaColumna(){
		return this.unMapa.devolverColumnas();
	}

	public void moverJugadorEnDireccion(Direccion unaDireccion) {
		this.unJugador.cambiarDireccion(unaDireccion);
	}

}
