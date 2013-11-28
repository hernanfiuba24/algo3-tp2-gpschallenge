package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.cambiadorDeVisibilidad.EncendedorDeVisibilidad;
import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public abstract class Vehiculo {
	final int movimientosPermitidos = 1;
	protected Esquina esquinaActual;
	protected Jugador jugadorAlQuePertenece;

	public Vehiculo(Mapa unMapa) throws ExcepcionEsquinaInvalida {
		this.esquinaActual = unMapa.devolverUnaEsquina(new Posicion(3, 3));
		EncendedorDeVisibilidad unEncendedor = new EncendedorDeVisibilidad(unMapa);
		unEncendedor.encenderVisibilidadDosALaRedonda(this.esquinaActual);
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
		
		this.jugadorAlQuePertenece.apagarVisibilidadDosALaRedonda(unMapa);
//		CambiadorDeVisibilidad unCambiador = new CambiadorDeVisibilidad(unMapa);
//		unCambiador.apagarVisibilidadDosALaRedonda(this.esquinaActual);

		Posicion posicionActual = this.devolverEsquina().devolverPosicion();
		Posicion posicionFutura = posicionActual.calcularPosicionSiguiente(unaDireccion);
		
		Esquina esquinaFutura = unMapa.devolverUnaEsquina(posicionFutura);
		
		if (esquinaFutura.tieneObstaculo())
			esquinaFutura.devolverObstaculo().setearEsquinaAnterior(this.esquinaActual);
		
		esquinaFutura.setearVehiculo(this);
		esquinaFutura.aplicarExtras(this.jugadorAlQuePertenece);
		
		this.jugadorAlQuePertenece.encenderVisibilidadDosALaRedonda(unMapa);
//		unCambiador.encenderVisibilidadDosALaRedonda(this.esquinaActual);

		esquinaActual.borrarVehiculo();
		
	}

	public Jugador devolverJugador() {
		return this.jugadorAlQuePertenece;

	}

	public abstract void cambioDeVehiculo();

	public abstract void interactuarCon(Obstaculo obstaculo);

}
