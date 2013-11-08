package fiuba.algo3.modelo;

public class Jugador {
	
    private Vehiculo unVehiculo;
    private int movimientosHechos;
	private Direccion unaDireccion;
    
	public Jugador(Vehiculo vehiculo) {
		this.unVehiculo = vehiculo;
		this.movimientosHechos = 0;
	}

	public Jugador() {
		//Constructor creado solo para Test
	}

	public void jugar(Mapa unMapa) {
		this.movimientosHechos += 1;
		unMapa.mover(this, this.unaDireccion);
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

}