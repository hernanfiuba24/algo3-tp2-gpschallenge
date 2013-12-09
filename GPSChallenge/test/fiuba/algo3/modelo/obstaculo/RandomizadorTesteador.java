package fiuba.algo3.modelo.obstaculo;

import fiuba.algo3.modelo.randomizador.RandomizadorImplementacion;


public class RandomizadorTesteador extends RandomizadorImplementacion{
	
	  private double random;

      public void numeroRandomADevolver(double random) {
        this.random = random;
      }
      
      @Override
      public double obtenerNumeroRandom() {
        return this.random;
      }
      
}
