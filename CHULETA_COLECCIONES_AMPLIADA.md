# CHULETA DE ESTUDIO - COLECCIONES JAVA

## TIPOS DE COLECCIONES PRINCIPALES

### 1. LISTAS (List)

**Explicación:** Las listas son colecciones ordenadas que permiten elementos duplicados. Mantienen el orden de inserción y permiten acceso por posición.

**Lógica:** Se usan cuando necesitas mantener un orden específico, permitir duplicados, o acceder a elementos por su índice.

**Ejemplo práctico (Examen Feria):**
```java
// Lista de consumiciones de un socio
LinkedList<Consumicion> consumiciones = new LinkedList<>();
consumiciones.add(new Consumicion(articulo, 2));
consumiciones.add(new Consumicion(otroArticulo, 1));

// Acceder por posición
Consumicion primera = consumiciones.get(0);
```

**Esqueleto de ejercicio:**
```java
public class GestionTareas {
    private ArrayList<String> tareasPendientes;
    
    public void añadirTarea(String tarea) {
        tareasPendientes.add(tarea);
    }
    
    public String obtenerTarea(int posicion) {
        return tareasPendientes.get(posicion);
    }
}
```

### 2. CONJUNTOS (Set)

**Explicación:** Los conjuntos no permiten elementos duplicados y no tienen orden garantizado (excepto LinkedHashSet y TreeSet).

**Lógica:** Se usan cuando necesitas garantizar unicidad de elementos y no te importa el orden (o necesitas orden específico).

**Ejemplo práctico (Examen Música):**
```java
// Conjunto de integrantes de un grupo (sin duplicados)
LinkedHashSet<Integrante> integrantes = new LinkedHashSet<>();
integrantes.add(new Integrante("Juan", "123A"));
integrantes.add(new Integrante("María", "456B"));

// Intentar añadir duplicado no funciona
boolean añadido = integrantes.add(new Integrante("Juan", "123A")); // false
```

**Esqueleto de ejercicio:**
```java
public class RegistroAsistencia {
    private HashSet<String> estudiantesPresentes;
    
    public boolean registrarEstudiante(String nombre) {
        return estudiantesPresentes.add(nombre); // true si no estaba, false si ya estaba
    }
    
    public boolean estaPresente(String nombre) {
        return estudiantesPresentes.contains(nombre);
    }
}
```

### 3. MAPAS (Map)

**Explicación:** Los mapas almacenan pares clave-valor. Cada clave es única y se asocia con un valor.

**Lógica:** Se usan cuando necesitas asociar datos con identificadores únicos, como diccionarios o bases de datos en memoria.

**Ejemplo práctico (Examen Feria):**
```java
// Mapa de precios de artículos
TreeMap<Articulo, Float> precios = new TreeMap<>();
precios.put(new Articulo("Cerveza", "Caña"), 2.5f);
precios.put(new Articulo("Tapa", "Pequeña"), 3.0f);

// Obtener precio
Float precio = precios.get(new Articulo("Cerveza", "Caña")); // 2.5f
```

**Esqueleto de ejercicio:**
```java
public class Diccionario {
    private HashMap<String, String> definiciones;
    
    public void añadirPalabra(String palabra, String definicion) {
        definiciones.put(palabra, definicion);
    }
    
    public String buscarDefinicion(String palabra) {
        return definiciones.get(palabra);
    }
}
```

## PATRONES FRECUENTES EN EXÁMENES

### PATRÓN 1: Mapa de colecciones anidadas

**Explicación:** Estructura donde cada clave del mapa apunta a otra colección, permitiendo agrupar elementos por categorías.

**Lógica:** Se usa para organizar datos jerárquicamente, como cuentas de usuarios con sus transacciones, o grupos con sus miembros.

