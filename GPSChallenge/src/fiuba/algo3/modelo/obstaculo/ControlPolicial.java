package fiuba.algo3.modelo.obstaculo;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicial extends Obstaculo {

	private RandomizadorImplementacion randomizador;
	
	public ControlPolicial(RandomizadorImplementacion unRandomizadorImplementacion){
		this.randomizador = unRandomizadorImplementacion;
	}

	public void aplicar(Auto unAuto) {
		if (this.randomizador.obtenerNumeroRandom() <= 0.5)
			unAuto.devolverJugador().aumentarMovimientoHechos(3);
	}

	public void aplicar(Moto unaMoto) {
		if (this.randomizador.obtenerNumeroRandom() <= 0.8)
			unaMoto.devolverJugador().aumentarMovimientoHechos(3);
	}

	public void aplicar(Camioneta unaCamioneta) {
		if (this.randomizador.obtenerNumeroRandom() <= 0.3)
			unaCamioneta.devolverJugador().aumentarMovimientoHechos(3);
	}
}
