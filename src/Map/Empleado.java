package Map;

import java.util.Objects;

public class Empleado {
	private String nombre;
	private int  id;

	public Empleado(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}


	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Empleado empleado = (Empleado) o;
		return id == empleado.id && Objects.equals(nombre, empleado.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, id);
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"nombre='" + nombre + '\'' +
				", id=" + id +
				'}';
	}
}
