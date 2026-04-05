# GUÍA DE PATRONES DE COLECCIONES - EXÁMENES

## 📋 INTRODUCCIÓN

Esta guía contiene los patrones más comunes que aparecen en los exámenes de colecciones. Para cada patrón, te digo exactamente qué hacer y te doy código copiable y pegable.

---

## 🎯 PATRÓN 1: AÑADIR A MAPA DE COLECCIONES ANIDADAS

**Si te piden:** "Añade X a Y, y si Y no existe créalo"

**Tienes que hacer:** Usar `containsKey()` + `put()` + `add()` en mapa anidado

**Explicación:** Es el patrón más común. Verificas si la clave existe, si no creas la colección, luego añades el elemento.

**Código copiable:**
```java
public boolean addElementoAColeccion(Clave clave, Elemento elemento) {
    // 1. Verificar si la clave ya existe en el mapa
    if (!mapa.containsKey(clave)) {
        // 2. Si no existe, crear nueva colección para esa clave
        mapa.put(clave, new HashSet<Elemento>()); // o ArrayList, LinkedList, etc.
    }
    // 3. Añadir el elemento a la colección de esa clave
    return mapa.get(clave).add(elemento); // add() devuelve boolean
}
```

**Ejemplo real (Examen Música):**
```java
public boolean addIntegrante(Grupo grupo, Integrante integrante) {
    if (!integrantes.containsKey(grupo)) {
        integrantes.put(grupo, new LinkedHashSet<Integrante>());
    }
    return integrantes.get(grupo).add(integrante);
}
```

---

## 🎯 PATRÓN 2: VERIFICAR EXISTENCIA ANTES DE OPERAR

**Si te piden:** "Haz X solo si existe Y" o "Verifica si existe Y"

**Tienes que hacer:** Usar `containsKey()` o `contains()` antes de cualquier operación

**Explicación:** Evita NullPointerException y errores al intentar acceder a elementos que no existen.

**Código copiable:**
```java
public TipoRetorno operarSiExiste(Clave clave) {
    // 1. Verificar si la clave existe
    if (mapa.containsKey(clave)) {
        // 2. Si existe, realizar la operación
        return mapa.get(clave).operacion();
    }
    // 3. Si no existe, devolver valor por defecto
    return valorPorDefecto;
}
```

**Ejemplo real (Examen Feria):**
```java
public void aniadeConsumicion(Socio socio, Articulo articulo, int cantidad) {
    if (listaCuentas.containsKey(socio)) {
        listaCuentas.get(socio).add(new Consumicion(articulo, cantidad));
    } else {
        LinkedList<Consumicion> consumiciones = new LinkedList<>();
        consumiciones.add(new Consumicion(articulo, cantidad));
        listaCuentas.put(socio, consumiciones);
    }
}
```

---

## 🎯 PATRÓN 3: RECORRER MAPAS ANIDADOS

**Si te piden:** "Busca algo en estructuras complejas" o "Recorre todos los elementos anidados"

**Tienes que hacer:** Usar `entrySet()` + bucles anidados

**Explicación:** Para acceder a todos los niveles de un mapa anidado, necesitas bucles anidados con entrySet().

**Código copiable:**
```java
public ArrayList<TipoResultado> buscarEnEstructuraAnidada() {
    ArrayList<TipoResultado> resultados = new ArrayList<>();
    
    // 1. Recorrer cada entrada del mapa principal
    for (Map.Entry<Clave, Coleccion<Elemento>> entrada : mapa.entrySet()) {
        // 2. Recorrer cada elemento de la colección anidada
        for (Elemento elemento : entrada.getValue()) {
            // 3. Verificar condición y añadir a resultados
            if (elemento.cumpleCondicion()) {
                resultados.add(elemento.getResultado());
            }
        }
    }
    return resultados;
}
```

**Ejemplo real (Examen Música):**
```java
public List<String> getIncidencias(Fecha fecha) {
    ArrayList<String> incidencias = new ArrayList<>();
    
    for (Map.Entry<Integer, TreeMap<FechaHora, String>> entrada : incidenciasLocales.entrySet()) {
        for (Map.Entry<FechaHora, String> entrada2 : entrada.getValue().entrySet()) {
            if (fecha.equals(entrada2.getKey())) {
                incidencias.add(entrada2.getValue());
            }
        }
    }
    return incidencias;
}
```

