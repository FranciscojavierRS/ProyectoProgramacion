# EXAMEN: CAMPUS UNIVERSITARIO - COLECCIONES

## DESCRIPCIÓN DEL DOMINIO

Debes implementar una aplicación para gestionar las matrículas y recursos de un campus universitario. El sistema debe manejar estudiantes, profesores, asignaturas, aulas y las relaciones entre ellos utilizando diferentes tipos de colecciones.

## CLASES DISPONIBLES

- **Estudiante**: Representa a un estudiante con DNI, nombre, apellidos y edad
- **Profesor**: Representa a un profesor con código, nombre y departamento  
- **Asignatura**: Representa una asignatura con código, nombre, créditos y facultad
- **Aula**: Representa un aula con código, capacidad, edificio y si tiene proyector
- **Matricula**: Relaciona un estudiante con una asignatura, incluyendo nota y convocatoria
- **Clase**: Representa una clase específica con asignatura, profesor, aula, día y hora

## ESTRUCTURA DE DATOS PRINCIPAL

La clase `Modelo` contiene las siguientes estructuras:

```java
private TreeMap<Asignatura, HashSet<Profesor>> profesoresPorAsignatura;
private HashMap<Estudiante, LinkedList<Matricula>> matriculasEstudiante;
private TreeMap<String, ArrayList<Clase>> clasesPorDia;
private TreeSet<Estudiante> estudiantes;
private LinkedHashSet<Aula> aulas;
private ArrayList<Matricula> todasLasMatriculas;
```

## MÉTODOS A IMPLEMENTAR

### 1. Mapa de colecciones anidadas (PATRÓN 1)
**Método**: `addProfesorAsignatura(Asignatura asignatura, Profesor profesor)`

**Tarea**: Añade un profesor a una asignatura. Si la asignatura no existe en el mapa, se crea el conjunto. No se permiten profesores duplicados para la misma asignatura. Devuelve true si se añadió correctamente, false si ya existía.

**Conceptos**: TreeMap, HashSet, containsKey, put, add, valor de retorno boolean

---

### 2. Verificación y adición en estructuras anidadas (PATRÓN 2)
**Método**: `matricularEstudiante(Estudiante estudiante, Asignatura asignatura, double nota, String convocatoria)`

**Tarea**: Matricula un estudiante en una asignatura con una nota inicial. Si el estudiante no tiene matrículas previas, se crea su lista. También añade la matrícula a la lista general de todas las matrículas. Devuelve true si se matriculó correctamente.

**Conceptos**: HashMap, LinkedList, containsKey, put, add, constructor de Matricula

---

### 3. Búsqueda en estructuras complejas (PATRÓN 3)
**Método**: `getClasesPorDia(String dia)`

**Tarea**: Devuelve todas las clases que se imparten en un día específico. Si no hay clases ese día, devuelve una lista vacía.

**Conceptos**: TreeMap, get, getOrDefault, ArrayList

---

### 4. Conteo de frecuencias (PATRÓN 4)
**Método**: `profesorConMasAsignaturas()`

**Tarea**: Devuelve el profesor con más asignaturas impartidas. Si hay empate, devuelve cualquiera de los profesores con más asignaturas. Si no hay profesores, devuelve null.

**Conceptos**: Recorrido de mapa anidado, HashMap contador, máximo, bucles anidados

---

### 5. Eliminación segura con Iterator (PATRÓN 5)
**Método**: `eliminarMatriculasSuspensas(Estudiante estudiante)`

**Tarea**: Elimina todas las matrículas suspensas (nota < 5.0) de un estudiante. Devuelve el número de matrículas eliminadas. Si el estudiante no existe, devuelve 0.

**Conceptos**: Iterator, eliminación segura, containsKey, remove, contador

---

### 6. Obtener elementos únicos de colecciones (PATRÓN 6)
**Método**: `getFacultadesConAsignaturas()`

**Tarea**: Devuelve un conjunto con todas las facultades distintas en las que hay asignaturas. Usa un TreeSet para mantener orden alfabético.

**Conceptos**: TreeSet, keySet, eliminación automática de duplicados, ordenación

---

### 7. Búsqueda de relaciones bidireccionales (PATRÓN 7)
**Método**: `haySolapamientoHorarios()`

