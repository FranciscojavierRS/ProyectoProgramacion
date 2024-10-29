package EXAMEN2018_2019;

import java.util.Scanner;

/** En la Oficina de Estudios Académicos Hermanos Machado (OEAHM),
se pretende estudiar una serie de datos sobre las notas de los alumnos de varias clases. Para ello se debe.
realizar un programa en Java que permita la introducción de datos, y posteriormente muestre unos
resultados,

El programa debe permitir al usuario la introducción de una serio de clases y sus alumnos y notas,
de la siguiente forma:

Para cada clase, se introduci
yr datos cuando el nombre de la mis

en primer lugar su nombre (se sabrá que se desea terminar de

1a sea “fin”) y a continuación el nombre del tutor. Después

introduc
se introducirán los datos de los alumnos de esa clase, de la forma: nombro del alumno, nota obtenida en
el control, nota obtenida en el examen final y nota de clase (son números enteros). La serie de alumnos
de una clase terminará cuando el nombre sea “fin”. Para calcular la nota global de un alumno se hace el
60% del examen final, el 30% del control y el 10% de la nota de clase. (1 punto la petición correcta de

datos)
Los resultados que se deben mostrar al finalizar la introducción de datos son:
a) (1 punto) Nombre de la clase con mayor número noto de alumnos con la nota global aprobada.

b) (1,5 puntos) Nombre del tutor de la clase con menor porcentaje de suspensos (nota global), y
ese porcentaje.

e) (1 punto) Número de clases en las que el número de aprobados (nota global) es mayor que el
des

¡spensos.

d) (1 punto) Porcentaje de alumnos del centro con la nota del examen final (no la global, sino la
del examen final) aprobada.

e) (1,5 puntos) Si hubiera alguna clase en la que los tres primeros alumnos introducidos tienen la
nota del control aprobada (no la global), se debe indicar con un mensaje. */


public class EstudiosAcademicos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nombreClase, nombreTutor, nombreAlumno;
        int notaControl, notaExamenFinal, notaClase;
        int totalAlumnosCentro = 0, totalAprobadosCentro = 0, totalClases = 0;
        int mayorAprobadosClase = 0;
        String claseMayorAprobados = "";
        String tutorMenorSuspensos = "";
        double menorPorcentajeSuspensos = 100.0;
        int clasesConMasAprobados = 0;
        boolean claseTresPrimerosAprobados = false;

        while (true) {
            System.out.println("Introduce el nombre de la clase (o 'fin' para terminar): ");
            nombreClase = scanner.next();

            if (nombreClase.equalsIgnoreCase("fin")) break;

            System.out.println("Introduce el nombre del tutor de la clase: ");
            nombreTutor = scanner.next();

            int alumnosClase = 0, aprobadosClase = 0, suspensosClase = 0;
            int primerosTresAprobados = 0;
            boolean tresPrimerosContados = false;

            while (true) {
                System.out.println("Introduce el nombre del alumno (o 'fin' para terminar la clase): ");
                nombreAlumno = scanner.next();

                if (nombreAlumno.equalsIgnoreCase("fin")) break;

                System.out.println("Introduce la nota del control (entero): ");
                notaControl = scanner.nextInt();
                System.out.println("Introduce la nota del examen final (entero): ");
                notaExamenFinal = scanner.nextInt();
                System.out.println("Introduce la nota de clase (entero): ");
                notaClase = scanner.nextInt();

                // Calcular la nota global del alumno
                double notaGlobal = notaExamenFinal * 0.6 + notaControl * 0.3 + notaClase * 0.1;

                // Contar el total de alumnos y aprobados en el centro
                totalAlumnosCentro++;
                if (notaExamenFinal >= 5) totalAprobadosCentro++;

                // Contar el alumno como aprobado o suspendido en la clase
                alumnosClase++;
                if (notaGlobal >= 5) {
                    aprobadosClase++;
                } else {
                    suspensosClase++;
                }

                // Revisar si los tres primeros alumnos tienen nota de control aprobada
                if (!tresPrimerosContados) {
                    if (notaControl >= 5) primerosTresAprobados++;
                    if (primerosTresAprobados == 3) claseTresPrimerosAprobados = true;
                    if (alumnosClase == 3) tresPrimerosContados = true;
                }
            }

            // Verificar la clase con el mayor número de aprobados
            if (aprobadosClase > mayorAprobadosClase) {
                mayorAprobadosClase = aprobadosClase;
                claseMayorAprobados = nombreClase;
            }

            // Calcular el porcentaje de suspensos en la clase actual
            double porcentajeSuspensosClase = (suspensosClase * 100.0) / alumnosClase;
            if (porcentajeSuspensosClase < menorPorcentajeSuspensos) {
                menorPorcentajeSuspensos = porcentajeSuspensosClase;
                tutorMenorSuspensos = nombreTutor;
            }

            // Verificar si hay más aprobados que suspensos en la clase
            if (aprobadosClase > suspensosClase) {
                clasesConMasAprobados++;
            }

            totalClases++;
        }

        // Calcular el porcentaje de aprobados en el examen final en todo el centro
        double porcentajeAprobadosExamenFinal = (totalAprobadosCentro * 100.0) / totalAlumnosCentro;

        // Mostrar resultados
        System.out.println("a) Clase con mayor número de alumnos aprobados: " + claseMayorAprobados);
        System.out.println("b) Tutor de la clase con menor porcentaje de suspensos: " + tutorMenorSuspensos +
                           " con " + menorPorcentajeSuspensos + "% de suspensos");
        System.out.println("c) Número de clases con más aprobados que suspensos: " + clasesConMasAprobados);
        System.out.println("d) Porcentaje de alumnos del centro con examen final aprobado: " + porcentajeAprobadosExamenFinal + "%");
        if (claseTresPrimerosAprobados) {
            System.out.println("e) Hay al menos una clase donde los tres primeros alumnos tienen aprobada la nota del control.");
        } else {
            System.out.println("e) No hay ninguna clase donde los tres primeros alumnos tengan aprobada la nota del control.");
        }

        scanner.close();
    }
}

