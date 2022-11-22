package uv.es.g00.cinemaventestingjmock;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.util.ArrayList;

import org.jmock.Expectations;
import org.jmock.junit5.JUnit5Mockery;

@TestMethodOrder(OrderAnnotation.class)
public class CineTest {

    Cine testCine;
    Provincia testProvincia;
    Sesion testSesion;
    Actor testActor;
    JUnit5Mockery context = new JUnit5Mockery();

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
    public void listarPoblacionesConCine() {
        final Provincia provincia = context.mock(Provincia.class);
        String[] listaCines = { "Cine 1", "Cine 2" };
        context.checking(new Expectations() {
            {
                oneOf(provincia).getListadoCinesPoblacion("Ayora");
                will(returnValue(listaCines));
            }
        });
        Assertions.assertArrayEquals(provincia.getListadoCinesPoblacion("Ayora"), listaCines);
    }

    @Test
    @Order(3)
    public void addPlobacionConCine() {
        final Provincia provincia = context.mock(Provincia.class);
        String[] poblacinesCine = { "Ayora: Cine 1" };
        String poblacion = "Ayora";
        context.checking(new Expectations() {
            {
                oneOf(provincia).addPoblacion(poblacion);
                will(returnValue(poblacinesCine));
            }
        });
        Assertions.assertArrayEquals(provincia.addPoblacion(poblacion), poblacinesCine);
    }

    @Test
    @Order(4)
    public void asociarActorAPeli() {
        final Actor actor = context.mock(Actor.class);
        final Pelicula pelicula = new Pelicula();
        context.checking(new Expectations() {
            {
                oneOf(actor).getNombreActor();
                will(returnValue("Actor 1"));
            }
        });
        context.checking(new Expectations() {
            {
                oneOf(actor).addPelicula(pelicula);
            }
        });

        Assertions.assertNotNull(actor.getNombreActor());
        testCine.AsociarActorAPeli(actor, pelicula);
    }

}