package pruebasJunit;

public class EjemploClase {
    private String nombre; // Almacena el nombre del objeto
    private int contador; // Contador que puede incrementarse
    private List<String> elementos; // Lista de elementos almacenados
    private static int totalInstancias = 0; // Contador de instancias creadas de la clase

    // Constructor: Inicializa el objeto con un nombre y una lista vacía
    public EjemploClase(String nombre) {
        this.nombre = nombre;
        this.contador = 0;
        this.elementos = new ArrayList<>();
        totalInstancias++; // Incrementa el número total de instancias creadas
    }

    // Getters: Métodos para obtener los valores de los atributos
    public String getNombre() {
        return nombre;
    }

    public int getContador() {
        return contador;
    }

    // Devuelve una copia de la lista de elementos para evitar modificaciones externas
    public List<String> getElementos() {
        return new ArrayList<>(elementos);
    }

    // Método estático para obtener el total de instancias creadas de la clase
    public static int getTotalInstancias() {
        return totalInstancias;
    }

    // Métodos funcionales

    // Incrementa el valor del contador en 1
    public void incrementarContador() {
        contador++;
    }

    // Divide dos números enteros, lanza una excepción si el divisor es 0
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return a / b;
    }

    // Invierte una cadena de texto. Lanza una excepción si el texto es nulo.
    public String invertirCadena(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("La cadena no puede ser nula");
        }
        return new StringBuilder(texto).reverse().toString();
    }

    // Suma todos los elementos de una lista de enteros y devuelve el resultado
    public int sumarLista(List<Integer> numeros) {
        return numeros.stream().mapToInt(Integer::intValue).sum();
    }

    // Métodos de manejo de listas

    // Agrega un elemento a la lista
    public void agregarElemento(String elemento) {
        elementos.add(elemento);
    }

    // Elimina un elemento de la lista y devuelve true si se eliminó correctamente
    public boolean eliminarElemento(String elemento) {
        return elementos.remove(elemento);
    }

    // Verifica si un elemento está presente en la lista
    public boolean contieneElemento(String elemento) {
        return elementos.contains(elemento);
    }
}
