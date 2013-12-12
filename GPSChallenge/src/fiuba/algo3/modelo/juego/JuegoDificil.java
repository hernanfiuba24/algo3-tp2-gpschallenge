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


public class JuegoDificil extends Juego {
	
	final int MULTIPLICADOR_DIFICULTAD = 3;

	public JuegoDificil(String nombreDeJugador, int tamanioMapa,
			Posicion posicionBandera, Vehiculo unVehiculo) throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {
		super(nombreDeJugador, tamanioMapa, posicionBandera, unVehiculo);
		this.movimientosRestantes = calcularLimiteDeMovimientos()+ 5;
	}
	
	public JuegoDificil(JugadorImplementacion unJugador, Mapa unMapa, Posicion posicionBandera, int movimientosRestantes){
		super(unJugador, unMapa, posicionBandera, movimientosRestantes);
	}

	@Override
	protected void setearCantidadSorprepasYObstaculos() {
		this.cantidadDePiquetes = 5;
		this.cantidadDeControlesPoliciales = 5;
		this.cantidadDePozos = 5;
		this.cantidadDeFavorables = 5;
		this.cantidadDeDesfavorables = 5;
		this.cantidadDeCambiosDeVehiculos = 3;

	}
	
	public Node toXml(Document doc) throws DOMException, ExcepcionEsquinaInvalida{
		Element xmlElement = doc.createElement("GpsChallengeDificil");
		xmlElement.setAttribute("Movimientos_Restantes", String.valueOf(this.movimientosRestantes));
		xmlElement.appendChild(this.unMapa.toXml(doc));
		xmlElement.appendChild(this.unJugador.toXml(doc));
		xmlElement.appendChild(this.posicionBandera.toXml(doc));
		return xmlElement;
	}

	@Override
	public int calcularPuntajeFinal() {
		return (this.movimientosRestantes) * MULTIPLICADOR_DIFICULTAD;		
	}

}