---

## 🎯 PATRÓN 4: ELIMINACIÓN SEGURA CON ITERATOR

**Si te piden:** "Elimina elementos mientras recorres" o "Elimina X que cumpla Y"

**Tienes que hacer:** Usar `Iterator` + `remove()`

**Explicación:** Es la ÚNICA forma segura de eliminar elementos mientras recorres una colección sin ConcurrentModificationException.

**Código copiable:**
```java
public int eliminarElementosPorCondicion(Clave clave, Condicion condicion) {
    int eliminados = 0;
    
    // 1. Verificar si existe la clave
    if (mapa.containsKey(clave)) {
        // 2. Crear Iterator para eliminación segura
        Iterator<Elemento> iterador = mapa.get(clave).iterator();
        
        // 3. Recorrer con Iterator
        while (iterador.hasNext()) {
            Elemento elemento = iterador.next();
            
            // 4. Verificar condición
            if (elemento.cumpleCondicion(condicion)) {
                // 5. Eliminar de forma segura
                iterador.remove();
                eliminados++;
            }
        }
    }
    return eliminados;
}
```

**Ejemplo real (Examen Música):**
```java
public boolean eliminaIntegrante(Grupo grupo, String dniIntegrante) {
    if (integrantes.containsKey(grupo)) {
        Iterator<Integrante> iteradorIntegrantes = integrantes.get(grupo).iterator();
        
        while (iteradorIntegrantes.hasNext()) {
            Integrante integrante = iteradorIntegrantes.next();
            if (integrante.getDni().equals(dniIntegrante)) {
                iteradorIntegrantes.remove();
                return true;
            }
        }
    }
    return false;
}
```

---

## 🎯 PATRÓN 5: CONTEO DE FRECUENCIAS

**Si te piden:** "Cuenta cuántos X hay" o "Encuentra el X más común"

**Tienes que hacer:** Usar `HashMap` contador + `getOrDefault()`

**Explicación:** Para contar frecuencias, usas un mapa donde la clave es el elemento y el valor es cuántas veces aparece.

**Código copiable:**
```java
public ElementoMasComun getElementoMasFrecuente() {
    Map<Elemento, Integer> contador = new HashMap<>();
    
    // 1. Contar frecuencia de cada elemento
    for (Elemento elemento : coleccion) {
        contador.put(elemento, contador.getOrDefault(elemento, 0) + 1);
    }
    
    // 2. Encontrar el elemento con máxima frecuencia
    ElementoMasComun masFrecuente = null;
    int maxFrecuencia = 0;
    
    for (Map.Entry<Elemento, Integer> entrada : contador.entrySet()) {
        if (entrada.getValue() > maxFrecuencia) {
            maxFrecuencia = entrada.getValue();
            masFrecuente = entrada.getKey();
        }
    }
    
    return masFrecuente;
}
```

**Ejemplo real (Examen Música):**
```java
public TipoMusica getTipoMusicaMasGrupos() {
    Map<TipoMusica, Integer> mapaRepeticiones = new HashMap<>();

    for (Grupo grupo : integrantes.keySet()) {
        mapaRepeticiones.put(grupo.getTipoMusica(), 
            mapaRepeticiones.getOrDefault(grupo.getTipoMusica(), 0) + 1);
    }
    
    TipoMusica tipoMasRepetido = null;
    int maxRepeticiones = 0;
    
    for (Map.Entry<TipoMusica, Integer> entrada : mapaRepeticiones.entrySet()) {
        if (entrada.getValue() > maxRepeticiones) {
            maxRepeticiones = entrada.getValue();
            tipoMasRepetido = entrada.getKey();
        }
    }
    
    return tipoMasRepetido;
}
```

---

## 🎯 PATRÓN 6: OBTENER ELEMENTOS ÚNICOS

**Si te piden:** "Obtiene todos los X distintos" o "Elimina duplicados"

