package Examenes_Tipo_Control;

import java.util.Scanner;

public class Chatgpt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int contM = 0, contC = 0, contE = 0;
        int totalNoches = 0;
        int totalExpediciones = 0;
        int expedicionesMas3Noches = 0;
        int maxEnergia = -1;
        String nombreMaxEnergia = "";
        int codigoMaxEnergia = 0;

        int minActividad1 = 11; // primer valor más bajo
        int minActividad2 = 11; // segundo valor más bajo

        System.out.println("Cantidad total de investigadores que han enviado informes:");
        int cantidadInvestigadores = sc.nextInt();

        for (int i = 1; i <= cantidadInvestigadores; i++) {

            System.out.println("Nombre:");
            String nombre = sc.next();

            System.out.println("Lugar que ha explorado:");
            String lugar = sc.next();

            char inicial = Character.toUpperCase(nombre.charAt(0));
            if (inicial == 'M') contM++;
            else if (inicial == 'C') contC++;
            else if (inicial == 'E') contE++;

            System.out.println("Código de expedición:");
            int codigoExpedicion = sc.nextInt();

            while (codigoExpedicion != -1) {

                System.out.println("Número de noches de registro:");
                int numNoches = sc.nextInt();

                totalExpediciones++;
                totalNoches += numNoches;
                if (numNoches > 3) expedicionesMas3Noches++;

                for (int j = 1; j <= numNoches; j++) {
                    System.out.println("Nivel de cordura restante del investigador (0–100):");
                    int cordura = sc.nextInt();

                    System.out.println("Índice de actividad cultista (en una escala de 0 a 10):");
                    int actividad = sc.nextInt();

                    System.out.println("Nivel de energía cósmica percibida (en unidades Lovecraft)");
                    int energia = sc.nextInt();

                    // Actualizar máximos de energía cósmica
                    if (energia > maxEnergia) {
                        maxEnergia = energia;
                        nombreMaxEnergia = nombre;
                        codigoMaxEnergia = codigoExpedicion;
                    }

                    // Actualizar los dos mínimos de actividad cultista
                    if (actividad < minActividad1) {
                        minActividad2 = minActividad1;
                        minActividad1 = actividad;
                    } else if (actividad < minActividad2) {
                        minActividad2 = actividad;
                    }
                }

                System.out.println("Código de expedición:");
                codigoExpedicion = sc.nextInt();
            }
        }

        // Cálculos finales
        double promedioNoches = (totalExpediciones > 0) ? (double) totalNoches / totalExpediciones : 0;
        boolean tresProcedencias = (contM > 0 && contC > 0 && contE > 0);
        double porcentajeMas3 = (totalExpediciones > 0) ? (expedicionesMas3Noches * 100.0 / totalExpediciones) : 0;

        // Resultados
        System.out.println("A. El número promedio de noches que dura una expedición es " + promedioNoches);
        System.out.println("B. Han participado investigadores de las tres procedencias (Miskatonic, Culto, E.Independiente): " + tresProcedencias);
        System.out.println("C. El nivel máximo de energía cósmica registrado, junto con el identificador de expedición y el nombre del investigador que la registró son: " +
                maxEnergia + ", " + codigoMaxEnergia + ", " + nombreMaxEnergia);
        System.out.println("D. Los dos valores más bajos de actividad cultista registrados en cualquier noche son: " + minActividad1 + " y " + minActividad2);
        System.out.println("E. Porcentaje de expediciones que duraron más de 3 noches: " + porcentajeMas3);

        sc.close();
    }
}
