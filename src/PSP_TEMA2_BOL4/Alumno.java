package PSP_TEMA2_BOL4;

import java.util.Scanner;

public class Alumno extends Thread {

    private Bienvenida saludo;
    private String nombre;

    public Alumno(String nombre, Bienvenida bienvenida) {
        this.nombre = nombre;
        this.saludo = bienvenida;
    }

    public void run() {
        System.out.println("El alumno " + nombre + " llegó");
        try {
            Thread.sleep(1000);
            saludo.saludarProfesor(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

