package fiuba.algo3.modelo.obstaculo;


public class RandomizadorTest extends RandomizadorImplementacion{
	
	  private double random;

      public void numeroRandomADevolver(double random) {
        this.random = random;
      }
      
      @Override
      public double obtenerNumeroRandom() {
        return this.random;
      }

}
