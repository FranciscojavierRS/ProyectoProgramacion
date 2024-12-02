package METODOSUTILES;

public class UtilidadesALAN {

	public static void main(String[] args) {
		import java.util.Arrays;

		public class FUNCIONESCONARRAYS {

			//1 FUNCIÓN PARA LLENAR TABLAS TRIDIMENSIONALES CON -1.
			//2 FUNCIÓN PARA BUSCAR ÍNDICES DENTRO DE UNA TABLA.
			//3 FUNCIÓN PARA BORRAR ELEMENTOS DE UNA TABLA ORDENADA.
			//4 FUNCIÓN PARA HACER COPIAS DE TABLAS Y ORDENARLAS.
			//5 FUNCIÓN PARA HACER COMPROBACIONES DE SI LOS VALORES SON DIFERENTES DE CERO.
			//6 FUNCIÓN PARA BUSCAR NÚMEROS EN ARRAYS ORDENADOS.
			//7 FUNCIÓN PARA HACER BÚSQUEDAS DE ÍNDICE Y SI NO LO ENCUENTRA EN LA TABLA LO INSERTA.
			//8 FUNCIÓN PARA BUSCAR NÚMEROS EN ARRAYS.
			//9 FUNCIÓN PARA HACER UNA COPIA DE LA TABLA Y ORDENARLA.
			
			
			
			
			
		   1 //FUNCIÓN PARA LLENAR TABLAS TRIDIMENSIONALES CON -1.
		    private static void fill(int tabla[][][], int valor) {
		        for (int i = 0; i < tabla.length; i++) {
		            for (int j = 0; j < tabla[i].length; j++) {
		                for (int k = 0; k < tabla[i][j].length; k++) {
		                    tabla[i][j][k] = valor;
		                }
		            }
		        }
		    }

		 2   //FUNCIÓN PARA BUSCAR ÍNDICES DENTRO DE UNA TABLA.
		    private static int getIndexOf(String t[], String aBuscar, int numelem) {
		        int indice = -1;
		        for (int i = 0; i < numelem && indice == -1; i++) {
		            if (t[i].equals(aBuscar)) {
		                indice = i;
		            }
		        }
		        return indice;
		    }

		  3  //FUNCIÓN PARA BORRAR ELEMENTOS DE UNA TABLA ORDENADA.
		    private static int[] borradoTablaOrdenada(int[] tabla, int  buscado) {
		        int pos = Arrays.binarySearch(tabla, buscado);
		        for (int i = pos; i < tabla.length - 1;i++) {
		            tabla[i] = tabla[i+1];
		        }
		        int tablanueva[];
		        tablanueva = Arrays.copyOf(tabla, tabla.length - 1);
		        return tablanueva;

		    }

		  4  //FUNCIÓN PARA HACER COPIAS DE TABLAS Y ORDENARLAS.
		    private static String[] getMatrizSorted(String[] matriz, int numElementos) {
		        String[] matrizOrdenada = Arrays.copyOf(matriz, numElementos);
		        Arrays.sort(matrizOrdenada);
		        return matrizOrdenada;
		    }

		 5   //FUNCIÓN PARA HACER COMPROBACIONES DE SI LOS VALORES SON DIFERENTES DE CERO.
		    private static boolean distintoCero(int numfila, float[][] transferencias) {
		        boolean lleno = false;
		        for (int i = numfila; i < transferencias.length && !lleno; i++) {
		            if (transferencias[numfila][i] != 0) {
		                lleno = true;
		            }
		        }
		        return lleno;
		    }

		  6  //FUNCIÓN PARA BUSCAR NÚMEROS EN ARRAYS ORDENADOS.
		    private static int getIndexOfSorted(int t[], int aBuscar) {
		        int pos = Arrays.binarySearch(t, aBuscar);
		        int indice = -pos -1;
		        return indice;
		    }

		  7  //FUNCIÓN PARA HACER BÚSQUEDAS DE ÍNDICE Y SI NO LO ENCUENTRA EN LA TABLA LO INSERTA.
		    private static void getIndexOfInsertar(int elemABuscar, float t[][]){
		        for (int i = 0; i<t[i].length; i++){
		            for(int j = 0; j< t[j].length; j++){
		                if (t[i][j] == -1){
		                    t[i][j] = elemABuscar;
		                }
		            }
		        }
		    }

		8    //FUNCIÓN PARA BUSCAR NÚMEROS EN ARRAYS.
		    private static int getIndexOf(int[] tabla, int valorbuscado) {
		        int comprobacion = -1;
		        int i = 0;
		        while (i < tabla.length && tabla[i] != valorbuscado) {
		            i++;
		        }
		        if (i < tabla.length) {
		            comprobacion = i;
		        }

		        return comprobacion;
		    }

		  9  //FUNCIÓN PARA HACER UNA COPIA DE LA TABLA Y ORDENARLA.
		    private static String[] copyOf(String[] original, int largotabla) {
		        String[] partordena = Arrays.copyOf(original, largotabla);
		        Arrays.sort(partordena);
		        return partordena;
		    }
		}
	}

}