**Tienes que hacer:** Usar `HashSet` o `TreeSet` para eliminación automática de duplicados

**Explicación:** Los Set eliminan duplicados automáticamente. TreeSet además ordena.

**Código copiable:**
```java
public Set<TipoUnico> getElementosUnicos() {
    Set<TipoUnico> unicos = new TreeSet<>(); // o HashSet
    
    // 1. Recorrer colección que puede tener duplicados
    for (Elemento elemento : coleccionConDuplicados) {
        // 2. Añadir al set (automáticamente elimina duplicados)
        unicos.add(elemento.getValorUnico());
    }
    
    return unicos;
}
```

**Ejemplo real (Examen Torneo Videojuegos):**
```java
public HashSet<String> juegosJugados() {
    HashSet<String> juegos = new HashSet<>();
    
    for (Partida partida : partidas) {
        juegos.add(partida.getJuego()); // Set elimina duplicados automáticamente
    }
    
    return juegos;
}
```

---

## 🎯 PATRÓN 7: BÚSQUEDA BIDIRECCIONAL

**Si te piden:** "Verifica si existe X vs Y y Y vs X" o "Detecta relaciones recíprocas"

**Tienes que hacer:** Usar bucles anidados comparando pares inversos

**Explicación:** Para detectar relaciones en ambas direcciones, necesitas comparar cada par con todos los demás.

**Código copiable:**
```java
public boolean hayRelacionReciproca() {
    // 1. Recorrer cada elemento menos el último
    for (int i = 0; i < coleccion.size() - 1; i++) {
        Elemento elemento1 = coleccion.get(i);
        
        // 2. Recorrer desde el siguiente elemento hasta el final
        for (int j = i + 1; j < coleccion.size(); j++) {
            Elemento elemento2 = coleccion.get(j);
            
            // 3. Verificar si son relación inversa
            if (elemento1.getA().equals(elemento2.getB()) && 
                elemento2.getA().equals(elemento1.getB())) {
                return true;
            }
        }
    }
    return false;
}
```

**Ejemplo real (Examen Torneo Videojuegos):**
```java
public boolean hayEnfrentamientosRepetidos() {
    for (int i = 0; i < partidas.size() - 1; i++) {
        Partida partida1 = partidas.get(i);
        for (int j = i + 1; j < partidas.size(); j++) {
            Partida partida2 = partidas.get(j);
            
            if (partida1.getEquipo1().equals(partida2.getEquipo2()) && 
                partida2.getEquipo1().equals(partida1.getEquipo2())) {
                return true;
            }
        }
    }
    return false;
}
```

---

## 🎯 PATRÓN 8: FILTRADO Y SUBCOLECCIONES

**Si te piden:** "Obtiene los X que cumplen Y" o "Filtra elementos por condición"

**Tienes que hacer:** Crear nueva colección + recorrer + filtrar por condición

**Explicación:** Para crear subcolecciones, creas una colección nueva y añades solo los elementos que cumplen la condición.

**Código copiable:**
```java
public ColeccionFiltrada getElementosFiltrados(Criterio criterio) {
    ColeccionFiltrada filtrados = new ArrayList<>(); // o HashSet, etc.
    
    // 1. Recorrer colección original
    for (Elemento elemento : coleccionOriginal) {
        // 2. Verificar si cumple criterio
        if (elemento.cumpleCriterio(criterio)) {
            // 3. Añadir a colección filtrada
            filtrados.add(elemento);
        }
    }
    
    return filtrados;
}
```

**Ejemplo real (Examen Empresa Comercial):**
```java
public TreeSet<Comercial> comercialesQueVisitaronEnElMes(int mes) {
    TreeSet<Comercial> comerciales = new TreeSet<>();
    
    for (Visita visita : visitas) {
        if (visita.getMes() == mes) {
            comerciales.add(visita.getComercial());
        }
    }
    
    return comerciales;
}
```

---

## 🎯 PATRÓN 9: CÁLCULO DE ESTADÍSTICAS

**Si te piden:** "Calcula el total/medio/máximo de X" o "Obtén estadísticas"

**Tienes que hacer:** Usar acumuladores + recorrer + cálculos matemáticos

