package fiuba.algo3.modelo;

public class Bandera {

	private Posicion unaPosicion;
	private boolean gano;
	
	public Bandera(Posicion unaPosicion){
		this.setearPosicion(unaPosicion);
		this.gano = false;
	}

	public void ganar() {
		this.gano = true;
	}

	public boolean saberSiGano() {
		return this.gano;
	}

	public Posicion devolverPosicion() {
		return unaPosicion;
	}

	public void setearPosicion(Posicion unaPosicion) {
		this.unaPosicion = unaPosicion;
	}

}
