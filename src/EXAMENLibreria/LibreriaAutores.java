package EXAMENLibreria;

import java.util.Scanner;

/**  Tras la polémica del caso “Carmen Mola”, en una librería se desea
hacer una estudio sobre autores y sus libros. Realiza un programa en Java que permita introducir los
datos de los autores y sus libros, y posteriormente muestre unos resultados.
Los datos se pedirán de la siguiente forma:
En primer lugar, se pedirá el número de autores de los que van a introducirse datos. Para cada
autor, se pedirá su nombre y su sexo, cosa que indicará mediante “M” o “H”. A continuación, se
introducirán los datos de sus libros, de la forma: título del libro (tipo String), precio unitario (float) y
unidades vendidas. La serie de libros escritos por cada autor terminará cuando su título sea “fin”. (1
punto la petición correcta de datos).
Los resultados que se deben mostrar al finalizar la introducción de datos son:
a) (1,75 puntos) Porcentaje de autores que son mujer. Suponemos que al menos se va a
introducir un autor de cada sexo.
b) (1,75 puntos) Sexo del autor en el que más dinero se han gastado los clientes en total.
c) (1,75 puntos) Cuántas autoras (mujer) han escrito 3 libros o más.
d) (1,75 puntos) Título de los dos libros más baratos.
e) (2 puntos) Cuál ha sido el título del libro más caro de entre los escritos por los autores que
han escrito más de 2 libros. Si no hay ninguno, en su lugar se mostrará “ningún autor ha
escrito más de dos libros” */

public class LibreriaAutores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalAutores = 0;
        int totalAutoresMujer = 0;
        double totalGastoAutoresMujer = 0.0;
        double totalGastoAutoresHombre = 0.0;
        int autorasConTresLibros = 0;
        String libroMasBarato1 = "";
        String libroMasBarato2 = "";
        float precioLibroMasBarato1 = Float.MAX_VALUE;
        float precioLibroMasBarato2 = Float.MAX_VALUE;
        String libroMasCaroMasDeDos = "";
        float precioLibroMasCaroMasDeDos = 0.0f;

        System.out.println("Introduce el número de autores:");
        int numeroAutores = scanner.nextInt();

        for (int i = 0; i < numeroAutores; i++) {
            System.out.println("Introduce el nombre del autor:");
            String nombreAutor = scanner.next();

            System.out.println("Introduce el sexo del autor (M/H):");
            String sexoAutor = scanner.next();
            boolean esMujer = sexoAutor.equalsIgnoreCase("M");

            if (esMujer) totalAutoresMujer++;
            totalAutores++;

            int librosAutor = 0;
            double gastoTotalAutor = 0.0;
            float precioLibroMasCaroActual = 0.0f;

            while (true) {
                System.out.println("Introduce el título del libro (o 'fin' para terminar):");
                String tituloLibro = scanner.next();

                if (tituloLibro.equalsIgnoreCase("fin")) break;

                System.out.println("Introduce el precio unitario del libro:");
                float precioLibro = scanner.nextFloat();

                System.out.println("Introduce las unidades vendidas:");
                int unidadesVendidas = scanner.nextInt();

                double ingresoLibro = precioLibro * unidadesVendidas;
                gastoTotalAutor += ingresoLibro;
                librosAutor++;

                // Actualizar libros más baratos
                if (precioLibro < precioLibroMasBarato1) {
                    precioLibroMasBarato2 = precioLibroMasBarato1;
                    libroMasBarato2 = libroMasBarato1;
                    precioLibroMasBarato1 = precioLibro;
                    libroMasBarato1 = tituloLibro;
                } else if (precioLibro < precioLibroMasBarato2) {
                    precioLibroMasBarato2 = precioLibro;
                    libroMasBarato2 = tituloLibro;
                }

                // Actualizar el libro más caro para autores con más de 2 libros
                if (librosAutor > 2 && precioLibro > precioLibroMasCaroActual) {
                    precioLibroMasCaroActual = precioLibro;
                    libroMasCaroMasDeDos = tituloLibro;
                }
            }

            // Acumular gasto según el sexo del autor
            if (esMujer) {
                totalGastoAutoresMujer += gastoTotalAutor;
                if (librosAutor >= 3) autorasConTresLibros++;
            } else {
                totalGastoAutoresHombre += gastoTotalAutor;
            }

            // Verificar el libro más caro de autores con más de 2 libros
            if (librosAutor > 2 && precioLibroMasCaroActual > precioLibroMasCaroMasDeDos) {
                precioLibroMasCaroMasDeDos = precioLibroMasCaroActual;
                libroMasCaroMasDeDos = libroMasCaroMasDeDos;
            }
        }

        // Calcular el porcentaje de autoras mujeres
        double porcentajeAutoresMujer = (totalAutoresMujer * 100.0) / totalAutores;
        String sexoMayorGasto = totalGastoAutoresMujer > totalGastoAutoresHombre ? "Mujer" : "Hombre";
        String mensajeLibroMasCaroMasDeDos = libroMasCaroMasDeDos.isEmpty() ? "ningún autor ha escrito más de dos libros" : libroMasCaroMasDeDos;

        // Mostrar los resultados
        System.out.println("a) Porcentaje de autores que son mujer: " + porcentajeAutoresMujer + "%");
        System.out.println("b) Sexo del autor con más gasto total en sus libros: " + sexoMayorGasto);
        System.out.println("c) Número de autoras que han escrito 3 libros o más: " + autorasConTresLibros);
        System.out.println("d) Títulos de los dos libros más baratos: " + libroMasBarato1 + ", " + libroMasBarato2);
        System.out.println("e) Título del libro más caro de autores que han escrito más de 2 libros: " + mensajeLibroMasCaroMasDeDos);

        scanner.close();
    }
}

