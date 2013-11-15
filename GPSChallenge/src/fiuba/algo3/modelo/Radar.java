package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class Radar {

	private Mapa unMapa;

	public Radar(Mapa mapa) {
		this.unMapa = mapa;
	}

	public Radar() {

	}

	public void encenderVisibilidad(Esquina unaEsquina) {
		unaEsquina.encenderVisibilidad();
	}
	
	public void apagarVisibilidad(Esquina unaEsquina) {
		unaEsquina.apagarVisibilidad();
	}

	public boolean devolverVisibilidad(Esquina unaEsquina) {
		return unaEsquina.devolverVisibilidad();
	}

	public void encenderVisibilidadDosALaRedonda(Esquina esquinaActual) throws ExcepcionEsquinaInvalida {
		ArrayList<Posicion> listaDePosiciones = esquinaActual.devolverPosicionesADistanciaDeRadio(2);
		for (int indice = 0; indice < listaDePosiciones.size(); indice++){
			if (this.unMapa.existeEsquina(listaDePosiciones.get(indice))){
				this.encenderVisibilidad(unMapa.devolverUnaEsquina(listaDePosiciones.get(indice)));
			}
		}
	}
	
	public void apagarVisibilidadDosALaRedonda(Esquina esquinaActual) throws ExcepcionEsquinaInvalida {
		ArrayList<Posicion> listaDePosiciones = esquinaActual.devolverPosicionesADistanciaDeRadio(2);
		for (int indice = 0; indice < listaDePosiciones.size(); indice++){
			if (this.unMapa.existeEsquina(listaDePosiciones.get(indice))){
					this.apagarVisibilidad(unMapa.devolverUnaEsquina(listaDePosiciones.get(indice)));
			}
		}
	}
}
