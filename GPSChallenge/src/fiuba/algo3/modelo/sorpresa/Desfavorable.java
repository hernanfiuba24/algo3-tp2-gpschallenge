package fiuba.algo3.modelo.sorpresa;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class Desfavorable extends Extra {

	public Desfavorable() {
		this.porcentaje = 25;
	}
	
	protected int signo(){
		return (-1);
	}

	@Override
	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Desfavorable");
		return xmlElement;
	}
	
}
