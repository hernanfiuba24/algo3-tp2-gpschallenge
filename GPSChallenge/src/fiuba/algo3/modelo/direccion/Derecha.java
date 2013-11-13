package fiuba.algo3.modelo.direccion;

public class Derecha extends Direccion {
	
	public Derecha(){
		this.x = 0;
		this.y = -1;
	}

	public Direccion cambiarDireccionContraria() {
		return (new Izquierda());
	}
}
