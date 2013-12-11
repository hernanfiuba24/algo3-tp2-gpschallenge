package fiuba.algo3.modelo.juego;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;

public class JuegoIntermedio extends Juego {
	
	final int MULTIPLICADOR_DIFICULTAD = 2;

	// public JuegoIntermedio() throws ExcepcionEsquinaInvalida {
	// this.setearCantidadSorprepasYObstaculos();
	// this.unMapa = new Mapa(5, 5);
	// this.unJugador = new Jugador(new Auto(this.unMapa), null);
	// this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
	// .devolverBandera();
	// this.completarMapaConExtras();
	// setChanged();
	// notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
	// .devolverPosicion());
	// }

	public JuegoIntermedio(String nombreDeJugador, int tamanioMapa,
			Posicion posicionBandera, Posicion posicionVehiculo) throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {
		super(nombreDeJugador, tamanioMapa, posicionBandera, posicionVehiculo);
		this.movimientosMaximo = 15;
	}
	
	public JuegoIntermedio(JugadorImplementacion unJugador, Mapa unMapa, Posicion posicionBandera){
		super(unJugador, unMapa, posicionBandera);
	}

	// this.setearCantidadSorprepasYObstaculos();
	// this.unMapa = new Mapa(5, 5);
	// this.unJugador = new Jugador(new Auto(this.unMapa), nombreDeJugador);
	// this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(3, 3))
	// .devolverBandera();
	// this.completarMapaConExtras();
	// setChanged();
	// notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
	// .devolverPosicion());

	public void setearCantidadSorprepasYObstaculos() {
		this.cantidadDePiquetes = 2;
		this.cantidadDeControlesPoliciales = 2;
		this.cantidadDePozos = 2;
		this.cantidadDeFavorables = 2;
		this.cantidadDeDesfavorables = 2;
		this.cantidadDeCambiosDeVehiculos = 2;
	}
	
	public Node toXml(Document doc) throws DOMException, ExcepcionEsquinaInvalida{
		Element xmlElement = doc.createElement("GpsChallengeIntermedio");
		xmlElement.appendChild(this.unMapa.toXml(doc));
		xmlElement.appendChild(this.unJugador.toXml(doc));
		xmlElement.appendChild(this.posicionBandera.toXml(doc));
		return xmlElement;
	}
	
	@Override
	public int calcularPuntajeFinal() {
		return (this.movimientosMaximo - this.unJugador.devolverMovimientosHechos()) * MULTIPLICADOR_DIFICULTAD;		
	}

}