**Ejemplo práctico (Examen Feria):**
```java
// Estructura: Socio -> Lista de sus consumiciones
HashMap<Socio, LinkedList<Consumicion>> cuentas = new HashMap<>();

// Añadir consumición a un socio
public void aniadirConsumicion(Socio socio, Articulo articulo, int cantidad) {
    if (!cuentas.containsKey(socio)) {
        cuentas.put(socio, new LinkedList<>());
    }
    cuentas.get(socio).add(new Consumicion(articulo, cantidad));
}
```

**Ejemplo práctico (Examen Torneo Videojuegos):**
```java
// Estructura: Equipo -> Conjunto de sus jugadores
TreeMap<Equipo, HashSet<Jugador>> jugadoresEquipo = new TreeMap<>();

// Añadir jugador a equipo (sin duplicados)
public boolean addJugadorAEquipo(Equipo equipo, Jugador jugador) {
    if (!jugadoresEquipo.containsKey(equipo)) {
        jugadoresEquipo.put(equipo, new HashSet<>());
    }
    return jugadoresEquipo.get(equipo).add(jugador);
}
```

**Esqueleto de ejercicio:**
```java
public class Biblioteca {
    // Autor -> Lista de sus libros
    private HashMap<String, ArrayList<Libro>> librosPorAutor;
    
    public void añadirLibro(String autor, Libro libro) {
        if (!librosPorAutor.containsKey(autor)) {
            librosPorAutor.put(autor, new ArrayList<>());
        }
        librosPorAutor.get(autor).add(libro);
    }
}
```

### PATRÓN 2: Búsqueda en estructuras complejas

**Explicación:** Recorrer mapas anidados para buscar información específica en múltiples niveles.

**Lógica:** Se usa cuando necesitas buscar datos que están organizados en varias capas de anidación.

**Ejemplo práctico (Examen Música):**
```java
// Buscar incidencias en un día específico
public List<String> getIncidencias(Fecha fecha) {
    ArrayList<String> incidencias = new ArrayList<>();
    
    // Recorrer cada local
    for (Map.Entry<Integer, TreeMap<FechaHora, String>> entrada : incidenciasLocales.entrySet()) {
        // Recorrer incidencias de ese local
        for (Map.Entry<FechaHora, String> entrada2 : entrada.getValue().entrySet()) {
            if (fecha.equals(entrada2.getKey())) {
                incidencias.add(entrada2.getValue());
            }
        }
    }
    return incidencias;
}
```

**Esqueleto de ejercicio:**
```java
public class SistemaVentas {
    // Tienda -> Año -> Ventas
    private HashMap<String, HashMap<Integer, Double>> ventasPorTienda;
    
    public double getTotalVentasAño(String tienda, int año) {
        double total = 0;
        if (ventasPorTienda.containsKey(tienda)) {
            HashMap<Integer, Double> ventasAño = ventasPorTienda.get(tienda);
            if (ventasAño.containsKey(año)) {
                total = ventasAño.get(año);
            }
        }
        return total;
    }
}
```

### PATRÓN 3: Eliminación segura con Iterator

**Explicación:** Usar Iterator para eliminar elementos mientras se recorre una colección sin causar ConcurrentModificationException.

**Lógica:** Es la única forma segura de modificar una colección mientras se itera sobre ella.

**Ejemplo práctico (Examen Música):**
```java
// Eliminar integrante por DNI
public boolean eliminaIntegrante(Grupo grupo, String dniIntegrante) {
    if (integrantes.containsKey(grupo)) {
        Iterator<Integrante> iterador = integrantes.get(grupo).iterator();
        while (iterador.hasNext()) {
            Integrante integrante = iterador.next();
            if (integrante.getDni().equals(dniIntegrante)) {
                iterador.remove(); // Eliminación segura
                return true;
            }
        }
    }
    return false;
}
```

**Esqueleto de ejercicio:**
```java
public class Inventario {
    private ArrayList<Producto> productos;
    
    public void eliminarProductosVencidos() {
        Iterator<Producto> iterador = productos.iterator();
        while (iterador.hasNext()) {
            Producto producto = iterador.next();
            if (producto.estaVencido()) {
                iterador.remove(); // Eliminación segura
            }
        }
    }
}
```

