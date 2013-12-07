package fiuba.algo3.modelo.obstaculo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete extends Obstaculo {
	
	private Esquina esquinaAnterior;
	
	public Piquete(/*Esquina unaEsquinaAnterior*/){
		//this.esquinaAnterior = unaEsquinaAnterior;
	}
	
	public void setearEsquinaAnterior(Esquina esquinaAnterior){
		this.esquinaAnterior = esquinaAnterior;
	}
	
	public void aplicar(Auto unAuto) {
		//unAuto.devolverJugador().cambiarDireccionContraria();
		unAuto.setearEsquina(this.esquinaAnterior);
	}
	
	public void aplicar(Moto unaMoto) {
		unaMoto.devolverJugador().aumentarMovimientoHechos(2);
	}
	
	public void aplicar(Camioneta unaCamioneta) {
//		unaCamioneta.devolverJugador().cambiarDireccionContraria();
		unaCamioneta.setearEsquina(this.esquinaAnterior);
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

}
