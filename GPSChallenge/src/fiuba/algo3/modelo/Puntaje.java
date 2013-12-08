package fiuba.algo3.modelo;

public class Puntaje {

	private String nombre;
	private int valor;

	public Puntaje(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public int getValor() {
		return valor;
	}
	
	public boolean equals(Puntaje puntaje) {
		if(this.valor == puntaje.getValor()){
			if(this.nombre == puntaje.getNombre()){
				return true;
			}
		}
		return false;
	}

}
