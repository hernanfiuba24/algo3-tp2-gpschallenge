package fiuba.algo3.modelo.sorpresa;

import fiuba.algo3.modelo.Jugador;

public class Desfavorable implements Sorpresa {

	private int porcentaje;

	public Desfavorable() {
		this.porcentaje = 25;
	}

	public void aplicar(Jugador unJugador) {
		unJugador.descontarMovimientos(unJugador.devolverMovimientosHechos()
				* porcentaje / 100 * (-1));
	}

}
