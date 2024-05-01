package comparadores;

import java.util.Comparator;

public class ComparadorEstudianteNota implements Comparator<Estudiante> {
	@Override
	public int compare(Estudiante o1, Estudiante o2) {
		int nota = Double.compare(o2.getNotaMedia(), o1.getNotaMedia());

		if (nota == 0){
			return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
		}
		return nota;
	}
}
