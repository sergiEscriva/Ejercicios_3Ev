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
	public Usuario(String nombre, String contrasenya, String apellido1, String apellido2, String correo, String ip, String nick, int telefono, int contador) {
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.ip = ip;
		this.nick = nick;
		this.telefono = telefono;
		this.contador = contador;
	}

	public Usuario(String nombre, String contrasenya, String apellido1, String correo, String ip, String nick, int telefono, int contador) {
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.correo = correo;
		this.ip = ip;
		this.nick = nick;
		this.telefono = telefono;
		this.contador = contador;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getCorreo() {
		return correo;
	}

	public String getIp() {
		return ip;
	}

	public String getNick() {
		return nick;
	}

	public int getTelefono() {
		return telefono;
	}

	public int getContador() {
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
