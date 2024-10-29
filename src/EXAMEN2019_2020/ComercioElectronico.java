package EXAMEN2019_2020;

import java.util.Scanner;


/** En el portal de comercio electrónico “Amazonlike Comercial
Hermanos Machado” (ACHM), so pretende contabilizar una serie de datos sobre las compras online
realizadas por distintos clientes. Para ello se debe realizar un programa en Java que permita la

introducción de datos, y posteriormente muestre unos resultados

El programa debe permitir al usuario la introducción de una serie de identificadores de clientes, y
de los artículos y cantidades compradas, de la siguiente forma

Para cada cliente, se introducirá en primer lugar su cuenta de e-mail, que lo identifica (se sabrá
in”) y a continuación se preguntará al
usuario si el cliente es Premium o no, cosa que indicará mediante “S” o “N”. Después se introducirán
los datos de las compras realizadas por eso cliente, de la forma: código del artículo (tipo String),
cantidad de unidades compradas (entero), y precio unitario (font). La serie de artículos comprados por
cada cliente terminará cuando el código sea “fin”. (1 punto la petición correcta de datos).

que se desea terminar de introducir datos cuando la misma sea *

Los resultados que se deben mostrar al finalizar la introducción de datos so

a) (1 puntos) Porcentajo de clientes Premium. Suponemos que al menos se va a introducir un
cliente de cada tipo (Premium o normal).

b) (1 puntos) Un mensaje indicando si han sido los clientes Premium o los normales los que han
gastado más dinero en total haciendo compras en el portal

€) (1 puntos) Cuál ha sido el código del artículo más caro comprado por los clientes que sólo

compraron un tipo de artículo (aunque fuesen varias unidades del mismo). Si no hay ninguno,
en su lugar se mostrará “ningún cliente compró solo un tipo de artículo”.

d) (1 puntos) Identificador (correo) dol cliente que ha gastado más dinero en total
e) (1 puntos) Cuántos clientes Premium compraron al monos 5 artículos distintos

1) (1 puntos) Un mensaje indicando si el cliente que compró más unidades de artículos en total
(distintos o no) era Premium o no. */

public class ComercioElectronico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalClientes = 0;
        int totalClientesPremium = 0;
        double totalGastoPremium = 0.0;
        double totalGastoNormales = 0.0;
        double mayorGastoCliente = 0.0;
        String clienteMayorGasto = "";
        int clientesPremiumCincoArticulos = 0;
        boolean clienteMasUnidadesEsPremium = false;
        String articuloMasCaroCodigo = "";
        double articuloMasCaroPrecio = 0.0;
        
        while (true) {
            System.out.println("Introduce el correo del cliente (o 'fin' para terminar): ");
            String correoCliente = scanner.next();

            if (correoCliente.equalsIgnoreCase("fin")) break;

            System.out.println("¿El cliente es Premium? (S/N): ");
            boolean esPremium = scanner.next().equalsIgnoreCase("S");

            double gastoCliente = 0.0;
            int totalArticulosComprados = 0;
            int distintosArticulosComprados = 0;
            double precioArticuloClienteUnico = 0.0;
            boolean clienteUnicoArticulo = true;

            while (true) {
                System.out.println("Introduce el código del artículo (o 'fin' para terminar las compras del cliente): ");
                String codigoArticulo = scanner.next();

                if (codigoArticulo.equalsIgnoreCase("fin")) break;

                System.out.println("Introduce la cantidad de unidades compradas: ");
                int cantidadUnidades = scanner.nextInt();
                
                System.out.println("Introduce el precio unitario: ");
                double precioUnitario = scanner.nextDouble();

                double costoArticulo = cantidadUnidades * precioUnitario;
                gastoCliente += costoArticulo;
                totalArticulosComprados += cantidadUnidades;

                // Verificar si el artículo es el más caro para clientes con un solo tipo de artículo
                if (distintosArticulosComprados == 0) {
                    precioArticuloClienteUnico = precioUnitario;
                    articuloMasCaroCodigo = codigoArticulo;
                } else if (precioUnitario > precioArticuloClienteUnico) {
                    clienteUnicoArticulo = false; // Cliente compró más de un tipo de artículo
                }

                distintosArticulosComprados++;
            }

            // Procesar datos del cliente actual
            totalClientes++;
            if (esPremium) {
                totalClientesPremium++;
                totalGastoPremium += gastoCliente;
                if (distintosArticulosComprados >= 5) clientesPremiumCincoArticulos++;
            } else {
                totalGastoNormales += gastoCliente;
            }

            if (gastoCliente > mayorGastoCliente) {
                mayorGastoCliente = gastoCliente;
                clienteMayorGasto = correoCliente;
            }

            if (totalArticulosComprados > (clienteMasUnidadesEsPremium ? totalClientesPremium : totalClientes - totalClientesPremium)) {
                clienteMasUnidadesEsPremium = esPremium;
            }

            if (clienteUnicoArticulo && precioArticuloClienteUnico > articuloMasCaroPrecio) {
                articuloMasCaroPrecio = precioArticuloClienteUnico;
                articuloMasCaroCodigo = articuloMasCaroCodigo;
            }
        }

        // Resultados
        double porcentajeClientesPremium = (totalClientesPremium * 100.0) / totalClientes;
        String tipoClienteMayorGasto = totalGastoPremium > totalGastoNormales ? "Premium" : "Normales";
        String mensajeArticuloUnico = articuloMasCaroCodigo.isEmpty() ? "ningún cliente compró solo un tipo de artículo" : articuloMasCaroCodigo;
        
        System.out.println("a) Porcentaje de clientes Premium: " + porcentajeClientesPremium + "%");
        System.out.println("b) Tipo de cliente con mayor gasto total: " + tipoClienteMayorGasto);
        System.out.println("c) Código del artículo más caro comprado por clientes que compraron un solo tipo de artículo: " + mensajeArticuloUnico);
        System.out.println("d) Identificador (correo) del cliente que ha gastado más dinero en total: " + clienteMayorGasto);
        System.out.println("e) Número de clientes Premium que compraron al menos 5 artículos distintos: " + clientesPremiumCincoArticulos);
        System.out.println("f) El cliente que compró más unidades en total era " + (clienteMasUnidadesEsPremium ? "Premium" : "No Premium"));

        scanner.close();
    }
}

