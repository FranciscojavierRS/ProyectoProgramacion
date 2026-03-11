package Examen_CampusUniversitario_Colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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
     * PATRÓN 1: Mapa de colecciones anidadas
     * Añade un profesor a una asignatura.
     * Si la asignatura no existe en el mapa, se crea el conjunto.
     * No se permiten profesores duplicados para la misma asignatura.
     * Devuelve true si se añadió correctamente, false si ya existía.
     */
    public boolean addProfesorAsignatura(Asignatura asignatura, Profesor profesor) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 2: Verificación y adición en estructuras anidadas
     * Matricula un estudiante en una asignatura con una nota inicial.
     * Si el estudiante no tiene matrículas previas, se crea su lista.
     * También añade la matrícula a la lista general de todas las matrículas.
     * Devuelve true si se matriculó correctamente.
     */
    public boolean matricularEstudiante(Estudiante estudiante, Asignatura asignatura, double nota, String convocatoria) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 3: Búsqueda en estructuras complejas
     * Devuelve todas las clases que se imparten en un día específico.
     * Si no hay clases ese día, devuelve una lista vacía.
     */
    public ArrayList<Clase> getClasesPorDia(String dia) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 4: Conteo de frecuencias
     * Devuelve el profesor con más asignaturas impartidas.
     * Si hay empate, devuelve cualquiera de los profesores con más asignaturas.
     * Si no hay profesores, devuelve null.
     */
    public Profesor profesorConMasAsignaturas() {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 5: Eliminación segura con Iterator
     * Elimina todas las matrículas suspensas (nota < 5.0) de un estudiante.
     * Devuelve el número de matrículas eliminadas.
     * Si el estudiante no existe, devuelve 0.
     */
    public int eliminarMatriculasSuspensas(Estudiante estudiante) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 6: Obtener elementos únicos de colecciones
     * Devuelve un conjunto con todas las facultades distintas en las que hay asignaturas.
     * Usa un TreeSet para mantener orden alfabético.
     */
    public TreeSet<String> getFacultadesConAsignaturas() {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 7: Búsqueda de relaciones bidireccionales
     * Verifica si existe un solapamiento de horarios:
     * Dos clases en el mismo aula, mismo día y misma hora con asignaturas/profesores diferentes.
     * Devuelve true si hay solapamiento, false en caso contrario.
     */
    public boolean haySolapamientoHorarios() {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 8: Filtrado y subcolecciones
     * Devuelve todos los estudiantes matriculados en asignaturas de una facultad específica.
     * Usa un LinkedHashSet para mantener orden de inserción sin duplicados.
     */
    public LinkedHashSet<Estudiante> getEstudiantesPorFacultad(String facultad) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 9: Cálculo de estadísticas
     * Calcula la nota media de todas las matrículas de una asignatura.
     * Si no hay matrículas para esa asignatura, devuelve 0.0.
     */
    public double getNotaMediaAsignatura(Asignatura asignatura) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 10: Clases personalizadas que extienden colecciones
     * Añade un aula al conjunto de aulas.
     * Si ya existe un aula con el mismo código, no la añade y devuelve false.
     * Devuelve true si se añadió correctamente.
     */
    public boolean addAula(Aula aula) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 11: Búsqueda por criterios complejos
     * Devuelve todas las asignaturas que imparte un profesor y que son de más de X créditos.
     * Si el profesor no tiene asignaturas, devuelve un conjunto vacío.
     */
    public HashSet<Asignatura> getAsignaturasProfesorPorCreditos(Profesor profesor, int creditosMinimos) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 12: Verificación de existencia en mapas anidados
     * Verifica si un estudiante está matriculado en una asignatura específica.
     * Devuelve true si está matriculado, false en caso contrario.
     */
    public boolean estaMatriculadoEn(Estudiante estudiante, Asignatura asignatura) {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 13: Recorrido y transformación de datos
     * Devuelve un mapa con el número de estudiantes por facultad.
     * La clave es el nombre de la facultad y el valor es el número de estudiantes.
     */
    public HashMap<String, Integer> getNumeroEstudiantesPorFacultad() {
        // TODO: Implementar este método
    }

    /*
     * PATRÓN 14: Búsqueda de elementos extremos
     * Devuelve la matrícula con la nota más alta de todas las registradas.
     * Si hay empate, devuelve cualquiera de las notas más altas.
     * Si no hay matrículas, devuelve null.
     */
    public Matricula getMatriculaNotaMasAlta() {
        // TODO: Implementar este método
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