**Explicación:** Para estadísticas necesitas acumuladores y recorrer toda la colección.

**Código copiable:**
```java
public double calcularEstadistica() {
    double acumulador = 0;
    int contador = 0;
    
    // 1. Recorrer colección
    for (Elemento elemento : coleccion) {
        // 2. Acumular valor
        acumulador += elemento.getValor();
        contador++;
    }
    
    // 3. Calcular estadística (controlar división por cero)
    return contador > 0 ? acumulador / contador : 0.0;
}
```

**Ejemplo real (Examen Feria):**
```java
public String calculaTotalCuenta(Socio socio) {
    LinkedList<Consumicion> consumiciones = listaCuentas.get(socio);
    Float sumaPrecios = 0F;
    
    for (Consumicion consumicion : consumiciones) {
        sumaPrecios += listaPrecios.get(consumicion.getArticulo()) * consumicion.getCantidad();
    }
    
    return sumaPrecios.toString();
}
```

---

## 🎯 PATRÓN 10: BÚSQUEDA DE EXTREMOS

**Si te piden:** "Encuentra el X con mayor/menor Y" o "Obtén el mejor/peor"

**Tienes que hacer:** Mantener variables de máximo/mínimo mientras recorres

**Explicación:** Para encontrar extremos, mantienes variables tracking del mejor encontrado hasta ahora.

**Código copiable:**
```java
public ElementoMejor getElementoExtremo() {
    ElementoMejor mejor = null;
    double valorMejor = Double.MIN_VALUE; // o MAX_VALUE para mínimo
    
    for (Elemento elemento : coleccion) {
        double valorActual = elemento.getValor();
        
        if (valorActual > valorMejor) {
            valorMejor = valorActual;
            mejor = elemento;
        }
    }
    
    return mejor;
}
```

