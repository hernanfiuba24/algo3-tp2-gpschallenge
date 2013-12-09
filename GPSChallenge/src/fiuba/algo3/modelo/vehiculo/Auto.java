package fiuba.algo3.modelo.vehiculo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.obstaculo.Piquete;

public class Auto extends Vehiculo {

	// public Auto(Mapa unMapa) throws ExcepcionEsquinaInvalida {
	// super(unMapa);
	// }

	// Si un constructor no invoca explicitamente un constructor de superclase,
	// el compilador de Java inserta automaticamente una llamada al constructor
	// sin argumentos de la superclase. Si la superclase no tiene un constructor
	// sin argumentos, obtendra un error en tiempo de compilacion. Object tiene
	// tal constructor, asi que si Object es la unica superclase, no hay
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

	@Override
	public boolean puedeAvanzar(Piquete piquete) {
		return false;
	}

	@Override
	public void actualizar() {
		seCambio();
		notificarObservadores(this);
	}
	
	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Auto");
		Posicion unaPosicion = this.esquinaActual.devolverPosicion();
		
		xmlElement.setAttribute("Movimientos_permitidos", String.valueOf(this.movimientosPermitidos));
		xmlElement.appendChild(unaPosicion.toXml(doc));
		return xmlElement;
	}
}
