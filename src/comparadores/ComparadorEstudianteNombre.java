package comparadores;

import java.util.Comparator;

public class ComparadorEstudianteNombre implements Comparator<Estudiante> {
	@Override
	public int compare(Estudiante o1, Estudiante o2) {
		int nombre = o1.getNombre().compareTo(o2.getNombre());
		if (nombre == 0){
			return o1.getApellido().compareTo(o2.getApellido());
		}
		return nombre;
	}
}
