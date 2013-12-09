package fiuba.algo3.modelo.obstaculo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Pozo extends Obstaculo {

	public void aplicar(Auto unAuto){
		unAuto.devolverJugador().aumentarMovimientoHechos(3);
	}
	
	public void aplicar (Moto unaMoto){
		unaMoto.devolverJugador().aumentarMovimientoHechos(3);
	}
	
	public void aplicar (Camioneta unaCamioneta){
		unaCamioneta.devolverJugador().aumentarMovimientoHechos(0);
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
		Element xmlElement = doc.createElement("Pozo");
		return xmlElement;
	}

	@Override
	public boolean tieneBandera() {
		return false;
	}
	
}
