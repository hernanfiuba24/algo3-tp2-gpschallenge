package fiuba.algo3.modelo.direccion;

public class Arriba extends Direccion {
	
	public Arriba(){
		this.x = 1;
		this.y = 0;
	}
	
	public Direccion cambiarDireccionContraria() {
		return (new Abajo());
	}
		
}
