package fiuba.algo3.modelo.notificadores;

import java.util.ArrayList;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;

public class ObjetoObservable {

	private static ArrayList<ObjetoObservador> observadores;
	private boolean cambio = false;

	// APLICANDO PATRON SINGLETON
	private static ArrayList<ObjetoObservador> devolverEstado() {
		if (observadores == null)
			return new ArrayList<ObjetoObservador>();
		return observadores;
	}

	public ObjetoObservable() {
		observadores = ObjetoObservable.devolverEstado();
		// this.observadores = new ArrayList<ObjetoObservador>();
	}

	public void seCambio() {
		this.cambio = true;
	}

	public void agregarObservador(ObjetoObservador o) {
		if (o == null)
			throw new NullPointerException();
		if (!ObjetoObservable.observadores.contains(o)) {
			ObjetoObservable.observadores.add(o);
		}
	}

	public void notificarObservadores(Auto unAuto) {
		if (this.cambio == false)
			return;
		for (int i = 0; i < ObjetoObservable.observadores.size(); i++) {
			ObjetoObservable.observadores.get(i).actualizar(this, unAuto);
		}
		this.cambio = false;
	}

	public void notificarObservadores(Moto unaMoto) {

		for (int i = 0; i < ObjetoObservable.observadores.size(); i++) {
			ObjetoObservable.observadores.get(i).actualizar(this, unaMoto);
		}
		this.cambio = false;
	}

	public void notificarObservadores(Camioneta unaCamioneta) {

		for (int i = 0; i < ObjetoObservable.observadores.size(); i++) {
			ObjetoObservable.observadores.get(i).actualizar(this, unaCamioneta);
		}
		this.cambio = false;
	}

}
