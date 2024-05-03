package enums;

public enum NivelJuego {
		PRINCIPIANTE,
		INTERMEDIO,
		AVANZADO;
	public static boolean esAvanzado(NivelJuego nivelJuego){
		if (nivelJuego == NivelJuego.AVANZADO){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

}
