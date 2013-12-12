package fiuba.algo3.modelo.cambiadorDeVisibilidad;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class EncendedorDeVisibilidad extends CambiadorDeVisibilidad {
	
	public EncendedorDeVisibilidad(Mapa unMapa) {
		super(unMapa);
	}
	
	public void encenderVisibilidad(Esquina unaEsquina) {
		unaEsquina.encenderVisibilidad();
	}
	
	public void encenderVisibilidadDosALaRedonda(Esquina esquinaActual)
			throws ExcepcionEsquinaInvalida {
		this.recorrerPosicionesCambiandoVisibilidad(esquinaActual);
	}
	
	protected void cambiarVisiblidad(Esquina unaEsquina){
		this.encenderVisibilidad(unaEsquina);
	}
	
}
