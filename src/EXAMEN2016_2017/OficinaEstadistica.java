package EXAMEN2016_2017;

import java.util.Scanner;

/** En la Oficina de Estadísticas Hermanos Machado (OEHM),
pretende estudiar una serie de datos sobre provincias y municipios. Para ello se debe realizar un

programa en Java que permita la introducción de datos, y posteriormente muestre unos resultados.
El programa debe permitir al usuario la introducción de los siguientes datos:

Primero, el número de provincias que se van a procesar. Después, para cada provincia se
introducirá su nombre y una serie de datos de localidades (nombre de la localidad, número de
habitantes de la localidad, extensión de su término municipal y si posee o no juzgados propios), hasta

que el nombre de la localidad sea “fin”; en cuyo caso se procederá a tratar la provincia siguiente (ver

ejemplo de datos de entrada en la siguiente página) (1 punto la petición correcta de datos).
Los resultados que se deben mostrar al finalizar la introducción do datos son
a) (1 punto) Nombre de la provincia con mayor extensión media de sus municipios.
b), (1 punto) Nombre de las tres localidados con más habitantes.
e). (1 punto) Número medio de localidades por provincia.
d) (1 punto) Si existe alguna provincia con menos de 3 localidades, un mensaje que lo indique,
e) (0,75 puntos) Nombre de la localidad con menor densidad de población.
1) (1.25 puntos) Nombre de la provincia con mayor porcentaje de localidades con juzgado.
Valoraciones:

NO podemos asumir que se introducen otros datos que no sean los que se indican
aquí, es decir, no se va a introducir ningún otro dato que no sea lo que se ha indicado. Se introducirán
obligatoriamente en el orden en que se indica, sin diálogos extra de confirmación. Sabemos que el
usuario no va a cometer errores en ninguna de las opciones,

- El fichero fuente java a entregar debe compilar sin errores (si no compila la nota máxima es 4,
según el código).

- No se deben producir excepciones (por cada situación distinta que produzca una excepción, se

restará 1 punto de la nota final obtenida).

- Sólo se puede presuponer alguna condición si no contradice el enunciado (en caso de
contradecirlo, el apartado tendrá 0 puntos).

- So valorará ol código correcto, indentado y comentado; la claridad de código y su eficiencia y la
stencia de código o variables superfluas. **/