### PATRÓN 5: Búsqueda de relaciones bidireccionales

**Explicación:** Detectar relaciones mutuas entre elementos en una colección, como enfrentamientos recíprocos o conexiones en ambos sentidos.

**Lógica:** Se usa para encontrar pares de elementos que tienen una relación en ambas direcciones.

**Ejemplo práctico (Examen Torneo Videojuegos):**
```java
// Detectar si existen enfrentamientos repetidos (A vs B y B vs A)
public boolean hayEnfrentamientosRepetidos() {
    for (int i = 0; i < partidas.size() - 1; i++) {
        Partida partida1 = partidas.get(i);
        for (int j = i + 1; j < partidas.size(); j++) {
            Partida partida2 = partidas.get(j);
            
            // Comprobar si son enfrentamientos inversos
            if (partida1.getEquipo1().equals(partida2.getEquipo2()) && 
                partida2.getEquipo1().equals(partida1.getEquipo2())) {
                return true;
            }
        }
    }
    return false;
}
```

**Esqueleto de ejercicio:**
```java
public class RedSocial {
    private ArrayList<Conexion> conexiones;
    
    public boolean hayAmistadReciproca() {
        for (int i = 0; i < conexiones.size() - 1; i++) {
            Conexion conn1 = conexiones.get(i);
            for (int j = i + 1; j < conexiones.size(); j++) {
                Conexion conn2 = conexiones.get(j);
                
                if (conn1.getPersona1().equals(conn2.getPersona2()) && 
                    conn2.getPersona1().equals(conn1.getPersona2())) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

### PATRÓN 6: Obtener elementos únicos de colecciones

**Explicación:** Extraer elementos únicos de una colección que puede tener duplicados, usando un Set para eliminar repeticiones.

**Lógica:** Se usa para obtener listas de elementos distintos sin duplicados a partir de datos repetidos.

**Ejemplo práctico (Examen Torneo Videojuegos):**
```java
// Obtener todos los juegos distintos jugados
public HashSet<String> juegosJugados() {
    HashSet<String> juegos = new HashSet<>();
    
    for (Partida partida : partidas) {
        juegos.add(partida.getJuego()); // Set elimina duplicados automáticamente
    }
    
    return juegos;
}

// Obtener equipos ganadores (sin duplicados)
public TreeSet<Equipo> equiposGanadores() {
    TreeSet<Equipo> equiposGanadores = new TreeSet<>();
    
    for (Partida partida : partidas) {
        equiposGanadores.add(partida.getGanador()); // TreeSet ordena y elimina duplicados
    }
    
    return equiposGanadores;
}
```

**Esqueleto de ejercicio:**
```java
public class AnalizadorVentas {
    private ArrayList<Venta> ventas;
    
    public HashSet<String> getProductosVendidos() {
        HashSet<String> productos = new HashSet<>();
        
        for (Venta venta : ventas) {
            productos.add(venta.getProducto());
        }
        
        return productos;
    }
    
