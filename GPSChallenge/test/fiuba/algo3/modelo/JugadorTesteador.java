package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class JugadorTesteador implements Jugador{
    
	public int movimientosDescontados;
	public int movimientosHechos;

    public JugadorTesteador(){
    	this.movimientosDescontados = 0;
    	this.movimientosHechos = 0;
    }
    
	public void jugar(Mapa unMapa) throws ExcepcionEsquinaInvalida {
	}

	@Override
	public int devolverMovimientosHechos() {
		return this.movimientosHechos;
	}

	@Override
	public Vehiculo devolverVehiculo() {
		return null;
	}

	@Override
	public void cambiarDireccion(Direccion direccion) {
		
	}

	@Override
	public void descontarMovimientos(int movimientosARestar) {
		this.movimientosHechos = this.movimientosHechos - movimientosARestar;
		
	}

	@Override
	public void setearVehiculo(Vehiculo vehiculo) {
		
	}

	@Override
	public void aumentarMovimientoHechos(int cantidad) {
		
	}

	@Override
	public Direccion devolverDireccion() {
		return null;
	}

	@Override
	public void cambiarDireccionContraria() {
		
	}

	@Override
	public String devolverNombre() {
		return null;
	}

	@Override
	public void ganar() {
		
	}

	@Override
	public void aplicarCambioDeVehiculo()
			throws ExcepcionJugadorYaAsignadoAlVehiculo {
		
	}

	@Override
	public int devolverPosicionXVehiculo() {
		return 0;
	}

	@Override
	public int devolverPosicionYVehiculo() {
		return 0;
	}
	

}
