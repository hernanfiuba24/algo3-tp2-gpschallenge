package fiuba.algo3.modelo;

public abstract class  Vehiculo implements Guardable<Vehiculo> {
    protected int movimientosPermitidos;
	protected Esquina esquinaActual;

	public void actualizarEsquina(Esquina nuevaEsquina) {
		this.esquinaActual = nuevaEsquina;
	}

	public Esquina devolverEsquina() {
		return esquinaActual;
	}

	public int movimientos() {
		return movimientosPermitidos;
	}

}