    public TreeSet<String> getClientesOrdenados() {
        TreeSet<String> clientes = new TreeSet<>();
        
        for (Venta venta : ventas) {
            clientes.add(venta.getCliente());
        }
        
        return clientes;
    }
}
```

### PATRÓN 4: Conteo de frecuencias

**Explicación:** Usar un mapa para contar cuántas veces aparece cada elemento en una colección.

**Lógica:** Se usa para estadísticas, análisis de datos, encontrar elementos más comunes, etc.

**Ejemplo práctico (Examen Música):**
```java
// Contar tipos de música más populares
public TipoMusica getTipoMusicaMasGrupos() {
    Map<TipoMusica, Integer> contador = new HashMap<>();
    
    // Contar cuántos grupos hay de cada tipo
    for (Grupo grupo : integrantes.keySet()) {
        contador.put(grupo.getTipoMusica(), 
            contador.getOrDefault(grupo.getTipoMusica(), 0) + 1);
    }
    
    // Encontrar el tipo con más grupos
    TipoMusica tipoMasPopular = null;
    int maxCount = 0;
    for (Map.Entry<TipoMusica, Integer> entry : contador.entrySet()) {
        if (entry.getValue() > maxCount) {
            maxCount = entry.getValue();
            tipoMasPopular = entry.getKey();
        }
    }
    return tipoMasPopular;
}
```

**Ejemplo práctico (Examen Torneo Videojuegos):**
```java
// Encontrar el equipo con más jugadores
public Equipo equipoConMasJugadores() {
    Equipo equipoConMasJugadores = null;
    int maxNumJugadores = 0;
    
    for (Map.Entry<Equipo, HashSet<Jugador>> entry : jugadoresEquipo.entrySet()) {
        int tamañoEquipo = entry.getValue().size();
        
        if (tamañoEquipo > maxNumJugadores) {
            maxNumJugadores = tamañoEquipo;
            equipoConMasJugadores = entry.getKey();
        }
    }
    
    return equipoConMasJugadores;
}
```

**Esqueleto de ejercicio:**
```java
public class AnalizadorTexto {
    public String palabraMasFrecuente(String texto) {
        String[] palabras = texto.split(" ");
        HashMap<String, Integer> frecuencias = new HashMap<>();
        
        // Contar frecuencia de cada palabra
        for (String palabra : palabras) {
            frecuencias.put(palabra, 
                frecuencias.getOrDefault(palabra, 0) + 1);
        }
        
        // Encontrar la más frecuente
        String masFrecuente = null;
        int maxFrecuencia = 0;
        for (Map.Entry<String, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                masFrecuente = entry.getKey();
            }
        }
        return masFrecuente;
    }
}
```

## OPERACIONES COMUNES DETALLADAS

### VERIFICAR EXISTENCIA

**Explicación:** Comprobar si un elemento o clave existe en una colección antes de operar con él.

**Lógica:** Evita errores como NullPointerException o intentar acceder a elementos que no existen.

**Ejemplo práctico:**
```java
// Verificar si un artículo tiene precio asignado
public boolean tienePrecio(Articulo articulo) {
    return listaPrecios.containsKey(articulo);
}

// Verificar si un socio ya está registrado
public boolean estaRegistrado(Socio socio) {
    return listaSocios.contains(socio);
}

// Verificar si hay consumiciones pendientes
public boolean tieneConsumicionesPendientes(Socio socio) {
    return listaCuentas.containsKey(socio) && !listaCuentas.get(socio).isEmpty();
}
```

**Esqueleto de ejercicio:**
```java
public class SistemaReservas {
    private HashMap<String, Boolean> asientosDisponibles;
    
    public boolean reservarAsiento(String numeroAsiento) {
        if (asientosDisponibles.containsKey(numeroAsiento)) {
            if (asientosDisponibles.get(numeroAsiento)) {
                asientosDisponibles.put(numeroAsiento, false);
                return true; // Reserva exitosa
            }
        }
        return false; // Asiento no existe u ocupado
    }
}
```

### AÑADIR ELEMENTOS

**Explicación:** Insertar nuevos elementos en las colecciones, manejando posibles restricciones como duplicados.

**Lógica:** Cada tipo de colección tiene sus propias reglas para añadir elementos.

**Ejemplo práctico:**
```java
// Añadir nuevo artículo con control de duplicados
public boolean aniadeArticulo(String nombre, String tamanio, float precio) {
    Articulo nuevoArticulo = new Articulo(nombre, tamanio);
    
    if (listaPrecios.containsKey(nuevoArticulo)) {
        listaPrecios.put(nuevoArticulo, precio); // Actualizar precio
        return false; // Ya existía
    }
    
    listaPrecios.put(nuevoArticulo, precio); // Nuevo artículo
    return true;
}

