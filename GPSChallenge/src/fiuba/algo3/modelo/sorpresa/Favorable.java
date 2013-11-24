package fiuba.algo3.modelo.sorpresa;


public class Favorable extends Extra implements Sorpresa {

	public Favorable() {
		this.porcentaje = 20;
	}
	
	protected int signo(){
		return 1;
	}

}
