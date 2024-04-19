package Iterable;

import java.util.ArrayList;
import java.util.Iterator;

public class Clase<Alumno> implements  Iterable<Alumno>{
	private ArrayList<Alumno> alumnos = new ArrayList<>();
	public void add(Alumno alumno) {
		alumnos.add(alumno);
	}


	@Override
	public Iterator<Alumno> iterator() {
		return alumnos.iterator();
	}
}
