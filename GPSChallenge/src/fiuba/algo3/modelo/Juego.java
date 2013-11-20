package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Auto;

public class Juego extends Observado {

	private Mapa unMapa;
	private Radar unRadar;
	private Jugador unJugador;

	public Juego() throws ExcepcionEsquinaInvalida {
		this.unMapa = new Mapa(20, 20);
		this.unJugador = new Jugador(new Auto(this.unMapa));
		this.unRadar = new Radar(unMapa);
	}

	public Mapa devolverMapa() {
		return this.unMapa;
	}

	public Jugador devolverJugador() {
		return this.unJugador;
	}

	public Radar devolverRadar() {
		return this.unRadar;
	}

}
