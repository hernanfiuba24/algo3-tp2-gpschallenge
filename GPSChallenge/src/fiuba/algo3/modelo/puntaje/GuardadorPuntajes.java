package fiuba.algo3.modelo.puntaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GuardadorPuntajes {

	private TreeMap<Integer, String> puntajesTotales = new TreeMap<Integer, String>(Collections.reverseOrder());

	
	public void guardarPuntaje(Puntaje unPuntaje) {
		this.puntajesTotales.put(unPuntaje.devolverValor(), unPuntaje.devolverNombre());
	}

	public Puntaje devolverPuntaje(int posicion) {
		//lista de entradas del diccionario
		ArrayList<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(this.puntajesTotales.entrySet());
		//pido la entrada en la posicion pedida
		Map.Entry<Integer, String> entrada = list.get(posicion);
		//le pido el valor(nombre del Jugador) a la entrada
		String nombre = entrada.getValue();
		//le pido la clave(puntuacion del Jugador) a la entrada
		int puntuacion = entrada.getKey();
		Puntaje puntaje = new Puntaje(nombre, puntuacion);
		return puntaje;

	}
	
	public TreeMap<Integer, String> devolverPuntajesTotales(){
		return this.puntajesTotales;
	}
	
	public Node toXml(Document doc) throws DOMException{
		Element xmlElement = doc.createElement("PuntajesTotales");
		for (int i=0; i < this.puntajesTotales.size();i++){		
		xmlElement.appendChild(this.devolverPuntaje(i).toXml(doc));
		}
		return xmlElement;
	}
}
