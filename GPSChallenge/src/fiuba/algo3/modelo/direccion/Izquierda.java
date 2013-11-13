package fiuba.algo3.modelo.direccion;

public class Izquierda extends Direccion {
	
	public Izquierda(){
		this.x = 0;
		this.y = 1;
	}

	public Direccion cambiarDireccionContraria() {
		return (new Derecha());
	}
}
