package fiuba.algo3.modelo;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJuegoTerminado;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public interface Jugador {

	void jugar(Mapa unMapa) throws ExcepcionEsquinaInvalida,
			ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo;

	public int devolverMovimientosHechos();

	public Vehiculo devolverVehiculo();

	public void cambiarDireccion(Direccion direccion);

	public void descontarMovimientos(int movimientosARestar);

	public void setearVehiculo(Vehiculo unVehiculo)
			throws ExcepcionJugadorYaAsignadoAlVehiculo;

	public void aumentarMovimientoHechos(int cantidad);

	public Direccion devolverDireccion();

	public void cambiarDireccionContraria();

	public String devolverNombre();

	public void ganar();

	void aplicarCambioDeVehiculo() throws ExcepcionJugadorYaAsignadoAlVehiculo;

}
