package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Auto;

public class JuegoIntermedio extends Juego {

	public JuegoIntermedio() throws ExcepcionEsquinaInvalida {
		this.setearCantidadSorprepasYObstaculos();
		this.unMapa = new Mapa(5, 5);
		this.unJugador = new Jugador(new Auto(this.unMapa), null);
		this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
				.devolverBandera();
		this.completarMapaConExtras();
		setChanged();
		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion());
	}

	public JuegoIntermedio(String nombreDeJugador) throws ExcepcionEsquinaInvalida {
		this.setearCantidadSorprepasYObstaculos();
		this.unMapa = new Mapa(5, 5);
		this.unJugador = new Jugador(new Auto(this.unMapa), nombreDeJugador);
		this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
				.devolverBandera();
		this.completarMapaConExtras();
		setChanged();
		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion());
	}

	public void setearCantidadSorprepasYObstaculos() {
		this.cantidadDePiquetes = 2;
		this.cantidadDeControlesPoliciales = 2;
		this.cantidadDePozos = 2;
		this.cantidadDeFavorables = 2;
		this.cantidadDeDesfavorables = 2;
		this.cantidadDeCambiosDeVehiculos = 2;
	}

}
