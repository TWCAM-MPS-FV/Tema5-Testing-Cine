package uv.es.g00.cinemaventestingjmock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class CineTest {

    Cine testCine;

    @BeforeEach
    void setUp() throws Exception {
        testCine = new Cine();
    }

    @AfterAll
    public static void cleanUp() {
    }

    @Test
    @Order(1)
    public void crearInstancia() {
        Assertions.assertNotNull(testCine);
    }

    @Test
    @Order(2)
    void testCalcularPrecioEntradaConTemporada() {
        Assertions.assertEquals(30, testCine.CalcularPrecioEntrada(10, "miercoles"));
    }

    @Test
    @Order(3)
    void testCalcularPrecioEntradaPorDefecto() {
        Assertions.assertEquals(50, testCine.CalcularPrecioEntrada(10, ""));
    }

    @Test
    @Order(4)
    void testPagarEntrada() throws Exception {
        Assertions.assertEquals(10, testCine.PagarEntrada(10, 20));
    }

    @Test
    @Order(5)
    void testPagarEntradaException() throws Exception {
        String excepcionEsperada = "Falta dinero";
        String excepcion;
        try {
            testCine.PagarEntrada(20, 10);
            fail();
        } catch (Exception e) {
            excepcion = e.getMessage().toString();
            Assertions.assertTrue(excepcionEsperada.contains(excepcion));
        }
    }
}