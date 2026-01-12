package EjerciciosChatGptArrays;

public class Ej2 {

	public static void main(String[] args) {

		int[][] tabla = new int[3][4];

		int numero = 1;

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 4; j++) {

				tabla[i][j] = numero;
				numero++;
			}

		}
		
		System.out.println("Matriz: ");
		
		for (int i = 0; i < 3; i++) {
			String linea = "";

			for (int j = 0; j < 4; j++) {
				linea += tabla[i][j] + " ";

			}
			System.out.println(linea);
		}
		System.out.println("Suma de filas: ");
		
		
		for (int i = 0; i < 3; i++) {
			String linea = "fila "+(i+1)+" = " ;
			int suma= 0;
			
			
			for (int j = 0; j < 4; j++) {
				suma += tabla[i][j];

			}
			System.out.println(linea+suma);
		}
		System.out.println("Suma de columnas");
		
		for (int j = 0; j < 4; j++) {
			String linea = "columna "+(j+1)+" = " ;
			int suma= 0;
			
			
			for (int i = 0; i < 3; i++) {
				suma += tabla[i][j];

			}
			System.out.println(linea+suma);
		}
		
	}

}
