package fiuba.algo3.modelo.obstaculo;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicial extends Obstaculo {

	public void aplicar(Jugador unJugador) {
		unJugador.devolverVehiculo().interactuarCon(this);
	}

	public void aplicar(Auto unAuto) {
		double probabilidad = Math.random();
		if (probabilidad <= 0.5)
			unAuto.devolverJugador().aumentarMovimientoHechos(3);
	}

	public void aplicar(Moto unaMoto) {
		double probabilidad = Math.random();
		if (probabilidad <= 0.8)
			unaMoto.devolverJugador().aumentarMovimientoHechos(3);
	}

	public void aplicar(Camioneta unaCamioneta) {
		double probabilidad = Math.random();
		if (probabilidad <= 0.3)
			unaCamioneta.devolverJugador().aumentarMovimientoHechos(3);
	}
}
