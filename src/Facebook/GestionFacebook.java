package Facebook;

public class GestionFacebook {

	public static void main(String[] args) 
	{
		Miembro a,b,c,d,e,f,g,h,x;
		a = new Miembro("emaila","a");
		b = new Miembro("emailb","b");
		c = new Miembro("emailc","c");
		d = new Miembro("emaild","d");
		e = new Miembro("emaile","e");
		f = new Miembro("emailf","f");
		g = new Miembro("emailg","g");
		h = new Miembro("emailh","h");
		
		x = new Miembro("emailx","x");

		ListaMiembros lista = new ListaMiembros();
		lista.anyadeMiembro(a);
		lista.anyadeMiembro(b);
		lista.anyadeMiembro(c);
		lista.anyadeMiembro(d);
		lista.anyadeMiembro(e);
		lista.anyadeMiembro(f);
		lista.anyadeMiembro(g);
		lista.anyadeMiembro(h);

		hacerAmigos(a,f);
		hacerAmigos(a,d);
		hacerAmigos(e,b);
		hacerAmigos(e,c);
		hacerAmigos(e,d);
		hacerAmigos(g,h);
		hacerAmigos(b,c);
		
		
		System.out.println("Apartado a)");
		System.out.println("La lista contiene al miembro a: "+lista.contieneMiembro(a));
		System.out.println("La lista contiene al miembro x: "+lista.contieneMiembro(x));
		
		System.out.println("\nApartado b)");
		System.out.println("Amigos de a (sin b): "+a.getAmigos());
		a.anyadeAmigo(b); 
		System.out.println("Amigos de a (con b): "+a.getAmigos());
		
		System.out.println("\nApartado c)");
		a.eliminaAmigo(b);
		System.out.println("Amigos de a (eliminado b): "+a.getAmigos());
		
		System.out.println("\nApartado d)");
		System.out.println("Personas que quiza conozca d: "+d.personasQueQuizaConozca());
		
		System.out.println("\nApartado e)");
		System.out.println("Amigos en comun de c y d: "+c.amigosEnComun(d));
		
		System.out.println("\nApartado f)");
		System.out.println("�Tienen b y c los mismos amigos? "+b.tieneLosMismosAmigosQue(c));
		System.out.println("�Tienen h y g los mismos amigos? "+h.tieneLosMismosAmigosQue(g));
		x.anyadeAmigo(g);
		System.out.println("�Tienen h y x los mismos amigos? "+h.tieneLosMismosAmigosQue(x));
		x.eliminaAmigo(g);
		
		System.out.println("\nApartado g)");
		System.out.println("�Son todos amigos en lista? "+sonTodosAmigos(lista));
		ListaMiembros otra = new ListaMiembros();
		otra.anyadeMiembro(b);
		otra.anyadeMiembro(c);
		otra.anyadeMiembro(e);
		System.out.println("�Son todos amigos en otra? "+sonTodosAmigos(otra));
		
		System.out.println("\nApartado h)");
		System.out.println("�Porcentaje del indice de similitud de los amigos de a y b: "+indiceDeSimilitud(a,b));
		System.out.println("�Porcentaje del indice de similitud de los amigos de d y b: "+indiceDeSimilitud(d,b));
		System.out.println("�Porcentaje del indice de similitud de los amigos de d y d: "+indiceDeSimilitud(d,d));
	
	}
	
	
	public static void hacerAmigos(Miembro a, Miembro b)
	{
		a.anyadeAmigo(b);
		b.anyadeAmigo(a);
	}
	
	public static boolean sonTodosAmigos(ListaMiembros lista)
	{
		for (int i=0; i<lista.getTamanyo()-1; i++) {
			for (int j = i+1; j<lista.getTamanyo(); j++) {
				Miembro a= lista.getTabla()[i];
				Miembro b= lista.getTabla()[j];
				if (!a.tieneComoAmigoA(b)) {
					return false;
				}

			}
		}
		
		return true;
	}
	
	public static float indiceDeSimilitud(Miembro a, Miembro b)
	{
		ListaMiembros lista = new ListaMiembros();
		
		
		for (Miembro miembro:a.getAmigos().getTabla()) {
			if (!miembro.equals(b)) {
				lista.anyadeMiembroSinRepetir(miembro);
			}
		}
		
		for (Miembro miembro:b.getAmigos().getTabla()) {
			if (!miembro.equals(a)) {
				lista.anyadeMiembroSinRepetir(miembro);
			}
		}
		
		
		int totalAmigos = lista.getTamanyo();
		int amigosEnComun = a.amigosEnComun(b).getTamanyo();
		
		
		return (float)amigosEnComun*100/totalAmigos;
	}
	

	

}
