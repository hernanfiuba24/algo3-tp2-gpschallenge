package fiuba.algo3.persistencia;

import java.io.IOException;

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

import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.obstaculo.Bandera;
import fiuba.algo3.modelo.obstaculo.ControlPolicial;
import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.obstaculo.Piquete;
import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.randomizador.RandomizadorImplementacion;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.sorpresa.Desfavorable;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.sorpresa.Sorpresa;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

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
			throws IOException, ClassNotFoundException, ExcepcionEsquinaInvalida, ExcepcionJugadorYaAsignadoAlVehiculo {
		
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
		
		// Obtenemos la etiqueta raiz
		Element elementRaiz = docXml.getDocumentElement();

		String nombreRaiz = elementRaiz.getNodeName();
		
		Mapa unMapa = cargarMapa(elementRaiz);
		JugadorImplementacion unJugador = cargarJugador(elementRaiz, unMapa);
		return cargarJuego(unJugador, unMapa);

	}
	
	private static Juego cargarJuego(JugadorImplementacion unJugador, Mapa unMapa){
		Juego unJuego = new Juego(unJugador, unMapa) {
			
			@Override
			public void setearCantidadSorprepasYObstaculos() {
				
			}
		};
		return unJuego;
	}
	
	/*
	 
		private static Juego crearJuegoConDatosCargados(String nombreJugador,
			String nombreRaiz, int tamanioMapa, Posicion posicionBandera,
			Posicion posicionVehiculo) {
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
	
	private static Posicion cargarPosicionVehiculo(Element elementRaiz) {

		ArrayList<String> posicionVehiculoString = new ArrayList<String>();
		
		NodeList hijosJuego;
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
		
		return posicionVehiculo;
	}

	private static Posicion cargarPosicionBandera(Element elementRaiz) {
		int posicionBanderaX;
		int posicionBanderaY;
		String posicionBanderaXtexto = "";
		String posicionBanderaYtexto = "";

		NodeList hijosJuego = elementRaiz.getElementsByTagName("Posicion");
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
		
		return posicionBandera;
	}

	private static int cargarTamanioMapa(Element elementRaiz) {
		String altoMapa = "";

		NodeList hijosJuego = elementRaiz.getElementsByTagName("Mapa");
		for (int i = 0; i < hijosJuego.getLength(); i++) {
			Node nodo = hijosJuego.item(i);
			NamedNodeMap atributosMapa = nodo.getAttributes();
			Node nodoAltoMapa = atributosMapa.getNamedItem("Alto");
			altoMapa = nodoAltoMapa.getNodeValue();
		}
		int tamanioMapa = Integer.parseInt(altoMapa);
		return tamanioMapa;
	}

	private static String cargarNombreJugador(Element elementRaiz) {
		
		NodeList hijosJuego = elementRaiz.getElementsByTagName("Jugador");
		
		String nombreJugador = null;
		
		for (int i = 0; i < hijosJuego.getLength(); i++) {
			Node nodo = hijosJuego.item(i);
			NamedNodeMap atributosJugador = nodo.getAttributes();
			Node nodoNombreJugador = atributosJugador.getNamedItem("Nombre");
			nombreJugador = nodoNombreJugador.getNodeValue();
		}
		
		return nombreJugador;		
	}
	*/
	private static Mapa cargarMapa(Element elementRaiz) throws ExcepcionEsquinaInvalida{
		NodeList hijosJuego = elementRaiz.getChildNodes();
		Node nodoMapa = hijosJuego.item(1);
		NamedNodeMap atributosMapa = nodoMapa.getAttributes();
		Node nodoAlto = atributosMapa.item(0);
		Node nodoAncho = atributosMapa.item(1);
		int alto = Integer.parseInt(nodoAlto.getNodeValue());
		int ancho = Integer.parseInt(nodoAncho.getNodeValue());
		Mapa unMapa = new Mapa(alto, ancho);
		
		NodeList hijosMapa = nodoMapa.getChildNodes();
		for (int i=0; i < hijosMapa.getLength(); i++){
			Node nodoEsquina = hijosMapa.item(i);
			NodeList hijosNodoEsquina = nodoEsquina.getChildNodes();
			if (hijosNodoEsquina.item(3) != null){
				Node nodoExtra = hijosNodoEsquina.item(3);
				String nombreExtra = nodoExtra.getNodeName();
				Node nodoPosicion = hijosNodoEsquina.item(1);
				NamedNodeMap atributosPosicion = nodoPosicion.getAttributes();
				int posicionX = Integer.parseInt(atributosPosicion.item(0).getNodeValue());
				int posicionY = Integer.parseInt(atributosPosicion.item(1).getNodeValue());
				Posicion unaPosicion = new Posicion(posicionX, posicionY);
				guardarExtraEnMapa(nombreExtra, unaPosicion, unMapa);
			}
			//cuando hay un Extra solo lo ubica en la posicion 3 del nodo, cuando hay dos uno lo ubica en la
			// posicion 3 y el otro en la 5
			if (hijosNodoEsquina.item(5) != null){
				Node nodoExtra = hijosNodoEsquina.item(5);
				String nombreExtra = nodoExtra.getNodeName();
				Node nodoPosicion = hijosNodoEsquina.item(1);
				NamedNodeMap atributosPosicion = nodoPosicion.getAttributes();
				int posicionX = Integer.parseInt(atributosPosicion.item(0).getNodeValue());
				int posicionY = Integer.parseInt(atributosPosicion.item(1).getNodeValue());
				Posicion unaPosicion = new Posicion(posicionX, posicionY);
				guardarExtraEnMapa(nombreExtra, unaPosicion, unMapa);
			}
		}
		
		return unMapa;
		
	}
	
	private static void guardarExtraEnMapa(String nombreExtra, Posicion unaPosicion, Mapa unMapa) throws ExcepcionEsquinaInvalida {
		Obstaculo unObstaculo = crearObstaculo(nombreExtra);
		if (unObstaculo != null){
			if (unMapa.existeEsquina(unaPosicion)){
				unMapa.devolverUnaEsquina(unaPosicion).setearObstaculo(unObstaculo);
			}
		}
		Sorpresa unaSorpresa = crearSorpresa(nombreExtra);
		if (unaSorpresa != null){
			if (unMapa.existeEsquina(unaPosicion)){
				unMapa.devolverUnaEsquina(unaPosicion).setearSorpresa(unaSorpresa);
			}
		}		
	}

	private static JugadorImplementacion cargarJugador(Element elementRaiz, Mapa unMapa) throws ExcepcionEsquinaInvalida, ExcepcionJugadorYaAsignadoAlVehiculo{
	
		NodeList hijosJuego = elementRaiz.getElementsByTagName("Jugador");
		
		Node nodo = hijosJuego.item(0);
		NamedNodeMap atributosJugador = nodo.getAttributes();
		Node nodoNombreJugador = atributosJugador.getNamedItem("Nombre");
		
		Node nodoMovimientosJugador = atributosJugador.getNamedItem("Movimientos_Hechos");
		
		int movimientosHechos = Integer.parseInt(nodoMovimientosJugador.getNodeValue());
		String nombreJugador = nodoNombreJugador.getNodeValue();
		NodeList hijosJugador = nodo.getChildNodes();
		Node nodoVehiculo = hijosJugador.item(1);
		NodeList hijosVehiculo = nodoVehiculo.getChildNodes();
		Node nodoPosicion = hijosVehiculo.item(1);
		NamedNodeMap atributosPosicion = nodoPosicion.getAttributes();
		
		int posicionX = Integer.parseInt(atributosPosicion.item(0).getNodeValue());
		int posicionY = Integer.parseInt(atributosPosicion.item(1).getNodeValue());
		
		String tipoDeVehiculo = nodoVehiculo.getNodeName();
		Vehiculo unVehiculo = crearVehiculo(tipoDeVehiculo, unMapa, new Posicion(posicionX, posicionY));
		
		JugadorImplementacion unJugador = new JugadorImplementacion(unVehiculo, nombreJugador);
		unJugador.aumentarMovimientoHechos(movimientosHechos);
		
		return unJugador;
	}
	
	private static Vehiculo crearVehiculo(String tipoDeVehiculo, Mapa unMapa, Posicion unaPosicion)
			throws ExcepcionEsquinaInvalida{
		
		if (tipoDeVehiculo.equalsIgnoreCase("Auto")){
			if (unMapa.existeEsquina(unaPosicion)){
				return new Auto(unMapa.devolverUnaEsquina(unaPosicion));
			}
		}else{
			if (tipoDeVehiculo.equalsIgnoreCase("Camioneta")){
				if (unMapa.existeEsquina(unaPosicion)){
					return new Camioneta(unMapa.devolverUnaEsquina(unaPosicion));
				}
			}else{
				if (tipoDeVehiculo.equalsIgnoreCase("Moto")){
					if (unMapa.existeEsquina(unaPosicion)){
						return new Moto(unMapa.devolverUnaEsquina(unaPosicion));
					}
				}
			}
		}
		return null;
	}

	private static Obstaculo crearObstaculo(String nombreObstaculo) {
		if (nombreObstaculo.equalsIgnoreCase("Pozo")){
			return new Pozo();
		}else{
			if (nombreObstaculo.equalsIgnoreCase("Piquete")){
				return new Piquete();
			}else{
				if (nombreObstaculo.equalsIgnoreCase("Control_Policial")){
					return new ControlPolicial(new RandomizadorImplementacion());
				}else{
					if (nombreObstaculo.equalsIgnoreCase("Bandera")){
						return new Bandera();
					}
				}
			}
		
		}
		return null;
	}
	
	private static Sorpresa crearSorpresa(String nombreSorpresa){
		if (nombreSorpresa.equalsIgnoreCase("Favorable")){
			return new Favorable();
		}else{
			if (nombreSorpresa.equalsIgnoreCase("Desfavorable")){
				return new Desfavorable();
			}else{
				if (nombreSorpresa.equalsIgnoreCase("Cambio_de_Vehiculo")){
					return new CambioDeVehiculo();
				}
			}
		
		}
		return null;
	}
}
