package b3;

import java.util.Scanner;

public class Ej6_SalarioMensual {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce las horas semanales trabajadas");
        float horas = scanner.nextFloat();
        float extra;
        float salario;
        
        if (horas > 40 ) {
        	extra = horas-40;
        	horas = horas-extra;
        	
        } else {
        	extra = 0; }
        
        	salario = (horas*12) + (extra*16);
        	
        	System.out.println("El salario semanal es "+salario+"€");
        	scanner.close();
        }
        	
        
        
        
        
        
        
        }


