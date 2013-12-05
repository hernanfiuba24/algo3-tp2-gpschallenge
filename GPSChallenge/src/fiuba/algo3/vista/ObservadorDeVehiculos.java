package fiuba.algo3.vista;

import fiuba.algo3.modelo.notificadores.ObjetoObservable;
import fiuba.algo3.modelo.notificadores.ObjetoObservador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class ObservadorDeVehiculos implements ObjetoObservador {
	
	private PanelMapa panelMapa;

	public ObservadorDeVehiculos(PanelMapa unPanel){
		this.panelMapa = unPanel;
	}

	@Override
	public void actualizar(ObjetoObservable o, Auto unAuto) {
		this.panelMapa.dibujarAuto(unAuto.devolverPosicionActual());

	}

	@Override
	public void actualizar(ObjetoObservable o, Moto unaMoto) {
		this.panelMapa.dibujarMoto(unaMoto.devolverPosicionActual());

	}

	@Override
	public void actualizar(ObjetoObservable o, Camioneta unaCamioneta) {
		this.panelMapa.dibujarCamioneta(unaCamioneta.devolverPosicionActual());

	}

}
