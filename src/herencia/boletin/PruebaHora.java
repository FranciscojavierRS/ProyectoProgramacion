package herencia.boletin;

public class PruebaHora {

	public static void main(String[] args) {
		Hora h1=new Hora(30, 62);
		Hora h2=new Hora(23, 59);
		
		System.out.println(h1);
		System.out.println(h2);

		h2.inc();
		System.out.println("incrementado: "+h2);
		
		Hora12 h121=new Hora12(12, 59, Meridiano.PM);
		
		System.out.println(h121);
		
		h121.setHora(22);
		System.out.println(h121);
		
		h121.inc();
		System.out.println(h121);
	}

}
