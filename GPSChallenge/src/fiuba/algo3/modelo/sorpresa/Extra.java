package fiuba.algo3.modelo.sorpresa;

import java.util.Observable;

import fiuba.algo3.modelo.Jugador;

public abstract class Extra extends Observable implements Sorpresa {

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
