package Practica;

import java.util.Scanner;

public class Globos { // Asume fichero llamado Globos.java

	static java.util.Scanner in;
	static Scanner sc = new Scanner(System.in);

	public static void casoDePrueba() {
		int globos = 0;
		do {
			globos = sc.nextInt();
			sc.nextLine();
		} while (globos < 1 || globos > 10000);

		String helio = sc.nextLine();
		String[] mat = helio.split(" ");

		int[] matrizHelio = new int[globos];
		for(int i = 0; i < globos; i++) {
			matrizHelio[i] = Integer.parseInt(mat[i]);
		}
		int min = 20000;
		for (int i = 0; i < globos; i++) {
			if (matrizHelio[i] < 1) {
				matrizHelio[i] = 1;
			}
			min = Math.min(min, matrizHelio[i]);
		}
		int total = 0;
		for (int i = 0; i < globos; i++) {
			total += matrizHelio[i] - min;
		}
		System.out.println(total);




	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			casoDePrueba();
	} // main
} // class Globos