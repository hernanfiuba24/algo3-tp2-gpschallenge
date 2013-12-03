package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class JugadorTesteador implements Jugador{
    
	public int movimientosDescontados;
	public int movimientosHechos;

    public JugadorTesteador(){
    	this.movimientosDescontados = 0;
    	this.movimientosHechos = 0;
    }
    
	public void jugar(Mapa unMapa) throws ExcepcionEsquinaInvalida {
		// TODO Auto-generated method stub		
	}

	@Override
	public int devolverMovimientosHechos() {
		return this.movimientosHechos;
	}

	@Override
	public Vehiculo devolverVehiculo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cambiarDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void descontarMovimientos(int movimientosARestar) {
		this.movimientosHechos = this.movimientosHechos - movimientosARestar;
		
	}

	@Override
	public void setearVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aumentarMovimientoHechos(int cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Direccion devolverDireccion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cambiarDireccionContraria() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String devolverNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ganar() {
		// TODO Auto-generated method stub
		
	}
	

}
