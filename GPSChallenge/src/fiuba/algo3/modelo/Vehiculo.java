package fiuba.algo3.modelo;

public abstract class  Vehiculo implements Guardable<Vehiculo> {
    protected int movimientosPermitidos;
	protected Esquina esquinaActual;
	protected Jugador jugadorAlQuePertenece;

	public void actualizarEsquina(Esquina nuevaEsquina) {
		this.esquinaActual = nuevaEsquina;
	}

	public Esquina devolverEsquina() {
		return esquinaActual;
	}

	public int movimientos() {
		return movimientosPermitidos;
	}

	public void setearJugadorAlQuePertenece(Jugador unJugador){
		this.jugadorAlQuePertenece = unJugador;
	}
	public void mover(Mapa unMapa, Direccion unaDireccion) {
		Esquina esquinaActual = this.devolverEsquina();
		Posicion posicionActual = esquinaActual.devolverPosicion();
		Esquina esquinaFutura = unMapa.dameEsquina(
				posicionActual.devolverPosicionFila()
						- unaDireccion.devolverX(),
				posicionActual.devolverPosicionColumna()
						- unaDireccion.devolverY());
		esquinaFutura.colocarAuto(this);
		esquinaFutura.chequearExtras(jugadorAlQuePertenece.devolverMovimientosHechos());
		esquinaActual.borrarAuto();
	}

}
