package Examen_Guerras;

import java.util.Arrays;

public class Gestion {
	private static Guerra tablaGuerras[];
	private static int nGuerras;

	public static void main(String args[]) {

		// Datos de ejemplo para poder hacer pruebas
		// Creación de varios países.

		Pais francia = new Pais("Francia");
		Pais reinoUnido = new Pais("Reino Unido");
		Pais rusia = new Pais("Rusia");
		Pais usa = new Pais("Estados Unidos");
		Pais austria = new Pais("Austria");
		Pais hungría = new Pais("Hungría");
		Pais turquía = new Pais("Turquía");
		Pais alemania = new Pais("Alemania");
		Pais japón = new Pais("Japón");
		Pais italia = new Pais("Italia");
		Pais polonia = new Pais("Polonia");

		// Creación de Bandos para las distintas guerras

		Bando aliados1 = new Bando("Aliados I");
		Bando centroeuropeo = new Bando("Centro Europeo");
		Bando aliados2 = new Bando("Aliados II");
		Bando eje = new Bando("Eje Berlín-Roma-Tokio");

		// Añadimos a cada bando de las guerras los países que lo componían.

		aliados1.anyadePais(francia);
		aliados1.anyadePais(reinoUnido);
		aliados1.anyadePais(usa);
		aliados1.anyadePais(rusia);

		centroeuropeo.anyadePais(austria);
		centroeuropeo.anyadePais(hungría);
		centroeuropeo.anyadePais(turquía);
		centroeuropeo.anyadePais(alemania);

		aliados2.anyadePais(francia);
		aliados2.anyadePais(polonia);
		aliados2.anyadePais(reinoUnido);
		aliados2.anyadePais(usa);
		aliados2.anyadePais(rusia);

		eje.anyadePais(alemania);
		eje.anyadePais(italia);
		eje.anyadePais(japón);

		// creamos varias batallas

		Batalla tannenberg = new Batalla("Tannenberg", rusia, alemania);
		Batalla verdún = new Batalla("Verdún", francia, alemania);
		Batalla gallipoli = new Batalla("Gallipoli", francia, turquía);
		Batalla elAlamein = new Batalla("El Alamein", reinoUnido, alemania);
		Batalla midway = new Batalla("Midway", usa, japón);
		Batalla stalingrado = new Batalla("Stalingrado", alemania, rusia);
		Batalla normandía = new Batalla("Normandía", usa, alemania);

		// creamos dos guerras, con sus respectivos bandos

		Guerra mundialI = new Guerra("Primera guerra mundial", aliados1, centroeuropeo);
		Guerra mundialII = new Guerra("Segunda guerra mundial", eje, aliados2);

		// colocamos las batallas en las guerras correspondientes

		mundialI.anyadeBatalla(tannenberg);
		mundialI.anyadeBatalla(verdún);
		mundialI.anyadeBatalla(gallipoli);

		mundialII.anyadeBatalla(elAlamein);
		mundialII.anyadeBatalla(midway);
		mundialII.anyadeBatalla(stalingrado);
		mundialII.anyadeBatalla(normandía);

		// hacemos que cada país sepa en qué guerras ha participado

		francia.participoEn(mundialI);
		reinoUnido.participoEn(mundialI);
		rusia.participoEn(mundialI);
		usa.participoEn(mundialI);
		austria.participoEn(mundialI);
		hungría.participoEn(mundialI);
		turquía.participoEn(mundialI);
		alemania.participoEn(mundialI);

		japón.participoEn(mundialII);
		italia.participoEn(mundialII);
		alemania.participoEn(mundialII);
		polonia.participoEn(mundialII);
		francia.participoEn(mundialII);
		reinoUnido.participoEn(mundialII);
		rusia.participoEn(mundialII);
		usa.participoEn(mundialII);

		// por último colocamos las guerras en la tabla de Guerras de la gestión

		tablaGuerras = new Guerra[10];
		nGuerras = 0;

		tablaGuerras[nGuerras++] = mundialI;
		tablaGuerras[nGuerras++] = mundialII;

		// mostramos los datos almacenados

		mostrarTablaGuerras();

		System.out.println("El más beligerante: " + masBeligerante());

		if (mundialI.compareTo(mundialII) < 0) {
			System.out.println("La guerra muldial 1 es menor que la 2");
		} else if (mundialI.compareTo(mundialII) == 0) {
			System.out.println("Son iguales");
		} else {
			System.out.println("La 1 es mayor");
		}

	}

	private static void mostrarTablaGuerras() {
		for (int i = 0; i < nGuerras; i++)
			System.out.println(tablaGuerras[i]);
	}

	public Guerra mayorConflagración() {
		Guerra mayorGuerra = null;

		int maxNumPaises = 0;

		for (int i = 0; i < nGuerras; i++) {
			Guerra guerra = tablaGuerras[i];

			int numpaises = guerra.getBandoA().getnPaises() + guerra.getBandoB().getnPaises();

			if (numpaises > maxNumPaises) {
				mayorGuerra = guerra;
				maxNumPaises = numpaises;
			}

		}

		return mayorGuerra;
	}

	public static Pais masBeligerante() {

		Pais masBeligerante = null;
		int maxNumBatallas = 0;

		/*
		 * Primero obtenemos una lista de todos los paises. Para eso recorremos la lista
		 * de guerras y por cada bando vamos añadiendo los paises participantes SI AUN
		 * NO SE HA AÑADIDO A LA LISTA.
		 * 
		 * 
		 * Una vez tenemos la lista de paises la recorremos y por cada pais miramos cada
		 * batalla de esa guerra, si ese pais esta incluido en esa batallaç sumamos 1 al
		 * contador de batallas de ese pais
		 * 
		 */

		Pais[] lista = new Pais[10];
		int npaises = 0;
		for (int i = 0; i < nGuerras; i++) {
			for (int j = 0; j < tablaGuerras[i].getBandoA().getnPaises(); j++) {
				Pais p = tablaGuerras[i].getBandoA().getTablaPaises()[j];
				if (!contienePais(lista, p, npaises)) {
					lista[npaises] = p;
					npaises++;
					if (npaises >= lista.length) {
						lista = Arrays.copyOf(lista, npaises + 10);
					}
				}
			}
			for (int j = 0; j < tablaGuerras[i].getBandoB().getnPaises(); j++) {
				Pais p = tablaGuerras[i].getBandoB().getTablaPaises()[j];
				if (!contienePais(lista, p, npaises)) {
					lista[npaises] = p;
					npaises++;
					if (npaises >= lista.length) {
						lista = Arrays.copyOf(lista, npaises + 10);
					}
				}
			}
		}

		for (int i = 0; i < npaises; i++) {
			Pais p = lista[i];
			int contadorBatallas = 0;
			for (int j = 0; j < p.getTablaGuerras().length; j++) {
				Guerra g = p.getTablaGuerras()[j];

				for (int k = 0; k < g.getTablaBatallas().length; k++) {
					if (g.getTablaBatallas()[k].participoPais(p)) {
						contadorBatallas++;
					}
				}
			}

			if (contadorBatallas > maxNumBatallas) {
				masBeligerante = p;
				maxNumBatallas = contadorBatallas;
			}

		}

		return masBeligerante;
	}

	private static boolean contienePais(Pais[] lista, Pais p, int npaises) {
		boolean esta = false;

		for (int i = 0; i < npaises && !esta; i++) {
			if (lista[i].equals(p)) {
				esta = true;
			}
		}
		return esta;
	}
}
