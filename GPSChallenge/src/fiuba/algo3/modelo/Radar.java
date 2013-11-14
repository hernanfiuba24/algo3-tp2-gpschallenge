package fiuba.algo3.modelo;

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

	public void encenderVisibilidadDosALaRedonda(Esquina esquinaActual) {
		this.encenderVisibilidad(esquinaActual);
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				this.encenderVisibilidad(unMapa.dameEsquina(new Posicion(
						esquinaActual.devolverPosicion().devolverPosicionFila()
								+ i, esquinaActual.devolverPosicion()
								.devolverPosicionColumna() + j)));
			}
		}
	}
	
	public void apagarVisibilidadDosALaRedonda(Esquina esquinaActual) {
		this.apagarVisibilidad(esquinaActual);
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				this.apagarVisibilidad(unMapa.dameEsquina(new Posicion(
						esquinaActual.devolverPosicion().devolverPosicionFila()
								+ i, esquinaActual.devolverPosicion()
								.devolverPosicionColumna() + j)));
			}
		}
	}
}
