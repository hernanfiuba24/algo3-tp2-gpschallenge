package fiuba.algo3.modelo.juego;

import java.util.Observable;

import fiuba.algo3.modelo.Esquina;
import fiuba.algo3.modelo.JugadorImplementacion;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.excepcion.ExcepcionJuegoTerminado;
import fiuba.algo3.modelo.excepcion.ExcepcionJugadorYaAsignadoAlVehiculo;
import fiuba.algo3.modelo.obstaculo.ControlPolicial;
import fiuba.algo3.modelo.obstaculo.Piquete;
import fiuba.algo3.modelo.obstaculo.Pozo;
import fiuba.algo3.modelo.obstaculo.RandomizadorImplementacion;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.sorpresa.Desfavorable;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Camioneta;

public abstract class Juego extends Observable {

	protected int cantidadDePiquetes;
	protected int cantidadDeControlesPoliciales;
	protected int cantidadDePozos;
	protected int cantidadDeFavorables;
	protected int cantidadDeDesfavorables;
	protected int cantidadDeCambiosDeVehiculos;

	protected Mapa unMapa;
	protected JugadorImplementacion unJugador;

	// public Juego() throws ExcepcionEsquinaInvalida {
	// this.unMapa = new Mapa(8, 8);
	// this.unJugador = new Jugador(new Auto(this.unMapa), null);
	// this.unaBandera = this.unMapa.devolverUnaEsquina(new Posicion(8, 8))
	// .devolverBandera();
	// this.completarMapaConExtras();
	// setChanged();
	// notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
	// .devolverPosicion());
	// }

	public Juego(String nombreDeJugador, int tamanioMapa,
			Posicion posicionBandera) throws ExcepcionEsquinaInvalida, ExcepcionJugadorYaAsignadoAlVehiculo {
		this.setearCantidadSorprepasYObstaculos();
		this.unMapa = new Mapa(tamanioMapa, tamanioMapa);
		Camioneta unaCamioneta = new Camioneta(this.unMapa.devolverUnaEsquina(new Posicion(3, 3)));
		this.unJugador = new JugadorImplementacion(unaCamioneta, nombreDeJugador);
		this.completarMapaConExtras(posicionBandera);
		setChanged();
		notifyObservers(this.unJugador.devolverVehiculo().devolverEsquina()
				.devolverPosicion());
		notifyObservers(unaCamioneta);
	}


	private Esquina devolverEsquinaConExtra(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		Esquina esquinaConExtra = this.unMapa.devolverUnaEsquina(new Posicion(
				randomizador.obtenerNumeroEntre(min, maxFilas), randomizador
						.obtenerNumeroEntre(min, maxColumnas)));
		return esquinaConExtra;
	}

