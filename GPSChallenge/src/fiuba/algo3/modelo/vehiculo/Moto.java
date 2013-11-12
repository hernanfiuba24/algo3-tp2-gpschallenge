package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public class Moto extends Vehiculo {

	public Moto(Mapa unMapa) {
		super(unMapa);
	}

	public Moto(Esquina unaEsquina) {
		super(unaEsquina);
	}

	public void cambioVehiculo() {
		this.jugadorAlQuePertenece
				.guardarVehiculo(new Auto(this.esquinaActual));
	}

	public void interactuarCon(Obstaculo obstaculo) {
		obstaculo.aplicar(this);
	}

}
