package fiuba.algo3.modelo;

public class Bandera {

	private Posicion unaPosicion;
	private boolean gano;
	
	public Bandera(Posicion unaPosicion){
		this.unaPosicion = unaPosicion;
		this.gano = false;
	}

	public void ganar() {
		this.gano = true;
	}

	public boolean saberSiGano() {
		return this.gano;
	}

}
