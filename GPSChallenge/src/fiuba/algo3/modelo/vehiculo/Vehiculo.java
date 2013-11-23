package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Radar;
import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public abstract class Vehiculo {
	final int movimientosPermitidos = 1;
	protected Esquina esquinaActual;
	protected Jugador jugadorAlQuePertenece;

	public Vehiculo(Mapa unMapa) throws ExcepcionEsquinaInvalida {
		this.esquinaActual = unMapa.devolverUnaEsquina(new Posicion(3, 3));
		Radar unRadar = new Radar(unMapa);
		unRadar.encenderVisibilidadDosALaRedonda(this.esquinaActual);
	}

	public Vehiculo(Esquina unaEsquina) {
		this.esquinaActual = unaEsquina;
	}

	public void setearEsquina(Esquina nuevaEsquina) {
		this.esquinaActual = nuevaEsquina;
	}

	public Esquina devolverEsquina() {
		return esquinaActual;
	}

	public int movimientosPorTurno() {
		return movimientosPermitidos;
	}

	public void setearJugadorAlQuePertenece(Jugador unJugador) {
		this.jugadorAlQuePertenece = unJugador;
	}

	public void mover(Mapa unMapa, Direccion unaDireccion)
			throws ExcepcionEsquinaInvalida {
		Radar unRadar = new Radar(unMapa);
		unRadar.apagarVisibilidadDosALaRedonda(this.esquinaActual);

		Posicion posicionActual = this.devolverEsquina().devolverPosicion();
		Posicion posicionFutura = posicionActual.calcularPosicionSiguiente(unaDireccion);
		
		Esquina esquinaFutura = unMapa.devolverUnaEsquina(posicionFutura);
		esquinaFutura.setearVehiculo(this);
		esquinaFutura.chequearExtras(this.jugadorAlQuePertenece);

		unRadar.encenderVisibilidadDosALaRedonda(this.esquinaActual);

		esquinaActual.borrarVehiculo();
	}

	public Jugador devolverJugador() {
		return this.jugadorAlQuePertenece;

	}

	public abstract void cambioDeVehiculo();

	public abstract void interactuarCon(Obstaculo obstaculo);

}