**Ejemplo real (Examen Torneo Videojuegos):**
```java
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

---

## 🎯 PATRÓN 11: TRANSFORMACIÓN DE DATOS

**Si te piden:** "Crea un mapa con X agrupado por Y" o "Transforma la estructura"

**Tienes que hacer:** Crear nueva estructura + recorrer + transformar/agrupar

**Explicación:** Para transformar datos, creas una nueva estructura y la llenas transformando los datos originales.

**Código copiable:**
```java
public Map<TipoClave, TipoValor> transformarDatos() {
    Map<TipoClave, TipoValor> resultado = new HashMap<>();
    
    for (Elemento elemento : coleccionOriginal) {
        TipoClave clave = elemento.getClave();
        TipoValor valor = elemento.getValor();
        
        // Usar getOrDefault para agrupación
        resultado.put(clave, resultado.getOrDefault(clave, 0) + valor);
    }
    
    return resultado;
}
```

**Ejemplo real (Examen Empresa Comercial):**
```java
public TreeMap<Comercial, LinkedList<Visita>> mapaVisitasPorComercial() {
    TreeMap<Comercial, LinkedList<Visita>> mapaVisitas = new TreeMap<>();
    
    for (Visita visita : visitas) {
        if (mapaVisitas.containsKey(visita.getComercial())) {
            mapaVisitas.get(visita.getComercial()).add(visita);
        } else {
            LinkedList<Visita> visitas2 = new LinkedList<>();
            visitas2.add(visita);
            mapaVisitas.put(visita.getComercial(), visitas2);
        }
    }
    
    return mapaVisitas;
}
```

---

## 🎯 PATRÓN 12: VERIFICACIÓN DE ERRORES O INCONSISTENCIAS

**Si te piden:** "Detecta si hay errores" o "Verifica si algo es inconsistente"

**Tienes que hacer:** Recorrer + verificar condiciones + devolver boolean al encontrar error

**Explicación:** Para detectar errores, recorres buscando cualquier condición que sea incorrecta y devuelves true inmediatamente.

**Código copiable:**
```java
public boolean hayErrores() {
    // 1. Recorrer colección buscando errores
    for (Elemento elemento : coleccion) {
        // 2. Verificar condición de error
        if (elemento.tieneError()) {
            // 3. Error encontrado, devolver true inmediatamente
            return true;
        }
    }
    
    // 4. No se encontraron errores
    return false;
}
```

**Ejemplo real (Examen Empresa Comercial):**
```java
public boolean hayErrores() {
    for (Visita visita : visitas) {
        if (!asignaciones.get(visita.getComercial()).contains(visita.getEmpresa())) {
            return true;
        }
    }
    return false;
}
```

---

## 🎯 PATRÓN 13: BÚSQUEDA POR CRITERIOS MÚLTIPLES

**Si te piden:** "Busca X que cumpla varias condiciones" o "Filtra por múltiples criterios"

**Tienes que hacer:** Usar operadores lógicos AND/OR en condiciones

**Explicación:** Para búsquedas complejas, combinas múltiples condiciones con && y ||.

**Código copiable:**
```java
public List<Elemento> buscarPorCriteriosMultiples(Criterio1 c1, Criterio2 c2) {
    List<Elemento> resultados = new ArrayList<>();
    
    for (Elemento elemento : coleccion) {
        // Combinar múltiples condiciones
        if (elemento.cumpleCriterio1(c1) && elemento.cumpleCriterio2(c2)) {
            resultados.add(elemento);
        }
    }
    
    return resultados;
}
```

**Ejemplo real (Examen Parejas):**
```java
public String getListadoAfinidades(String nombreSolicitante) {
    Persona solicitante = getPersonaPorNombre(nombreSolicitante);
    String posiblesParejas = "";
    
    for (Persona persona : solicitantes) {
        // Múltiples condiciones: no es misma persona + sexo compatible
        if (!persona.equals(solicitante) && 
            persona.getSexoPropio().equals(solicitante.getSexoBuscado())) {
            posiblesParejas += persona.getNombre() + "-" + 
                             solicitante.aficionesComunesCon(persona) + "\n";
        }
    }
    
    return posiblesParejas;
}
```

---

## 🎯 PATRÓN 14: ACTUALIZACIÓN O REEMPLAZO

**Si te piden:** "Actualiza X si existe, si no créalo" o "Modifica valores existentes"

**Tienes que hacer:** Usar `containsKey()` + `put()` para actualizar o crear

**Explicación:** `put()` siempre sobrescribe el valor existente o crea uno nuevo si no existe.

**Código copiable:**
```java
public boolean actualizarOCrear(Clave clave, Valor valor) {
    boolean existia = mapa.containsKey(clave);
    
    // put() siempre funciona: crea si no existe, actualiza si existe
    mapa.put(clave, valor);
    
    return existia; // true si ya existía, false si es nuevo
}
```

**Ejemplo real (Examen Feria):**
```java
public boolean aniadeArticulo(String nombre, String tamanio, float precio) {
    Articulo articulo = new Articulo(nombre, tamanio);
    
    if (listaPrecios.containsKey(articulo)) {
        listaPrecios.put(articulo, precio); // Actualiza precio
        return false; // Ya existía
    }
    
    listaPrecios.put(articulo, precio); // Crea nuevo
    return true; // Nuevo añadido
}
```

---

## 🔥 CONSEJOS FINALES PARA EXÁMENES

### ✅ Siempre haz esto:
1. **Usa `containsKey()` antes de `get()`** en mapas
2. **Usa `Iterator` para eliminar mientras recorres**
3. **Inicializa colecciones anidadas** antes de usarlas
4. **Controla `null`** en operaciones con mapas
5. **Usa `getOrDefault()`** para simplificar código

### ❌ Nunca hagas esto:
1. **Elimines elementos con `remove()` en bucle for-each**
2. **Accedas a mapas sin verificar si existe la clave**
3. **Te olvides de inicializar colecciones anidadas**
4. **Uses `==` para comparar objetos (usa `equals()`)**
5. **Dejes bucles sin romper cuando ya encontraste lo que buscabas**

### 🎯 Para el examen:
- **Identifica el patrón** que te piden
- **Copia el código base** de esta guía
- **Adapta los nombres** a tu dominio específico
- **Añade comentarios** explicando cada paso
- **Prueba con datos simples** antes de entregar

¡Mucha suerte! 🚀
