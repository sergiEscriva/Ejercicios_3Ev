package Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pila<T> implements Iterable<T> {
	private List<T> pila = new ArrayList<>();
	/**
	 * Returns an iterator over elements of type {@code T}.
	 *
	 * @return an Iterator.
	 */
	@Override
	public Iterator<T> iterator() {
		return pila.iterator();
	}

	public void push(T element) {
		pila.add(0,element);
	}

	/**
	 * Elimina y devuelve el primer elemento de la pila.
	 * @return el primer elemento de la pila, o null si la pila está vacía.
	 */
	public T pop() {
		if (pila.isEmpty()) {
			return null;
		} else {
			pila.remove(0);
			return pila.get(0);
		}
	}

	/**
	 * Devuelve el primer elemento de la pila sin eliminarlo.
	 * @return el primer elemento de la pila, o null si la pila está vacía.
	 */
	public T peek() {
		if (pila.isEmpty()) {
			return null;
		} else {
			return pila.get(0);
		}
	}

	/**
	 * Comprueba si la pila está vacía.
	 * @return true si la pila está vacía, false en caso contrario.
	 */
	public boolean isEmpty() {
		return pila.isEmpty();
	}

	/**
	 * Agrega un elemento al final de la pila.
	 * @param element el elemento a agregar.
	 */
	public void add(T element) {
		pila.add(element);
	}
}
