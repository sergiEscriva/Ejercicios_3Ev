package enums;

public class Carta {
	public static void main(String[] args) {
		ValorCarta as = ValorCarta.AS;
		ValorCarta j = ValorCarta.J;
		System.out.println("Que vale el 'AS'?");
		System.out.println("El AS vale " + as.obtenerPuntos(as));

		System.out.println("Que vale el 'J'?");
		System.out.println("La J vale " + j.obtenerPuntos(j));

	}
}
