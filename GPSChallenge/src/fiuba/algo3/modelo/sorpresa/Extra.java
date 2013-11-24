package fiuba.algo3.modelo.sorpresa;

import fiuba.algo3.modelo.Jugador;

public abstract class Extra implements Sorpresa {

	protected int porcentaje;

	protected abstract int signo();

	public void aplicar(Jugador unJugador) {
		unJugador.descontarMovimientos((unJugador.devolverMovimientosHechos()
				* porcentaje / 100)
				* this.signo());
	}

	public int devolverPorcentaje() {
		return this.porcentaje;
	}

}
