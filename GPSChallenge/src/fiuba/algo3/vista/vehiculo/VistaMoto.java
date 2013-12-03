package fiuba.algo3.vista.vehiculo;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.vista.PanelMapa;

public class VistaMoto extends VistaVehiculo implements Observer {

	public VistaMoto(PanelMapa unPanel) {
		super(unPanel);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		panelMapa.dibujarMoto(((Moto)arg).devolverEsquina().devolverPosicion());
		System.out.println("m");
	}

}
