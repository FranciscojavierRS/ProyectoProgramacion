package ExamenEstudiosAcademicos;

import java.util.Scanner;

public class EstudiosAcademicos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String claseMayorAprobado = "";
		int maxAlumnoAprobado = 0;
		String nombreTutorMenorSuspensos = "";
		float menorPorcentajeSuspensos = 100;
		int numeroDeClasesMayorAprobados = 0;
		float porcentajeAlumnosExamenFinalAprobado = 0;
		int alumnoExamenFinalAprobado = 0;
		int numeroAlumnosCentro = 0;

		boolean tresPrimerosAprobados = false;

		String nombreClase = "";
		while (!nombreClase.equalsIgnoreCase("fin")) {
			System.out.println("Nombre de la clase");
			nombreClase = sc.next();

			if (!nombreClase.equalsIgnoreCase("fin")) {
				System.out.println("Nombre del tutor");
				String nombreTutor = sc.next();

				int alumnosAprobados = 0;
				int alumnosSuspensos = 0;

				int numeroAlumnos = 0;

				boolean tresPrimerosAprobadosClase = false;

				String nombreAlumno = "";
				while (!nombreAlumno.equalsIgnoreCase("fin")) {

					System.out.println("Nombre del Alumno");
					nombreAlumno = sc.next();
					if (!nombreAlumno.equalsIgnoreCase("fin")) {
						numeroAlumnos++;
						numeroAlumnosCentro++;

						System.out.println("Nota obtenida en el control");
						int notaObtenidaControl = sc.nextInt();

						if (numeroAlumnos <= 3) {
							tresPrimerosAprobadosClase = notaObtenidaControl >= 5;
						}

						System.out.println("Nota obtenida en el Examen");
						int notaObtenidaExamenFianl = sc.nextInt();

						if (notaObtenidaExamenFianl >= 5) {
							alumnoExamenFinalAprobado++;
						}

						System.out.println("Nota de clase");
						int notaClase = sc.nextInt();

						int notaGlobal = (int) (notaObtenidaExamenFianl * 0.6 + notaObtenidaControl * 0.3
								+ notaClase * 0.1);

						if (notaGlobal >= 5) {
							alumnosAprobados++;
						} else {
							alumnosSuspensos++;
						}
					}
				}

				if (alumnosAprobados > maxAlumnoAprobado) {
					claseMayorAprobado = nombreClase;
					maxAlumnoAprobado = alumnosAprobados;

				}

				float porcentajeSuspenso = (float) alumnosSuspensos / numeroAlumnos;

				if (porcentajeSuspenso < menorPorcentajeSuspensos) {
					nombreTutorMenorSuspensos = nombreTutor;
					menorPorcentajeSuspensos = porcentajeSuspenso;
				}
				if (alumnosAprobados > alumnosSuspensos) {
					numeroDeClasesMayorAprobados++;

				}
				if (tresPrimerosAprobadosClase) {
					tresPrimerosAprobados = true;
				}
			}

		}

		System.out.println("(A) La clase con mayor número neto de aprobados es: " + claseMayorAprobado);
		System.out.println("(B) El tutor de la clase con menor porcentaje de suspensos es: " + nombreTutorMenorSuspensos
				+ " Con un porcentaje de " + menorPorcentajeSuspensos * 100);
		System.out
				.println("(C) El número de clases con más aprobados que suspensos es: " + numeroDeClasesMayorAprobados);

		porcentajeAlumnosExamenFinalAprobado = (float) alumnoExamenFinalAprobado / numeroAlumnosCentro;
		System.out.println("(D) El porcentaje total de alumnos con el final aprobado de todo el centro es:  "
				+ porcentajeAlumnosExamenFinalAprobado * 100);

		if (tresPrimerosAprobados) {
			System.out.println(
					"Hay alguna clase donde los tres primeros alumnos introducidos tienen el control aprobado.");
		} else {
			System.out.println(
					" No hay alguna clase donde los tres primeros alumnos introducidos tienen el control aprobado.");
		}

		sc.close();

	}

}
