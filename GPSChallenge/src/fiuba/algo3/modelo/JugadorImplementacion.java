package fiuba.algo3.modelo;

import java.util.Observable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJuegoTerminado;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class JugadorImplementacion extends Observable implements Jugador {

	private Vehiculo unVehiculo;
	private int movimientosHechos;
	private Direccion unaDireccion;
	private final String nombre;
	private boolean gano;

	public JugadorImplementacion(Vehiculo vehiculo, String nombre)
			throws ExcepcionJugadorYaAsignadoAlVehiculo {
		this.unVehiculo = vehiculo;
		this.movimientosHechos = 0;
		this.nombre = nombre;
		this.gano = false;
		this.unVehiculo.setearJugadorAlQuePertenece(this);
	}

	public void jugar(Mapa unMapa) throws ExcepcionEsquinaInvalida,
			ExcepcionJuegoTerminado, ExcepcionJugadorYaAsignadoAlVehiculo {

		if (gano == false) {
			Posicion posicionActual = this.unVehiculo.devolverPosicionActual();
			unVehiculo.mover(unMapa, this.unaDireccion);
			if (posicionActual.equals(unVehiculo.devolverPosicionActual()) == false) {
				this.movimientosHechos += 1;
			}
		}
	}

	public int devolverMovimientosHechos() {
		return movimientosHechos;
	}

	public Vehiculo devolverVehiculo() {
		return this.unVehiculo;
	}

	public void cambiarDireccion(Direccion direccion) {
		this.unaDireccion = direccion;
	}

	public void descontarMovimientos(int movimientosARestar) {
		this.movimientosHechos = this.movimientosHechos - movimientosARestar;
	}

	public void setearVehiculo(Vehiculo unVehiculo)
			throws ExcepcionJugadorYaAsignadoAlVehiculo {
		this.unVehiculo = unVehiculo;
		unVehiculo.setearJugadorAlQuePertenece(this);
	}

	public void aumentarMovimientoHechos(int cantidad) {
		this.movimientosHechos = this.movimientosHechos + cantidad;
	}

	public Direccion devolverDireccion() {
		return this.unaDireccion;
	}

	public void cambiarDireccionContraria() {
		this.unaDireccion = this.unaDireccion.cambiarDireccionContraria();
	}

	public String devolverNombre() {
		return this.nombre;
	}

	public int devolverPosicionXVehiculo() {
		return unVehiculo.obtenerPosicionX();
	}

	public int devolverPosicionYVehiculo() {
		return unVehiculo.obtenerPosicionY();
	}

	@Override
	public void ganar() {
		this.gano = true;
	}

	public boolean gano() {
		return this.gano;
	}

	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Jugador");
		xmlElement.setAttribute("Nombre", this.nombre);
		xmlElement.setAttribute("Gano", String.valueOf(this.gano));
		xmlElement.setAttribute("Movimientos_Hechos",
				String.valueOf(this.movimientosHechos));
		xmlElement.appendChild(this.unVehiculo.toXml(doc));
		return xmlElement;
	}

	public Posicion devolverPosicionDelVehiculo() {
		return this.unVehiculo.devolverPosicionActual();
	}

	public void setearEsquinaDelVehiculo(Esquina unaEsquina) {
		this.unVehiculo.setearEsquina(unaEsquina);
	}

	public void actualizarVehiculo() {
		this.unVehiculo.actualizar();
	}

	@Override
	public void aplicarCambioDeVehiculo()
			throws ExcepcionJugadorYaAsignadoAlVehiculo {
		this.unVehiculo.cambioDeVehiculo();
	}

	

}