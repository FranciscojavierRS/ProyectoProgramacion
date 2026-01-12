package Facebook;

import java.util.Arrays;

public class ListaMiembros
{
	private Miembro tabla[];


	public Miembro[] getTabla()
	{
		return tabla;
	}
	
	public int getTamanyo()
	{
		return this.tabla.length;
	}

	public ListaMiembros()
	{
		this.tabla = new Miembro[0];
	}

	public void anyadeMiembro(Miembro m)
	{
		Miembro[] tablaNueva = new Miembro[this.getTamanyo()+1];
		for(int i=0;i<this.getTamanyo();i++)
			tablaNueva[i] = this.tabla[i];
		tablaNueva[this.getTamanyo()]=m;
		this.tabla = tablaNueva;
	}
	
	public void anyadeMiembroSinRepetir(Miembro m)
	{
		if (!this.contieneMiembro(m)) {
			this.anyadeMiembro(m);
		}
		
	}

	public String toString()
	{
		return Arrays.toString(this.tabla);
	}


	public boolean contieneMiembro(Miembro m)
	{
		for (Miembro m2:this.tabla) {
			if (m.equals(m2)) {
				return true;
			}
		}
		
		return false;
	}

	public void eliminaMiembro(Miembro m)
	{
		Miembro[] tablaNueva = new Miembro[this.getTamanyo()-1];
		for(int i=0;i<this.getTamanyo();i++) {
			
			if (!this.tabla[i].equals(m))
				tablaNueva[i] = this.tabla[i];
		}
		this.tabla = tablaNueva;
	}

}
