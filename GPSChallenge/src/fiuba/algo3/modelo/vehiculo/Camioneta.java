package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.obstaculo.Piquete;

public class Camioneta extends Vehiculo {

//	public Camioneta(Mapa unMapa) throws ExcepcionEsquinaInvalida {
//		super(unMapa);
//	}

	public Camioneta(Esquina unaEsquina) {
		super(unaEsquina);
		seCambio();
		notificarObservadores(this);
	}
	
	public void setearEsquina(Esquina nuevaEsquina){
		super.setearEsquina(nuevaEsquina);
		seCambio();
		notificarObservadores(this);
	}

	public void cambioDeVehiculo() throws ExcepcionJugadorYaAsignadoAlVehiculo {
		this.jugadorAlQuePertenece
				.setearVehiculo(new Moto(this.esquinaActual));
//		seCambio();
//		notificarObservadores(this);
	}

	public void interactuarCon(Obstaculo obstaculo) {
		obstaculo.aplicar(this);
	}
	
	@Override
	public boolean puedeAvanzar(Piquete piquete) {
		return false;
	}

}
