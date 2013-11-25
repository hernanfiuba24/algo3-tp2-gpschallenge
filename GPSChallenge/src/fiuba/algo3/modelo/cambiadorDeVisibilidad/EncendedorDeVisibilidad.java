package fiuba.algo3.modelo.cambiadorDeVisibilidad;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;

public class EncendedorDeVisibilidad extends CambiadorDeVisibilidad {
	
	public EncendedorDeVisibilidad(Mapa unMapa) {
		super(unMapa);
	}
	
	public void encenderVisibilidad(Esquina unaEsquina) {
		unaEsquina.encenderVisibilidad();
	}
	
	protected void cambiarVisiblidad(Esquina unaEsquina){
		this.encenderVisibilidad(unaEsquina);
	}
	
}
