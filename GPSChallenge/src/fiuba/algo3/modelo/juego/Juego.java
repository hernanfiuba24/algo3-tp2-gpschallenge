package fiuba.algo3.modelo.juego;

import java.util.Observable;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
import fiuba.algo3.modelo.randomizador.RandomizadorImplementacion;
import fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import fiuba.algo3.modelo.sorpresa.Desfavorable;
import fiuba.algo3.modelo.sorpresa.Favorable;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public abstract class Juego extends Observable {

	protected int cantidadDePiquetes;
	protected int cantidadDeControlesPoliciales;
	protected int cantidadDePozos;
	protected int cantidadDeFavorables;
	protected int cantidadDeDesfavorables;
	protected int cantidadDeCambiosDeVehiculos;
	protected Posicion posicionBandera;
	protected Mapa unMapa;
	protected JugadorImplementacion unJugador;
	private Posicion posicionInicialVehiculo;
	protected int movimientosMaximo;

	public Juego(String nombreDeJugador, int tamanioMapa,
			Posicion posicionBandera, Vehiculo unVehiculo)
			throws ExcepcionEsquinaInvalida,
			ExcepcionJugadorYaAsignadoAlVehiculo {

		this.setearCantidadSorprepasYObstaculos();
		this.posicionBandera = posicionBandera;
		this.unMapa = new Mapa(tamanioMapa, tamanioMapa);
		this.unJugador = new JugadorImplementacion(unVehiculo, nombreDeJugador);

		this.completarMapaConExtras(posicionBandera);

		setChanged();
		notifyObservers(this.unJugador.devolverPosicionDelVehiculo());
		notifyObservers(unVehiculo);
	}

	public Juego(JugadorImplementacion unJugador, Mapa unMapa,
			Posicion posicionBandera) {
		this.unJugador = unJugador;
		this.unMapa = unMapa;
		this.posicionBandera = posicionBandera;
		this.posicionInicialVehiculo = this.unJugador.devolverPosicionDelVehiculo();
	}

	private Esquina devolverEsquinaConExtra(int min, int maxFilas,
			int maxColumnas, RandomizadorImplementacion randomizador)
			throws ExcepcionEsquinaInvalida {
		
		int unNumeroRandom = randomizador.obtenerNumeroEntre(min, maxFilas);
		int otroNumeroRandom = randomizador.obtenerNumeroEntre(min, maxColumnas);
		Esquina esquinaConExtra = this.unMapa.devolverUnaEsquina(new Posicion(unNumeroRandom, otroNumeroRandom));
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
				if (esquinaConExtra.tieneBandera() == false) {
					if (esquinaConExtra.tieneSorpresa() == false) {
						esquinaConExtra.setearSorpresa(new Desfavorable());
						ubicado = true;
					}
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
				if (esquinaConExtra.tieneBandera() == false) {
					if (esquinaConExtra.tieneSorpresa() == false) {
						esquinaConExtra.setearSorpresa(new Favorable());
						ubicado = true;
					}
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
				if (esquinaConExtra.tieneBandera() == false) {
					if (esquinaConExtra.tieneSorpresa() == false) {
						esquinaConExtra.setearSorpresa(new CambioDeVehiculo());
						ubicado = true;
					}
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
				if (esquinaConExtra.tieneBandera() == false) {
					if (esquinaConExtra.tieneObstaculo() == false) {
						esquinaConExtra.setearObstaculo(new ControlPolicial(
								new RandomizadorImplementacion()));
						ubicado = true;
					}
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
				if (esquinaConExtra.tieneBandera() == false) {
					if (esquinaConExtra.tieneObstaculo() == false) {
						esquinaConExtra.setearObstaculo(new Piquete());
						ubicado = true;
					}
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
				if (esquinaConExtra.tieneBandera() == false) {
					if (esquinaConExtra.tieneObstaculo() == false) {
						esquinaConExtra.setearObstaculo(new Pozo());
						ubicado = true;
					}
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

	private void completarMapaConBandera(Posicion posicionBandera)
			throws ExcepcionEsquinaInvalida {
		this.unMapa.setearBandera(posicionBandera);
	}

	/*-------------------------------------------------------------------------------------------------------------*/

	public void completarMapaConExtras(Posicion posicionBandera)
			throws ExcepcionEsquinaInvalida {

		RandomizadorImplementacion randomizador = new RandomizadorImplementacion();

		int min = 1;
		int maxFilas = this.devolverMapaFila();
		int maxColumnas = this.devolverMapaColumna();

		this.completarMapaConBandera(posicionBandera);

		this.completarMapaConSorpresas(min, maxFilas, maxColumnas, randomizador);

		this.completarMapaConObstaculos(min, maxFilas, maxColumnas,
				randomizador);
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

	public void setearPosicionInicial(Posicion unaPosicion)
			throws ExcepcionEsquinaInvalida {
		this.unJugador.setearEsquinaDelVehiculo(unMapa.devolverUnaEsquina(unaPosicion));
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

	public void jugar(Direccion unaDireccion)
			throws ExcepcionJugadorYaAsignadoAlVehiculo {
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

	protected abstract void setearCantidadSorprepasYObstaculos();

	public int obtenerPosicionXVehiculo() {
		return unJugador.obtenerPosicionXVehiculo();
	}

	public int obtenerPosicionYVehiculo() {
		return unJugador.obtenerPosicionYVehiculo();
	}

	public boolean seTermino() {
		return this.unJugador.gano();
	}

	public Posicion devolverPosicionInicial() {
		return this.posicionInicialVehiculo;
	}

	public void actualizar() {
		setChanged();
		notifyObservers(this.unJugador);
		this.unJugador.actualizarVehiculo();

	}

	public Node toXml(Document doc) throws DOMException,
			ExcepcionEsquinaInvalida {
		Element xmlElement = doc.createElement("GPSChallenge");
		xmlElement.appendChild(this.unMapa.toXml(doc));
		xmlElement.appendChild(this.unJugador.toXml(doc));
		return xmlElement;
	}

	public Vehiculo devolverVehiculo() {
		return this.unJugador.devolverVehiculo();
	}

	public String devolverNombreJugador() {
		return this.unJugador.devolverNombre();
	}

	public abstract int calcularPuntajeFinal();

}
