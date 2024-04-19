package practica;


public class Pagina { // Asume fichero llamado solution.java

	static java.util.Scanner in;

	public static void casoDePrueba() {
		StringBuilder sb = new StringBuilder();
		boolean primerNumero = Boolean.TRUE;
		String[] numerosString = in.nextLine().split(" ");
		int[] numerosGuardados = new int[numerosString.length];

		for (int i = 0; i < numerosGuardados.length; i++) {
			numerosGuardados[i] = Integer.parseInt(numerosString[i]);
		}

		if (numerosGuardados[0] == 0 && numerosGuardados.length == 1) {
			return;
		}

		int inicioRango = -1;
		int finRango = -1;


		for (int i = 0; i < numerosGuardados.length; i++) {
			if (primerNumero) {
				primerNumero = false;
			} else {
				if (numerosGuardados[i - 1] + 1 == numerosGuardados[i]) {
					if (inicioRango == -1) {
						inicioRango = numerosGuardados[i - 1];
					}
					finRango = numerosGuardados[i];
				} else {
					if (inicioRango != -1) {
						if (sb.length() > 0) {
							sb.append(",");
						}
						sb.append(inicioRango + "-" + finRango);
						inicioRango = -1;
						finRango = -1;
					} else {
						if (sb.length() > 0) {
							sb.append(",");
						}
						sb.append(numerosGuardados[i - 1]);
					}
				}
			}
		}

		if (inicioRango != -1) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(inicioRango + "-" + finRango);
		} else {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(numerosGuardados[numerosGuardados.length - 1]);
		}
		if (sb.charAt(sb.length() - 1) == '0') {
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println(sb);

	}

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		casoDePrueba();

	} // main
} // class solution
