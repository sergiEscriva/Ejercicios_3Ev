package control_acceso;

import java.time.LocalDate;

public class Usuario {
    private final String contrasenya;
    private String nombre;
    private int contador;
    private LocalDate fechaAcceso;

    public Usuario(String nombre, String contrasenya) {
        this.nombre = nombre;
        this.contrasenya = contrasenya;
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

    public void incrementarContador(){
        this.contador++;
    }

    public void mostrarDatos(){
        setFechaAcceso(LocalDate.now());
        System.out.println("Ultima fecha accedido: " + this.fechaAcceso);

        System.out.println("El numero de acceso es de: " + getContador());

    }

}