	private void completarMapaConDesfavorables(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		for (int i = 1; i <= cantidadDeDesfavorables; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.devolverEsquinaConExtra(min,
						maxFilas, maxColumnas, randomizador);
				if (esquinaConExtra.tieneSorpresa() == false) {
					esquinaConExtra.setearSorpresa(new Desfavorable());
					ubicado = true;
				}
			}
		}

	}

	private void completarMapaConFavorables(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		for (int i = 1; i <= cantidadDeFavorables; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.devolverEsquinaConExtra(min,
						maxFilas, maxColumnas, randomizador);
				if (esquinaConExtra.tieneSorpresa() == false) {
					esquinaConExtra.setearSorpresa(new Favorable());
					ubicado = true;
				}
			}
		}

	}

	private void completarMapaConCambiosDeVehiculo(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		for (int i = 1; i <= cantidadDeCambiosDeVehiculos; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.devolverEsquinaConExtra(min,
						maxFilas, maxColumnas, randomizador);
				if (esquinaConExtra.tieneSorpresa() == false) {
					esquinaConExtra.setearSorpresa(new CambioDeVehiculo());
					ubicado = true;
				}
			}
		}
	}

	private void completarMapaConSorpresas(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		this.completarMapaConCambiosDeVehiculo(min, maxFilas, maxColumnas,
				randomizador);
		this.completarMapaConDesfavorables(min, maxFilas, maxColumnas,
				randomizador);
		this.completarMapaConFavorables(min, maxFilas, maxColumnas,
				randomizador);
	}

	/*-------------------------------------------------------------------------------------------------------------*/

	private void completarMapaConControlesPoliciales(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		for (int i = 1; i <= cantidadDeControlesPoliciales; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.devolverEsquinaConExtra(min,
						maxFilas, maxColumnas, randomizador);
				if (esquinaConExtra.tieneObstaculo() == false) {
					esquinaConExtra.setearObstaculo(new ControlPolicial(
							new RandomizadorImplementacion()));
					ubicado = true;
				}
			}
		}

	}

	private void completarMapaConPiquetes(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		for (int i = 1; i <= cantidadDePiquetes; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.devolverEsquinaConExtra(min,
						maxFilas, maxColumnas, randomizador);
				if (esquinaConExtra.tieneObstaculo() == false) {
					esquinaConExtra.setearObstaculo(new Piquete());
					ubicado = true;
				}
			}
		}

	}

	private void completarMapaConPozos(int min, int maxFilas, int maxColumnas,
			RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		for (int i = 1; i <= cantidadDePozos; i++) {
			boolean ubicado = false;
			while (ubicado == false) {
				Esquina esquinaConExtra = this.devolverEsquinaConExtra(min,
						maxFilas, maxColumnas, randomizador);
				if (esquinaConExtra.tieneObstaculo() == false) {
					esquinaConExtra.setearObstaculo(new Pozo());
					ubicado = true;
				}
			}
		}

	}

	private void completarMapaConObstaculos(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {

		this.completarMapaConPozos(min, maxFilas, maxColumnas, randomizador);
		this.completarMapaConPiquetes(min, maxFilas, maxColumnas, randomizador);
		this.completarMapaConControlesPoliciales(min, maxFilas, maxColumnas,
				randomizador);
	}
	
	private void completarMapaConBandera(Posicion posicionBandera) throws ExcepcionEsquinaInvalida{
		this.unMapa.setearBandera(posicionBandera);
	}

	/*-------------------------------------------------------------------------------------------------------------*/

	public void completarMapaConExtras(Posicion posicionBandera) throws ExcepcionEsquinaInvalida {
		
		RandomizadorImplementacion randomizador = new RandomizadorImplementacion();

		int min = 1;
		int maxFilas = this.devolverMapaFila();
		int maxColumnas = this.devolverMapaColumna();

		this.completarMapaConSorpresas(min, maxFilas, maxColumnas, randomizador);

		this.completarMapaConObstaculos(min, maxFilas, maxColumnas,
				randomizador);
		
		this.completarMapaConBandera(posicionBandera);
	}

	/*-------------------------------------------------------------------------------------------------------------*/

	public Mapa devolverMapa() {
		return this.unMapa;
	}

	public JugadorImplementacion devolverJugador() {
		return this.unJugador;
	}

	public int devolverMapaFila() {
		return this.unMapa.devolverAlto();
	}

	public int devolverMapaColumna() {
		return this.unMapa.devolverAncho();
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

	public void jugar(Direccion unaDireccion) throws ExcepcionJugadorYaAsignadoAlVehiculo {
		// if (this.unaBandera.saberSiGano() == false) {
		this.unJugador.cambiarDireccion(unaDireccion);
		try {
			this.unJugador.jugar(unMapa);
			setChanged();
			notifyObservers(this.unJugador);
		} catch (ExcepcionEsquinaInvalida e1) {
		} catch (ExcepcionJuegoTerminado e2) {
		}
		
		// } else {
		// // ACA HAY QUE LANZAR UNA VENTANA DICIENDO QUE GANO RAUL
		// System.out.println("Gananste Raulito");
		// }
	}

	public abstract void setearCantidadSorprepasYObstaculos();


	public int obtenerPosicionXVehiculo() {
		return unJugador.obtenerPosicionXVehiculo();
	}


	public int obtenerPosicionYVehiculo() {
		return unJugador.obtenerPosicionYVehiculo();
	}
}
