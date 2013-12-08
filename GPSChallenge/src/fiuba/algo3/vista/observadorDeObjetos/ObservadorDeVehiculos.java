package fiuba.algo3.vista.observadorDeObjetos;

import fiuba.algo3.modelo.notificadores.ObjetoObservable;
import fiuba.algo3.modelo.notificadores.ObjetoObservador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.vista.PanelMapa;
import fiuba.algo3.vista.vistaVehiculo.VistaAuto;
import fiuba.algo3.vista.vistaVehiculo.VistaCamioneta;
import fiuba.algo3.vista.vistaVehiculo.VistaMoto;

public class ObservadorDeVehiculos implements ObjetoObservador {
	
	private PanelMapa panelMapa;

	public ObservadorDeVehiculos(PanelMapa unPanel){
		this.panelMapa = unPanel;
	}

	@Override
	public void actualizar(ObjetoObservable o, Auto unAuto) {		
		VistaAuto unaVistaAuto = new VistaAuto();
		unaVistaAuto.dibujarAuto(unAuto.devolverPosicionActual(), this.panelMapa);
	}

	@Override
	public void actualizar(ObjetoObservable o, Moto unaMoto) {		
		VistaMoto unaVistaMoto = new VistaMoto();
		unaVistaMoto.dibujarMoto(unaMoto.devolverPosicionActual(), this.panelMapa);
	}

	@Override
	public void actualizar(ObjetoObservable o, Camioneta unaCamioneta) {		
		VistaCamioneta unaVistaCamioneta = new VistaCamioneta();
		unaVistaCamioneta.dibujarAuto(unaCamioneta.devolverPosicionActual(), this.panelMapa);
	}

}
