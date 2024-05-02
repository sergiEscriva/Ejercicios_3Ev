package enums;

public class Niveles {


	public static void main(String[] args) {
		System.out.println("Avanzado " +esAvanzado(NivelJuego.AVANZADO));
		System.out.println("Principiante " +esAvanzado(NivelJuego.PRINCIPIANTE));
		System.out.println("Intermedio " +esAvanzado(NivelJuego.INTERMEDIO));

		System.out.println("Pausado " );
		mostrarEstado(EstadoJuego.PAUSADO);

		System.out.println("Iniciado ");
		mostrarEstado(EstadoJuego.INICIADO);

		System.out.println("En progreso ");
		mostrarEstado(EstadoJuego.EN_PROGRESO);

		System.out.println("Terminado ");
		mostrarEstado(EstadoJuego.TERMINADO);



	}

	private static boolean esAvanzado(NivelJuego nivelJuego){
		if (nivelJuego == NivelJuego.AVANZADO){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	private static void mostrarEstado(EstadoJuego estadoJuego){
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
