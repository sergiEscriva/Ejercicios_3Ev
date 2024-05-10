package Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Empresa {
    static HashMap<Empleado, String> listaEmpleados = new HashMap<>();
    static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido a la empresa que agrega, busca, elimina empleados\n");
        do {
            System.out.println("1. Agregar Empleado\n" +
                    "2. Eliminar Empleado\n" +
                    "3. Buscar Empleado");
            try {

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        agregarEmpleado(sc);
                        break;
                    case 2:
                        eliminarEmpleado(sc);
                        break;
                    case 3:
                        buscarnombre(sc);
                        break;
                    default:
                        System.out.println("Numero no valido");
                }

            } catch (RuntimeException e) {
                LOGGER.error(e.getStackTrace());
            }
        } while (opcion <= 3 && opcion >= 1);
    }

    private static void agregarEmpleado(Scanner sc) {
        boolean idPosible = Boolean.FALSE;
        String nombre;
        int id;
        try {
            System.out.print("Nombre de empleado:");
            nombre = sc.next();

            System.out.print("Identificador de empleado\n" +
                    "Ejemplo: 111\n");
            do {
                id = sc.nextInt();
                idPosible = comprobarId(id);
            }while (!idPosible);
            Empleado empleado = new Empleado(nombre, id);

            System.out.print("Cargo en la empresa:");
            String cargo = sc.next();

            listaEmpleados.put(empleado, cargo);
        } catch (RuntimeException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    private static void eliminarEmpleado(Scanner sc) {
        try {
            System.out.print("Nombre de empleado:");
            String nombre = sc.next();

            System.out.print("Identificador de empleado\n" +
                    "Ejemplo: 111\n");
            int id = sc.nextInt();
            Empleado empleado = new Empleado(nombre, id);

            for (Map.Entry<Empleado, String> listaBuscar : listaEmpleados.entrySet()) {
                if (listaBuscar.getKey().getNombre().equalsIgnoreCase(empleado.getNombre()) && listaBuscar.getKey().getId() == empleado.getId()) {
                    listaEmpleados.remove(listaBuscar.getKey());
                }
            }
        } catch (RuntimeException e) {
            LOGGER.error(e.getStackTrace());
        }
    }

    private static void buscarnombre(Scanner sc) {
        boolean encontrado = Boolean.FALSE;
        System.out.print("Nombre de empleado:");
        String nombre = sc.next();

        System.out.print("Identificador de empleado\n" +
                "Ejemplo: 111\n");
        int id = sc.nextInt();

        Empleado empleado = new Empleado(nombre, id);
        for (Map.Entry<Empleado, String> listaBuscar : listaEmpleados.entrySet()) {
            if (listaBuscar.getKey().getNombre().equalsIgnoreCase(empleado.getNombre()) && listaBuscar.getKey().getId() == empleado.getId()) {
                System.out.println(listaBuscar);
                encontrado = Boolean.TRUE;
            }
        }
        if (encontrado) {
            System.out.println("No se encuentra en el sistema");
        }

    }

    private static boolean comprobarId(int id) {
        for (Map.Entry<Empleado, String> listaBuscar : listaEmpleados.entrySet()) {
            if (listaBuscar.getKey().getId() == id) {
                System.out.println("Este id ya existe");
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
