package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.Pozo;

public class Mapa {
	private int filas;
	private int columnas;
	private Esquina[][] tablero;

	public Mapa(int fila, int columna) {
		filas = fila;
		columnas = columna;

		tablero = new Esquina[fila][columna];
		for (int i = 1; i <= devolverFilas(); i++) {
			for (int j = 1; j <= devolverColumnas(); j++) {
				Posicion posicion = new Posicion(i, j);
				Esquina esquina = new Esquina(posicion);
				agregarUnaEsquina(esquina, posicion);
			}
		}
	}

	public int devolverFilas() {
		return this.filas;
	}

	public int devolverColumnas() {
		return this.columnas;
	}

	public boolean existeEsquina(Posicion unaPosicion){
		if ((unaPosicion.devolverPosicionFila() > this.filas) || (unaPosicion.devolverPosicionFila() <= 0)){
			return false;
		}
		if ((unaPosicion.devolverPosicionColumna() > this.columnas) || (unaPosicion.devolverPosicionColumna() <= 0)){
			return false;
		}
		return true;
	}
	public Esquina devolverUnaEsquina(Posicion unaPosicion)throws ExcepcionEsquinaInvalida {
		if (this.existeEsquina(unaPosicion)){
			return tablero[unaPosicion.devolverPosicionFila() - 1][unaPosicion
				.devolverPosicionColumna() - 1];
		}
		else{
			throw new ExcepcionEsquinaInvalida();		
		}
	}

	public void agregarUnaEsquina(Esquina unaEsquina, Posicion unaPosicion) {
		tablero[unaPosicion.devolverPosicionFila() - 1][unaPosicion.devolverPosicionColumna() - 1] = unaEsquina;
	}
	
}