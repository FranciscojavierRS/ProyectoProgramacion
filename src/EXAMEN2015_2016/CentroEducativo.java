package EXAMEN2015_2016;

import java.util.ArrayList;
import java.util.Scanner;

/** 1.- (7 Ptos.) En un centro educativo se desea realizar un estudio de determinados aspectos de las unidades de
que dispone. Las unidades pueden ser Clases o Departamentos. Todas las unidades tienen un código formado
por una letra y tres dígitos. El código de los departamentos empieza por "D" (D765, D324, D076,...) y el de las
clases por "C" (C222, C659, C001,...). Para realizar el estudio, se van a introducir los datos mediante un
programa en Java. Realiza un programa en Java que permita hacerlo (1 punto, junto con la valoración general),
sabiendo que:
 - No sabemos cuántas unidades se van a introducir. Para cada unidad, se va a introducir como primer dato
el código. Los datos acabarán cuando el código introducido sea "fin".
 - Si el código introducido es de un departamento, seguidamente se pedirá el nombre del departamento, el
número de profesores que tiene, y para cada profesor el nombre y los años que lleva en el centro.
 - Si el código es de una clase, se introducirá después una letra : E, P, B o F; dependiendo de si la clase es de
ESO, PCPI, Bachillerato o FP.
- Si la clase es de ESO, se pedirán los nombres de cada alumno y la nota media del alumno,
hasta que el nombre sea "fin".
- Si la clase es de PCPI, el nombre de la especialidad.
- Si la clase es de Bachillerato, el número de asignaturas que tiene.
- Si la clase es de FP, el nombre del título y las horas totales de duración del ciclo.
 - NO podemos asumir que se introducen otros datos que no sean los que se indican aquí, es decir, no
se va a introducir ningún otro dato que no sea lo que se ha indicado. Siempre habrá al menos un profesor en
cada departamento. Puede no haber ninguna clase de PCPI. Habrá al menos una clase de Bachillerato. Los
ciclos de F.P. no duran más de 2.500 h. Los años de permanencia de un profesor no van a pasar de 40. En la
parte trasera de esta hoja hay un ejemplo de los datos que se podrían introducir.
Se debe mostrar al final:
 Nombre del departamento con más profesores.(0,5 puntos)
 Nombre del alumno de ESO con mayor nota media, de los grupos de menos de 20 alumnos. (1,25
puntos)
 Nombre de las dos últimas especialidades de PCPI introducidas. Si hay menos de dos en total, deberá
indicarse. (1 punto)
 Media del número de asignaturas en las clases de Bachillerato. (1 punto)
 Número de ciclos de F.P. con más de 1.500 horas. (0,5 puntos)
 Nombre del ciclo de F.P. de menor duración. (0,5 puntos)
 Nombre del departamento con menor media de años de permanencia en el centro de sus profesores.
(1,25 puntos) */


