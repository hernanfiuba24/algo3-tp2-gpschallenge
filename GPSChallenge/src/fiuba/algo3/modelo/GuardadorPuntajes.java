package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.TreeMap;

public class GuardadorPuntajes extends TreeMap<String, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> listaJugadores = new ArrayList<String>();

	public void guardarPuntaje(String nombreJugador, int puntaje) {
		put(nombreJugador, puntaje);
		listaJugadores.add(nombreJugador);
	}

	public Puntaje obtenerPuntaje(int posicion) {
		int valor = get(listaJugadores.get(posicion));
		String nombre = listaJugadores.get(posicion);
		Puntaje puntaje = new Puntaje(nombre, valor);
		return puntaje;

	}

}
