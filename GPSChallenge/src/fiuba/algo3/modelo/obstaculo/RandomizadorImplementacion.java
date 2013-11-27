package fiuba.algo3.modelo.obstaculo;

import java.util.Random;

public class RandomizadorImplementacion implements Randomizador {

	@Override
	public double obtenerNumeroRandom() {
		return Math.random();
	}

	public int obtenerNumeroEntre(int min, int max){
		Random random = new Random();
		int numeroADevolver = random.nextInt((max-min)+1) + min;
		return numeroADevolver;
	}
}
