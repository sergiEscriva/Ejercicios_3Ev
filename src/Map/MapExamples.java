package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {
	public static void main(String[] args) {
		HashMap<String, Integer> mapa1 = new HashMap<>();

		mapa1.put("Josep", 37);
		mapa1.put("Juan", 31);
		mapa1.put("Carles", 32);
		mapa1.put("Albert", 30);
		mapa1.put("Bea", 20);

		TreeMap<String, Integer> mapa2 = new TreeMap<>();

		mapa2.put("Josep", 37);
		mapa2.put("Juan", 31);
		mapa2.put("Carles", 32);
		mapa2.put("Albert", 30);
		mapa2.put("Bea", 20);

		LinkedHashMap<String, Integer> mapa3 = new LinkedHashMap<>();

		mapa3.put("Josep", 37);
		mapa3.put("Juan", 31);
		mapa3.put("Carles", 32);
		mapa3.put("Albert", 30);
		mapa3.put("Bea", 20);

		System.out.println("Mapa 1: " + mapa1);
		System.out.println("Mapa 2: " + mapa2);
		System.out.println("Mapa 3: " + mapa3);
		//Sacar valor de una key en concreto

		//Mapa 1
		for (Map.Entry<String, Integer> mapEntry : mapa1.entrySet()) {
			if (mapEntry.getKey().equalsIgnoreCase("Bea")) {
				System.out.println("Valor: " + mapEntry.getValue());
			}
		}
		//Mapa 2
		for (Map.Entry<String, Integer> mapEntry : mapa2.entrySet()) {
			if (mapEntry.getKey().equalsIgnoreCase("Bea")) {
				System.out.println("Valor: " + mapEntry.getValue());
			}
		}
		//Mapa 3
		for (Map.Entry<String, Integer> mapEntry : mapa3.entrySet()) {
			if (mapEntry.getKey().equalsIgnoreCase("Bea")) {
				System.out.println("Valor: " + mapEntry.getValue());
			}
		}

		if (mapa1.containsKey("Josep")) {
			System.out.println("Esta en la lista");
		}
		if (!mapa1.containsKey("Lluis")) {
			System.out.println("No esta en la lista");
		}
		if (mapa2.containsKey("Josep")) {
			System.out.println("Esta en la lista");
		}

		if (mapa3.containsKey("Josep")) {
			System.out.println("Esta en la lista");
		}

		mapa1.remove("Carles", 32);
		mapa2.remove("Carles", 32);
		mapa3.remove("Carles", 32);

		System.out.println("Tamaño mapa 1: " + mapa1.size());
		System.out.println("Tamaño mapa 2: " +mapa2.size());
		System.out.println("TAmaño mapa 3: " +mapa3.size());

		buscarEdad(mapa1, "Josep");
		buscarEdad(mapa2, "Josep");
		buscarEdad(mapa3, "Josep");

	}

	public static void buscarEdad(Map<String, Integer> mapa , String nombre){
		for (Map.Entry<String, Integer> mapEntry : mapa.entrySet()) {
			if (mapEntry.getKey().equalsIgnoreCase(nombre)) {
				System.out.println("Edad: " + mapEntry.getValue());
			}
		}
	}
}
