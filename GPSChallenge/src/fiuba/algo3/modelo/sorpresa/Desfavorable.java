package fiuba.algo3.modelo.sorpresa;

public class Desfavorable extends Sorpresa {
	
	private int porcentaje;
	
	public Desfavorable() {
		this.porcentaje = 25;
	}
	
	public void aplicar(int movimientosHechos){
		movimientosHechos = movimientosHechos + (movimientosHechos*porcentaje/100);
	}

}
