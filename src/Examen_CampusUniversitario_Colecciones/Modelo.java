package Examen_CampusUniversitario_Colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


import java.util.Iterator;

public class Modelo {

	// Estructura principal de datos del campus
	private TreeMap<Asignatura, HashSet<Profesor>> profesoresPorAsignatura;
	private HashMap<Estudiante, LinkedList<Matricula>> matriculasEstudiante;
	private TreeMap<String, ArrayList<Clase>> clasesPorDia;
	private TreeSet<Estudiante> estudiantes;
	private LinkedHashSet<Aula> aulas;
	private ArrayList<Matricula> todasLasMatriculas;

	public Modelo() {
		profesoresPorAsignatura = new TreeMap<>();
		matriculasEstudiante = new HashMap<>();
		clasesPorDia = new TreeMap<>();
		estudiantes = new TreeSet<>();
		aulas = new LinkedHashSet<>();
		todasLasMatriculas = new ArrayList<>();
	}

	/*
	 * PATRÓN 1: Mapa de colecciones anidadas Añade un profesor a una asignatura. Si
	 * la asignatura no existe en el mapa, se crea el conjunto. No se permiten
	 * profesores duplicados para la misma asignatura. Devuelve true si se añadió
	 * correctamente, false si ya existía.
	 */
	public boolean addProfesorAsignatura(Asignatura asignatura, Profesor profesor) {

		// 1. Verificar si la asignatura ya existe como clave en el TreeMap
		if (!profesoresPorAsignatura.containsKey(asignatura)) {
			// 2. Si no existe, crear un nuevo HashSet para almacenar profesores de esta asignatura
			profesoresPorAsignatura.put(asignatura, new HashSet<>());
		}

		// 3. Añadir el profesor al HashSet de la asignatura
		// 4. El HashSet.add() devuelve true si se añadió, false si ya existía (evita duplicados)
		return profesoresPorAsignatura.get(asignatura).add(profesor);

	}

	/*
	 * PATRÓN 2: Verificación y adición en estructuras anidadas Matricula un
	 * estudiante en una asignatura con una nota inicial. Si el estudiante no tiene
	 * matrículas previas, se crea su lista. También añade la matrícula a la lista
	 * general de todas las matrículas. Devuelve true si se matriculó correctamente.
	 */
	public boolean matricularEstudiante(Estudiante estudiante, Asignatura asignatura, double nota,
			String convocatoria) {

		// 1. Verificar si el estudiante ya tiene matrículas registradas
		if (!matriculasEstudiante.containsKey(estudiante)) {
			// 2. Si no existe, crear una nueva LinkedList para sus matrículas
			matriculasEstudiante.put(estudiante, new LinkedList<>());
		}
		// 3. Crear el objeto Matricula con los datos proporcionados
		Matricula matricula = new Matricula(estudiante, asignatura, nota, convocatoria);

		// 4. Añadir la matrícula a la lista general de todas las matrículas (para estadísticas)
		todasLasMatriculas.add(matricula);

		// 5. Añadir la matrícula a la lista específica del estudiante
		// 6. Devolver true si se añadió correctamente a la lista del estudiante
		return matriculasEstudiante.get(estudiante).add(matricula);
	}

	/*
	 * PATRÓN 3: Búsqueda en estructuras complejas Devuelve todas las clases que se
	 * imparten en un día específico. Si no hay clases ese día, devuelve una lista
	 * vacía.
	 */
	public ArrayList<Clase> getClasesPorDia(String dia) {

		// 1. Verificar si existen clases registradas para el día especificado
		if (!clasesPorDia.containsKey(dia)) {
			// 2. Si no hay clases ese día, devolver una ArrayList vacía (evita null)
			return new ArrayList<>();
		}

		// 3. Devolver la ArrayList de clases para ese día específico
		return clasesPorDia.get(dia);
	}