// Añadir integrante a grupo (control de duplicados con Set)
public boolean addIntegrante(Grupo grupo, Integrante integrante) {
    if (!integrantes.containsKey(grupo)) {
        integrantes.put(grupo, new LinkedHashSet<>());
    }
    return integrantes.get(grupo).add(integrante); // false si ya existía
}
```

**Ejemplo práctico (Examen Torneo Videojuegos):**
```java
// Añadir equipo (TreeSet evita duplicados por nombre)
public boolean addEquipo(Equipo equipo) {
    return equipos.add(equipo); // false si ya existe equipo con mismo nombre
}

// Añadir jugador a equipo (HashSet evita duplicados por nick)
public boolean addJugadorAEquipo(Equipo equipo, Jugador jugador) {
    if (!jugadoresEquipo.containsKey(equipo)) {
        jugadoresEquipo.put(equipo, new HashSet<>());
    }
    return jugadoresEquipo.get(equipo).add(jugador); // false si nick duplicado
}
```

**Esqueleto de ejercicio:**
```java
public class CarritoCompras {
    private HashMap<Producto, Integer> items;
    
    public boolean añadirProducto(Producto producto, int cantidad) {
        if (items.containsKey(producto)) {
            items.put(producto, items.get(producto) + cantidad);
        } else {
            items.put(producto, cantidad);
        }
        return true;
    }
}
```

### RECORRER COLECCIONES

**Explicación:** Iterar sobre los elementos de una colección para procesarlos uno por uno.

**Lógica:** Existen múltiples formas de recorrer colecciones, cada una con sus ventajas.

**Ejemplo práctico:**
```java
// For-each simple (para listas y conjuntos)
public void mostrarTodosLosSocios() {
    for (Socio socio : listaSocios) {
        System.out.println(socio.getNombre());
    }
}

// Recorrer mapa con entrySet (acceso a clave y valor)
public String calculaTotalCuenta(Socio socio) {
    Float sumaPrecios = 0F;
    LinkedList<Consumicion> consumiciones = listaCuentas.get(socio);
    
    for (Consumicion consumicion : consumiciones) {
        Float precioUnitario = listaPrecios.get(consumicion.getArticulo());
        sumaPrecios += precioUnitario * consumicion.getCantidad();
    }
    return sumaPrecios.toString();
}

// Recorrer mapa con keySet (solo necesitamos las claves)
public void mostrarCuentasPendientes() {
    for (Socio socio : listaCuentas.keySet()) {
        System.out.println("Socio: " + socio.getNombre());
        System.out.println("Total: " + calculaTotalCuenta(socio));
    }
}
```

**Esqueleto de ejercicio:**
```java
public class ReporteVentas {
    private ArrayList<Venta> ventas;
    
    public double calcularTotalVentas() {
        double total = 0;
        for (Venta venta : ventas) {
            total += venta.getMonto();
        }
        return total;
    }
    
    public void mostrarVentasPorCliente(HashMap<String, ArrayList<Venta>> ventasPorCliente) {
        for (Map.Entry<String, ArrayList<Venta>> entry : ventasPorCliente.entrySet()) {
            System.out.println("Cliente: " + entry.getKey());
            for (Venta venta : entry.getValue()) {
                System.out.println("  - " + venta.getProducto() + ": $" + venta.getMonto());
            }
        }
    }
}
```

### OBTENER SUBCOLECCIONES

**Explicación:** Crear nuevas colecciones filtrando elementos que cumplen ciertos criterios.

**Lógica:** Se usa cuando necesitas trabajar con un subconjunto de datos que cumplen condiciones específicas.

**Ejemplo práctico:**
```java
// Obtener todas las líneas aéreas que vuelan a una localidad
public TreeSet<LineaAerea> lineasHasta(Localidad localidad) {
    TreeSet<LineaAerea> lineasDestino = new TreeSet<>();
    
    // Recorrer todas las localidades de origen
    for (Localidad origen : conexiones.keySet()) {
        // Recorrer todos los vuelos desde ese origen
        for (Vuelo vuelo : conexiones.get(origen)) {
            if (vuelo.getDestino().equals(localidad)) {
                lineasDestino.add(vuelo.getLinea());
            }
        }
    }
    return lineasDestino;
}

