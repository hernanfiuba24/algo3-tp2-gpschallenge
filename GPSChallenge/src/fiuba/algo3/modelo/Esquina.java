package fiuba.algo3.modelo;

public class Esquina {
	private boolean visibilidad;
	private Posicion unaPosicion;
	private Vehiculo unVehiculo;
	private Obstaculo unObstaculo;
	private Sorpresa unaSorpresa;

	public Esquina(Posicion posicion) {
		this.unaPosicion = posicion;
		this.visibilidad = false;
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

	public void chequearExtras(int movimientos) {
		if (unaSorpresa != null){
			unaSorpresa.aplicar(unVehiculo , movimientos);
		}
		if (unObstaculo != null){
			unObstaculo.aplicar(unVehiculo , movimientos);
		}
	}

	public void colocarSorpresa(Sorpresa sorpresa) {
		this.unaSorpresa = sorpresa;
	}

	public boolean dameVisibilidad() {
		return this.visibilidad;
	}

	public void cambiarVisibilidad() {
		this.visibilidad = !(this.visibilidad);
	}

	public boolean devolverVisibilidad() {
		return this.visibilidad;
	}
}
