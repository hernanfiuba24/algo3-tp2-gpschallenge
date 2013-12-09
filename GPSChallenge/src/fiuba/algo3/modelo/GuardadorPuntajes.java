package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class GuardadorPuntajes {

	private TreeMap<Integer, String> diccionario = new TreeMap<Integer, String>(Collections.reverseOrder());

	public void guardarPuntaje(String nombreJugador, int puntaje) {
		diccionario.put(puntaje, nombreJugador);
		
		//listaJugadores.add(nombreJugador);
	}

	public Puntaje obtenerPuntaje(int posicion) {
		//lista de entradas del diccionario
		ArrayList<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(this.diccionario.entrySet());
		//pido la entrada en la posicion pedida
		Map.Entry<Integer, String> entrada = list.get(posicion);
		//le pido el valor(nombre del Jugador) a la entrada
		String nombre = entrada.getValue();
		//le pido la clave(puntuacion del Jugador) a la entrada
		int puntuacion = entrada.getKey();
		Puntaje puntaje = new Puntaje(nombre, puntuacion);
		return puntaje;

	}
	
	public void ordenarPorValor(){
		
	}
}
