package Examen_Guerras;

import java.util.Arrays;

public class Guerra 
{
	private String denominaciin;                  // nombre de la guerra
	private Bando bandoA;                         // uno de los dos bandos que lucharon en esta guerra
	private Bando bandoB;                         // el otro bando que luchi en esta guerra.
	private Batalla tablaBatallas[];              // batallas que tuvieron lugar en esta guerra
	private int nBatallas;                        // numero de batallas en la tabla
	public static final int MAX_BATALLAS = 10;    // maximo

	public Guerra(String denominaciin, Bando BandoA, Bando BandoB)
	{
		this.denominaciin = denominaciin;
		this.bandoA = BandoA;
		this.bandoB = BandoB;
		this.tablaBatallas = new Batalla[Guerra.MAX_BATALLAS];
		this.nBatallas = 0;
	}

	public void anyadeBatalla(Batalla batalla) 
	{
     this.tablaBatallas[nBatallas++] = batalla;
	}
	
	

	public Batalla[] getTablaBatallas() {
		return Arrays.copyOf(tablaBatallas, nBatallas);
	}

	public void setTablaBatallas(Batalla[] tablaBatallas) {
		this.tablaBatallas = tablaBatallas;
	}

	public Bando getBandoA() {
		return bandoA;
	}

	public Bando getBandoB() {
		return bandoB;
	}

	@Override
	public String toString() 
	{
		String cad = "Guerra: " + denominaciin + "\n\n"
				+"    Bando:   "+ bandoA //+ "\n"
				+"    Bando:   "+ bandoB //+ "\n"
				+"    Batallas:\n";
		for (int i=0;i<this.nBatallas;i++)
		  cad += "             "+this.tablaBatallas[i]+"\n";
		
		return cad;
	}

	public int compareTo(Object oGuerra) {
		
		if (oGuerra instanceof Guerra) {
			Guerra guerra = (Guerra) oGuerra; 
			int numpaises1 = this.bandoA.getnPaises()+this.bandoB.getnPaises();
			int numpaises2 = guerra.getBandoA().getnPaises()+guerra.getBandoB().getnPaises();
			if (numpaises1==numpaises2) {
				return 0;
			}else if (numpaises1>numpaises2) {
				return 1;
			}else {
				return -1;
			}

		}else {
			return 1;
		}
		
	}


}
