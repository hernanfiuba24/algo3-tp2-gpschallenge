package fiuba.algo3.modelo.sorpresa;

import fiuba.algo3.modelo.Jugador;

public class Favorable extends Extra implements Sorpresa {

	public Favorable() {
		this.porcentaje = 20;
	}

	public void aplicar(Jugador unJugador) {
		unJugador.descontarMovimientos(unJugador.devolverMovimientosHechos()
				* porcentaje / 100);
	}

	@Override
	public int devolverPorcentaje() {
		return this.porcentaje;
	}

}
