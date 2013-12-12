package fiuba.algo3.modelo.sorpresa;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public interface Sorpresa {

	public abstract void aplicar(Jugador unJugador)
			throws ExcepcionJugadorYaAsignadoAlVehiculo;

	public abstract Node toXml(Document doc);

}
