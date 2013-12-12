package fiuba.algo3.modelo.obstaculo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.randomizador.RandomizadorImplementacion;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ControlPolicial extends Obstaculo {

	private RandomizadorImplementacion randomizador;
	
	public ControlPolicial(RandomizadorImplementacion unRandomizadorImplementacion){
		this.randomizador = unRandomizadorImplementacion;
	}

	public void aplicar(Auto unAuto) {
		if (this.randomizador.obtenerNumeroRandom() <= 0.5)
			unAuto.aumentarMovimientosDelJugador(3);
	}

	public void aplicar(Moto unaMoto) {
		if (this.randomizador.obtenerNumeroRandom() <= 0.8)
			unaMoto.aumentarMovimientosDelJugador(3);
	}

	public void aplicar(Camioneta unaCamioneta) {
		if (this.randomizador.obtenerNumeroRandom() <= 0.3)
			unaCamioneta.aumentarMovimientosDelJugador(3);
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
		Element xmlElement = doc.createElement("Control_Policial");
		return xmlElement;
	}

	@Override
	public boolean tieneBandera() {
		return false;
	}
}
