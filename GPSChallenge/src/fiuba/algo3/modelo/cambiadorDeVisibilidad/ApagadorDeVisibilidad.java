package fiuba.algo3.modelo.cambiadorDeVisibilidad;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;

public class ApagadorDeVisibilidad extends CambiadorDeVisibilidad {

	public ApagadorDeVisibilidad(Mapa unMapa) {
		super(unMapa);
	}

	public void apagarVisibilidad(Esquina unaEsquina) {
		unaEsquina.apagarVisibilidad();
	}
	
	@Override
	protected void cambiarVisiblidad(Esquina unaEsquina) {
		this.apagarVisibilidad(unaEsquina);
	}

}
