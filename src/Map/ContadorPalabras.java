package Map;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ContadorPalabras {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> listaPalabras = new LinkedHashMap<>();
		List<String> palabras =  Arrays.asList("SUMAR","SUMAR","SUMAR","PSOE","PSOE","PSOE","PSOE","PSOE","ERC","ERC","ERC","ERC","ERC","ERC","ERC","ERC","PP","PP");

		for (String palabra : palabras){
			listaPalabras.put(palabra, listaPalabras.getOrDefault(palabra, 0) + 1);
		}
		System.out.println(listaPalabras);
	}
}
