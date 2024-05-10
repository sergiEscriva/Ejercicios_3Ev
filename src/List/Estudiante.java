package List;

import java.time.LocalDate;
import java.util.Objects;

public class Estudiante implements Comparable<Estudiante>{
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private double notaMedia;

	public Estudiante(String nombre, String apellido, LocalDate fechaNacimiento, double notaMedia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.notaMedia = notaMedia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
		Estudiante that = (Estudiante) o;
		return Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, apellido, fechaNacimiento, notaMedia);
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Apellidos: " + apellido + ", Fecha de nacimiento: " + fechaNacimiento + ", Nota media" + notaMedia + "\n";
	}

	@Override
	public int compareTo(Estudiante o) {
		int comparador = Double.compare(this.notaMedia, o.getNotaMedia());
		if (comparador == 0){
			comparador = this.nombre.compareTo(o.getNombre());
			if (comparador == 0){
				return this.apellido.compareTo(o.getApellido());
			}
			return comparador;
		}
		return comparador;
	}


}
