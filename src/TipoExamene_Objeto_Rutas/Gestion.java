package TipoExamene_Objeto_Rutas;

import java.util.Arrays;

public class Gestion {
	

	public static void main(String[] args) {
		
		
		
		ListaRutas listaRutas= new ListaRutas();
		
		Ciudad huelva = new Ciudad("Huelva", 144258);
		Ciudad sevilla = new Ciudad("Sevilla", 688711);
		Ciudad sevilla2 = new Ciudad("sEvilla", 688788);
		Ciudad pilas = new Ciudad("Pilas", 13949);
		Ciudad camas= new Ciudad("Camas", 27463);
		
		listaRutas.addRuta(new Ruta(huelva, sevilla, 90));
		listaRutas.addRuta(new Ruta(pilas, sevilla, 49));
		listaRutas.addRuta(new Ruta(sevilla, pilas, 41));
		listaRutas.addRuta(new Ruta(huelva, pilas, 49));		
		listaRutas.addRuta(new Ruta(camas, pilas, 30));
		
		System.out.println("Datos: "+ listaRutas);
		System.out.println("\nApartado a)");
		System.out.println("Hay ruta entre sevilla y huelva:"+listaRutas.hayRutaEntre(sevilla, huelva));//false
		System.out.println("Hay ruta entre sevilla y pilas:"+listaRutas.hayRutaEntre(sevilla2, pilas));//true
		
		System.out.println("\nApartado b)");
		System.out.println("Hay ruta de ida y vuelta entre sevilla y huelva:"+listaRutas.hayRutaDeIdaYVueltaEntre(sevilla2, huelva));//false
		System.out.println("Hay ruta de ida y vuelta entre sevilla y pilas:"+listaRutas.hayRutaDeIdaYVueltaEntre(sevilla2, pilas));//true
		
		System.out.println("\nApartado c)");
		System.out.println("Rutas desde sevilla:"+listaRutas.getRutasDesde(sevilla2)); //sevilla-pilas
		System.out.println("Rutas desde huelva:"+listaRutas.getRutasDesde(huelva)); //huelva - sevilla, huelva-pilas
		
		System.out.println("\nApartado d)");
		System.out.println("Ciudades importantes:"+Arrays.toString(listaRutas.getCiudadesImportantes(100000))); //huelva, sevilla
		
		System.out.println("\nApartado e)");
		System.out.println("Rutas ordenadas por kil�metros:"+listaRutas.getListaOrdenada()); 
		
		//Prueba Ciudad Gastronomica
		System.out.println("\nApartado f)");
	}
}
