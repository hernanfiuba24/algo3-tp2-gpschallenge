package fiuba.algo3.modelo.direccion;

public abstract class Direccion {
	
	protected int x; //  posicion de las fila (en el eje vertical)
	protected int y; //  posicion de la columna (en el eje horizontal)
	
	public int devolverX() {
		return this.x;
	}
	
	public int devolverY(){
		return this.y;
	}

	public abstract Direccion cambiarDireccionContraria();
	
}
