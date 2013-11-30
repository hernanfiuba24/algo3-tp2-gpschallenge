package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class JuegoFacil extends Juego {

//	public JuegoFacil() throws ExcepcionEsquinaInvalida {
//		this.setearCantidadSorprepasYObstaculos();
//		this.unMapa = new Mapa(3, 3);
//		this.unJugador = new Jugador(new Auto(this.unMapa), null);
//		this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
//				.devolverBandera();
//		this.completarMapaConExtras();
//		setChanged();
//		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
//				.devolverPosicion());
//
//	}

	public JuegoFacil(String nombreDeJugador, int tamanioMapa, Posicion posicionBandera) throws ExcepcionEsquinaInvalida{
		super(nombreDeJugador,tamanioMapa,posicionBandera);
	}
//		this.setearCantidadSorprepasYObstaculos();
//		this.unMapa = new Mapa(3, 3);
//		this.unJugador = new Jugador(new Auto(this.unMapa), nombreDeJugador);
//		this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
//				.devolverBandera();
//		this.completarMapaConExtras();
//		setChanged();
//		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
//				.devolverPosicion());

	public void setearCantidadSorprepasYObstaculos() {
		this.cantidadDePiquetes = 1;
		this.cantidadDeControlesPoliciales = 1;
		this.cantidadDePozos = 1;
		this.cantidadDeFavorables = 1;
		this.cantidadDeDesfavorables = 1;
		this.cantidadDeCambiosDeVehiculos = 1;
	}

}
