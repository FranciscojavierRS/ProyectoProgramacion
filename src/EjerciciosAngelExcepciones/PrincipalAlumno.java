package EjerciciosAngelExcepciones;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

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
