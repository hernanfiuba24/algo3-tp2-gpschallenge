package fiuba.algo3.modelo;

public class Radar {

	private Mapa unMapa;
	
	public Radar(Mapa mapa){
		this.unMapa = mapa;
	}
	
	public Radar(){
		
	}

	public void cambiarVisibilidad(Esquina unaEsquina) {
		unaEsquina.cambiarVisibilidad();
	}

	public boolean devolverVisibilidad(Esquina unaEsquina) {
		return unaEsquina.devolverVisibilidad();		
	}
}
