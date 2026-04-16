package ExamenBiblioteca2Objetos;

import java.time.LocalDate;
import java.util.Arrays;

public class Biblioteca {

	private MaterialBibliografico[] materiales;
	private int numMateriales;
	private Usuario[] usuarios;
	private int numUsuarios;

	// Constructor: crea arrays con tamaño máximo y contadores a 0
	public Biblioteca(int tamMax) {
		this.materiales = new MaterialBibliografico[tamMax];
		this.numMateriales = 0;
		this.usuarios = new Usuario[tamMax];
		this.numUsuarios = 0;
	}

	// Getters
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

	// Añade usuario al array (sin comprobaciones de espacio)
	public void agregarUsuario(Usuario usuario) {
		usuarios[numUsuarios] = usuario;
		numUsuarios++;
	}

	// Añade material si hay espacio libre
	public boolean addMaterial(MaterialBibliografico m) {
		boolean anyadido = false;

		// Comprueba si hay hueco en el array
		if (numMateriales < materiales.length) {
			materiales[numMateriales++] = m; // añade y aumenta contador
			anyadido = true;
		}

		return anyadido;
	}

	// Muestra todos los materiales en forma de texto
	public String toString() {
		String cadBiblio = "";

		// Recorre solo los materiales existentes
		for (int i = 0; i < numMateriales; i++) {
			cadBiblio += "\n" + materiales[i].toString();
		}

		return cadBiblio;
	}

	// a)

	/*
	 * a) (2 Puntos) Realizar el método public MaterialBibliografico[]
	 * getMaterialesOrdenados() que devuelve una tabla de objetos de la clase
	 * MaterialBibliografico con todos materiales ordenados. El tamaño de la tabla
	 * debe ser el del número de materiales que contenga. El orden natural de los
	 * objetos MaterialBibliografico es por año de publicación de manera descendente
	 * (los años más actuales van primero, y al final, los más antiguos). A igualdad
	 * de año, se ordenan ascendentemente por titulo. Crea el método que corresponda
	 * para implementar esta ordenación
	 */
	/*
	 * Devuelve array con tamaño exacto y ordenado
	 */
	public MaterialBibliografico[] getMaterialesOrdenados() {

		// Copia solo los elementos válidos
		MaterialBibliografico[] tablaMateriales = Arrays.copyOf(materiales, numMateriales);

		// Ordena usando compareTo (orden natural)
		Arrays.sort(tablaMateriales);

		return tablaMateriales;
	}

	// b)

	/*
	 * b) (2 puntos) Realizar el método public boolean agregarPrestamo(Prestamo
	 * prestamo1, Usuario usuario1) que busca dicho usuario entre los de la
	 * biblioteca, y le agrega el préstamo recibido como parámetro a sus préstamos.
	 * Si el material o el usuario no están registrados en la biblioteca, o el
	 * material está marcado como prestado en los materiales de la biblioteca, el
	 * préstamo no debe incluirse. Devuelve true o false dependiendo de si el
	 * préstamo ha sido registrado o no. Se considera un material igual que otro si
	 * su título, autor y año de publicación son iguales. Se considera un usuario
	 * igual que otro si su número de identificación es igual. Cabo suelto: Nótese
	 * que no estamos actualizando el campo prestado del material cuando el préstamo
	 * se realiza. Ya lo haremos en el método del apartado d).
	 * 
	 */
	/*
	 * Añade préstamo a un usuario SOLO si: - El material existe en la biblioteca -
	 * El material NO está prestado - El usuario existe en la biblioteca
	 */
	public boolean agregarPrestamo(Prestamo prestamo, Usuario usuario) {

		boolean encontrado = false;

		// 1. Comprobar que el material existe y NO está prestado
		for (int i = 0; i < numMateriales; i++) {

			if (materiales[i].equals(prestamo.getMaterialBibliografico()) && !materiales[i].estaPrestado()) {
				encontrado = true;
			}
		}

		// Si no existe o está prestado → no se puede hacer préstamo
		if (!encontrado) {
			return false;
		}

		// 2. Comprobar que el usuario existe
		for (int i = 0; i < numUsuarios; i++) {

			if (usuarios[i].equals(usuario)) {
				encontrado = true;
			}
		}

		// Si no existe el usuario → no se puede
		if (!encontrado) {
			return false;
		}

		// 3. Añadir préstamo al usuario
		return usuario.agregarPrestamo(prestamo);
	}

