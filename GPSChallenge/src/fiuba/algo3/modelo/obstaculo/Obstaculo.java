package fiuba.algo3.modelo.obstaculo;

import java.util.Observable;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public abstract class Obstaculo extends Observable {

	public void aplicar(Jugador unJugador) {
		unJugador.devolverVehiculo().interactuarCon(this);
	}

	public abstract void aplicar(Auto unAuto);

	public abstract void aplicar(Moto unaMoto);

	public abstract void aplicar(Camioneta unaCamioneta);
	
	public abstract void setearEsquinaAnterior(Esquina esquinaAnterior);

	public abstract boolean puedeAvanzar(Vehiculo vehiculo);

	public abstract Node toXml(Document doc) ;

}
