package fiuba.algo3.modelo.sorpresa;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExtraTest {

	@Test
	public void testDeberiaTenerPorcentaje() {
		Favorable unFavorable = new Favorable();
		assertTrue(unFavorable.devolverPorcentaje() == 20 );
	}

}
