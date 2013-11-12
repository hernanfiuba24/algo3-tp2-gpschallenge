package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public class Auto extends Vehiculo {

	public Auto(Mapa unMapa) {
		super(unMapa);
	}

	public Auto(Esquina unaEsquina) {
		super(unaEsquina);
	}

	public void cambioVehiculo() {
		this.jugadorAlQuePertenece.guardarVehiculo(new Camioneta(
				this.esquinaActual));
	}

	public void interactuarCon(Obstaculo obstaculo) {
		obstaculo.aplicar(this);
	}

}
