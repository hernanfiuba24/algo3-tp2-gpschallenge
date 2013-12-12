package fiuba.algo3.modelo.sorpresa;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public class CambioDeVehiculo implements Sorpresa {
	
	public void aplicar(Jugador unJugador) throws ExcepcionJugadorYaAsignadoAlVehiculo{
		unJugador.aplicarCambioDeVehiculo();
	}

	@Override
	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Cambio_de_Vehiculo");
		return xmlElement;
	}
}
