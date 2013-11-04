package fiuba.algo3.modelo;

public class Auto extends Vehiculo {

	public Auto(Mapa unMapa) {
		super();
		// Se puso coordenadas 5,5 como ejemplo, habria que definir donde va a
		// aparecer el auto cada vez que se crea
		this.esquinaActual = unMapa.dameEsquina(5, 5);
	}

	public Auto() {
		// Se creo para que pase el EsquinaTest, pero habria que modificar ese
		// test porque el auto debe ser creado en una posicion del mapa
	}

}
