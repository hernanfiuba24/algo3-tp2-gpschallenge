package fiuba.algo3.modelo.puntaje;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Puntaje {

	private String nombre;
	private int valor;

	public Puntaje(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public int getValor() {
		return valor;
	}
	
	public boolean equals(Puntaje puntaje) {
		if(this.valor == puntaje.getValor()){
			if(this.nombre == puntaje.getNombre()){
				return true;
			}
		}
		return false;
	}

	public String devolverNombre() {
		return this.nombre;
	}
	
	public int devolverValor(){
		return this.valor;
	}

	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Puntaje");
		xmlElement.setAttribute("Nombre", this.nombre);
		xmlElement.setAttribute("Valor", String.valueOf(this.valor));
		return xmlElement;
	}

}
