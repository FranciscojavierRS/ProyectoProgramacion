package Examen_Biblioteca_Objetos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

import Formula1_Examen_Objetos.Equipo;
import Formula1_Examen_Objetos.PilotoResultado;

public class Biblioteca {

	private MaterialBibliografico[] materiales;
	private int numMateriales;
	private Usuario[] usuarios;
	private int numUsuarios;

	public Biblioteca(int tamMax) {
		this.materiales = new MaterialBibliografico[tamMax];
		this.numMateriales = 0;
		this.usuarios = new Usuario[tamMax];
		this.numUsuarios = 0;
	}

	public MaterialBibliografico[] getMateriales() {
		return materiales;
	}

	public int getNumMateriales() {
		return numMateriales;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public int getNumUsuarios() {
		return numUsuarios;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios[numUsuarios] = usuario;
		numUsuarios++;
	}

	public boolean addMaterial(MaterialBibliografico m) {
		boolean anyadido = false;
		if (numMateriales < materiales.length) {
			materiales[numMateriales++] = m;
			anyadido = true;
		}
		return anyadido;
	}

	public String toString() {
		String cadBiblio = "";
		for (int i = 0; i < numMateriales; i++) {
			cadBiblio += "\n" + materiales[i].toString();
		}
		return cadBiblio;
	}

	// a)
	/*
	 * que devuelve una tabla de objetos de la clase MaterialBibliografico con todos
	 * materiales ordenados. El tama�o de la tabla debe ser el del n�mero de
	 * materiales que contenga. El orden natural de los objetos
	 * MaterialBibliografico es por a�o de publicaci�n de manera descendente (los
	 * a�os m�s actuales van primero, y al final, los m�s antiguos). A igualdad de
	 * a�o, se ordenan ascendentemente por titulo. Crea el m�todo que corresponda
	 * para implementar esta ordenaci�n.
	 */
	public MaterialBibliografico[] getMaterialesOrdenados() {

		/*
		 * Copiamos el Array de materiales con tamaño [numMateriales] y despues hacemos
		 * Arrays.sort y luego definimos la forma en la que se ordena
		 */

		/*
		 * Si el tipo del Array ya implementa una interfaz, por lo que no podemos hacer
		 * que implemente la clase comparable tenemos que crear una implementacion de
		 * comparable en la llamada a Arrays.sort
		 */
		MaterialBibliografico[] materialesOrdenados = Arrays.copyOf(materiales, numMateriales);

		Arrays.sort(materialesOrdenados, new Comparator<MaterialBibliografico>() {

			@Override
			public int compare(MaterialBibliografico material1, MaterialBibliografico material2) {

				if (material1.anoPublicacion == material2.anoPublicacion) {
					return material1.titulo.compareTo(material2.titulo);
				}

				return material2.anoPublicacion - material1.anoPublicacion; // Si quiremos descendente ponemos el objeto
																			// 2 antes que el 1 sino al reves
			}

		});

		return materialesOrdenados;
	}

	// b)
	/*
	 * que busca dicho usuario entre los de la biblioteca, y le agrega el pr�stamo
	 * recibido como par�metro a sus pr�stamos. Si el material o el usuario no est�n
	 * registrados en la biblioteca, o el material est� marcado como prestado en los
	 * materiales de la biblioteca, el pr�stamo no debe incluirse. Devuelve true o
	 * false dependiendo de si el pr�stamo ha sido registrado o no. Se considera un
	 * material igual que otro si su t�tulo, autor y a�o de publicaci�n son iguales.
	 * Se considera un usuario igual que otro si su n�mero de identificaci�n es
	 * igual. Cabo suelto: N�tese que no estamos actualizando el campo prestado del
	 * material cuando el pr�stamo se realiza. Ya lo haremos en el m�todo del
	 * apartado d).
	 * 
	 */

	public boolean agregarPrestamo(Prestamo prestamo, Usuario usuario) {

		/*
		 * Comprobamos que el material existe. Para eso recooremos el Array de
		 * MaterialBibliografico[] materiales y si no encontramos el material del
		 * prestamo cortamos la ejecucion devolviendo false
		 * 
		 * Recorro el Array de Usuarios Usuario[] usuarios, si encuentro el usuario en
		 * el Array llamamos al metodo agregarPrestamo y devolvemos true
		 */
		boolean existeMaterial = false;

		for (MaterialBibliografico material : materiales) {
			if (prestamo.getMaterialBibliografico().equals(material) && !material.prestado) {
				existeMaterial = true;
			}
		}
		if (!existeMaterial) {
			return false;
		}

		for (Usuario user : usuarios) {
			if (usuario.equals(user)) {
				return usuario.agregarPrestamo(prestamo);
			}
		}

		return false;

	}

	// c)
	/*
	 * M�todo que marca el material como devuelto tanto en los materiales de la
	 * biblioteca como en los materiales de los pr�stamos de los usuarios de la
	 * biblioteca, e indica la fecha de devoluci�n en sus pr�stamos.
	 */
	public void devolver(MaterialBibliografico mat, LocalDate fechaDev) {

		/*
		 * Recorremos el Array de usuarios Usuario[] usuarios por cada usuario
		 * recooremos los prestamos y si el material de ese prestamo es el material de
		 * entrada y NO esta devuelto llamamos al metodo devolver
		 */

		for (int i = 0; i < numUsuarios; i++) {
			for (int j = 0; j < usuarios[i].getNumPrestamos(); j++) {
				Prestamo prestamo = usuarios[i].getPrestamos()[j];
				if (mat.equals(prestamo.getMaterialBibliografico()) && prestamo.estaPrestado()) {
					prestamo.devolver(fechaDev);
				}
			}

		}
	}

	// d)
	/*
	 * Actualiza el campo prestado del material bibliogr�fico de la biblioteca
	 * teniendo en cuenta los pr�stamos de los usuarios. Si, para un material, hay
	 * alg�n pr�stamo de alguno de los usuarios cuya fecha de devoluci�n sea nula,
	 * quiere decir que est� prestado, y si no hay pr�stamos, o los que hay, tienen
	 * fecha de devoluci�n, es que ese material no est� prestado.
	 */
	public void actualizaMaterialesPrestados() {

		/*
		 * Recorremos el Array de MaterialBibliografico[] materiales Por cada material
		 * ponemos el estado prestado a false y recorremos el Arrays de usuarios Por
		 * cada usuario recorremos los prestamos y SI tenemos un prestamo de ese
		 * material en estado prestado lo ponemos a true
		 */

		for (int i = 0; i < numMateriales; i++) {
			materiales[i].prestado = false;

			for (int j = 0; j < numUsuarios; j++) {
				for (int k = 0; k < usuarios[j].getNumPrestamos(); k++) {
					if (materiales[i].equals(usuarios[j].getPrestamos()[k].getMaterialBibliografico())
							&& usuarios[j].getPrestamos()[k].estaPrestado()) {
						materiales[i].prestado = true;
					}
				}
			}

		}
	}

	// e)
	/*
	 * Devuelve un array -del tama�o justo- con los pr�stamos asociados al material
	 * que se pasa como par�metro.
	 */
	public Prestamo[] prestamosDeMaterial(MaterialBibliografico material) {
		/*
		 * Creamos un Array de prestamos con tamaño 0 Recorremos el Array de Usuarios y
		 * por cada usuario recorremos los prestamos Si el material del prestamo es el
		 * material de entrada aumentamos en +1 el Array de prestamos y añadimos el
		 * prestamo al Array
		 */

		Prestamo[] prestamos = new Prestamo[0];

		for (int i = 0; i < numUsuarios; i++) {
			for (int j = 0; j < usuarios[i].getNumPrestamos(); j++) {
				if (material.equals(usuarios[i].getPrestamos()[j].getMaterialBibliografico())) {
					prestamos = Arrays.copyOf(prestamos, prestamos.length + 1);
					prestamos[prestamos.length - 1] = usuarios[i].getPrestamos()[j];
				}
			}
		}

		return prestamos;
	}

}