**Tarea**: Verifica si existe un solapamiento de horarios: dos clases en el mismo aula, mismo día y misma hora con asignaturas/profesores diferentes. Devuelve true si hay solapamiento, false en caso contrario.

**Conceptos**: Bucles anidados, comparación de objetos, equals, búsqueda bidireccional

---

### 8. Filtrado y subcolecciones (PATRÓN 8)
**Método**: `getEstudiantesPorFacultad(String facultad)`

**Tarea**: Devuelve todos los estudiantes matriculados en asignaturas de una facultad específica. Usa un LinkedHashSet para mantener orden de inserción sin duplicados.

**Conceptos**: LinkedHashSet, filtrado, bucles anidados, contains, add

---

### 9. Cálculo de estadísticas (PATRÓN 9)
**Método**: `getNotaMediaAsignatura(Asignatura asignatura)`

**Tarea**: Calcula la nota media de todas las matrículas de una asignatura. Si no hay matrículas para esa asignatura, devuelve 0.0.

**Conceptos**: Recorrido de colecciones, suma, contador, división, control de división por cero

---

### 10. Clases personalizadas que extienden colecciones (PATRÓN 10)
**Método**: `addAula(Aula aula)`

**Tarea**: Añade un aula al conjunto de aulas. Si ya existe un aula con el mismo código, no la añade y devuelve false. Devuelve true si se añadió correctamente.

**Conceptos**: LinkedHashSet, add, valor de retorno boolean, equals/hashCode

---

### 11. Búsqueda por criterios complejos (PATRÓN 11)
**Método**: `getAsignaturasProfesorPorCreditos(Profesor profesor, int creditosMinimos)`

**Tarea**: Devuelve todas las asignaturas que imparte un profesor y que son de más de X créditos. Si el profesor no tiene asignaturas, devuelve un conjunto vacío.

**Conceptos**: Recorrido de mapa, filtrado por condición, HashSet, comparación de valores

---

### 12. Verificación de existencia en mapas anidados (PATRÓN 12)
**Método**: `estaMatriculadoEn(Estudiante estudiante, Asignatura asignatura)`

**Tarea**: Verifica si un estudiante está matriculado en una asignatura específica. Devuelve true si está matriculado, false en caso contrario.

**Conceptos**: HashMap, containsKey, LinkedList, equals, búsqueda en colección

---

### 13. Recorrido y transformación de datos (PATRÓN 13)
**Método**: `getNumeroEstudiantesPorFacultad()`

**Tarea**: Devuelve un mapa con el número de estudiantes por facultad. La clave es el nombre de la facultad y el valor es el número de estudiantes.

**Conceptos**: HashMap, getOrDefault, conteo, transformación de datos, agrupación

---

### 14. Búsqueda de elementos extremos (PATRÓN 14)
**Método**: `getMatriculaNotaMasAlta()`

**Tarea**: Devuelve la matrícula con la nota más alta de todas las registradas. Si hay empate, devuelve cualquiera de las notas más altas. Si no hay matrículas, devuelve null.

**Conceptos**: Búsqueda de máximo, comparación de valores, control de colección vacía

---

## REQUISITOS IMPORTANTES

1. **IMPORTACIONES**: Asegúrate de importar todas las clases de colecciones necesarias
2. **EQUALS/HASHCODE**: Todas las clases ya tienen implementados estos métodos correctamente
3. **COMPARABLE**: Las clases que necesitan ordenación implementan Comparable
4. **MANEJO DE NULL**: Considera casos donde las estructuras puedan estar vacías o contener null
5. **DOCUMENTACIÓN**: Cada método debe tener comentarios explicando la lógica implementada

## CONSEJOS PARA EL EXAMEN

- Revisa la chuleta de colecciones ampliada para ver patrones similares
- Usa `containsKey()` antes de `get()` en mapas para evitar NullPointerException
- Para eliminar elementos mientras recorres colecciones, usa siempre Iterator
- Recuerda que `add()` en Set devuelve boolean (true si se añadió, false si ya existía)
- Usa `getOrDefault()` para simplificar código con valores por defecto
- Para contar frecuencias, usa HashMap con `getOrDefault()` o `computeIfAbsent()`

¡Mucha suerte!
