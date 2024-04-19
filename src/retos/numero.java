package retos;


public class numero { // Asume fichero llamado solution.java

	static java.util.Scanner in;

	public static boolean casoDePrueba() {
		int contadorUNO = 0;
		int contadorCERO = 0;
		String  numero = in.next();
		for (int i = 0; i < numero.length(); i++) {
			if (numero.charAt(i) == '1') {
				contadorUNO++;
			} else {
				contadorCERO++;
			}
		}

		int[] charArray = new int[numero.length()];
		for (int i = 0; i < numero.length(); i++) {
			charArray[i] = Integer.parseInt(String.valueOf(numero.charAt(i)));
		}
		String cabeza = Integer.toString(charArray[0]) + Integer.toString(charArray[1]);
		String cola = Integer.toString(charArray[charArray.length - 2]) + Integer.toString(charArray[charArray.length - 1]);

		if (contadorUNO == contadorCERO && cabeza.equals(cola)) {
			return true;
		} else {
			return false;
		}


	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			if (casoDePrueba()) {
			System.out.println("EQUILIBRADA");
		} else{
			System.out.println("ERROR");
		}
	} // main
} // class solution{

