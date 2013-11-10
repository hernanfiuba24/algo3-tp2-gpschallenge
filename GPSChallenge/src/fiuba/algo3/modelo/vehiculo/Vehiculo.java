package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Guardable;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Direccion;

public abstract class  Vehiculo implements Guardable<Vehiculo> {
    protected int movimientosPermitidos;
	protected Esquina esquinaActual;
	protected Jugador jugadorAlQuePertenece;

	public Vehiculo(Esquina unaEsquina) {
		this.movimientosPermitidos = 1;
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

	public void mover(Mapa unMapa, Direccion unaDireccion, int movimientos) {
		Esquina esquinaActual = this.devolverEsquina();
		Posicion posicionActual = esquinaActual.devolverPosicion();
		Posicion posicionFutura = new Posicion(
				posicionActual.devolverPosicionFila()
						- unaDireccion.devolverX(),
				posicionActual.devolverPosicionColumna()
						- unaDireccion.devolverY());
		
		Esquina esquinaFutura = unMapa.dameEsquina(posicionFutura);
		esquinaFutura.colocarAuto(this);
		
		System.out.println(this.jugadorAlQuePertenece.devolverMovimientosHechos());
		
		esquinaFutura.chequearExtras(this.jugadorAlQuePertenece);
		
		esquinaActual.borrarAuto();
	}

	public Jugador devolverJugador() {
		return this.jugadorAlQuePertenece;
		
	}

}