public class CentroEducativo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables para almacenar datos generales
        String nombreDepartamentoMayorProfesores = "";
        String nombreDepartamentoMenorMediaAños = "";
        String nombreAlumnoMayorNota = "";
        String fpCicloMenorDuracion = "";
        String[] ultimasEspecialidadesPCPI = new String[2];
        ultimasEspecialidadesPCPI[0] = "No hay especialidades suficientes";
        ultimasEspecialidadesPCPI[1] = "No hay especialidades suficientes";
        int mayorNumeroProfesores = 0;
        int menorMediaAños = Integer.MAX_VALUE;
        int ciclosFP1500Horas = 0;
        int menorDuracionCiclo = Integer.MAX_VALUE;
        double mayorNota = 0;
        double sumaAsignaturasBachillerato = 0;
        int clasesBachillerato = 0;

        // Datos temporales
        String codigoUnidad;
        int numAlumnos = 0;

        while (true) {
            System.out.println("Introduce el código de la unidad (o 'fin' para terminar): ");
            codigoUnidad = scanner.nextLine();

            // Salir del bucle si se introduce "fin"
            if (codigoUnidad.equalsIgnoreCase("fin")) {
                break;
            }

            // Procesar departamentos
            if (codigoUnidad.startsWith("D")) {
                System.out.println("Introduce el nombre del departamento: ");
                String nombreDepartamento = scanner.nextLine();
                System.out.println("Introduce el número de profesores: ");
                int numeroProfesores = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                // Procesar cada profesor del departamento
                int sumaAños = 0;
                for (int i = 0; i < numeroProfesores; i++) {
                    System.out.println("Introduce el nombre del profesor " + (i + 1) + ": ");
                    String nombreProfesor = scanner.nextLine();
                    System.out.println("Introduce los años que lleva en el centro: ");
                    int añosProfesor = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    sumaAños += añosProfesor;
                }

                // Verificar el departamento con mayor número de profesores
                if (numeroProfesores > mayorNumeroProfesores) {
                    mayorNumeroProfesores = numeroProfesores;
                    nombreDepartamentoMayorProfesores = nombreDepartamento;
                }

                // Calcular la media de años de permanencia en el departamento
                int mediaAños = sumaAños / numeroProfesores;
                if (mediaAños < menorMediaAños) {
                    menorMediaAños = mediaAños;
                    nombreDepartamentoMenorMediaAños = nombreDepartamento;
                }

            } else if (codigoUnidad.startsWith("C")) {
                System.out.println("Introduce la letra de la clase (E, P, B, F): ");
                char tipoClase = scanner.nextLine().toUpperCase().charAt(0);

                // Procesar según el tipo de clase
                if (tipoClase == 'E') { // ESO
                    numAlumnos = 0;
                    while (true) {
                        System.out.println("Introduce el nombre del alumno (o 'fin' para terminar): ");
                        String nombreAlumno = scanner.nextLine();
                        if (nombreAlumno.equalsIgnoreCase("fin")) {
                            break;
                        }
                        System.out.println("Introduce la nota media del alumno: ");
                        double notaMedia = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar buffer
                        numAlumnos++;

                        // Verificar si la nota es la mayor para grupos de menos de 20 alumnos
                        if (numAlumnos < 20 && notaMedia > mayorNota) {
                            mayorNota = notaMedia;
                            nombreAlumnoMayorNota = nombreAlumno;
                        }
                    }
                } else if (tipoClase == 'P') { // PCPI
                    System.out.println("Introduce el nombre de la especialidad: ");
                    String especialidad = scanner.nextLine();

                    // Almacenar las dos últimas especialidades
                    ultimasEspecialidadesPCPI[0] = ultimasEspecialidadesPCPI[1];
                    ultimasEspecialidadesPCPI[1] = especialidad;

                } else if (tipoClase == 'B') { // Bachillerato
                    System.out.println("Introduce el número de asignaturas: ");
                    int numAsignaturas = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    // Acumular para el cálculo de la media
                    sumaAsignaturasBachillerato += numAsignaturas;
                    clasesBachillerato++;

                } else if (tipoClase == 'F') { // FP
                    System.out.println("Introduce el nombre del ciclo: ");
                    String nombreCiclo = scanner.nextLine();
                    System.out.println("Introduce las horas totales del ciclo: ");
                    int horasCiclo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    // Verificar si el ciclo tiene más de 1500 horas
                    if (horasCiclo > 1500) {
                        ciclosFP1500Horas++;
                    }

                    // Verificar el ciclo de menor duración
                    if (horasCiclo < menorDuracionCiclo) {
                        menorDuracionCiclo = horasCiclo;
                        fpCicloMenorDuracion = nombreCiclo;
                    }
                }
            } else {
                System.out.println("Código inválido.");
            }
        }

        // Mostrar los resultados
        System.out.println("Departamento con más profesores: " + nombreDepartamentoMayorProfesores);
        System.out.println("Alumno de ESO con mayor nota en grupos de menos de 20 alumnos: " + nombreAlumnoMayorNota);
        System.out.println("Últimas dos especialidades PCPI introducidas: " + ultimasEspecialidadesPCPI[0] + ", " + ultimasEspecialidadesPCPI[1]);

        // Mostrar la media de asignaturas en Bachillerato
        if (clasesBachillerato > 0) {
            double mediaAsignaturas = sumaAsignaturasBachillerato / clasesBachillerato;
            System.out.println("Media de asignaturas en Bachillerato: " + String.format("%.2f", mediaAsignaturas));
        } else {
            System.out.println("No hay clases de Bachillerato.");
        }

        // Mostrar ciclos de FP con más de 1500 horas
        System.out.println("Número de ciclos de FP con más de 1500 horas: " + ciclosFP1500Horas);
        System.out.println("Ciclo de FP con menor duración: " + fpCicloMenorDuracion);
        System.out.println("Departamento con menor media de años de permanencia: " + nombreDepartamentoMenorMediaAños);

        scanner.close();
    }
}

