package fiuba.algo3.modelo.obstaculo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete extends Obstaculo {	
	
	public void aplicar(Moto unaMoto) {
		unaMoto.aumentarMovimientosDelJugador(2);
	}
	
	@Override
	public boolean puedeAvanzar(Vehiculo vehiculo) {
		return vehiculo.puedeAvanzar(this);		
	}

	@Override
	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Piquete");
		return xmlElement;
	}

	@Override
	public boolean tieneBandera() {
		return false;
	}

	@Override
	public void aplicar(Auto unAuto) {		
	}

	@Override
	public void aplicar(Camioneta unaCamioneta) {		
	}
}
