package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.sorpresa.Desfavorable;

public class DesfavorableTest {

	@Test
	public void testDesfavorableDeberiaExistir() {
		Desfavorable unaDesfavorable = new Desfavorable();
		assertTrue(unaDesfavorable instanceof Desfavorable);
	}
}
