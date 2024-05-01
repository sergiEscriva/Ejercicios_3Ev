package control_acceso;

import java.time.LocalDate;

public class Usuario {
	private LocalDate fechaAcceso;
	private String contrasenya;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String correo;
	private String ip;
	private String nick;
	private int telefono;
	private int contador;

	public Usuario(String contrasenya, String nombre) {
		this.contrasenya = contrasenya;
		this.nombre = nombre;

	}
	public Usuario(String contrasenya, String nombre, String apellido1, String apellido2, String correo, String ip, String nick, int telefono) {
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.ip = ip;
		this.nick = nick;
		this.telefono = telefono;
	}

	public Usuario(String contrasenya, String nombre, String apellido1, String correo, String ip, String nick, int telefono) {
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.correo = correo;
		this.ip = ip;
		this.nick = nick;
		this.telefono = telefono;
	}

	private int getContador() {
		return contador;
	}

	private void setFechaAcceso(LocalDate fechaAcceso) {
		this.fechaAcceso = fechaAcceso;
	}

	public String getNombre() {
		return nombre;
	}


	public String getContrasenya() {
		return contrasenya;
	}

	public void incrementarContador() {
		this.contador++;
	}

	public void mostrarDatos() {
		setFechaAcceso(LocalDate.now());
		System.out.println("Ultima fecha accedido: " + this.fechaAcceso);

		System.out.println("El numero de acceso es de: " + getContador());

	}

}
