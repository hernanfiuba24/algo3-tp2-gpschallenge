package fiuba.algo3.modelo;

public class Posicion {
	private int fila;
	private int columna;

	public Posicion(int unaFila, int unaColumna) {
		this.fila = unaFila;
		this.columna = unaColumna;
	}

	public int devolverPosicionFila() {
		return this.fila;
	}

	public int devolverPosicionColumna() {
		return this.columna;
	}
	
	public boolean equals(Posicion unaPosicion){
		if ((this.devolverPosicionFila() == unaPosicion.devolverPosicionFila()) &&
		(this.devolverPosicionColumna() == unaPosicion.devolverPosicionColumna()))
			return true;
		return false;
	}

}
