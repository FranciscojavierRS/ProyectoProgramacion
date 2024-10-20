package EjerciciosCortosExamen;

import java.util.Scanner;

/**
 * 2.- Un grupo de biólogos está realizando un trabajo de campo, tomando medidas de árboles
de un bosque. Una vez tomados los datos, deben introducirlos en un ordenador. Los datos
que han tomado de los árboles son: Tipo del árbol (A o B), diámetro del tronco y altura en
metros. Además, si el árbol es de tipo B, se dispone de la edad del mismo en años. Realizar
un programa en Java que:
- Pida el número de árboles de los que se van a introducir datos.
- Para cada árbol, debe pedir el tipo, diámetro y altura; si es tipo B además, la edad.
- Debe mostrarse al final: Media de las alturas de los árboles. Altura máxima,
mínima, diámetro máximo y mínimo. Media de las edades de árboles del tipo B. Si
existe algún árbol de más de 30 m., debe indicarse al final con el mensaje: “Existen
árboles de más de 30 m.”
 */

public class Ej2_Arboles {

	public static void main(String[] args) {
	    // Creación del objeto Scanner para leer datos de entrada
	    Scanner sc = new Scanner(System.in);
	    
	    // Solicita la cantidad de árboles a insertar
	    System.out.println("¿Cuantos arboles vas a insertar?");
	    int numArboles = sc.nextInt();  // Almacena el número de árboles

	    // Declaración de variables
	    String tipoArbol;  // Almacena el tipo de árbol (A o B)
	    double diametro;  // Almacena el diámetro del árbol
	    double alturArbol;  // Almacena la altura del árbol
	    int edadArbol;  // Almacena la edad del árbol (para árboles tipo B)
	    double mediaArbol;  // Almacena la altura media de los árboles
	    double alturaMaximaArbol = 0.0;  // Almacena la mayor altura registrada
	    double alturaMinimaArbol = 0.0;  // Almacena la menor altura registrada
	    double diametroMaximo = 0.0;  // Almacena el mayor diámetro registrado
	    double diametroMinimo = 0.0;  // Almacena el menor diámetro registrado
	    double edadMediaArbol = 0.0;  // Acumulador para calcular la media de edad de árboles tipo B
	    int numArbolesB = 0;  // Contador para los árboles de tipo B
	    boolean arbol30M = false;  // Bandera para verificar si existe un árbol de más de 30 metros
	    double sumarAlturaArbol = 0.0;  // Acumulador para sumar la altura de todos los árboles

	    boolean primero = true;  // Bandera para determinar si es el primer árbol (para alturas y diámetros mínimos)

	    // Ciclo que se ejecuta para cada árbol a insertar
	    for (int i = 0; i < numArboles; i++) {
	        System.out.println("Insertando nuevo Arbol");
	        
	        // Solicita el tipo de árbol
	        System.out.println("Inserta el tipo de Arbol");
	        tipoArbol = "";
	        
	        // Bucle para asegurar que el tipo de árbol sea A o B
	        while (!tipoArbol.equals("A") && !tipoArbol.equals("B")) {
	            tipoArbol = sc.next();
	        }

	        // Si el árbol es de tipo B, solicita la edad
	        if (tipoArbol.equals("B")) {
	            System.out.println("inserta edad Arbol");
	            edadArbol = sc.nextInt();
	            edadMediaArbol += edadArbol;  // Acumula la edad para calcular la media
	            numArbolesB++;  // Incrementa el contador de árboles tipo B
	        }

	        // Solicita el diámetro del árbol
	        System.out.println("inserta diametro del Arbol");
	        diametro = 0.0;
	        // Bucle para asegurar que el diámetro sea mayor a 0
	        while (diametro <= 0.0) {
	            diametro = sc.nextDouble();
	        }

	        // Actualiza el diámetro máximo si es necesario
	        if (diametro > diametroMaximo) {
	            diametroMaximo = diametro;
	        }

	        // Actualiza el diámetro mínimo si es el primero o si es menor que el actual mínimo
	        if (diametro < diametroMinimo || primero) {
	            diametroMinimo = diametro;
	        }

	        // Solicita la altura del árbol
	        System.out.println("inserta Altura del Arbol");
	        alturArbol = 0.0;
	        // Bucle para asegurar que la altura sea mayor a 0
	        while (alturArbol <= 0.0) {
	            alturArbol = sc.nextDouble();
	        }

	        // Actualiza la altura máxima si es necesario
	        if (alturArbol > alturaMaximaArbol) {
	            alturaMaximaArbol = alturArbol;
	        }

	        // Actualiza la altura mínima si es el primero o si es menor que la actual mínima
	        if (alturArbol < alturaMinimaArbol || primero) {
	            alturaMinimaArbol = alturArbol;
	        }

	        // Suma la altura del árbol al acumulador
	        sumarAlturaArbol += alturArbol;

	        // Verifica si hay algún árbol con más de 30 metros de altura
	        if (alturArbol >= 30) {
	            arbol30M = true;
	        }

	        // Después de procesar el primer árbol, desactiva la bandera "primero"
	        primero = false;
	    }

	    // Calcula la altura media de los árboles
	    mediaArbol = sumarAlturaArbol / numArboles;
	    // Imprime los resultados
	    System.out.println("La altura media de los Arboles es " + mediaArbol);
	    System.out.println("La altura maxima es " + alturaMaximaArbol);
	    System.out.println("La altura minima es " + alturaMinimaArbol);
	    System.out.println("El diametro maximo es " + diametroMaximo);
	    System.out.println("El diametro minimo es " + diametroMinimo);

	    // Calcula la media de edad para los árboles tipo B si hay al menos uno
	    if (numArbolesB > 0) {
	        System.out.println("La media de los Arboles tipo B es " + (edadMediaArbol / numArbolesB));
	    }

	    // Verifica si existe algún árbol con más de 30 metros de altura
	    if (arbol30M) {
	        System.out.println("Existen Arboles de mas de 30 metros");
	    }

	    // Cierra el objeto Scanner
	    sc.close();
	}


}
