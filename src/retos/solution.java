package retos;

public class solution { // Asume fichero llamado solution.java

	static java.util.Scanner in;

	public static boolean casoDePrueba() {
		int casosPrueba = in.nextInt();
		in.nextLine();
		String[] numeros = in.nextLine().split(" ");
		for (int i = 1; i < casosPrueba; i++) {
			int temp = Integer.parseInt(numeros[i]);
			if ((Math.abs(temp) < Math.abs(Integer.parseInt(numeros[i - 1])))) {
				if (Math.signum(temp) == Math.signum(Integer.parseInt(numeros[i - 1]))) {
					return false;
				}
			}
		}

		return true;
	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			if (casoDePrueba()) {
				System.out.println("CORRECTA");
			} else {
				System.out.println("INCORRECTA");
			}
	} // main
} // class solution