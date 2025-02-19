package pruebasJunit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class EjemploClaseTest {
    private EjemploClase ejemplo; // Instancia de la clase a probar

    // Se ejecuta antes de cada test para inicializar la instancia
    @BeforeEach
    void setUp() {
        ejemplo = new EjemploClase("Test");
    }

    // Se ejecuta después de cada test para limpiar recursos si es necesario
    @AfterEach
    void tearDown() {
        System.out.println("Prueba finalizada.");
    }

    // Se ejecuta una vez antes de que empiecen todas las pruebas
    @BeforeAll
    static void initAll() {
        System.out.println("Inicio de pruebas.");
    }

    // Se ejecuta una vez después de que finalicen todas las pruebas
    @AfterAll
    static void tearDownAll() {
        System.out.println("Todas las pruebas finalizadas.");
    }

    // Prueba la creación del objeto y verifica que sus valores iniciales sean correctos
    @Test
    void testCrearObjeto() {
        assertNotNull(ejemplo); // Verifica que la instancia no sea nula
        assertEquals("Test", ejemplo.getNombre()); // Verifica que el nombre es el esperado
    }

    // Prueba la funcionalidad de incrementar el contador
    @Test
    void testIncrementarContador() {
        ejemplo.incrementarContador();
        assertEquals(1, ejemplo.getContador()); // Verifica que el contador incrementó correctamente
    }

    // Prueba que la división por cero lanza una excepción
    @Test
    void testDivisionPorCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ejemplo.dividir(10, 0);
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }

    // Prueba la funcionalidad de incrementar el contador varias veces usando valores parametrizados
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5}) // Se ejecuta una vez por cada valor en el array
    void testIncrementoMultiple(int valor) {
        for (int i = 0; i < valor; i++) {
            ejemplo.incrementarContador();
        }
        assertEquals(valor, ejemplo.getContador()); // Verifica que el contador coincide con el número de incrementos
    }

    // Prueba la funcionalidad de invertir cadenas usando valores parametrizados
    @ParameterizedTest
    @CsvSource({"hello, olleh", "java, avaj", "JUnit, tinUJ"})
    void testInvertirCadena(String input, String expected) {
        assertEquals(expected, ejemplo.invertirCadena(input));
    }

    // Prueba que al pasar una cadena nula a invertirCadena, se lance una excepción
    @Test
    void testInvertirCadenaNula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ejemplo.invertirCadena(null);
        });
        assertEquals("La cadena no puede ser nula", exception.getMessage());
    }

    // Prueba la funcionalidad de sumar listas de enteros usando valores parametrizados
    @ParameterizedTest
    @MethodSource("provideListsForSum") // Fuente de datos para la prueba
    void testSumarLista(List<Integer> lista, int expectedSum) {
        assertEquals(expectedSum, ejemplo.sumarLista(lista));
    }

    // Método estático que proporciona datos de prueba para testSumarLista
    static Stream<Arguments> provideListsForSum() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3), 6),
            Arguments.of(Arrays.asList(10, 20, 30), 60),
            Arguments.of(Arrays.asList(-1, -2, -3), -6)
        );
    }

    // Prueba la funcionalidad de manipulación de listas dentro de la clase
    @Test
    void testManejoDeListas() {
        ejemplo.agregarElemento("A");
        ejemplo.agregarElemento("B");
        ejemplo.agregarElemento("C");

        assertAll("Lista de elementos",
            () -> assertTrue(ejemplo.contieneElemento("A")),
            () -> assertTrue(ejemplo.contieneElemento("B")),
            () -> assertTrue(ejemplo.contieneElemento("C")),
            () -> assertFalse(ejemplo.contieneElemento("D")) // Verifica que "D" no está en la lista
        );

        assertTrue(ejemplo.eliminarElemento("B")); // Elimina "B" y verifica que la operación fue exitosa
        assertFalse(ejemplo.contieneElemento("B")); // Verifica que "B" ya no está en la lista
    }

    // Prueba la funcionalidad del contador de instancias
    @Test
    void testContadorDeInstancias() {
        new EjemploClase("Otra instancia");
        new EjemploClase("Otra más");

        assertEquals(3, EjemploClase.getTotalInstancias()); // Verifica que el número de instancias es correcto
    }
}
