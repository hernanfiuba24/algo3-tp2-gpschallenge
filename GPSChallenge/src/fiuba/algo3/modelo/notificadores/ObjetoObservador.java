package fiuba.algo3.modelo.notificadores;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public interface ObjetoObservador {

	void actualizar(ObjetoObservable o, Auto unAuto);
	
	void actualizar(ObjetoObservable o, Moto unMoto);
	
	void actualizar(ObjetoObservable o, Camioneta unaCamioneta);
	
}
