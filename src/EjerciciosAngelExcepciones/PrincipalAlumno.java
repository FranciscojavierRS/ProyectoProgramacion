package EjerciciosAngelExcepciones;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * Crea una clase Alumno con:
Atributos: dni (String), nombre (String) y notaMedia (double).
Un alumno es igual a otro si tiene el mismo dni
Orden natural: Por notaMedia de mayor a menor.

En una clase Principal, crea un HashSet<Alumno> y añade 5 alumnos (asegúrate de repetir un DNI para comprobar que el Set no lo admite).
Escribe todos los alumnos del HashSet en un fichero binario llamado estudiantes.dat

Imprime por pantalla y escribe en un fichero de texto:
1 Dame la lista de alumnos ordenada.
Al final del fichero, indica quién es el alumno con la nota más alta.
Indica cuántos alumnos tienen una nota superior a 5.
 */

public class PrincipalAlumno {

	public static void main(String[] args) {

		HashSet<Alumno> conjuntoAlumnos = new HashSet<>();

		conjuntoAlumnos.add(new Alumno("49134342V", "Francisco Javier", 7.7));
		conjuntoAlumnos.add(new Alumno("49134342V", "Pepito", 7.7));
		conjuntoAlumnos.add(new Alumno("49134342V", "Francisco Javier", 7.7));
		conjuntoAlumnos.add(new Alumno("51134342V", "nito", 3.7));
		conjuntoAlumnos.add(new Alumno("50134342V", "tontito", 2.7));

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("estudiantes.dat"));

			for (Alumno alumno : conjuntoAlumnos) {
				out.writeObject(alumno);

			}

			out.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// parte 2

		try {
			BufferedWriter out2 = new BufferedWriter(new FileWriter("alumnosResultados.txt"));

			ArrayList<Alumno> alumnosOrdenados = new ArrayList<>(conjuntoAlumnos);

			alumnosOrdenados.sort(null);

			System.out.println("Lista de alumnos ordenados");
			out2.write("Lista de alumnos ordenados");

			for (Alumno alumno : alumnosOrdenados) {

				System.out.println(alumno);
				out2.newLine();
				out2.write(alumno.toString());
			}

			double notaMaxima = 0;
			Alumno alumnoNotaMasAlta = null;
			int contadorAlumnosMas5 = 0;

			for (Alumno alumno : conjuntoAlumnos) {

				if (alumno.getNotaMedia() > notaMaxima) {
					alumnoNotaMasAlta = alumno;
					notaMaxima = alumno.getNotaMedia();

				}

				if (alumno.getNotaMedia() > 5) {
					contadorAlumnosMas5++;
				}
			}

			System.out.println("El alumno con mayor nota media es: " + alumnoNotaMasAlta.getNombre());

			out2.newLine();

			out2.write("El alumno con mayor nota media es: " + alumnoNotaMasAlta.getNombre());

			System.out.println("La cantidad de Alumnos que tienen mas de un 5 son " + contadorAlumnosMas5);

			out2.newLine();

			out2.write("La cantidad de Alumnos que tienen mas de un 5 son " + contadorAlumnosMas5);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
