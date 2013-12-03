package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public class Moto extends Vehiculo {

//	public Moto(Mapa unMapa) throws ExcepcionEsquinaInvalida {
//		super(unMapa);
//	}

	public Moto(Esquina unaEsquina) {
		super(unaEsquina);
		setChanged();
		notifyObservers(this);
	}

	public void cambioDeVehiculo() {
		this.jugadorAlQuePertenece
				.setearVehiculo(new Auto(this.esquinaActual));
	}

	public void interactuarCon(Obstaculo obstaculo) {
		obstaculo.aplicar(this);
	}

}
