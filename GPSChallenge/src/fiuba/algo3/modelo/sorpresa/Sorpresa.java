package fiuba.algo3.modelo.sorpresa;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public interface Sorpresa {

	public void aplicar(Jugador unJugador)
			throws ExcepcionJugadorYaAsignadoAlVehiculo;

}
