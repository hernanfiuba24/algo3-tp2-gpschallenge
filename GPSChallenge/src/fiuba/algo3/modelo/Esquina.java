package fiuba.algo3.modelo;

public class Esquina {
	private Posicion unaPosicion;
	private Guardable<Auto> unAuto;
	private Guardable<Obstaculo> unObstaculo;
	private Guardable<Sorpresa> unaSorpresa;
	
	public Esquina(Posicion posicion){
		this.unaPosicion = posicion;
	}

	public void colocarAuto(Guardable<Auto> auto){
		this.unAuto = auto;
		auto.actualizarEsquina(this);
	}
	
	public void borrarAuto(){
		this.unAuto = null;
	}

	public Guardable<Auto> obtenerAuto() {
		return this.unAuto;
	}
	
}
