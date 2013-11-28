package fiuba.algo3.modelo;

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

public class Juego extends Observado {
	private int cantidadDePiquetes = 5;
	private int cantidadDeControlesPoliciales = 5;
	private int cantidadDePozos = 5;
	private int cantidadDeFavorables = 5;
	private int cantidadDeDesfavorables = 5;
	private int cantidadDeCambiosDeVehiculos = 3;

	private Mapa unMapa;
	private Jugador unJugador;
	private Bandera unaBandera;

	public Juego() throws ExcepcionEsquinaInvalida {
		this.unMapa = new Mapa(8, 8);
		this.unJugador = new Jugador(new Auto(this.unMapa), null);
		this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(8, 8))
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

	public void jugar(Direccion unaDireccion) {
		if (this.unaBandera.saberSiGano() == false) {
			this.unJugador.cambiarDireccion(unaDireccion);
			try {
				this.unJugador.jugar(unMapa);
				setChanged();
				notifyObservers(this.unJugador);
			} catch (ExcepcionEsquinaInvalida e1) {
			}
		} else {
			// ACA HAY QUE LANZAR UNA VENTANA DICIENDO QUE GANO RAUL
			System.out.println("Gananste Raulcito");
		}
	}
}
