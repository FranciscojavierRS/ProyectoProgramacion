package pruebasJunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PilaTest {
	//Ejercicio 1	
	@Test
	void testpushValido() {
		Pila p = new Pila();

		assertTrue(p.push(3));
		assertTrue(p.push(5));
		assertTrue(p.push(4));
		assertTrue(p.push(6));
	}

	@Test
	void testpushNoValido() {
		Pila p = new Pila();

		assertFalse(p.push(1));
		assertFalse(p.push(2));
		assertFalse(p.push(20));
		assertFalse(p.push(21));
	}
	
	/*
	 * @Test void testpushMayor20() { Pila p = new Pila();
	 * 
	 * assertFalse(p.push(21)); }
	 */
	
	//Ejercicio 2
	@Test
	void testpopLlena() {
		Pila p = new Pila();
		p.push(3);
		assertEquals(3,p.pop());
	}
	
	@Test
	void testpopVacia() {
		Pila p = new Pila();
		assertThrows(NullPointerException.class, ()-> p.pop());
	}
	//Ejercicio 3
	@Test
	void testsumaUltimos() {
		Pila p = new Pila();
		p.push(3);
		assertEquals(0,p.sumaUltimos(2));
		p.push(3);

		assertEquals(6,p.sumaUltimos(2));
	}
	
	/*
	 * @Test void testsumaUltimosNoValido() { Pila p = new Pila(); p.push(3);
	 * assertEquals(0,p.sumaUltimos(2)); }
	 */

}
