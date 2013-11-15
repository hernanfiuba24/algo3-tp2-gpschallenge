package fiuba.algo3.modelo.obstaculo;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class ControlPolicial extends Obstaculo {
	
	private double probabilidad;
	
	public double obtenerProbabilidad(){
		return this.probabilidad;
	}

	public void aplicar(Auto unAuto) {
		this.probabilidad = Math.random();
		if (this.probabilidad <= 0.5)
			unAuto.devolverJugador().aumentarMovimientoHechos(3);
	}

	public void aplicar(Moto unaMoto) {
		this.probabilidad = Math.random();
		if (this.probabilidad <= 0.8)
			unaMoto.devolverJugador().aumentarMovimientoHechos(3);
	}

	public void aplicar(Camioneta unaCamioneta) {
		this.probabilidad = Math.random();
		if (this.probabilidad <= 0.3)
			unaCamioneta.devolverJugador().aumentarMovimientoHechos(3);
	}
}
