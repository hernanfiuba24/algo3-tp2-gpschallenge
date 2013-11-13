package fiuba.algo3.modelo;

public class Radar {

	private Mapa unMapa;

	public Radar(Mapa mapa) {
		this.unMapa = mapa;
	}

	public Radar() {

	}

	public void cambiarVisibilidad(Esquina unaEsquina) {
		unaEsquina.cambiarVisibilidad();
	}

	public boolean devolverVisibilidad(Esquina unaEsquina) {
		return unaEsquina.devolverVisibilidad();
	}

	public void cambiarVisibilidadDosALaRedonda(Esquina esquinaActual) {
		this.cambiarVisibilidad(esquinaActual);
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				this.cambiarVisibilidad(unMapa.dameEsquina(new Posicion(
						esquinaActual.devolverPosicion().devolverPosicionFila()
								+ i, esquinaActual.devolverPosicion()
								.devolverPosicionColumna() + j)));
			}
		}
	}
}
