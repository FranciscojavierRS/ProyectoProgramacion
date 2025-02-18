package pruebasJunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebaTest {

	@Test
	void testValido() {
		Prueba p = new Prueba();

		assertTrue(p.diaValido(1));
	}

	@Test
	void testMenor1() {
		Prueba p = new Prueba();

		assertFalse(p.diaValido(0));
	}

	@Test
	void testMayor7() {
		Prueba p = new Prueba();

		assertFalse(p.diaValido(8));
	}
	
	@Test
	void testMultiplica() {
		Prueba p = new Prueba();
		assertEquals(6, p.multiplica(2, 3));
	}

}
