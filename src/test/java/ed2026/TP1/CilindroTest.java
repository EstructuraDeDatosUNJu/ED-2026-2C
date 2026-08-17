package ed2026.TP1;

// Importar las clases necesarias para las pruebas unitarias
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Clase de prueba para la clase Cilindro
public class CilindroTest {
    @Test
    void testSetAltura() {
        Cilindro cilindro = new Cilindro();
        cilindro.setAltura(5.0);
        assertEquals(5.0, cilindro.getAltura());
    }

    @Test
    void testSetRadio() {
        Cilindro cilindro = new Cilindro();
        cilindro.setRadio(3.0);
        assertEquals(3.0, cilindro.getRadio());
    }

    @Test
    void testSetAltura2() {
        Cilindro cilindro = new Cilindro();

        // Verifica que se lance la excepción IllegalArgumentException al pasar -5.0
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            cilindro.setAltura(-5.0);
        });

        // Verifica que el mensaje de error sea el correcto
        assertEquals("La altura no puede ser negativa", excepcion.getMessage());
    }

    @Test
    void testSetRadio2() {
        Cilindro cilindro = new Cilindro();

        // Verifica que se lance la excepción IllegalArgumentException al pasar -3.0
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            cilindro.setRadio(-3.0);
        });

        // Verifica que el mensaje de error sea el correcto
        assertEquals("El radio no puede ser negativo", excepcion.getMessage());
    }
}
