package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class Mapa {
	private int filas;
	private int columnas;
	private Esquina[][] tablero;

	public Mapa(int fila, int columna) {
		filas = fila;
		columnas = columna;

		tablero = new Esquina[fila][columna];
		for (int i = 1; i <= this.devolverAlto(); i++) {
			for (int j = 1; j <= this.devolverAncho(); j++) {
				Posicion posicion = new Posicion(i, j);
				Esquina esquina = new Esquina(posicion);
				agregarUnaEsquina(esquina, posicion);
			}
		}
	}

	public int devolverAlto() {
		return this.filas;
	}

	public int devolverAncho() {
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

	private void agregarUnaEsquina(Esquina unaEsquina, Posicion unaPosicion) {
		tablero[unaPosicion.devolverPosicionFila() - 1][unaPosicion.devolverPosicionColumna() - 1] = unaEsquina;
	}
	
}