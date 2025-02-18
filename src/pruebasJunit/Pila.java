package pruebasJunit;

import java.util.Stack;

public class Pila {
	private Stack<Integer> pila = new Stack<Integer>();

	// A�ade el n�mero solo si es mayor que 2 y menor que 20. Devuelve true
	// si lo ha a�adido, y false si no
	public boolean push(int num) {
		boolean anyadido = false;
		if (num > 2 && num < 20) {
			pila.push(num);
			anyadido = true;
		}
		return anyadido;
	}

	/*
	 * Si la pila est� vac�a, lanzamos excepci�n, si no, se devuelve el �ltimo
	 * n�mero a�adido a la pila sac�ndolo de la pila
	 */
	public int pop() {
		int elem = -1;
		if (!pila.isEmpty()) {
			elem = pila.pop();
		} else {
			throw new NullPointerException();
		}
		return elem;
	}

	/*
	 * Si el tama�o de la pila es mayor o igual que el n�mero recibido por par�metro
	 * (n), devuelve la suma de los n �ltimos elementos de la pila (Los n �ltimos
	 * que se han insertado). Si no, devuelve 0.
	 */
	public int sumaUltimos(int n) {
		int resul = 0;
		for (int i = 0; pila.size() >= n && i < n; i++) {
			resul += pila.get(pila.size()-1-i);
		}
		return resul;
	}
}