// Obtener grupos con incidencias en sus locales alquilados
public HashSet<Grupo> getGruposConAlquileresEnLocalesIncidencia() {
    HashSet<Grupo> gruposConIncidencias = new HashSet<>();
    
    for (Alquiler alquiler : alquileres) {
        if (incidenciasLocales.containsKey(alquiler.getCodLocal())) {
            gruposConIncidencias.add(alquiler.getGrupo());
        }
    }
    return gruposConIncidencias;
}
```

**Esqueleto de ejercicio:**
```java
public class FiltradorProductos {
    private ArrayList<Producto> todosLosProductos;
    
    public ArrayList<Producto> getProductosPorCategoria(String categoria) {
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        
        for (Producto producto : todosLosProductos) {
            if (producto.getCategoria().equals(categoria)) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
    
    public ArrayList<Producto> getProductosEnRangoPrecio(double min, double max) {
        ArrayList<Producto> productosRango = new ArrayList<>();
        
        for (Producto producto : todosLosProductos) {
            if (producto.getPrecio() >= min && producto.getPrecio() <= max) {
                productosRango.add(producto);
            }
        }
        return productosRango;
    }
}
```

## CLASES PERSONALIZADAS QUE EXTIENDEN COLECCIONES

**Explicación:** Crear clases que heredan de colecciones existentes para añadir funcionalidad específica.

**Lógica:** Se usa cuando necesitas una colección con comportamiento personalizado pero manteniendo toda la funcionalidad de la colección base.

**Ejemplo práctico (Examen Feria):**
```java
// Lista de precios especializada
public class ListaPrecios extends TreeMap<Articulo, Float> {
    
    // Método personalizado para añadir con control
    public boolean addArticuloSiNoExiste(Articulo articulo, float precio) {
        if (this.containsKey(articulo)) {
            return false; // Ya existe
        }
        this.put(articulo, precio);
        return true; // Añadido correctamente
    }
    
    // Método para obtener precio con valor por defecto
    public float getPrecio(Articulo articulo) {
        return this.getOrDefault(articulo, 0.0f);
    }
}

// Lista de socios especializada
public class ListaSocios extends LinkedList<Socio> {
    
    // Método para buscar por nombre
    public Socio buscarPorNombre(String nombre) {
        for (Socio socio : this) {
            if (socio.getNombre().equals(nombre)) {
                return socio;
            }
        }
        return null; // No encontrado
    }
    
    // Método para obtener socios con deudas
    public LinkedList<Socio> getSociosConDeudas(HashMap<Socio, LinkedList<Consumicion>> cuentas) {
        LinkedList<Socio> deudores = new LinkedList<>();
        
        for (Socio socio : this) {
            if (cuentas.containsKey(socio) && !cuentas.get(socio).isEmpty()) {
                deudores.add(socio);
            }
        }
        return deudores;
    }
}
```

**Esqueleto de ejercicio:**
```java
public class ListaTareasPrioritarias extends ArrayList<Tarea> {
    
    // Añadir tarea solo si no existe otra con misma descripción
    public boolean addTareaUnica(Tarea tarea) {
        for (Tarea existente : this) {
            if (existente.getDescripcion().equals(tarea.getDescripcion())) {
                return false; // Ya existe una tarea igual
            }
        }
        return this.add(tarea);
    }
    
    // Obtener tareas por prioridad
    public ArrayList<Tarea> getTareasPorPrioridad(int prioridad) {
        ArrayList<Tarea> tareasPrioridad = new ArrayList<>();
        
        for (Tarea tarea : this) {
            if (tarea.getPrioridad() == prioridad) {
                tareasPrioridad.add(tarea);
            }
        }
        return tareasPrioridad;
    }
    
    // Marcar tarea como completada
    public boolean completarTarea(String descripcion) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getDescripcion().equals(descripcion)) {
                this.get(i).setCompletada(true);
                return true;
            }
        }
        return false; // No encontrada
    }
}
```

## IMPORTACIONES NECESARIAS

```java
// Listas
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Conjuntos
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

