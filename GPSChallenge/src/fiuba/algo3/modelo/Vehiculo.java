package fiuba.algo3.modelo;

public class Vehiculo implements Guardable {

	protected Esquina esquinaActual;

	public void actualizarEsquina(Esquina nuevaEsquina) {
		this.esquinaActual = nuevaEsquina;
	}

	public Esquina devolverEsquina() {
		return esquinaActual;
	}

	public int movimientos() {
		// TODO Auto-generated method stub
		return 0;
	}

}
