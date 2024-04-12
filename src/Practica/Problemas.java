package Practica;

import java.util.Scanner;

public class Problemas { // Asume fichero llamado solution.java

	static Scanner in;
	static Scanner sc = new Scanner(System.in);

	public static int[] casoDePrueba() {
		String  entradaDatos = sc.nextLine();
		String[] mat = entradaDatos.split(" ");
		int[] datos = new int[3];
		for(int i = 0; i < 3; i++) {
			datos[i] = Integer.parseInt(mat[i]);
		}
		return datos;


	}

	public static void main(String[] args) {

		in = new Scanner(System.in);

		int numCasos = in.nextInt();

		String cadena = "";
		int[] datos = new int[3];
		int[][] datosProblemas  = new int[numCasos][3];
		for (int i = 0; i < numCasos; i++) {
			datos = casoDePrueba();
			datosProblemas[i][0] = datos[0];
			datosProblemas[i][1] = datos[1];
			datosProblemas[i][2] = datos[2];
		}
		comparar(datosProblemas);

	} // main
	public static void comparar(int[][] datosProblemas) {
		f





	}
} // class solution
