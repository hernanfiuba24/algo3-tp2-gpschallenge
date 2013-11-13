package fiuba.algo3.modelo.direccion;

public class Abajo extends Direccion {
	
	public Abajo(){
		this.x = -1;
		this.y = 0;
	}
	
	public Direccion cambiarDireccionContraria() {
		return (new Arriba());
	}	

}
