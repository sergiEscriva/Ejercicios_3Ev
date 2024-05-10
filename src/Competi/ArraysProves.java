package Competi;

import java.util.Arrays;

public class ArraysProves {
    public static void main(String[] args) {
        int[][] array = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};

        // Ordenar cada fila del array bidimensional
        for (int i = 0; i < array.length; i++) {
            Arrays.sort(array[i]);
        }

        // Imprimir el array bidimensional ordenado
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
