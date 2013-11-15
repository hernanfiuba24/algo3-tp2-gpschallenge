package fiuba.algo3.modelo.obstaculo;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

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
}
