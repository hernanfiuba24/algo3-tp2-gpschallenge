package fiuba.algo3.modelo.sorpresa;

import fiuba.algo3.modelo.Jugador;

public abstract class Extra {

	protected int porcentaje;

	public abstract void aplicar(Jugador unJugador);
	
	public abstract int devolverPorcentaje();

}
