package enums;

public enum ValorCarta {
	AS(1),
	UNO(1),
	DOS(2),
	TRES(3),
	CUATRO(4),
	CINCO(5),
	SEIS(6),
	SIETE(7),
	OCHO(8),
	NUEVE(9),
	DIEZ(10),
	J(10),
	Q(10),
	K(10);


	private final int VALOR;

	ValorCarta(int valor) {
		this.VALOR = valor;
	}

	public int getVALOR() {
		return VALOR;
	}

	public  int obtenerPuntos(ValorCarta valorCarta){
		return valorCarta.getVALOR();
	}
}
