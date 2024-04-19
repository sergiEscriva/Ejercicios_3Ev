package practica;


public class ImprimirPaginas { // Asume fichero llamado solution.java

	static java.util.Scanner in;

	public static void casoDePrueba() {
		StringBuilder sb = new StringBuilder();
		boolean primerNumero = Boolean.TRUE;
		String numeros = in.nextLine();
		String[] numerosString = numeros.split(" ");
		int[] numerosGuardados = new int[numerosString.length];

		for (int i = 0; i < numerosGuardados.length; i++) {
			numerosGuardados[i] = Integer.parseInt(numerosString[i]);
		}

		if (numerosGuardados[0] == 0 && numerosGuardados.length == 1) {
			return;
		}

		int contador = 0;
		for (int i = 0; i < numerosGuardados.length; i++) {

			if (primerNumero) {
				sb.append(numerosGuardados[i]);
				primerNumero = Boolean.FALSE;
				contador++;
			} else {
				contador++;
				if (numerosGuardados[i - 1] - numerosGuardados[i] != -1) {
					if (numerosGuardados[i] == 0) {
						sb.append("-" + numerosGuardados[i - 1]);
						 break;
					}
					if (contador == 1 ) {
						sb.append(", " + numerosGuardados[i]);
					}

					sb.append("-" + numerosGuardados[i - 1] + ", " + numerosGuardados[i]);

				}
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		casoDePrueba();

	} // main
} // class solution
