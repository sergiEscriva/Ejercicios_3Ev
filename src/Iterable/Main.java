package Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		imprimirArray();
		imprimirAlumnos();
		imprimirPila();
	}

	public static void imprimirArray() {
		ArrayList<Integer> numbers = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			numbers.add(rand.nextInt(100));
		}

		Iterator<Integer> iterator = numbers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void imprimirAlumnos() {

		Clase<Alumno> clase = new Clase<Alumno>();
		clase.add(new Alumno("Pepe", 1, 20, "1º", 5.0));
		clase.add(new Alumno("Juan", 2, 21, "2º", 6.0));
		clase.add(new Alumno("Luis", 3, 22, "3º", 7.0));
		clase.add(new Alumno("Ana", 4, 23, "4º", 8.0));
		clase.add(new Alumno("Maria", 5, 24, "5º", 9.0));
		clase.add(new Alumno("Lucia", 6, 25, "6º", 10.0));

		Iterator<Alumno> iterator = clase.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	public static void imprimirPila() {
		Pila<Integer> pila = new Pila<Integer>();
		pila.add(1);
		pila.add(2);
		pila.add(3);
		pila.push(4);
		pila.push(5);
		pila.push(6);
		pila.pop();
		pila.peek();

		pila.isEmpty();
		if (pila.isEmpty()) {
			System.out.println("La pila esta vacia");
		}

		Iterator<Integer> iterator = pila.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
