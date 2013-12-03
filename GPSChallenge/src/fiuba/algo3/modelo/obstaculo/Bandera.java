package fiuba.algo3.modelo.obstaculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

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
}
