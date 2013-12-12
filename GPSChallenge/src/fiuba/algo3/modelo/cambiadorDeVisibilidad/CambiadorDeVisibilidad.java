package fiuba.algo3.modelo.cambiadorDeVisibilidad;

import java.util.ArrayList;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public abstract class CambiadorDeVisibilidad {

	private Mapa unMapa;

	public CambiadorDeVisibilidad(Mapa mapa) {
		this.unMapa = mapa;
	}
	
	public boolean devolverVisibilidad(Esquina unaEsquina) {
		return unaEsquina.devolverVisibilidad();
	}

	protected abstract void cambiarVisiblidad(Esquina unaEsquina);

	private ArrayList<Posicion> devolverPosicionesARadioDeEsquina(int unRadio,
			Esquina unaEsquina) {
		ArrayList<Posicion> posicionesRadioUnRadio = unaEsquina
				.devolverPosicionesADistanciaDeRadio(unRadio);
		return posicionesRadioUnRadio;
	}

	protected void recorrerPosicionesCambiandoVisibilidad(Esquina esquinaActual)
			throws ExcepcionEsquinaInvalida {

		ArrayList<Posicion> posicionesRadioDos = this
				.devolverPosicionesARadioDeEsquina(2, esquinaActual);

		for (int indice = 0; indice < posicionesRadioDos.size(); indice++) {
			if (this.unMapa.existeEsquina(posicionesRadioDos.get(indice)))
			this.cambiarVisiblidad(this.unMapa
					.devolverUnaEsquina(posicionesRadioDos.get(indice)));
		}
	}

}
