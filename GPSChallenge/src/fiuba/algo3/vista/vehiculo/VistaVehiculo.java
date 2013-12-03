package fiuba.algo3.vista.vehiculo;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.vista.PanelMapa;

public class VistaVehiculo implements Observer {

	protected PanelMapa panelMapa;

	public VistaVehiculo(PanelMapa unPanel) {
		this.panelMapa = unPanel;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

}
