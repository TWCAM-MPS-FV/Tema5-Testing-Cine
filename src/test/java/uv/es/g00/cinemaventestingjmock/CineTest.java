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

}
