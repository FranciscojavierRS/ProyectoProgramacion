package Examenes_Tipo_Control;

import java.util.Scanner;

public class EstacionMeteorologica {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String nombreMes = ""; //A
        String mesMenosDiasNublados =""; // B
        float menorProporcionNublado = 9;
        int contadorDiasCiclogenesis = 0;
        int diaMasCaluroso=0;
        String mesMasCaluroso= "";
        
        int diaMasCaluroso2=0;
        String mesMasCaluroso2= "";
        float temperaturaMasAlta= Integer.MIN_VALUE;
        int humedadMaxima =Integer.MIN_VALUE;
        String estadoHumedadMaxima = "";
        boolean menosDeTresDiasLluviosos= false;
        
        
        
        while (!nombreMes.equalsIgnoreCase("ya")) {
		System.out.println("¿nombre del mes?");
		nombreMes = sc.next();
		if(!nombreMes.equalsIgnoreCase("ya")) {
			
			int contadorDiasLluviosos= 0;
			
		int numDiasNublados =0;
		System.out.println("¿De cuántos días van a introducirse datos?");
		int numDias = sc.nextInt();
		
		boolean mesConCiclogenesis= false;
		
		
		for (int i=1; i<=numDias; i++) {
			System.out.println("Dia: ");
			int dia=sc.nextInt();
			System.out.println("Temperatura");
			float temperatura =sc.nextFloat();
			
			System.out.println("Humedad");
			int humedad = sc.nextInt();
			
			System.out.println("Velocidad del Viento");
			int viento = sc.nextInt();
			
			System.out.println("Estado del cielo");
			String estadoCielo = sc.next();
			
			if(estadoCielo.equals("nublado")) {
				numDiasNublados++;
			}else if(estadoCielo.equals("lluvioso")){
				contadorDiasLluviosos++;
			}
			
			if (humedad>humedadMaxima) {
				humedadMaxima=humedad;
				estadoHumedadMaxima=estadoCielo;
			}
			
			if (viento>40 || temperatura<0) {
				mesConCiclogenesis=true;
				
			}
			
			if (temperatura>temperaturaMasAlta) {
				diaMasCaluroso2=diaMasCaluroso;
				mesMasCaluroso2=mesMasCaluroso;
				diaMasCaluroso=dia;
				mesMasCaluroso=nombreMes;
				temperaturaMasAlta=temperatura;
			}
			
			}
				float proporcionNublado = (float)numDiasNublados/numDias;
				if (proporcionNublado<menorProporcionNublado) {
					mesMenosDiasNublados=nombreMes;
					menorProporcionNublado = proporcionNublado;
					
				}
				if (mesConCiclogenesis) {
					contadorDiasCiclogenesis++;
				}
				
				if (numDias>10 && contadorDiasLluviosos<3) {
					menosDeTresDiasLluviosos=true;
				}
				
		}
		
		
		
		
		}
			
		System.out.println("(A) Estado del cielo del día en el que hubo más humedad: "+estadoHumedadMaxima+" con humedad "+humedadMaxima);
		System.out.println("(B) Mes con menor proporción de días nublados: "+mesMenosDiasNublados);
		System.out.println("(C) Número de meses con algún día de ciclogénesis: "+contadorDiasCiclogenesis);
		System.out.println("(D)Los dos días más calurosos del año son: "+diaMasCaluroso+"/"+mesMasCaluroso+ " y "+ diaMasCaluroso2+"/"+mesMasCaluroso2);
		if (menosDeTresDiasLluviosos) {
			System.out.println(" Ha habido algún mes con menos de tres días lluviosos");
		}else {
			System.out.println("No ha habido algún mes con menos de tres días lluviosos");
		}
		

	    sc.close();
}

}
