package fiuba.algo3.modelo.obstaculo;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class Piquete extends Obstaculo {
	
	private Esquina esquinaAnterior;
	
	public Piquete(Esquina unaEsquinaAnterior){
		this.esquinaAnterior = unaEsquinaAnterior;
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

}
