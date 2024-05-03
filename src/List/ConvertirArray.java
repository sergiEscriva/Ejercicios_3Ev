package List;

import java.util.ArrayList;
import java.util.List;

public class ConvertirArray {
	public static void main(String[] args) {
		int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> lsitaConvertido = new ArrayList<>(pasarList(numeros));
		int[] arrayConvertido = pasarArray(lsitaConvertido);
	}

	public static ArrayList pasarList(int[] array) {
		ArrayList<Integer> arrayAPasar = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			arrayAPasar.add(array[i]);
		}
		return arrayAPasar;
	}

	public static int[] pasarArray(List<Integer> arrayList) {
		int[] numeros = new int[arrayList.size()];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = arrayList.get(i);
		}
		return numeros;
	}
}
