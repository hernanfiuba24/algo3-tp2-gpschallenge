package fiuba.algo3.modelo.juego;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public class JuegoDificil extends Juego {

	// public JuegoDificil() throws ExcepcionEsquinaInvalida {
	// this.setearCantidadSorprepasYObstaculos();
	// this.unMapa = new Mapa(8, 8);
	// this.unJugador = new Jugador(new Auto(this.unMapa), null);
	// this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
	// .devolverBandera();
	// this.completarMapaConExtras();
	// setChanged();
	// notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
	// .devolverPosicion());
	// }

	public JuegoDificil(String nombreDeJugador, int tamanioMapa,
			Posicion posicionBandera, Posicion posicionVehiculo) throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {
		super(nombreDeJugador, tamanioMapa, posicionBandera, posicionVehiculo);
	}

	@Override
	public void setearCantidadSorprepasYObstaculos() {
		this.cantidadDePiquetes = 5;
		this.cantidadDeControlesPoliciales = 5;
		this.cantidadDePozos = 5;
		this.cantidadDeFavorables = 5;
		this.cantidadDeDesfavorables = 5;
		this.cantidadDeCambiosDeVehiculos = 3;

	}
	
	public Node toXml(Document doc) throws DOMException, ExcepcionEsquinaInvalida{
		Element xmlElement = doc.createElement("GpsChallengeDificil");
		xmlElement.appendChild(this.unMapa.toXml(doc));
		xmlElement.appendChild(this.unJugador.toXml(doc));
		xmlElement.appendChild(this.posicionBandera.toXml(doc));
		return xmlElement;
	}

}
