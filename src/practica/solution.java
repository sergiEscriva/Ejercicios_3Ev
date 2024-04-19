
package practica;

public class solution {

	static java.util.Scanner in;

	public static boolean casoDePrueba(int numPersonas) {
		in.nextLine();

		String[] fechaArray = in.nextLine().split(" ");

		for (int i = 0; i < fechaArray.length; i++) {
			fechaArray[i] = fechaArray[i].substring(0, fechaArray[i].length() - 5);
		}

		for (int i = 1; i < numPersonas; i++) {
			for (int j = 0; j < fechaArray.length; j++) {
				if (fechaArray[i].equals(fechaArray[j])) {
					return true;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);
		int numPersonas;
		do {
			numPersonas = in.nextInt();
			if (numPersonas == 0) {
				System.exit(0);
			}
			if (casoDePrueba(numPersonas)) {
				System.out.println("SI");
			} else
				System.out.println("NO");
		} while (true);
	}
}