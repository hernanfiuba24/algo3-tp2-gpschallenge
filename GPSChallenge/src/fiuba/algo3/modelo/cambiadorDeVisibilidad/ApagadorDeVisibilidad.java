package fiuba.algo3.modelo.cambiadorDeVisibilidad;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class ApagadorDeVisibilidad extends CambiadorDeVisibilidad {

	public ApagadorDeVisibilidad(Mapa unMapa) {
		super(unMapa);
	}

	public void apagarVisibilidad(Esquina unaEsquina) {
		unaEsquina.apagarVisibilidad();
	}
	
	public void apagarVisibilidadDosALaRedonda(Esquina esquinaActual)
			throws ExcepcionEsquinaInvalida {		
		this.recorrerPosiciones(esquinaActual);
	}
	
	@Override
	protected void cambiarVisiblidad(Esquina unaEsquina) {
		this.apagarVisibilidad(unaEsquina);
	}

}
