package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public class Auto extends Vehiculo {

//	public Auto(Mapa unMapa) throws ExcepcionEsquinaInvalida {
//		super(unMapa);
//	}

	public Auto(Esquina unaEsquina) {
		super(unaEsquina);
		setChanged();
		notifyObservers(this);
	}

	public void cambioDeVehiculo() {
		this.jugadorAlQuePertenece.setearVehiculo(new Camioneta(
				this.esquinaActual));
	}

	public void interactuarCon(Obstaculo obstaculo) {
		obstaculo.aplicar(this);
	}

}
