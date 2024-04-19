package retos;


import java.util.IllegalFormatCodePointException;

public class Resistencias { // Asume fichero llamado solution.java

	static java.util.Scanner in;

	public static void casoDePrueba() {
		String[] espacios = in.nextLine().split(" ");

		int F = Integer.parseInt(espacios[0]);
		int C = Integer.parseInt(espacios[1]);

		char[][] matriz = new char[F][C];
		String linea;
		for (int i = 0; i < F; i++) {
			linea = in.nextLine();
			for (int k = 0; k < linea.length(); k++) {
				matriz[i][k] = linea.charAt(k);
			}
		}

		int contadorR = 0;
		int contadorC = 0;
		int totalC = 0;


		for (int i = 0; i < F; i++) {
			for (int j = 0; j < C; j++) {
				if (matriz[i][j] == 'C') {
					while (j < C && matriz[i][j] == 'C') {
						if (j > matriz.length - 1)
							j++;

						if (matriz[i][j] != 'C') {
							break;
						}
						contadorC++;
					}
					totalC = contadorC;
					contadorC = 0;
				}
			}
		}


	}

// casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		casoDePrueba();
	}
}