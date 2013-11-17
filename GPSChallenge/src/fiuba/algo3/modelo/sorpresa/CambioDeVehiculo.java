package fiuba.algo3.modelo.sorpresa;

import fiuba.algo3.modelo.Jugador;

public class CambioDeVehiculo implements Sorpresa {
	
	public void aplicar(Jugador unJugador){
		unJugador.devolverVehiculo().cambioDeVehiculo();
	}

}
