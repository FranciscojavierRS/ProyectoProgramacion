package pruebasJunit;

import static org.junit.jupiter.api.Assertions.*;  // Importa todas las clases necesarias para realizar aserciones en las pruebas.
import org.junit.jupiter.api.BeforeEach;           // Importa la anotación BeforeEach para ejecutar el código antes de cada prueba.
import org.junit.jupiter.api.Test;                 // Importa la anotación Test para definir métodos de prueba.

public class CalculadoraTest {

    // Declaramos una instancia de la clase Calculadora que será utilizada en las pruebas.
    private Calculadora calculadora;

    // Este método se ejecuta antes de cada prueba individual.
    // Aquí inicializamos el objeto 'calculadora' para asegurarnos de que esté listo antes de cada prueba.
    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    // Prueba para el método 'suma' de la clase Calculadora.
    // Verifica si la suma de 7 + 3 es igual a 10.
    @Test
    public void testSuma() {
        assertEquals(10, calculadora.suma(7, 3));  // La aserción compara el resultado esperado (10) con el resultado de 'calculadora.suma(7, 3)'.
    }

    // Prueba para el método 'resta' de la clase Calculadora.
    // Verifica si la resta de 7 - 3 es igual a 4.
    @Test
    public void testResta() {
        assertEquals(4, calculadora.resta(7, 3));  // Compara el resultado esperado (4) con el resultado de 'calculadora.resta(7, 3)'.
    }

    // Prueba para el método 'multiplicacion' de la clase Calculadora.
    // Verifica si la multiplicación de 7 * 3 es igual a 21.
    @Test
    public void testMultiplicacion() {
        assertEquals(21, calculadora.multiplicacion(7, 3));  // Compara el resultado esperado (21) con el resultado de 'calculadora.multiplicacion(7, 3)'.
    }

    // Prueba para el método 'division' de la clase Calculadora.
    // Verifica si la división de 6 / 3 es igual a 2.
    @Test
    public void testDivision() {
        assertEquals(2, calculadora.division(6, 3));  // Compara el resultado esperado (2) con el resultado de 'calculadora.division(6, 3)'.
    }

    // Prueba para el caso especial de división por cero.
    // Verifica si la excepción 'ArithmeticException' es lanzada cuando se intenta dividir por cero.
    @Test
    public void testDivisionPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.division(7, 0);  // Intenta dividir 7 entre 0, lo cual debe lanzar una excepción de tipo 'ArithmeticException'.
        });
    }
}
