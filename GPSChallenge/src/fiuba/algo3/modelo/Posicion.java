package fiuba.algo3.modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.direccion.Direccion;

public class Posicion {
	private int fila;
	private int columna;

	public Posicion(int unaFila, int unaColumna) {
		this.fila = unaFila;
		this.columna = unaColumna;
	}

	public int devolverPosicionFila() {
		return this.fila;
	}

	public int devolverPosicionColumna() {
		return this.columna;
	}
	
	public boolean equals(Posicion unaPosicion){
		if ((this.devolverPosicionFila() == unaPosicion.devolverPosicionFila()) &&
		(this.devolverPosicionColumna() == unaPosicion.devolverPosicionColumna()))
			return true;
		return false;
	}

	public Posicion calcularPosicionSiguiente(Direccion unaDireccion) {
		Posicion unaPosicion = new Posicion(this.devolverPosicionFila() - unaDireccion.devolverX(), this.devolverPosicionColumna() - unaDireccion.devolverY());
		return unaPosicion;
	}

	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Posicion");
		xmlElement.setAttribute("PosicionX", String.valueOf(this.fila));
		xmlElement.setAttribute("PosicionY", String.valueOf(this.columna));

		
		return xmlElement;
	}

}
