package Examen_Guerras;


public class Batalla
{
 private String nombre;    // nombre de la batalla
 private Pais pais1;       // uno de los paises contendientes en la batalla
 private Pais pais2;       // el otro pais de la batalla.
 
 public Batalla(String nombre, Pais pais1, Pais pais2)
 {
	 this.nombre = nombre;
	 this.pais1 = pais1;
	 this.pais2 = pais2;
 }
 
 public String toString()
 {
	 return this.nombre+" ("+pais1+" - "+pais2+")";
 }
 
 public boolean participoPais (Pais pais) {
	 return pais1.equals(pais)|| pais2.equals(pais);
	 
 }
 
}
