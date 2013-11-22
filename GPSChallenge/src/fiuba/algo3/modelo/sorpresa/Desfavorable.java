package fiuba.algo3.modelo.sorpresa;

import fiuba.algo3.modelo.Jugador;

public class Desfavorable extends Extra implements Sorpresa {

	public Desfavorable() {
		this.porcentaje = 25;
	}

	public void aplicar(Jugador unJugador) {
		unJugador.descontarMovimientos(unJugador.devolverMovimientosHechos()
				* porcentaje / 100 * (-1));
	}

	@Override
	public int devolverPorcentaje() {
		return this.porcentaje;
	}

}
