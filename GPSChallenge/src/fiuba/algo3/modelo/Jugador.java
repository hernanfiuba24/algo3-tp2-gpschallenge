package fiuba.algo3.modelo;

public class Jugador {
	
    private Vehiculo unVehiculo;
    private int movimientosHechos;
    
	public Jugador(Vehiculo vehiculo) {
		this.unVehiculo = vehiculo;
		this.movimientosHechos = 0;
	}

	public Jugador() {
		
	}

	public void jugarArriba(Mapa unMapa) {
		this.movimientosHechos += 1;
		unMapa.moverArriba(this.unVehiculo , this.movimientosHechos);

	}

	public int devolverMovimientosHechos() {
		return movimientosHechos;
	}

}