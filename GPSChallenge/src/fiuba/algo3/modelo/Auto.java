package fiuba.algo3.modelo;

public class Auto extends Vehiculo {

	public Auto(Esquina unaEsquina) {
		super();
		// Se puso coordenadas 5,5 como ejemplo, habria que definir donde va a
		// aparecer el auto cada vez que se crea
		this.movimientosPermitidos = 1;
		this.esquinaActual = unaEsquina;
	}

}
