package Examen29102024;

import java.util.Scanner;

public class Nasa {
/** La Agencia de Exploración Espacial "Hermanos Machado"
(AEEHM) ha encargado la creación de un programa en Java que permita gestionar y
analizar los datos obtenidos por diferentes robots de exploración en diversas misiones
espaciales. El objetivo del programa es permitir la introducción de los datos obtenidos por
los robots y generar diversas estadísticas sobre las misiones.
El programa deberá solicitar la cantidad total de robots que han enviado datos. Para cada
robot, se debe solicitar su nombre y el nombre del planeta que visita. Se sabe que si el
nombre del robot empieza por la letra N es de la marca NASA, si empieza por E es de la
ESA (Agencia Espacial Europea), y si empieza por J es de la marca JAXA (Agencia
Japonesa de Exploración Aeroespacial).
A continuación, el usuario deberá ingresar los datos de distintas misiones realizadas en el
planeta asignado al robot. Las misiones se identificarán por números consecutivos
(empezando por el 1). Para cada misión, pide al usuario el número de días de registro de
datos de esa misión. Cuando ya no quiera insertar datos de más misiones, ese valor será
-1. Para cada día de registro en la misión, el usuario debe introducir la temperatura (en
grados Celsius), la presión atmosférica (en atmósferas) y el nivel de radiación (en sieverts).
(1,5 puntos la petición correcta de datos)
*/

	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int DiaMision = 0;
    System.out.print("Numero total de Robots): ");
    String TotalRobots = scanner.next().toLowerCase();
    
    System.out.print("¿De que empresa es (N) NASA   (E) ESA? (J) JAXA): ");
    String PrimeraLetra = scanner.next().toLowerCase();
    
    System.out.print("Nombre Robot): ");
    String NombreRobot = scanner.next().toLowerCase();
    
    /** Aqui hago el if para saber que en el caso de que se pongan los 3 tipos de letras posible suelte el mensaje Existen de los 
     * 3 tipos (Pero como no me funciona el bucle no se hace)
     * 
     */
    while (true) {
        System.out.println("Introduce la letra del grupo (N, E, J):");
        TotalRobots = scanner.next().toUpperCase();

        switch (TotalRobots) {
            case "N":
                NombreRobot = "N-Curiosity";
                break;
            case "E":
                NombreRobot = "E-Rosetta";
                break;
            case "J":
                NombreRobot = "J-Hayabusa";
                break;
            
            default:
                System.out.println("Grupo inválido. Inténtalo de nuevo.");
                continue;
        }
    
    if (PrimeraLetra=="N"+"E"+"J") 
		System.out.println("Existen de los 3 Tipos");
    
    
    /** La parte de sacar el promedio de dias si sale, pero no se como introducirla bien dentro del for*/
    
    
    System.out.println("Introduce un Dia");
	int Dia1= scanner.nextInt();
	
	System.out.println("Introduce otro Dia");

	int Dia2= scanner.nextInt();
	double media= (Dia1+Dia2)/2;
	System.out.println("La media es "+media);
    
    
    
    
    
    
    
    
    System.out.print("Nombre Planeta que visita): ");
    String NombrePlaneta = scanner.next().toLowerCase();
    
    
    
    for (int j = 0; j < DiaMision; j++) {
    	System.out.println("Dia 1");
    	
    }
        System.out.println("Introduce la temperatura de Dia 1: ");
        String Temperatura = scanner.next();

        System.out.println("Presion para el Dia 1: ");
        double Presion = scanner.nextDouble();
        
        System.out.println("Nivel de Radiacion de Dia 1: ");
        String Radiacion = scanner.next();
        
        {
        	System.out.println("Dia 2");
        	
        }
            System.out.println("Introduce la temperatura de Dia 2: ");
            String Temperatura2 = scanner.next();

            System.out.println("Presion para el Dia 2: ");
            double Presion2 = scanner.nextDouble();
            
            System.out.println("Nivel de Radiacion de Dia 2: ");
            String Radiacion2 = scanner.next();
            
            {
            	System.out.println("Dia 3");
            	
            }
                System.out.println("Introduce la temperatura de Dia 3: ");
                String Temperatura3 = scanner.next();

                System.out.println("Presion para el Dia 3: ");
                double Presion3 = scanner.nextDouble();
                
                System.out.println("Nivel de Radiacion de Dia 3: ");
                String Radiacion3 = scanner.next();
        
                {
                	System.out.println("Dia 4");
                	
                }
                    System.out.println("Introduce la temperatura de Dia 4: ");
                    String Temperatura4 = scanner.next();

                    System.out.println("Presion para el Dia 4: ");
                    double Presion4 = scanner.nextDouble();
                    
                    System.out.println("Nivel de Radiacion de Dia 4: ");
                    String Radiacion4 = scanner.next();
                    
                    
                    
        							
        if (DiaMision==1) {
          
        }
        DiaMision++;

    scanner.close();
}
}
}

/** A ve si con lo poco que hice puedo rascar algo de nota y ya cuando sea el examen del dia 29 lo hago mejor */