// Mapas
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Iteración y utilidades
import java.util.Iterator;
import java.util.Map.Entry;
```

## IMPLEMENTACIÓN DE equals() y hashCode() - CLAVE PARA COLECCIONES

**Explicación:** Estos métodos son fundamentales para que funcionen correctamente las colecciones basadas en hash (HashSet, HashMap) y ordenación (TreeSet, TreeMap).

**Lógica:** 
- `equals()` determina si dos objetos son "iguales" según tus criterios
- `hashCode()` genera un número que debe ser igual para objetos iguales
- Si equals() devuelve true, hashCode() debe devolver el mismo valor

**Ejemplo práctico (Examen Torneo Videojuegos):**

**Clase Equipo:**
```java
public class Equipo implements Comparable<Equipo> {
    private String nombre;
    private String pais;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        
        Equipo e = (Equipo) o;
        return nombre.equals(e.nombre); // Dos equipos son iguales si tienen mismo nombre
    }

    @Override
    public int hashCode() {
        return nombre.hashCode(); // Hash basado en el nombre
    }

    @Override
    public int compareTo(Equipo o) {
        return nombre.compareTo(o.nombre); // Ordenación por nombre
    }
}
```

**Clase Jugador:**
```java
public class Jugador {
    private String nombre;
    private int edad;
    private String nick;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;
        
        Jugador j = (Jugador) o;
        return nick.equals(j.nick); // Dos jugadores son iguales si tienen mismo nick
    }

    @Override
    public int hashCode() {
        return nick.hashCode(); // Hash basado en el nick
    }
}
```

**Esqueleto de ejercicio:**
```java
public class Producto implements Comparable<Producto> {
    private String codigo;
    private String nombre;
    private double precio;

    // Dos productos son iguales si tienen mismo código
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        
        Producto p = (Producto) o;
        return codigo.equals(p.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    // Ordenación por precio (ascendente)
    @Override
    public int compareTo(Producto o) {
        return Double.compare(this.precio, o.precio);
    }
}
```

**Consejos importantes:**
1. **Consistencia:** Si equals() es true, hashCode() debe ser igual
2. **Inmutabilidad:** Usa campos inmutables (como String, Integer) para equals/hashCode
3. **Consistencia con compareTo:** Si implementas Comparable, compareTo debe ser consistente con equals
4. **IDE:** La mayoría de IDEs pueden generar estos métodos automáticamente

## CONSEJOS PARA EXÁMENES

1. **Elige la colección adecuada:**
   - ¿Necesitas orden? → TreeSet/TreeMap
   - ¿Necesitas rapidez? → HashSet/HashMap  
   - ¿Necesitas duplicados? → ArrayList/LinkedList
   - ¿Necesitas acceso por índice? → ArrayList

2. **Usa tipos genéricos siempre:** `ArrayList<String>`, no `ArrayList`

3. **Inicializa las colecciones anidadas** antes de usarlas

4. **Para eliminar mientras recorres**, usa Iterator

5. **Verifica null** antes de operar con `get()` de mapas

6. **Implementa equals() y hashCode()** en tus clases personalizadas

7. **Usa containsKey() antes de get()** para evitar NullPointerException

8. **Recuerda que add() en Set devuelve boolean** (true si se añadió, false si ya existía)

9. **Para ordenar colecciones**, usa TreeSet o Collections.sort()

10. **Documenta tus métodos** indicando qué devuelven en cada caso

11. **Para búsquedas complejas**, considera bucles anidados con Map.Entry

12. **Para eliminar duplicados**, usa colecciones Set automáticamente

13. **Para contar elementos**, usa HashMap con getOrDefault()

14. **Para relaciones bidireccionales**, usa bucles anidados comparando pares inversos
