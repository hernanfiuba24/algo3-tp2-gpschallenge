package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.obstaculo.Obstaculo;

public class Auto extends Vehiculo {

	// public Auto(Mapa unMapa) throws ExcepcionEsquinaInvalida {
	// super(unMapa);
	// }

	// Si un constructor no invoca expl�citamente un constructor de superclase,
	// el compilador de Java inserta autom�ticamente una llamada al constructor
	// sin argumentos de la superclase. Si la superclase no tiene un constructor
	// sin argumentos, obtendr� un error en tiempo de compilaci�n. Object tiene
	// tal constructor, as� que si Object es la �nica superclase, no hay
	// problema.
	public Auto(Esquina unaEsquina) {
		super(unaEsquina);
		seCambio();
		notificarObservadores(this);
	}

	public void setearEsquina(Esquina nuevaEsquina) {
		super.setearEsquina(nuevaEsquina);
		seCambio();
		notificarObservadores(this);
	}

	public void cambioDeVehiculo() throws ExcepcionJugadorYaAsignadoAlVehiculo {
		this.jugadorAlQuePertenece.setearVehiculo(new Camioneta(
				this.esquinaActual));
	}

	public void interactuarCon(Obstaculo obstaculo) {
		obstaculo.aplicar(this);
	}

}
