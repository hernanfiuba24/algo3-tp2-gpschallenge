package fiuba.algo3.modelo;

import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.sorpresa.Sorpresa;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Esquina {
	private boolean visibilidad;
	private Posicion unaPosicion;
	private Vehiculo unVehiculo;
	private Sorpresa unaSorpresa;
	private Obstaculo unObstaculo;

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

	public void chequearExtras(Jugador unJugador) {
		if (this.unaSorpresa != null) {
			this.unaSorpresa.aplicar(unJugador);
		}
		 if (this.unObstaculo != null) {
			 this.unObstaculo.aplicar(unJugador);
		 }
	}

	public void colocarSorpresa(Sorpresa sorpresa) {
		this.unaSorpresa = sorpresa;
	}

	public void cambiarVisibilidad() {
		this.visibilidad = !(this.visibilidad);
	}

	public boolean devolverVisibilidad() {
		return this.visibilidad;
	}

	public void colocarObstaculo(Obstaculo obstaculo) {
		this.unObstaculo = obstaculo;
	}

	public Obstaculo getObstaculo() {
		return unObstaculo;
	}

	public void cambiarVisibilidad(boolean valor) {
		this.visibilidad = valor;
		
	}
}
