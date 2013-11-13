package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Guardable;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Radar;
import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public abstract class Vehiculo implements Guardable<Vehiculo> {
	protected int movimientosPermitidos;
	protected Esquina esquinaActual;
	protected Jugador jugadorAlQuePertenece;

	public Vehiculo(Mapa unMapa) {
		this.movimientosPermitidos = 1;
		// En esta linea iria una funcion random que posicione el
		// vehiculo en alguna esquina
		this.esquinaActual = unMapa.dameEsquina(new Posicion(3, 3));
		Radar unRadar = new Radar(unMapa);
		unRadar.cambiarVisibilidadDosALaRedonda(this.esquinaActual);
	}

	public Vehiculo(Esquina unaEsquina) {
		this.esquinaActual = unaEsquina;
	}

	public void actualizarEsquina(Esquina nuevaEsquina) {
		this.esquinaActual = nuevaEsquina;
	}

	public Esquina devolverEsquina() {
		return esquinaActual;
	}

	public int movimientos() {
		return movimientosPermitidos;
	}

	public void setearJugadorAlQuePertenece(Jugador unJugador) {
		this.jugadorAlQuePertenece = unJugador;
	}

	public void mover(Mapa unMapa, Direccion unaDireccion) {
		Radar unRadar = new Radar(unMapa);
		unRadar.cambiarVisibilidadDosALaRedonda(this.esquinaActual);

		Posicion posicionActual = this.devolverEsquina().devolverPosicion();
		Posicion posicionFutura = new Posicion(
				posicionActual.devolverPosicionFila()
						- unaDireccion.devolverX(),
				posicionActual.devolverPosicionColumna()
						- unaDireccion.devolverY());

		Esquina esquinaFutura = unMapa.dameEsquina(posicionFutura);
		esquinaFutura.colocarAuto(this);

		unRadar.cambiarVisibilidadDosALaRedonda(this.esquinaActual);

		esquinaFutura.chequearExtras(this.jugadorAlQuePertenece);
		esquinaFutura.cambiarVisibilidad(true);

		esquinaActual.borrarAuto();
	}

	public Jugador devolverJugador() {
		return this.jugadorAlQuePertenece;

	}

	public void cambioVehiculo() {

	}
	
	public void interactuarCon(Obstaculo obstaculo){
		
	}

}
