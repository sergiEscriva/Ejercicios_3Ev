package Iterable;

import java.util.Objects;

public class Alumno{
	private String nombre;
	private int nia;
	private int edad;
	private String curso;
	private double notaMedia;

	public Alumno(String nombre, int nia, int edad, String curso, double notaMedia) {
		this.nombre = nombre;
		this.nia = nia;
		this.edad = edad;
		this.curso = curso;
		this.notaMedia = notaMedia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNia() {
		return nia;
	}

	public void setNia(int nia) {
		this.nia = nia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Alumno alumno = (Alumno) o;
		return nia == alumno.nia && edad == alumno.edad && Double.compare(notaMedia, alumno.notaMedia) == 0 && Objects.equals(nombre, alumno.nombre) && Objects.equals(curso, alumno.curso);
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre, nia, edad, curso, notaMedia);
	}

	@Override
	public String toString() {
		return getNombre() + " " + getNia() + " " + getEdad() + " " + getCurso() + " " + getNotaMedia();
	}
}
