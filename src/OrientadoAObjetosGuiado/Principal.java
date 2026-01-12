package OrientadoAObjetosGuiado;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		/*
		 * Alumno a1 = new Alumno("Fran", 23, 10); Alumno a2 = new Alumno("Angel", 31,
		 * 9); Alumno a3 = new Alumno("Virginia", 62, 8); System.out.println(a1);
		 * System.out.println(a2); System.out.println(a3);
		 */
		Profesor b1 = new Profesor("Paco", 30, "toca pelotas");
		/*
		 * Profesor b2 = new Profesor("Jaimito", 30, "El tonto"); Profesor b3 = new
		 * Profesor("Timy", 30, "Raton"); System.out.println(b1);
		 * System.out.println(b2); System.out.println(b3);
		 */
		Grupo g1 = new Grupo("DAW1", b1);
		/*
		 * if (!g1.addAlumno(a1) || !g1.addAlumno(a2) || !g1.addAlumno(a3) ||
		 * !g1.addAlumno(new Alumno("Maria", 19, 54321))) { System.out.println("Error");
		 * }
		 * 
		 * System.out.println(g1);
		 */

		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		while (opcion != 3) {

			System.out.println("1 – Añadir alumno al grupo.");
			System.out.println("2-Listar el grupo");
			System.out.println("3- Fin.");

			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				// Introduce un caballo (nuevo o existente), la carrera y su velocidad
				System.out.println("Introduce nombre de Alumno");
				String nombre = sc.next();
				System.out.println("introduce edad del Alumno");
				int edad = sc.nextInt();
				System.out.println("introduce expediente del Alumno");
				long expediente = sc.nextLong();
				if (!g1.addAlumno(new Alumno(nombre, edad, expediente))) {
					System.out.println("Error");
				}
				break;
			case 2:
				System.out.println(g1);
				break;

			default:
			}
		}
		sc.close();
	}

}
