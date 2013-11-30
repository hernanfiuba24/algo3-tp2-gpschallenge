package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Auto;

public class JuegoDificil extends Juego {

	public JuegoDificil() throws ExcepcionEsquinaInvalida {
		this.setearCantidadSorprepasYObstaculos();
		this.unMapa = new Mapa(8, 8);
		this.unJugador = new Jugador(new Auto(this.unMapa), null);
		this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
				.devolverBandera();
		this.completarMapaConExtras();
		setChanged();
		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion());
	}

	public JuegoDificil(String nombreDeJugador) throws ExcepcionEsquinaInvalida {
		this.setearCantidadSorprepasYObstaculos();
		this.unMapa = new Mapa(8, 8);
		this.unJugador = new Jugador(new Auto(this.unMapa), nombreDeJugador);
		this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
				.devolverBandera();
		this.completarMapaConExtras();
		setChanged();
		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion());
	}

	@Override
	public void setearCantidadSorprepasYObstaculos() {
		this.cantidadDePiquetes = 5;
		this.cantidadDeControlesPoliciales = 5;
		this.cantidadDePozos = 5;
		this.cantidadDeFavorables = 5;
		this.cantidadDeDesfavorables = 5;
		this.cantidadDeCambiosDeVehiculos = 3;

	}

}
