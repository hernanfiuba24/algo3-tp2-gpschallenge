package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public class Camioneta extends Vehiculo {

//	public Camioneta(Mapa unMapa) throws ExcepcionEsquinaInvalida {
//		super(unMapa);
//	}

	public Camioneta(Esquina unaEsquina) {
		super(unaEsquina);
	}

	public void cambioDeVehiculo() {
		this.jugadorAlQuePertenece
				.setearVehiculo(new Moto(this.esquinaActual));
	}

	public void interactuarCon(Obstaculo obstaculo) {
		obstaculo.aplicar(this);
	}

}
