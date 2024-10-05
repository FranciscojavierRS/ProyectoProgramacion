package b4;

public class Ej7_ImparesMultiplicar {

	public static void main(String[] args) {
		int num = 1;
		
		int mult = 1;
		// 1 3 5 7 9 11 13 15 17 19
		for(int i=0; i<10; i++) {
			num = num*mult;
			mult = mult + 2;
		}
		
		System.out.println(num);

	}

}
