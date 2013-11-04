package fiuba.algo3.modelo;


public class Mapa {
	private int filas;
	private int columnas;
	private Esquina[][] tablero; 
		
	public Mapa (int fila , int columna){
		filas = fila;
		columnas = columna;
		
		tablero = new Esquina [fila][columna];
		for (int i = 1 ; i <= dameFilas() ; i++){
			for (int j = 1 ; j <= dameColumnas() ; j++){
				Posicion posicion = new Posicion(i, j);
				Esquina esquina = new Esquina(posicion);
				colocarEsquina(esquina, i ,j );
			}
		}
	}
	
	public int dameFilas(){
		return this.filas;
	}
	
	public int dameColumnas(){
		return this.columnas;
	}
	
	public Esquina dameEsquina (int fila , int columna){
		return tablero[fila-1][columna-1];
	}
	
	public void colocarEsquina(Esquina unaEsquina, int fila, int columna){
		tablero [fila-1][columna-1] = unaEsquina;
	}
	
	public void moverArriba (Vehiculo unVehiculo, int movimientosHechos){
		Esquina esquinaActual = unVehiculo.devolverEsquina();
		Posicion posicionActual = esquinaActual.devolverPosicion();
		Esquina esquinaFutura = this.dameEsquina(posicionActual.devolverPosicionFila() - 1,posicionActual.devolverPosicionColumna());
		esquinaFutura.colocarAuto(unVehiculo);
		esquinaFutura.chequearExtras(movimientosHechos);
		esquinaActual.borrarAuto();
	}
}