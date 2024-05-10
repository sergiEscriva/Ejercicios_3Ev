package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class NumerosAleatorios {
	public static void main(String[] args) {
		int numeroContiene = 5;
		List<Integer> listaNumeros = generarNumeros();

		System.out.println("Conjunto de numeros: " + listaNumeros);
		System.out.println("---------------------------------------");
		TreeSet<Integer> listaNumerosTree = introducirNumeros(listaNumeros);

		System.out.println("Conjunto de numeros: " + listaNumerosTree);
		System.out.println("---------------------------------------");
		if (listaNumerosTree.contains(numeroContiene)) {
			modificarLista(listaNumerosTree, numeroContiene);
		}

	}

	private static ArrayList<Integer> generarNumeros() {
		ArrayList<Integer> lista = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int numero = random.nextInt(10) + 1;
			lista.add(numero);
		}
		return lista;
	}

	private static TreeSet<Integer> introducirNumeros(List<Integer> lista) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.addAll(lista);
		return treeSet;

	}

	private static void modificarLista(TreeSet lista, int numero) {
		lista.add(15);
		lista.add(0);
		lista.add(25);
		System.out.println("Conjunto de numeros: " + lista);
		System.out.println("---------------------------------------");
		lista.remove(numero);
		System.out.println("Conjunto de numeros: " + lista);
	}
}
