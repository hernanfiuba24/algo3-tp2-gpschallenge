package fiuba.algo3.vista.vehiculo;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.vista.PanelMapa;

public class VistaAuto extends VistaVehiculo implements Observer {
	
	public VistaAuto(PanelMapa unPanel){
		super(unPanel);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		panelMapa.dibujarAuto(((Auto)arg).devolverEsquina().devolverPosicion());
		System.out.println("s");
	}
	
}
