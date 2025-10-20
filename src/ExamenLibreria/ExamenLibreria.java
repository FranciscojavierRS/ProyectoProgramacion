package ExamenLibreria;

import java.util.Scanner;

public class ExamenLibreria {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Número de autores:");
		int numeroAutores =sc.nextInt();
		int contadorAutoresMujeres = 0;
		boolean masdinerohombres= true;
		float sumaPrecioHombre = 0;
		float sumaPrecioMujer = 0;
		int autorasTresLibrosOMas = 0;
		String titulobarato = "";
		String titulobarato2 = "";
		float precioMasBarato = Integer.MAX_VALUE;
		float precioMasBarato2 = Integer.MAX_VALUE;
		String tituloLibroMasCaro = "";
		float precioMasAlto = 0;
		
		for (int i = 0; i<numeroAutores; i++) {
			String tituloLibroMasCaroAutor = "";
			float precioMasAltoAutor = 0;
			int contadorLibroAutor = 0;
			
			System.out.println("Nombre:");
			String nombreAutor = sc.next();
			
			System.out.println("Sexo (M/H):");
			char sexo = sc.next().charAt(0);
			
			if(sexo=='M') {
				contadorAutoresMujeres++;
			}
			
			int librosEscritosMujer =0;
			System.out.println("Titulo del libro:");
			String tituloLibro =sc.next();
			
			while(!tituloLibro.equals("fin")) {
				contadorLibroAutor++;
				
				if (sexo=='M') {
					librosEscritosMujer++;
					
				}
				System.out.println("Precio: ");
				float precio =sc.nextFloat();
				
				if (precio>precioMasAltoAutor) {
					precioMasAltoAutor=precio;
					tituloLibroMasCaroAutor=tituloLibro;
				}
				
				if (precio<precioMasBarato) {
					precioMasBarato2=precioMasBarato;
					titulobarato2=titulobarato;
					titulobarato=tituloLibro;
					precioMasBarato=precio;
				}else if(precio<precioMasBarato2) {
					precioMasBarato2=precio;
					titulobarato2=tituloLibro;
				}
				
				
				System.out.println("Unidades vendidas:");
				int unidadesVendidas = sc.nextInt();
				
				if (sexo=='H') {
					sumaPrecioHombre+=precio*unidadesVendidas;
					
					
				}else {
					sumaPrecioMujer+=precio*unidadesVendidas;
				}
				
				System.out.println("Titulo del libro:");
				 tituloLibro =sc.next();	
			}
			
			if(contadorLibroAutor>2 && precioMasAltoAutor>precioMasAlto) {
				precioMasAlto=precioMasAltoAutor;
				tituloLibroMasCaro=tituloLibroMasCaroAutor;
			}
			
			if (sexo=='M' && librosEscritosMujer>=3) {
				autorasTresLibrosOMas++;
				
			}
			
			
		}
		
		
		
		System.out.println("a) Porcentaje de autores que son mujer: "+(float)contadorAutoresMujeres*100/numeroAutores);
		masdinerohombres=sumaPrecioHombre>sumaPrecioMujer;
		
		char sexoMasVendido = 'M';
		
		if (masdinerohombres) {
			sexoMasVendido='H';
		}
		
		
		
		
		System.out.println("b) Sexo del autor en el que más se han gastado los clientes: "+sexoMasVendido);
		System.out.println("c) Número de autoras que han escrito 3 libros o más: "+autorasTresLibrosOMas);
		System.out.println("d) Los dos libros más baratos son: "+titulobarato+" y "+titulobarato2);
		
		if (tituloLibroMasCaro.equals("")) {
			System.out.println("“ningún autor ha escrito más de dos libros");
		}else {
			System.out.println("e) Título del libro más caro de autores de más de 2 libros: "+tituloLibroMasCaro);
		}
		
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
