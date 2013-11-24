package fiuba.algo3.modelo.sorpresa;


public class Desfavorable extends Extra implements Sorpresa {

	public Desfavorable() {
		this.porcentaje = 25;
	}
	
	protected int signo(){
		return (-1);
	}
	
}
