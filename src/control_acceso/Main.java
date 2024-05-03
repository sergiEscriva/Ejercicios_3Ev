package control_acceso;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static Scanner leer = new Scanner(System.in);
	static ArrayList<String> listaUsuariosEncripatda = new ArrayList<String>();
	static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	static char finalizar;
	private final static Logger LOGGER = LogManager.getLogger();
	private final static String RUTA = "src\\control_acceso\\fichero_acceso\\fichero_acceso.csv";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		System.out.println("Bienvenido, porfavor introduzca usuario y contraseña");
		try {
			datosEncriptados();
			IntroducirDatos();
			leer.close();
		} catch (Exception e) {
			LOGGER.error("Si ves esto es muy malo");
		}

	}

	public static void IntroducirDatos() {
		try {
			do {
				System.out.print("Nombre: ");
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
					leer.nextLine();
					if (alta == 's') {
						darAlta();
					} else {
						System.out.println("Me las piro vampiro");
						System.exit(0);
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

	public static void datosEncriptados() {
		String linea;
		int contador = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			while ((linea = br.readLine()) != null) {

				contador++;
				if (contador == 1) {
					continue;
				}
				listaUsuariosEncripatda.add(linea);

			}

		} catch (IOException e) {
			LOGGER.error("Fallo en la lectura del archivo");
		}
		datosCorrectos();
	}

	public static void datosCorrectos() {
		listaUsuarios = desencriptarLista();
	}

	public static ArrayList<Usuario> desencriptarLista() {
		ArrayList listaDesencriptada = new ArrayList<>();

		String lineaCompleta;
		String[] datosUsuario;

		for (int i = 0; i < listaUsuariosEncripatda.size(); i++) {
			StringBuilder lineaSeparada = new StringBuilder();
			ArrayList<Integer> valorAsci = sacarValorAsci(String.valueOf(listaUsuariosEncripatda.get(i)));
			for (int num : valorAsci) {
				int valorEncriptado = num - 3;
				char letra = (char) valorEncriptado;
				lineaSeparada.append(letra);
			}
			lineaCompleta = lineaSeparada.toString();
			datosUsuario = lineaCompleta.split(";");
			if (datosUsuario.length == 9) {
				listaDesencriptada.add(new Usuario(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4], datosUsuario[5], datosUsuario[6], Integer.parseInt(datosUsuario[7]), Integer.parseInt(datosUsuario[8])));

			} else {
				listaDesencriptada.add(new Usuario(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4], datosUsuario[5], Integer.parseInt(datosUsuario[6]), Integer.parseInt(datosUsuario[7])));
			}
		}
		return listaDesencriptada;
	}


	public static void darAlta() {
		try {
			Usuario usuario = obtenerDatosUsuario();
			listaUsuarios.add(usuario);
			anyadirSistema(usuario);
		} catch (RuntimeException e) {
			LOGGER.error("Fallo en la introduccion de datos" + e.getStackTrace());
		}
	}

	public static Usuario obtenerDatosUsuario() {
		String nombre = obtenerNombreValido();
		String contrasenya = obtenerContrasenyaValida();
		String correo = obtenerCorreoValido();
		String ip = obtenerIpValida();
		String nick = obtenerNickValido();
		String telefono = obtenerTelefonoValido();
		int contador = 0;
		String[] nombreCompleto = nombre.split(" ");
		if (nombreCompleto.length == 2) {
			return new Usuario(nombre, contrasenya, nombreCompleto[0], correo, ip, nick, Integer.parseInt(telefono), contador);
		} else {
			return new Usuario(nombre, contrasenya, nombreCompleto[0], nombreCompleto[1], correo, ip, nick, Integer.parseInt(telefono), contador);
		}

	}
	private static String obtenerNombreValido() {
		String nombre;
		do {
			System.out.println("Introduzca APELLIDOS y NOMBRE ejemplo:\n" +
					"Uroz Porrero Bea");
			nombre = leer.nextLine();

			if (!comprobarNombre(nombre)) {
				System.err.println("Formato de nombre incorrecto");
			}
		} while (!comprobarNombre(nombre));
		return nombre;
	}
	private static String obtenerContrasenyaValida() {
		String contrasenya;
		do {
			System.out.println("Introduzca su contraseña \n" +
					"-Caracteres minimos 8\n" +
					"-Debe contener minusculas y mayusculas\n" +
					"-Numeros y simbolos\n" +
					"ejemplo:" +
					"Abc1234@");
			contrasenya = leer.nextLine();

			if (!comprobarContrasenya(contrasenya)) {
				System.err.println("Formato de contraseña incorrecto");
			}
		} while (!comprobarContrasenya(contrasenya));
		return contrasenya;
	}
	private static String obtenerCorreoValido() {
		String correo;
		do {
			System.out.println("Introduzca su correo electronico");
			correo = leer.nextLine();

			if (!comprobarCorreo(correo)) {
				System.err.println("Formato de correo incorrecto");
			}
		} while (!comprobarCorreo(correo));
		return correo;
	}
	private static String obtenerIpValida() {
		String ip;
		do {
			System.out.println("Introduzca su direccion IP, IPV4");
			ip = leer.nextLine();

			if (!comprobarIP(ip)) {
				System.err.println("Formato de IP incorrecto");
			}
		} while (!comprobarIP(ip));
		return ip;
	}
	private static String obtenerNickValido() {
		String nick;
		do {
			System.out.println("Introduzca su nick\n" +
					"-Todo minusculas\n" +
					"-Unico simbolo permitido '_' ");
			nick = leer.nextLine();

			if (!comprobarNick(nick)) {
				System.err.println("Formato de nick incorrecto");
			}
		} while (!comprobarNick(nick));
		return nick;
	}
	private static String obtenerTelefonoValido() {
		String telefono;
		do {
			System.out.println("Introduzca su telefono\n" +
					"Sin region");
			telefono = leer.nextLine();

			if (!comprobarTelefono(telefono)) {
				System.err.println("Formato de telefono incorrecto");
			}
		} while (!comprobarTelefono(telefono));
		return telefono;
	}



	public static boolean comprobarNombre(String nombre) {
		Pattern pattern = Pattern.compile("^[a-zA-Z-]{1,20}\\s[a-zA-Z-]{1,20}(\\s[a-zA-Z-]{1,20})?$");
		Matcher matcher = pattern.matcher(nombre);
		return matcher.matches();
	}

	public static boolean comprobarContrasenya(String contrasenya) {
		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		Matcher matcher = pattern.matcher(contrasenya);
		return matcher.matches();
	}

	public static boolean comprobarCorreo(String correo) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(correo);
		return matcher.matches();
	}

	public static boolean comprobarIP(String ip) {

		Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
		Matcher matcher = pattern.matcher(ip);
		return matcher.matches();
	}

	public static boolean comprobarNick(String nick) {
		Pattern pattern = Pattern.compile("^[a-z_]{1,20}$");
		Matcher matcher = pattern.matcher(nick);
		return matcher.matches();
	}

	public static boolean comprobarTelefono(String telefono) {
		Pattern pattern = Pattern.compile("^[0-9]{9}$");
		Matcher matcher = pattern.matcher(telefono);
		return matcher.matches();
	}

	public static boolean anyadirSistema(Usuario usuario) {
		String nombreEncriptado = encriptar(usuario.getNombre());
		String contrasenyaEncripatda = encriptar(usuario.getContrasenya());
		String correoEncriptado = encriptar(usuario.getCorreo());
		String ipEncriptada = encriptar(usuario.getIp());
		String nickEncriptado = encriptar(usuario.getNick());
		String telefonoEncriptado = encriptar(String.valueOf(usuario.getTelefono()));
		String contador = encriptar(String.valueOf(usuario.getContador()));

		try (FileWriter fileWriter = new FileWriter(RUTA, true)) {
			fileWriter.write("\n" + nombreEncriptado + ">" + contrasenyaEncripatda + ">" + correoEncriptado + ">" + ipEncriptada + ">" + nickEncriptado + ">" + telefonoEncriptado + ">" + contador);
			listaUsuariosEncripatda.clear();
			datosEncriptados();
			return true;
		} catch (IOException e) {
			LOGGER.error("Error al crear usuario");
		}
		return false;
	}


	public static ArrayList<Integer> sacarValorAsci(String palabra) {

		ArrayList<Integer> valorPalabra = new ArrayList<>();
		for (int i = 0; i < palabra.length(); i++) {
			char caracter = palabra.charAt(i);
			valorPalabra.add((int) caracter);
		}
		return valorPalabra;
	}

	public static String encriptar(String palabra) {
		StringBuilder lineaSeparada = new StringBuilder();
		String lineaCompleta;
		ArrayList<Integer> valorAsci = sacarValorAsci(palabra);
		for (int num : valorAsci) {
			int valorEncriptado = num + 3;
			char letra = (char) valorEncriptado;
			lineaSeparada.append(letra);
		}
		return lineaCompleta = lineaSeparada.toString();

	}

}