public class OficinaEstadistica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables globales para los resultados solicitados
        String provinciaMayorExtensionMedia = "";
        String localidadMenorDensidad = "";
        String provinciaMayorPorcentajeJuzgado = "";
        String localidadMasHabitantes1 = "";
        String localidadMasHabitantes2 = "";
        String localidadMasHabitantes3 = "";
        
        double mayorExtensionMedia = 0;
        double menorDensidad = Double.MAX_VALUE;
        double mayorPorcentajeJuzgado = 0;
        int totalLocalidadesProvinciaJuzgados = 0;
        int totalLocalidadesJuzgados = 0;
        int totalLocalidades = 0;
        int totalProvincias = 0;
        int provinciasConMenosDe3Localidades = 0;

        System.out.print("Introduce el número de provincias: ");
        int numProvincias = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer de nueva línea

        for (int i = 1; i <= numProvincias; i++) {
            System.out.print("Introduce el nombre de la provincia: ");
            String nombreProvincia = scanner.nextLine();

            // Variables para la provincia actual
            int numLocalidades = 0;
            double sumaExtensiones = 0;
            int localidadesConJuzgado = 0;

            while (true) {
                System.out.print("Introduce el nombre de la localidad (o 'fin' para terminar): ");
                String nombreLocalidad = scanner.nextLine();

                if (nombreLocalidad.equalsIgnoreCase("fin")) {
                    break;
                }

                System.out.print("Introduce el número de habitantes de " + nombreLocalidad + ": ");
                int habitantes = scanner.nextInt();
                System.out.print("Introduce la extensión de " + nombreLocalidad + " en km²: ");
                double extension = scanner.nextDouble();
                System.out.print("¿Posee juzgado propio? (1 para sí, 0 para no): ");
                int tieneJuzgado = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer de nueva línea

                // Sumar para calcular extensión media y otras estadísticas
                sumaExtensiones += extension;
                numLocalidades++;
                totalLocalidades++;

                // Contar juzgados
                if (tieneJuzgado == 1) {
                    localidadesConJuzgado++;
                    totalLocalidadesJuzgados++;
                }

                // Comparar localidades con más habitantes
                if (habitantes > getHabitantes(localidadMasHabitantes1)) {
                    localidadMasHabitantes3 = localidadMasHabitantes2;
                    localidadMasHabitantes2 = localidadMasHabitantes1;
                    localidadMasHabitantes1 = nombreLocalidad + "," + habitantes;
                } else if (habitantes > getHabitantes(localidadMasHabitantes2)) {
                    localidadMasHabitantes3 = localidadMasHabitantes2;
                    localidadMasHabitantes2 = nombreLocalidad + "," + habitantes;
                } else if (habitantes > getHabitantes(localidadMasHabitantes3)) {
                    localidadMasHabitantes3 = nombreLocalidad + "," + habitantes;
                }

                // Calcular la densidad de población y buscar la localidad con menor densidad
                double densidad = habitantes / extension;
                if (densidad < menorDensidad) {
                    menorDensidad = densidad;
                    localidadMenorDensidad = nombreLocalidad;
                }
            }

            // Calcular extensión media y compararla
            if (numLocalidades > 0) {
                double extensionMedia = sumaExtensiones / numLocalidades;
                if (extensionMedia > mayorExtensionMedia) {
                    mayorExtensionMedia = extensionMedia;
                    provinciaMayorExtensionMedia = nombreProvincia;
                }

                // Calcular porcentaje de localidades con juzgado
                double porcentajeJuzgado = (double) localidadesConJuzgado / numLocalidades * 100;
                if (porcentajeJuzgado > mayorPorcentajeJuzgado) {
                    mayorPorcentajeJuzgado = porcentajeJuzgado;
                    provinciaMayorPorcentajeJuzgado = nombreProvincia;
                }

                // Contar si hay provincias con menos de 3 localidades
                if (numLocalidades < 3) {
                    provinciasConMenosDe3Localidades++;
                }

                totalLocalidadesProvinciaJuzgados += localidadesConJuzgado;
                totalProvincias++;
            }
        }

        // Mostrar resultados
        System.out.println("Provincia con mayor extensión media: " + provinciaMayorExtensionMedia);
        System.out.println("Localidades con más habitantes: " + getLocalidadNombre(localidadMasHabitantes1) + ", "
                + getLocalidadNombre(localidadMasHabitantes2) + ", " + getLocalidadNombre(localidadMasHabitantes3));
        System.out.println("Número medio de localidades por provincia: " + (double) totalLocalidades / totalProvincias);
        if (provinciasConMenosDe3Localidades > 0) {
            System.out.println("Existen " + provinciasConMenosDe3Localidades + " provincias con menos de 3 localidades.");
        }
        System.out.println("Localidad con menor densidad de población: " + localidadMenorDensidad);
        System.out.println("Provincia con mayor porcentaje de localidades con juzgado: " + provinciaMayorPorcentajeJuzgado);

        scanner.close();
    }

    // Método para obtener el número de habitantes desde la cadena con formato "nombreLocalidad,habitantes"
    private static int getHabitantes(String localidad) {
        if (localidad == null || localidad.isEmpty()) return 0;
        return Integer.parseInt(localidad.split(",")[1]);
    }

    // Método para obtener el nombre de la localidad desde la cadena con formato "nombreLocalidad,habitantes"
    private static String getLocalidadNombre(String localidad) {
        if (localidad == null || localidad.isEmpty()) return "";
        return localidad.split(",")[0];
    }
}

