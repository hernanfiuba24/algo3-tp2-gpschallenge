package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.obstaculo.Piquete;

public class Moto extends Vehiculo {

//	public Moto(Mapa unMapa) throws ExcepcionEsquinaInvalida {
//		super(unMapa);
//	}

	public Moto(Esquina unaEsquina) {
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
				.setearVehiculo(new Auto(this.esquinaActual));
		//seCambio();
		//notificarObservadores(this);
	}

	public void interactuarCon(Obstaculo obstaculo) {
		obstaculo.aplicar(this);
	}
	
	@Override
	public boolean puedeAvanzar(Piquete piquete) {
		return true;
	}

}
