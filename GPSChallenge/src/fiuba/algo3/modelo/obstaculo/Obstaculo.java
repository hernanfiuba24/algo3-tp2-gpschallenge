package fiuba.algo3.modelo.obstaculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public abstract class Obstaculo {

	public void aplicar(Jugador unJugador) {
		unJugador.devolverVehiculo().interactuarCon(this);
	}

	public abstract void aplicar(Auto unAuto);

	public abstract void aplicar(Moto unaMoto);

	public abstract void aplicar(Camioneta unaCamioneta);
	
	public abstract void setearEsquinaAnterior(Esquina esquinaAnterior);

}
