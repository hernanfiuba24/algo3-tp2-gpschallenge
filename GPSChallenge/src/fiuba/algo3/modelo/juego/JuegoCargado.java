package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public class JuegoCargado extends Juego {

	public JuegoCargado(String nombreDeJugador, int tamanioMapa,
			Posicion posicionBandera, Posicion posicionVehiculo)
			throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {
		super(nombreDeJugador, tamanioMapa, posicionBandera, posicionVehiculo);
	}

	public JuegoCargado(JugadorImplementacion unJugador, Mapa unMapa) {
		super(unJugador, unMapa);
	}

	@Override
	public void setearCantidadSorprepasYObstaculos() {

	}

}
