package fiuba.algo3.modelo.sorpresa;

public class Favorable extends Sorpresa {
	
	private int porcentaje;
	
	public Favorable() {
		this.porcentaje = 20;
	}
	
	public void aplicar(int movimientosHechos){
		movimientosHechos = movimientosHechos - (movimientosHechos*porcentaje/100);
	}

}
