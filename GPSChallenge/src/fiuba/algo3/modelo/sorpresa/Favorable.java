package fiuba.algo3.modelo.sorpresa;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Posicion;


public class Favorable extends Extra {

	public Favorable() {
		this.porcentaje = 20;
	}
	
	protected int signo(){
		return 1;
	}

	@Override
	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Favorable");
		return xmlElement;
	}

}
