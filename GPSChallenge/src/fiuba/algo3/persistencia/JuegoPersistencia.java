package fiuba.algo3.persistencia;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.JuegoDificil;
import fiuba.algo3.modelo.juego.JuegoFacil;
import fiuba.algo3.modelo.juego.JuegoIntermedio;

public class JuegoPersistencia {

	public static void guardarGpsChallenge(String nombreArchivo, Juego unJuego)
			throws IOException, ParserConfigurationException, DOMException,
			ExcepcionEsquinaInvalida {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder loader = factory.newDocumentBuilder();
		Document doc = loader.newDocument();

		doc.appendChild(unJuego.toXml(doc));

		XMLSerializer serializer = new XMLSerializer();

		com.sun.org.apache.xml.internal.serialize.OutputFormat outFormat = new com.sun.org.apache.xml.internal.serialize.OutputFormat();

		outFormat.setVersion("1.0");
		outFormat.setIndenting(true);
		outFormat.setIndent(4);

		serializer.setOutputFormat(outFormat);
		serializer.setOutputCharStream(new java.io.FileWriter(nombreArchivo));
		serializer.serialize(doc);
	}

	public static Juego cargarGpsChallenge(String nombreArchivo)
			throws IOException, ClassNotFoundException {
		DOMParser parser = new DOMParser();

		try {
			parser.parse(nombreArchivo);

		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		Document docXml = parser.getDocument();

		String nombreJugador = "";
		String tamanioMapaString = "";
		ArrayList<String> posicionVehiculoString = new ArrayList<String>();
		// Obtenemos la etiqueta raiz
		Element elementRaiz = docXml.getDocumentElement();

		String nombreRaiz = elementRaiz.getNodeName();

		// -------------------------------------------------------------------------------

		// Iteramos sobre sus hijos
		NodeList hijosJuego = elementRaiz.getElementsByTagName("Jugador");

		for (int i = 0; i < hijosJuego.getLength(); i++) {
			Node nodo = hijosJuego.item(i);
			NamedNodeMap atributosJugador = nodo.getAttributes();
			Node nodoNombreJugador = atributosJugador.getNamedItem("Nombre");
			nombreJugador = nodoNombreJugador.getNodeValue();
		}
		String altoMapa = "";

		hijosJuego = elementRaiz.getElementsByTagName("Mapa");
		for (int i = 0; i < hijosJuego.getLength(); i++) {
			Node nodo = hijosJuego.item(i);
			NamedNodeMap atributosMapa = nodo.getAttributes();
			Node nodoAltoMapa = atributosMapa.getNamedItem("Alto");
			altoMapa = nodoAltoMapa.getNodeValue();
		}
		int tamanioMapa = Integer.parseInt(altoMapa);

		// -------------------------------------------------------------------------------

		int posicionBanderaX;
		int posicionBanderaY;
		String posicionBanderaXtexto = "";
		String posicionBanderaYtexto = "";

		hijosJuego = elementRaiz.getElementsByTagName("Posicion");
		for (int i = 0; i < hijosJuego.getLength(); i++) {
			Node nodo = hijosJuego.item(i);
			NamedNodeMap atributosBandera = nodo.getAttributes();
			Node nodoPosicionBanderaX = atributosBandera
					.getNamedItem("PosicionX");
			Node nodoPosicionBanderaY = atributosBandera
					.getNamedItem("PosicionY");
			posicionBanderaXtexto = nodoPosicionBanderaX.getNodeValue();
			posicionBanderaYtexto = nodoPosicionBanderaY.getNodeValue();

		}
		posicionBanderaX = Integer.parseInt(posicionBanderaXtexto);
		posicionBanderaY = Integer.parseInt(posicionBanderaYtexto);

		// Creo la posicion de la bandera para pasarsela al constructor del
		// juego

		Posicion posicionBandera = new Posicion(posicionBanderaX,
				posicionBanderaY);
		
//		------------------------------------------------------------------------------

		hijosJuego = elementRaiz.getElementsByTagName("Jugador");
		int posicionVehiculoX;
		int posicionVehiculoY;
		
		Node nodoJugador = hijosJuego.item(0);
		
		
		NodeList hijosJugador = nodoJugador.getChildNodes();
		Node nodoVehiculo = hijosJugador.item(1);
		
		NodeList hijosVehiculo = nodoVehiculo.getChildNodes();
		
		Node nodoPosicionVehiculo = hijosVehiculo.item(1);
		
		NamedNodeMap atributosVehiculoPosicion = nodoPosicionVehiculo.getAttributes();

		Node nodoVehiculoPosicionX = atributosVehiculoPosicion.getNamedItem("PosicionX");
		Node nodoVehiculoPosicionY = atributosVehiculoPosicion.getNamedItem("PosicionY");

		posicionVehiculoString.add(nodoVehiculoPosicionX.getNodeValue());
		posicionVehiculoString.add(nodoVehiculoPosicionY.getNodeValue());

		posicionVehiculoX = Integer.parseInt(posicionVehiculoString.get(0));
		posicionVehiculoY = Integer.parseInt(posicionVehiculoString.get(1));
		
		Posicion posicionVehiculo = new Posicion(posicionVehiculoX, posicionVehiculoY);	
		
//		----------------------------------------------------------------------------------

		Juego unJuego = null;
		
		if (nombreRaiz.equalsIgnoreCase("GpsChallengeDificil")){
			try {
				unJuego = new JuegoDificil(nombreJugador, tamanioMapa,
						posicionBandera, posicionVehiculo);
			} catch (ExcepcionEsquinaInvalida e) {
				e.printStackTrace();
			} catch (ExcepcionJugadorYaAsignadoAlVehiculo e) {
				e.printStackTrace();
			}
		}else{
			if (nombreRaiz.equalsIgnoreCase("GpsChallengeIntermedio")){
				try {
					unJuego = new JuegoIntermedio(nombreJugador, tamanioMapa,
							posicionBandera, posicionVehiculo);
				} catch (ExcepcionEsquinaInvalida e) {
					e.printStackTrace();
				} catch (ExcepcionJugadorYaAsignadoAlVehiculo e) {
					e.printStackTrace();
				}
			}else{
				if (nombreRaiz.equalsIgnoreCase("GpsChallengeFacil")){
					try {
						unJuego = new JuegoFacil(nombreJugador, tamanioMapa,
								posicionBandera, posicionVehiculo);
					} catch (ExcepcionEsquinaInvalida e) {
						e.printStackTrace();
					} catch (ExcepcionJugadorYaAsignadoAlVehiculo e) {
						e.printStackTrace();
					}
				}
			}
		}

		return unJuego;

	}
}
