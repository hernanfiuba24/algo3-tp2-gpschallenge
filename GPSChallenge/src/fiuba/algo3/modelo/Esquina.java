package fiuba.algo3.modelo;

public class Esquina {
	private Posicion unaPosicion;
	private Vehiculo unVehiculo;
	private Obstaculo unObstaculo;
	private Sorpresa unaSorpresa;

	public Esquina(Posicion posicion) {
		this.unaPosicion = posicion;
	}

	public void colocarAuto(Vehiculo vehiculo) {
		this.unVehiculo = vehiculo;
		vehiculo.actualizarEsquina(this);
	}

	public void borrarAuto() {
		this.unVehiculo = null;
	}

	public Vehiculo obtenerAuto() {
		return this.unVehiculo;
	}

	public Posicion devolverPosicion() {
		return this.unaPosicion;
	}
}
