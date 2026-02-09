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

/*
 * package PSP_TEMA2_BOL4;

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
 * 
 * 
 * --------------------------------------------------------------------
 * 
 * public class Bienvenida {

    private boolean clase_comenzada = false;
    private int totalAlumnos;
    private int alumnosSaludados = 0;

    public Bienvenida(int totalAlumnos) {
        this.totalAlumnos = totalAlumnos;
    }

    public synchronized void saludarProfesor(String nombre) {
        try {
            while (!clase_comenzada) {
                wait();
            }

            System.out.println("El alumno saluda al profesor");
            alumnosSaludados++;

            System.out.println("Hola, soy " + nombre);

            if (alumnosSaludados == totalAlumnos) {
                System.out.println("Fin de los saludos");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void llegadaProfesor(String nombre) {
        System.out.println("Buenos días, soy " + nombre);
        clase_comenzada = true;
        notifyAll();
    }
}
 * 
 * -----------------------------------------------------------------------------------------
 * 
 * import java.util.Scanner;

public class ComienzoClase {

    public static void main(String[] args) {

        int numAlumnos = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);

        Bienvenida bienvenida = new Bienvenida(numAlumnos);
        String[] alumnos = new String[numAlumnos];

        for (int i = 0; i < numAlumnos; i++) {
            System.out.print("Alumno" + i + "=");
            alumnos[i] = sc.nextLine();
        }

        for (String nombre : alumnos) {
            new Alumno(nombre, bienvenida).start();
        }

        new Profesor("María Molina", bienvenida).start();

        sc.close();
    }
}
 * 
 * -----------------------------------------------------------------------------------------------
 * 
 * 
 * package PSP_TEMA2_BOL4;

public class Profesor extends Thread {

    private String nombre;
    private Bienvenida saludo;

    public Profesor(String nombre, Bienvenida bienvenida) {
        this.nombre = nombre;
        this.saludo = bienvenida;
    }

    public void run() {
        System.out.println("El profesor " + nombre + " llegó");
        try {
            Thread.sleep(1000);
            saludo.llegadaProfesor(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 */