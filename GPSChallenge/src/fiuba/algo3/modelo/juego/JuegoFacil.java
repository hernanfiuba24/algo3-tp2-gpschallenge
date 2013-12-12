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
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class JuegoFacil extends Juego {
	
	final int MULTIPLICADOR_DIFICULTAD = 1;

	public JuegoFacil(String nombreDeJugador, int tamanioMapa,
			Posicion posicionBandera, Vehiculo unVehiculo) throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {
		super(nombreDeJugador, tamanioMapa, posicionBandera, unVehiculo);
		this.movimientosMaximo = 5;
	}
	
	public JuegoFacil(JugadorImplementacion unJugador, Mapa unMapa, Posicion posicionBandera){
		super(unJugador, unMapa, posicionBandera);
	}

	protected void setearCantidadSorprepasYObstaculos() {
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
	
	@Override
	public int calcularPuntajeFinal() {
		return (this.movimientosMaximo - this.unJugador.devolverMovimientosHechos()) * MULTIPLICADOR_DIFICULTAD;		
	}

}
