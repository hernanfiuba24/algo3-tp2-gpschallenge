package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {

	private Vehiculo unVehiculo;
	private int movimientosHechos;
	private Direccion unaDireccion;

	public Jugador(Vehiculo vehiculo) {
		this.unVehiculo = vehiculo;
		this.movimientosHechos = 0;
		vehiculo.setearJugadorAlQuePertenece(this);
	}

	public Jugador() {
		// Constructor creado solo para Test
	}

	public void jugar(Mapa unMapa) {
		this.movimientosHechos += 1;
		unVehiculo.mover(unMapa, this.unaDireccion);
	}

	public int devolverMovimientosHechos() {
		return movimientosHechos;
	}

	public Vehiculo devolverVehiculo() {
		return this.unVehiculo;
	}

	public void setDireccion(Direccion direccion) {
		this.unaDireccion = direccion;
	}

	public void descontarMovimientos(int movimientosRestantes) {

		this.movimientosHechos = this.movimientosHechos - movimientosRestantes;

	}

	public void guardarVehiculo(Vehiculo vehiculo) {
		this.unVehiculo = vehiculo;

	}

	public void aumentarMovimientoHechos(int cantidad) {
		this.movimientosHechos = this.movimientosHechos + cantidad;

	}

}