	/*
	 * PATRÓN 4: Conteo de frecuencias Devuelve el profesor con más asignaturas
	 * impartidas. Si hay empate, devuelve cualquiera de los profesores con más
	 * asignaturas. Si no hay profesores, devuelve null.
	 */
	public Profesor profesorConMasAsignaturas() {

		// 1. Crear un HashMap auxiliar para contar asignaturas por profesor
		Map<Profesor, Integer> contador = new HashMap<>();

		// 2. Recorrer cada entrada del TreeMap (asignatura -> conjunto de profesores)
		for (Map.Entry<Asignatura, HashSet<Profesor>> entry : profesoresPorAsignatura.entrySet()) {
			// 3. Para cada profesor de esta asignatura, incrementar su contador
			for (Profesor profesor : entry.getValue()) {

				// 4. Usar getOrDefault para obtener el conteo actual o 0 si no existe, luego sumar 1
				contador.put(profesor, contador.getOrDefault(profesor, 0) + 1);
			}

		}

		// 5. Variables para tracking del profesor con máximo de asignaturas
		Profesor profesorMasAsignaturas = null;
		int maxCount = 0;
		// 6. Recorrer el contador para encontrar el profesor con más asignaturas
		for (Map.Entry<Profesor, Integer> entry : contador.entrySet()) {
			// 7. Si este profesor tiene más asignaturas que el máximo actual, actualizar
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				profesorMasAsignaturas = entry.getKey();
			}
		}
		// 8. Devolver el profesor con más asignaturas (o null si no hay profesores)
		return profesorMasAsignaturas;

	}

	/*
	 * PATRÓN 5: Eliminación segura con Iterator Elimina todas las matrículas
	 * suspensas (nota < 5.0) de un estudiante. Devuelve el número de matrículas
	 * eliminadas. Si el estudiante no existe, devuelve 0.
	 */
	public int eliminarMatriculasSuspensas(Estudiante estudiante) {

		// 1. Contador para registrar cuántas matrículas se eliminan
		int contadorMatriculasEliminadas = 0;

		// 2. Verificar si el estudiante existe en el sistema (tiene matrículas)
		if (matriculasEstudiante.containsKey(estudiante)) {
			// 3. Obtener un Iterator para eliminación segura mientras recorremos
			Iterator<Matricula> iterador = matriculasEstudiante.get(estudiante).iterator();
			// 4. Recorrer todas las matrículas del estudiante
			while (iterador.hasNext()) {
				Matricula matricula = iterador.next();
				// 5. Verificar si la matrícula está suspensa (nota menor a 5.0)
				if (matricula.getNota() < 5) {
					// 6. Eliminar de la lista del estudiante de forma segura con Iterator
					iterador.remove(); //
					// 7. Eliminar también de la lista general para mantener consistencia
					todasLasMatriculas.remove(matricula);
					// 8. Incrementar el contador de eliminaciones
					contadorMatriculasEliminadas++;
				}
			}
		}
		// 9. Devolver el total de matrículas eliminadas (0 si el estudiante no existía)
		return contadorMatriculasEliminadas;
	}

	/*
	 * PATRÓN 6: Obtener elementos únicos de colecciones Devuelve un conjunto con
	 * todas las facultades distintas en las que hay asignaturas. Usa un TreeSet
	 * para mantener orden alfabético.
	 */
	public TreeSet<String> getFacultadesConAsignaturas() {

		// 1. Crear TreeSet para almacenar facultades (automáticamente ordenadas y sin duplicados)
		TreeSet<String> facultades = new TreeSet<>();

		// 2. Recorrer todas las asignaturas que son claves en el TreeMap
		for (Asignatura asignatura : profesoresPorAsignatura.keySet()) {
			// 3. Añadir la facultad de cada asignatura al TreeSet
			// 4. TreeSet automáticamente elimina duplicados y mantiene orden alfabético
			facultades.add(asignatura.getFacultad());
		}

		// 5. Devolver el conjunto de facultades únicas ordenadas alfabéticamente
		return facultades;
	}

	/*
	 * PATRÓN 7: Búsqueda de relaciones bidireccionales Verifica si existe un
	 * solapamiento de horarios: Dos clases en el mismo aula, mismo día y misma hora
	 * con asignaturas/profesores diferentes. Devuelve true si hay solapamiento,
	 * false en caso contrario.
	 */
	public boolean haySolapamientoHorarios() {

		// 1. Recorrer cada día del TreeMap (clave: día, valor: ArrayList de clases)
		for (Map.Entry<String, ArrayList<Clase>> entry : clasesPorDia.entrySet()) {

			// 2. Para cada día, comparar todas las clases entre sí (bucle anidado)
			// 3. Optimización: solo comparar cada par una vez (i < j)
			for (int i = 0; i < entry.getValue().size() - 1; i++) {
				Clase clase1 = entry.getValue().get(i);
				// 4. Comparar con todas las clases restantes del mismo día
				for (int j = i + 1; j < entry.getValue().size(); j++) {
					Clase clase2 = entry.getValue().get(j);

					// 5. Verificar solapamiento: misma hora Y mismo aula
					if (clase1.getHora().equals(clase2.getHora()) && clase1.getAula().equals(clase2.getAula())) {

						// 6. Si hay solapamiento, devolver true inmediatamente
						return true;
					}

				}
			}

		}

		// 7. Si se recorrieron todas las combinaciones sin encontrar solapamiento, devolver false
		return false;

	}

	/*
	 * PATRÓN 8: Filtrado y subcolecciones Devuelve todos los estudiantes
	 * matriculados en asignaturas de una facultad específica. Usa un LinkedHashSet
	 * para mantener orden de inserción sin duplicados.
	 */
	public LinkedHashSet<Estudiante> getEstudiantesPorFacultad(String facultad) {

		// 1. Crear LinkedHashSet para mantener orden de inserción sin duplicados
		LinkedHashSet<Estudiante> estudiantesFiltrados = new LinkedHashSet<>();

		// 2. Recorrer cada entrada del HashMap (estudiante -> lista de matrículas)
		for (Map.Entry<Estudiante, LinkedList<Matricula>> entry : matriculasEstudiante.entrySet()) {

			// 3. Recorrer todas las matrículas de este estudiante
			for (Matricula matricula : entry.getValue()) {

				// 4. Verificar si la asignatura de esta matrícula pertenece a la facultad buscada
				if (matricula.getAsignatura().getFacultad().equals(facultad)) {

					// 5. Añadir el estudiante al conjunto (LinkedHashSet evita duplicados)
					estudiantesFiltrados.add(entry.getKey());

				}

			}

		}

		// 6. Devolver el conjunto de estudiantes de esa facultad (orden de inserción)
		return estudiantesFiltrados;
	}

	/*
	 * PATRÓN 9: Cálculo de estadísticas Calcula la nota media de todas las
	 * matrículas de una asignatura. Si no hay matrículas para esa asignatura,
	 * devuelve 0.0.
	 */
	public double getNotaMediaAsignatura(Asignatura asignatura) {

		// 1. Variables para el cálculo estadístico
		double sumatorioNotas = 0;
		int contadorMatriculas = 0;
		// 2. Recorrer todas las matrículas registradas en el sistema
		for (Matricula matricula : todasLasMatriculas) {

			// 3. Verificar si esta matrícula corresponde a la asignatura especificada
			if (matricula.getAsignatura().equals(asignatura)) {
				// 4. Incrementar contador y sumar la nota al acumulador
				contadorMatriculas++;
				sumatorioNotas += matricula.getNota();
			}

		}

		// 5. Control de división por cero: si no hay matrículas, devolver 0.0
		if (contadorMatriculas == 0) {
			return 0;
		}

		// 6. Calcular y devolver el promedio (suma total / número de matrículas)
		return sumatorioNotas / contadorMatriculas;
	}

	/*
	 * PATRÓN 10: Clases personalizadas que extienden colecciones Añade un aula al
	 * conjunto de aulas. Si ya existe un aula con el mismo código, no la añade y
	 * devuelve false. Devuelve true si se añadió correctamente.
	 */
	public boolean addAula(Aula aula) {

		// 1. Delegar toda la lógica al LinkedHashSet
		// 2. LinkedHashSet.add() automáticamente:
		//    - Verifica duplicados usando equals() de Aula
		//    - Añade si no existe, devuelve true
		//    - No añade si ya existe, devuelve false
		// 3. Mantiene orden de inserción
		return aulas.add(aula);
	}

	/*
	 * PATRÓN 11: Búsqueda por criterios complejos Devuelve todas las asignaturas
	 * que imparte un profesor y que son de más de X créditos. Si el profesor no
	 * tiene asignaturas, devuelve un conjunto vacío.
	 */
	public HashSet<Asignatura> getAsignaturasProfesorPorCreditos(Profesor profesor, int creditosMinimos) {

		// 1. Crear HashSet para almacenar las asignaturas que cumplan los criterios
		HashSet<Asignatura> asignaturas = new HashSet<>();

		// 2. Recorrer cada entrada del TreeMap (asignatura -> conjunto de profesores)
		for (Map.Entry<Asignatura, HashSet<Profesor>> entrada : profesoresPorAsignatura.entrySet()) {

			// 3. Verificar doble condición:
			//    a) El profesor imparte esta asignatura (contains)
			//    b) La asignatura tiene los créditos mínimos requeridos
			if (entrada.getValue().contains(profesor) && entrada.getKey().getCreditos() >= creditosMinimos) {

				// 4. Añadir la asignatura al conjunto de resultados
				asignaturas.add(entrada.getKey());
			}

		}
		// 5. Devolver el conjunto de asignaturas que cumplen ambos criterios
		return asignaturas;
	}

	/*
	 * PATRÓN 12: Verificación de existencia en mapas anidados Verifica si un
	 * estudiante está matriculado en una asignatura específica. Devuelve true si
	 * está matriculado, false en caso contrario.
	 */
	public boolean estaMatriculadoEn(Estudiante estudiante, Asignatura asignatura) {

		// 1. Verificar si el estudiante existe en el sistema (tiene matrículas registradas)
		if (matriculasEstudiante.containsKey(estudiante)) {
			// 2. Recorrer todas las matrículas de este estudiante
			for (Matricula matricula : matriculasEstudiante.get(estudiante)) {
				// 3. Verificar si alguna matrícula corresponde a la asignatura especificada
				if (matricula.getAsignatura().equals(asignatura)) {
					// 4. Si encontramos coincidencia, devolver true inmediatamente (corto circuito)
					return true;
				}
			}
		}
		// 5. Si el estudiante no existe o no tiene matrícula en esta asignatura, devolver false
		return false;
	}

	/*
	 * PATRÓN 13: Recorrido y transformación de datos Devuelve un mapa con el número
	 * de estudiantes por facultad. La clave es el nombre de la facultad y el valor
	 * es el número de estudiantes.
	 */
	public HashMap<String, Integer> getNumeroEstudiantesPorFacultad() {

		// 1. Crear HashMap para almacenar conteo de estudiantes por facultad
		HashMap<String, Integer> estudiantesFacultad = new HashMap<>();

		// 2. Recorrer cada estudiante y sus matrículas
		for (Map.Entry<Estudiante, LinkedList<Matricula>> entry : matriculasEstudiante.entrySet()) {

			// 3. Recorrer cada matrícula de este estudiante
			for (Matricula matricula : entry.getValue()) {
				// 4. Obtener la facultad de esta matrícula
				String facultad = matricula.getAsignatura().getFacultad();
				// 5. Usar getOrDefault para obtener conteo actual o 0, luego sumar 1
				// 6. Esto cuenta por matrícula, no por estudiante único
				estudiantesFacultad.put(facultad,
						estudiantesFacultad.getOrDefault(facultad, 0) + 1);
			}

		}

		// 7. Devolver el mapa con el conteo de estudiantes por facultad
		return estudiantesFacultad;
	}

	/*
	 * PATRÓN 14: Búsqueda de elementos extremos
	 *  Devuelve la matrícula con la nota
	 * más alta de todas las registradas. Si hay empate, devuelve cualquiera de las
	 * notas más altas. Si no hay matrículas, devuelve null.
	 */
	public Matricula getMatriculaNotaMasAlta() {
		// 1. Inicializar variables para tracking del máximo
		Matricula matriculaNotaMasAlta = null;
		double maxCount = 0;
		// 2. Recorrer todas las matrículas registradas en el sistema
		for (Matricula matricula : todasLasMatriculas) {
			// 3. Verificar si esta matrícula tiene una nota mayor que el máximo actual
			if (matricula.getNota() > maxCount) {
				// 4. Actualizar el máximo y guardar referencia a esta matrícula
				maxCount = matricula.getNota();
				matriculaNotaMasAlta = matricula;
			}
		}
		// 5. Devolver la matrícula con nota más alta (null si no hay matrículas)
		return matriculaNotaMasAlta;
	}

	// Getters para acceso a las estructuras principales (si son necesarios)
	public TreeMap<Asignatura, HashSet<Profesor>> getProfesoresPorAsignatura() {
		return profesoresPorAsignatura;
	}

	public HashMap<Estudiante, LinkedList<Matricula>> getMatriculasEstudiante() {
		return matriculasEstudiante;
	}

	public TreeMap<String, ArrayList<Clase>> getClasesPorDia() {
		return clasesPorDia;
	}

	public TreeSet<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public LinkedHashSet<Aula> getAulas() {
		return aulas;
	}

	public ArrayList<Matricula> getTodasLasMatriculas() {
		return todasLasMatriculas;
	}
}
