# CHULETA DE ESTUDIO - COLECCIONES JAVA

## TIPOS DE COLECCIONES PRINCIPALES

### 1. LISTAS (List)
- **ArrayList**: Acceso rápido por índice, tamaño dinámico
- **LinkedList**: Inserción/eliminación rápida, acceso secuencial

**Uso común:**
```java
ArrayList<Alquiler> alquileres = new ArrayList<>();
LinkedList<Consumicion> consumiciones = new LinkedList<>();
```

### 2. CONJUNTOS (Set)
- **HashSet**: Rápido, no ordenado, sin duplicados
- **LinkedHashSet**: Orden de inserción, sin duplicados
- **TreeSet**: Orden natural, sin duplicados

**Uso común:**
```java
HashSet<Grupo> grupos = new HashSet<>();
LinkedHashSet<Integrante> integrantes = new LinkedHashSet<>();
TreeSet<LineaAerea> lineas = new TreeSet<>();
```

### 3. MAPAS (Map)
- **HashMap**: Rápido, sin orden
- **TreeMap**: Ordenado por clave
- **LinkedHashMap**: Orden de inserción

**Uso común:**
```java
HashMap<Socio, LinkedList<Consumicion>> cuentas;
TreeMap<Grupo, LinkedHashSet<Integrante>> integrantes;
TreeMap<Localidad, HashSet<Vuelo>> conexiones;
```

## PATRONES FRECUENTES EN EXÁMENES

### PATRÓN 1: Mapa de colecciones anidadas
```java
// Estructura: Clave -> Colección de objetos
HashMap<Socio, LinkedList<Consumicion>> listaCuentas;

// Añadir elemento
if (!mapa.containsKey(clave)) {
    mapa.put(clave, new LinkedList<>());
}
mapa.get(clave).add(elemento);
```

### PATRÓN 2: Búsqueda en estructuras complejas
```java
// Recorrer mapa de mapas
for (Map.Entry<Integer, TreeMap<FechaHora, String>> entrada : incidenciasLocales.entrySet()) {
    for (Map.Entry<FechaHora, String> entrada2 : entrada.getValue().entrySet()) {
        // Procesar cada entrada
    }
}
```

### PATRÓN 3: Eliminación segura con Iterator
```java
Iterator<Integrante> iterador = conjunto.iterator();
while (iterador.hasNext()) {
    Integrante integrante = iterador.next();
    if (condicion) {
        iterador.remove(); // Eliminación segura
    }
}
```

### PATRÓN 4: Conteo de frecuencias
```java
Map<TipoMusica, Integer> contador = new HashMap<>();
for (Grupo grupo : grupos) {
    contador.put(grupo.getTipoMusica(), 
        contador.getOrDefault(grupo.getTipoMusica(), 0) + 1);
}
```

## OPERACIONES COMUNES

### VERIFICAR EXISTENCIA
```java
if (mapa.containsKey(clave)) { ... }
if (conjunto.contains(elemento)) { ... }
if (lista.contains(elemento)) { ... }
```

### AÑADIR ELEMENTOS
```java
lista.add(elemento);
conjunto.add(elemento); // Devuelve boolean
mapa.put(clave, valor);
```

### RECORRER COLECCIONES
```java
// For-each
for (Elemento e : coleccion) { ... }

// Con entrySet (mapas)
for (Map.Entry<Clave, Valor> entry : mapa.entrySet()) {
    Clave clave = entry.getKey();
    Valor valor = entry.getValue();
}

// Con keySet (mapas)
for (Clave clave : mapa.keySet()) {
    Valor valor = mapa.get(clave);
}
```

### OBTENER SUBCOLECCIONES
```java
// Filtrar elementos
ArrayList<String> resultados = new ArrayList<>();
for (Elemento e : coleccion) {
    if (condicion) {
        resultados.add(e.toString());
    }
}
return resultados;
```

## CLASES PERSONALIZADAS QUE EXTIENDEN COLECCIONES

```java
// Extender TreeMap
public class ListaPrecios extends TreeMap<Articulo, Float> {
    // Hereda todos los métodos de TreeMap
}

// Extender LinkedList  
public class ListaSocios extends LinkedList<Socio> {
    // Hereda todos los métodos de LinkedList
}
```

## IMPORTACIONES NECESARIAS

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
```

## CONSEJOS PARA EXÁMENES

1. **Elige la colección adecuada** según necesites:
   - ¿Necesitas orden? → TreeSet/TreeMap
   - ¿Necesitas rapidez? → HashSet/HashMap  
   - ¿Necesitas duplicados? → ArrayList/LinkedList
   - ¿Necesitas acceso por índice? → ArrayList

2. **Usa tipos genéricos** siempre: `ArrayList<String>`, no `ArrayList`

3. **Inicializa las colecciones anidadas** antes de usarlas

4. **Para eliminar mientras recorres**, usa Iterator

5. **Verifica null** antes de operar con `get()` de mapas

6. **Implementa equals() y hashCode()** en tus clases personalizadas
