package fiuba.algo3.modelo.obstaculo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Bandera extends Obstaculo {

	@Override
	public void aplicar(Auto unAuto) {
		unAuto.devolverJugador().ganar();		
	}

	@Override
	public void aplicar(Moto unaMoto) {
		unaMoto.devolverJugador().ganar();	
	}

	@Override
	public void aplicar(Camioneta unaCamioneta) {
		unaCamioneta.devolverJugador().ganar();		
	}

	@Override
	public void setearEsquinaAnterior(Esquina esquinaAnterior) {		
	}

	@Override
	public boolean puedeAvanzar(Vehiculo vehiculo) {
		return true;
	}

	@Override
	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Bandera");
		return xmlElement;
	}

	@Override
	public boolean tieneBandera() {
		return true;
	}
}
