package fiuba.algo3.modelo.sorpresa;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public class CambioDeVehiculo implements Sorpresa {
	
	public void aplicar(Jugador unJugador) throws ExcepcionJugadorYaAsignadoAlVehiculo{
		unJugador.devolverVehiculo().cambioDeVehiculo();
	}

}
