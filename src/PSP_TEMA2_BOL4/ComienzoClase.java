package PSP_TEMA2_BOL4;

import java.util.Scanner;

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