	// c)

	/*
	 * c) (2 puntos) public void devolver(MaterialBibliografico mat, LocalDate
	 * fechaDev) Método que marca el material como devuelto tanto en los materiales
	 * de la biblioteca como en los materiales de los préstamos de los usuarios de
	 * la biblioteca, e indica la fecha de devolución en sus préstamos.
	 * 
	 */
	/*
	 * Marca un material como devuelto: - En la biblioteca - En los préstamos de los
	 * usuarios - Añade fecha de devolución
	 */
	public void devolver(MaterialBibliografico mat, LocalDate fechaDev) {

		// 1. Marcar como devuelto en la biblioteca
		for (int i = 0; i < numMateriales; i++) {

			if (materiales[i].equals(mat)) {
				materiales[i].devolver();
			}
		}

		// 2. Buscar en préstamos de usuarios y actualizar
		for (int i = 0; i < numUsuarios; i++) {

			for (int j = 0; j < usuarios[i].getNumPrestamos(); j++) {

				// Si coincide el material y está prestado
				if (usuarios[i].getPrestamos()[j].getMaterialBibliografico().equals(mat)
						&& usuarios[i].getPrestamos()[j].estaPrestado()) {

					// Se devuelve con fecha
					usuarios[i].getPrestamos()[j].devolver(fechaDev);
				}
			}
		}
	}

	// d)

	/*
	 * d) (2 puntos) public void actualizaMaterialesPrestados() Actualiza el campo
	 * prestado del material bibliográfico de la biblioteca teniendo en cuenta los
	 * préstamos de los usuarios. Si, para un material, hay algún préstamo de alguno
	 * de los usuarios cuya fecha de devolución sea nula, quiere decir que está
	 * prestado, y si no hay préstamos, o los que hay, tienen fecha de devolución,
	 * es que ese material no está prestado
	 */
	/*
	 * Actualiza el estado "prestado" de cada material: - Si hay algún préstamo sin
	 * devolver → prestado
	 */
	public void actualizaMaterialesPrestados() {

		// Recorre todos los materiales
		for (int i = 0; i < numMateriales; i++) {

			// Recorre usuarios
			for (int j = 0; j < numUsuarios; j++) {

				// Recorre préstamos de cada usuario
				for (int x = 0; x < usuarios[j].getNumPrestamos(); x++) {

					// Si el préstamo corresponde al material y sigue activo
					if (usuarios[j].getPrestamos()[x].getMaterialBibliografico().equals(materiales[i])
							&& usuarios[j].getPrestamos()[x].estaPrestado()) {

						// Se marca como prestado
						materiales[i].prestar();
					}
				}
			}
		}
	}

	// e)

	/*
	 * e) (2 puntos) public Prestamo[] prestamosDeMaterial(MaterialBibliografico
	 * material) Devuelve un array -del tamaño justo- con los préstamos asociados al
	 * material que se pasa como parámetro.
	 * 
	 */
	/*
	 * Devuelve array dinámico con TODOS los préstamos de un material
	 */
	public Prestamo[] prestamosDeMaterial(MaterialBibliografico material) {

		Prestamo[] prestamosDeMaterial = new Prestamo[0]; // array vacío

		// Recorre usuarios
		for (int i = 0; i < numUsuarios; i++) {

			// Recorre préstamos de cada usuario
			for (int j = 0; j < usuarios[i].getNumPrestamos(); j++) {

				// Si el préstamo corresponde al material
				if (usuarios[i].getPrestamos()[j].getMaterialBibliografico().equals(material)) {

					// Aumenta tamaño del array en 1
					prestamosDeMaterial = Arrays.copyOf(prestamosDeMaterial, prestamosDeMaterial.length + 1);

					// Añade el préstamo al final
					prestamosDeMaterial[prestamosDeMaterial.length - 1] = usuarios[i].getPrestamos()[j];
				}
			}
		}

		return prestamosDeMaterial;
	}

}