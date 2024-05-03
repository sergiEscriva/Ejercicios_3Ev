package enums;

public enum EstadoJuego{
	INICIADO,
	EN_PROGRESO,
	PAUSADO,
	TERMINADO;
	public   void mostrarEstado(EstadoJuego estadoJuego){
		switch (estadoJuego){
			case PAUSADO :
				System.out.println("Esta pausado");
				break;
			case INICIADO:
				System.out.println("El juego esta iniciado");
				break;
			case TERMINADO:
				System.out.println("El juego ha terminado");
				break;
			case EN_PROGRESO:
				System.out.println("El juegp esta en progreso");
				break;
			default:
				System.out.println("cualquier otro estado");
		}

	}
}
