package fiuba.algo3.modelo;

import java.util.ArrayList;

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

	public void colocarVehiculo(Vehiculo vehiculo) {
		this.unVehiculo = vehiculo;
		vehiculo.setearEsquina(this);
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
			//this.unObstaculo.aplicar(unJugador.devolverVehiculo());
			unJugador.devolverVehiculo().interactuarCon(unObstaculo);
		}
	}

	public void colocarSorpresa(Sorpresa sorpresa) {
		this.unaSorpresa = sorpresa;
	}

	public void encenderVisibilidad() {
		this.visibilidad = true;
	}

	public void apagarVisibilidad() {
		this.visibilidad = false;

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

	public ArrayList<Posicion> devolverPosicionesADistanciaDeRadio(int radio) {
		ArrayList<Posicion> PosicionesAdyacentes = new ArrayList<Posicion>();
		for (int i = -2; i <= radio; i++) {
			for (int j = -2; j <= radio; j++) {
				Posicion unaPosicionAdyacente = new Posicion(
						this.unaPosicion.devolverPosicionFila() + i,
						this.unaPosicion.devolverPosicionColumna() + j);
				PosicionesAdyacentes.add(unaPosicionAdyacente);
			}
		}
		return PosicionesAdyacentes;
	}

}
