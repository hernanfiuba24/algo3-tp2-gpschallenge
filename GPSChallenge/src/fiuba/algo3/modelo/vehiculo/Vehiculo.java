package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.cambiadorDeVisibilidad.ApagadorDeVisibilidad;
import fiuba.algo3.modelo.cambiadorDeVisibilidad.EncendedorDeVisibilidad;
import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.notificadores.ObjetoObservable;
import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.obstaculo.Piquete;

public abstract class Vehiculo extends ObjetoObservable {
	final int movimientosPermitidos = 1;
	protected Esquina esquinaActual;
	protected Jugador jugadorAlQuePertenece;

	// public Vehiculo(Mapa unMapa) throws ExcepcionEsquinaInvalida {
	// this.esquinaActual = unMapa.devolverUnaEsquina(new Posicion(3, 3));
	// EncendedorDeVisibilidad unEncendedor = new
	// EncendedorDeVisibilidad(unMapa);
	// unEncendedor.encenderVisibilidadDosALaRedonda(this.esquinaActual);
	// }

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

	public void setearJugadorAlQuePertenece(Jugador unJugador)
			throws ExcepcionJugadorYaAsignadoAlVehiculo {
		if (this.jugadorAlQuePertenece == null) {
			this.jugadorAlQuePertenece = unJugador;
		} else {
			throw new ExcepcionJugadorYaAsignadoAlVehiculo();
		}
	}

	public void mover(Mapa unMapa, Direccion unaDireccion)
			throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {

		this.esquinaActual.apagarVisibilidadDosALaRedonda(unMapa);
		ApagadorDeVisibilidad unApagador = new ApagadorDeVisibilidad(unMapa);
		unApagador.apagarVisibilidadDosALaRedonda(this.esquinaActual);

		Posicion posicionActual = this.devolverEsquina().devolverPosicion();
		Posicion posicionFutura = posicionActual
				.calcularPosicionSiguiente(unaDireccion);

		if (unMapa.existeEsquina(posicionFutura)) {
			Esquina esquinaFutura = unMapa.devolverUnaEsquina(posicionFutura);

			// SETEA AL PIQUETE LA ESQUINA ANTERIOR PARA DESPUES EVITAR QUE
			// SE MUEVA EL VEHICULO
			if (esquinaFutura.puedeAvanzar(this)) {
				esquinaFutura.setearVehiculo(this);
				esquinaFutura.aplicarExtras(this.jugadorAlQuePertenece);
			}
		}
		this.esquinaActual.encenderVisibilidadDosALaRedonda(unMapa);
		EncendedorDeVisibilidad unEncendedor = new EncendedorDeVisibilidad(
				unMapa);
		unEncendedor.encenderVisibilidadDosALaRedonda(this.esquinaActual);

		this.esquinaActual.borrarVehiculo();

	}

	public Jugador devolverJugador() {
		return this.jugadorAlQuePertenece;
	}

	public abstract void cambioDeVehiculo()
			throws ExcepcionJugadorYaAsignadoAlVehiculo;

	public abstract void interactuarCon(Obstaculo obstaculo);

	public int obtenerPosicionX() {
		return this.esquinaActual.obtenerPosicionX();
	}

	public int obtenerPosicionY() {
		return this.esquinaActual.obtenerPosicionY();
	}

	public Posicion devolverPosicionActual() {
		return this.esquinaActual.devolverPosicion();
	}

	public abstract boolean puedeAvanzar(Piquete piquete);

}
