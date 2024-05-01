package control_acceso;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner leer = new Scanner(System.in);
	static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	static char finalizar;
	private final static Logger LOGGER = LogManager.getLogger();
	private final static String RUTA = "src\\control_acceso\\fichero_acceso\\fichero_acceso.csv";

	public static void main(String[] args) {
		boolean isEncriptado = Boolean.FALSE;
		System.out.println("Bienvenido, porfavor introduzca usuario y contraseña");
		try {
			datosCorrectos();
			IntroducirDatos();
			leer.close();
		} catch (Exception e) {
			LOGGER.error("Si ves esto es muy malo");
		}

	}

	public static void IntroducirDatos() {
		try {
			do {
				System.out.print("Usuario: ");
				String nombre = leer.next();

				System.out.print("Contraseña: ");
				String contrasenya = leer.next();
				Usuario usuarioAComprobar = new Usuario(nombre, contrasenya);
				Usuario usuarioComprobado = comprobarDatos(usuarioAComprobar);
				if (usuarioComprobado != null) {
					System.out.println("Permitido!!!");
					usuarioComprobado.mostrarDatos();

				} else {
					System.out.println("No hemos encontrado las credenciales en nuestra BD\n" +
							"Desea darse de alta? \n (s / n)");
					char alta = leer.next().charAt(0);
					if (alta == 's') {
						darseAlta(nombre, contrasenya);
					}
				}
				System.out.println("Desea continuar? (s / n)");
				finalizar = leer.next().charAt(0);

			} while (finalizar == 's');
		} catch (RuntimeException e) {
			LOGGER.error("Fallo en la introduccion de datos" + e.getStackTrace());
		}
	}

	public static Usuario comprobarDatos(Usuario usuario) {
		for (Usuario buscarUsuario : listaUsuarios) {
			if (buscarUsuario.getNombre().equals(usuario.getNombre()) && buscarUsuario.getContrasenya().equals(usuario.getContrasenya())) {
				buscarUsuario.incrementarContador();
				return buscarUsuario;
			}
		}
		return null;
	}


	public static void datosCorrectos() {
		String linea;
		int contador = 0;
		String[] usuarioContrasenya = new String[2];
		try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			while ((linea = br.readLine()) != null) {

				contador++;
				if (contador == 1) {
					continue;
				}
				usuarioContrasenya = linea.split(";");
				listaUsuarios.add(new Usuario(usuarioContrasenya[0], usuarioContrasenya[1]));

			}

		} catch (IOException e) {
			LOGGER.error("Fallo en la lectura del archivo");
		}

	}

	public static boolean darseAlta(String nombre, String contrasenya) {

		try (FileWriter fileWriter = new FileWriter(RUTA, true)) {
			fileWriter.write("\n" + nombre + ";" + contrasenya);
			listaUsuarios.add(new Usuario(nombre, contrasenya));
			return true;
		} catch (IOException e) {
			LOGGER.error("Error al crear usuario");
		}
		return false;
	}

}
