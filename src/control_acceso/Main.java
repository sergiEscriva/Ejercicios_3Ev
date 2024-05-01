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
			prueba(2);
			prueba(1);
			datosCorrectos();
			IntroducirDatos();
			prueba(2);
			isEncriptado = Boolean.TRUE;
			leer.close();
		} catch (Exception e) {
			LOGGER.error("Si ves esto es muy malo");
		}finally {
			if (!isEncriptado){
				prueba(2);
			}
		}
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				prueba(2);
			}
		});
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

	public static void prueba(int opcion) {
		try {
			ArrayList<String> lineas = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					lineas.add(linea);
				}
			}

			if (opcion == 1) {
				for (int i = 0; i < lineas.size(); i++) {
					lineas.set(i, desencriptar(lineas.get(i)));
				}

			} else {
				for (int i = 0; i < lineas.size(); i++) {
					lineas.set(i, encriptar(lineas.get(i)));
				}
			}

			try (FileWriter writer = new FileWriter(RUTA)) {
				for (String linea : lineas) {
					writer.write(linea + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String encriptar(String linea) {
		ArrayList<Integer> valorAsci = sacarValorAsci(linea);
		StringBuilder sb = new StringBuilder();
		for (int num : valorAsci) {
			int valorEncriptado = num + 3;
			char letra = (char) valorEncriptado;
			sb.append(letra);
		}
		return sb.toString();
	}

	public static String desencriptar(String linea) {
		ArrayList<Integer> valorAsci = sacarValorAsci(linea);
		StringBuilder sb = new StringBuilder();
		for (int num : valorAsci) {
			int valorDesencriptado = num - 3;
			char letra = (char) valorDesencriptado;
			sb.append(letra);
		}
		return sb.toString();
	}

	public static ArrayList<Integer> sacarValorAsci(String palabra) {
		ArrayList<Integer> valorPalabra = new ArrayList<>();
		for (int i = 0; i < palabra.length(); i++) {
			char caracter = palabra.charAt(i);
			valorPalabra.add((int) caracter);
		}
		return valorPalabra;
	}
}
