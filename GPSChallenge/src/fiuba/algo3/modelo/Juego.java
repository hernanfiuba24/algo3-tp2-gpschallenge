package fiuba.algo3.modelo;

public class Juego {

	private Mapa unMapa;
	private Radar unRadar;
	private Jugador unJugador;

	public Juego(Mapa mapa, Jugador jugador, Radar radar) {
		this.unJugador = jugador;
		this.unMapa = mapa;
		this.unRadar = radar;
	}

	public Mapa dameMapa() {
		return this.unMapa;
	}

	public Jugador dameJugador() {
		return this.unJugador;
	}

	public Radar dameRadar() {
		return this.unRadar;
	}

}
