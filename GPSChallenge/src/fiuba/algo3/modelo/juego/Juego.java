package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.Bandera;
import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Observado;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.ControlPolicial;
import fiuba.algo3.modelo.obstaculo.Piquete;
import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.obstaculo.RandomizadorImplementacion;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.sorpresa.Desfavorable;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Auto;

public abstract class Juego extends Observado {

	protected int cantidadDePiquetes;
	protected int cantidadDeControlesPoliciales;
	protected int cantidadDePozos;
	protected int cantidadDeFavorables;
	protected int cantidadDeDesfavorables;
	protected int cantidadDeCambiosDeVehiculos;

	protected Mapa unMapa;
	protected Jugador unJugador;
	protected Bandera unaBandera;

//	public Juego() throws ExcepcionEsquinaInvalida {		
//		this.unMapa = new Mapa(8, 8);
//		this.unJugador = new Jugador(new Auto(this.unMapa), null);
//		this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(8, 8))
//				.devolverBandera();
//		this.completarMapaConExtras();
//		setChanged();
//		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
//				.devolverPosicion());
//	}

	public Juego(String nombreDeJugador, int tamanioMapa, Posicion posicionBandera) throws ExcepcionEsquinaInvalida {
		this.setearCantidadSorprepasYObstaculos();
		this.unMapa = new Mapa(tamanioMapa, tamanioMapa);
		this.unJugador = new Jugador(new Auto(this.unMapa), nombreDeJugador);
		this.unaBandera = this.unMapa.devolverUnaEsquina(posicionBandera)
				.devolverBandera();
		this.completarMapaConExtras();
		setChanged();
		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion());
	}

	public void completarMapaConExtras() throws ExcepcionEsquinaInvalida {
		RandomizadorImplementacion randomizador = new RandomizadorImplementacion();
		int min = 1;
		int maxFilas = this.unMapa.devolverFilas();
		int maxColumnas = this.unMapa.devolverColumnas();

		for (int i = 1; i <= cantidadDeCambiosDeVehiculos; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.unMapa
						.devolverUnaEsquina(new Posicion(randomizador
								.obtenerNumeroEntre(min, maxFilas),
								randomizador.obtenerNumeroEntre(min,
										maxColumnas)));
				if (esquinaConExtra.tieneSorpresa() == false) {
					esquinaConExtra.setearSorpresa(new CambioDeVehiculo());
					ubicado = true;
				}
			}
		}

		for (int i = 1; i <= cantidadDeDesfavorables; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.unMapa
						.devolverUnaEsquina(new Posicion(randomizador
								.obtenerNumeroEntre(min, maxFilas),
								randomizador.obtenerNumeroEntre(min,
										maxColumnas)));
				if (esquinaConExtra.tieneSorpresa() == false) {
					esquinaConExtra.setearSorpresa(new Desfavorable());
					ubicado = true;
				}
			}
		}

		for (int i = 1; i <= cantidadDeFavorables; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.unMapa
						.devolverUnaEsquina(new Posicion(randomizador
								.obtenerNumeroEntre(min, maxFilas),
								randomizador.obtenerNumeroEntre(min,
										maxColumnas)));
				if (esquinaConExtra.tieneSorpresa() == false) {
					esquinaConExtra.setearSorpresa(new Favorable());
					ubicado = true;
				}
			}
		}

		for (int i = 1; i <= cantidadDePiquetes; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.unMapa
						.devolverUnaEsquina(new Posicion(randomizador
								.obtenerNumeroEntre(min, maxFilas),
								randomizador.obtenerNumeroEntre(min,
										maxColumnas)));
				if (esquinaConExtra.tieneObstaculo() == false) {
					esquinaConExtra.setearObstaculo(new Piquete());
					ubicado = true;
				}
			}
		}

		for (int i = 1; i <= cantidadDePozos; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.unMapa
						.devolverUnaEsquina(new Posicion(randomizador
								.obtenerNumeroEntre(min, maxFilas),
								randomizador.obtenerNumeroEntre(min,
										maxColumnas)));
				if (esquinaConExtra.tieneObstaculo() == false) {
					esquinaConExtra.setearObstaculo(new Pozo());
					ubicado = true;
				}
			}
		}

		for (int i = 1; i <= cantidadDeControlesPoliciales; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.unMapa
						.devolverUnaEsquina(new Posicion(randomizador
								.obtenerNumeroEntre(min, maxFilas),
								randomizador.obtenerNumeroEntre(min,
										maxColumnas)));
				if (esquinaConExtra.tieneObstaculo() == false) {
					esquinaConExtra.setearObstaculo(new ControlPolicial(
							new RandomizadorImplementacion()));
					ubicado = true;
				}
			}
		}
	}

	public Mapa devolverMapa() {
		return this.unMapa;
	}

	public Jugador devolverJugador() {
		return this.unJugador;
	}

	public int devolverMapaFila() {
		return this.unMapa.devolverFilas();
	}

	public int devolverMapaColumna() {
		return this.unMapa.devolverColumnas();
	}

	public void moverJugadorEnDireccion(Direccion unaDireccion) {
		this.unJugador.cambiarDireccion(unaDireccion);
	}

	public void setearPosicionInicial() throws ExcepcionEsquinaInvalida {
		this.unJugador.devolverVehiculo().setearEsquina(
				unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		setChanged();
		notifyObservers(this.unJugador);
	}

	public int devolverCantidadDePiquetes() {
		return cantidadDePiquetes;
	}

	public int devolverCantidadDeControlesPoliciales() {
		return cantidadDeControlesPoliciales;
	}

	public int devolverCantidadDePozos() {
		return cantidadDePozos;
	}

	public int devolverCantidadDeFavorables() {
		return cantidadDeFavorables;
	}

	public int devolverCantidadDeDesfavorables() {
		return cantidadDeDesfavorables;
	}

	public int devolverCantidadDeCambiosDeVehiculos() {
		return cantidadDeCambiosDeVehiculos;
	}

	public void jugar(Direccion unaDireccion) {
		// if (this.unaBandera.saberSiGano() == false) {
		this.unJugador.cambiarDireccion(unaDireccion);
		try {
			this.unJugador.jugar(unMapa);
			setChanged();
			notifyObservers(this.unJugador);
		} catch (ExcepcionEsquinaInvalida e1) {
		}
		// } else {
		// // ACA HAY QUE LANZAR UNA VENTANA DICIENDO QUE GANO RAUL
		// System.out.println("Gananste Raulcito");
		// }
	}

	public abstract void setearCantidadSorprepasYObstaculos();
}
