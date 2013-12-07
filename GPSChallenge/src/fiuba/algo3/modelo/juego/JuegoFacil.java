package fiuba.algo3.modelo.juego;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public class JuegoFacil extends Juego {

	// public JuegoFacil() throws ExcepcionEsquinaInvalida {
	// this.setearCantidadSorprepasYObstaculos();
	// this.unMapa = new Mapa(3, 3);
	// this.unJugador = new Jugador(new Auto(this.unMapa), null);
	// this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
	// .devolverBandera();
	// this.completarMapaConExtras();
	// setChanged();
	// notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
	// .devolverPosicion());
	//
	// }

	public JuegoFacil(String nombreDeJugador, int tamanioMapa,
			Posicion posicionBandera, Posicion posicionVehiculo) throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {
		super(nombreDeJugador, tamanioMapa, posicionBandera, posicionVehiculo);
	}

	// this.setearCantidadSorprepasYObstaculos();
	// this.unMapa = new Mapa(3, 3);
	// this.unJugador = new Jugador(new Auto(this.unMapa), nombreDeJugador);
	// this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
	// .devolverBandera();
	// this.completarMapaConExtras();
	// setChanged();
	// notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
	// .devolverPosicion());

	public void setearCantidadSorprepasYObstaculos() {
		this.cantidadDePiquetes = 1;
		this.cantidadDeControlesPoliciales = 1;
		this.cantidadDePozos = 1;
		this.cantidadDeFavorables = 1;
		this.cantidadDeDesfavorables = 1;
		this.cantidadDeCambiosDeVehiculos = 1;
	}
	
	public Node toXml(Document doc) throws DOMException, ExcepcionEsquinaInvalida{
		Element xmlElement = doc.createElement("GpsChallengeFacil");
		xmlElement.appendChild(this.unMapa.toXml(doc));
		xmlElement.appendChild(this.unJugador.toXml(doc));
		xmlElement.appendChild(this.posicionBandera.toXml(doc));
		return xmlElement;
	}

}
