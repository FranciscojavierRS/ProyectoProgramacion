package B1Funciones;

public class Ej3_AreaVolumenDeUnCilindro {

    // Método que calcula y muestra el área o el volumen de un cilindro
    public static void calcularAreaOVolumen(int opcion, double radio, double altura) {
        // Validamos que el radio y la altura sean positivos
        if (radio <= 0 || altura <= 0) {
            System.out.println("El radio y la altura deben ser mayores que cero.");
            return;
        }
        
        // Calculamos el área o el volumen según la opción indicada
        if (opcion == 1) {
            // Cálculo del área del cilindro
            double area = 2 * Math.PI * radio * (radio + altura);
            System.out.println("El área del cilindro es: " + area);
        } else if (opcion == 2) {
            // Cálculo del volumen del cilindro
            double volumen = Math.PI * Math.pow(radio, 2) * altura;
            System.out.println("El volumen del cilindro es: " + volumen);
        } else {
            // Opción inválida
            System.out.println("Opción inválida. Elige 1 para área o 2 para volumen.");
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la función
        calcularAreaOVolumen(1, 5, 10); // Calcula y muestra el área
        calcularAreaOVolumen(2, 5, 10); // Calcula y muestra el volumen
    }
}



