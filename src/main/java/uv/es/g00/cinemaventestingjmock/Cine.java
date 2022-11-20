
package uv.es.g00.cinemaventestingjmock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Grupo3
 */
public class Cine {

    private ArrayList<Pelicula> cartelera;
    private ArrayList<Sala> salas;
    private ArrayList<Sesion> sesiones;
    private ArrayList<Actor> actores = new ArrayList<Actor>();
    private Provincia provincia;

    /**
     * Es lo que identifica al cine. El nombre.
     */
    private String nombre = "";
    /**
     * Localizacion de un cine por la direccion
     */
    private String direccion = "";

    /**
     * Codigo postal del cine
     */
    private int codigoPostal = 0;
    /**
     * La poblacion donde esta el cine
     */
    private String poblacion = "";

    /**
     * Constructor con argumentos. Nombre, direccion, telefono, poblacion, codigo
     * postal y provincia.
     * 
     * @param nombre
     * @param direccion
     * @param telefono
     * @param poblacion
     * @param codigopostal
     * @param precioTicket
     * @param provincia
     */

    public Cine(String nombre, String direccion, String poblacion, int codigopostal, Provincia provincia,
            ArrayList<Sesion> sesions) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codigoPostal = codigopostal;
        this.salas = new ArrayList<Sala>();
        this.cartelera = new ArrayList<Pelicula>();
        this.provincia = provincia;
        this.sesiones = new ArrayList<Sesion>();
        this.sesiones = sesions;
    }

    public Cine() {
    }

    /**
     * Añade una pelicula a la cartelera
     * 
     * @param pelicula
     */
    public void addPelicula(Pelicula pelicula) {
        this.cartelera.add(pelicula);
    }

    /**
     * Añade una sala al cine
     * 
     * @param sala
     */
    public void addSala(Sala sala) {
        this.salas.add(sala);
    }

    public float CalcularPrecioEntrada(int numEntradas, String temporada) {
        float precio;
        switch (temporada) {

            case "miercoles":
                precio = numEntradas * 3;
                break;
            case "findesemana":
                precio = numEntradas * 8;
                break;
            default:
                precio = numEntradas * 5;

        }
        return precio;

    }

    public float PagarEntrada(float APagar, float Pagado) throws Exception {
        float devolver;

        if (APagar > Pagado)
            throw new Exception("Falta dinero");
        else
            devolver = Pagado - APagar;
        return devolver;

    }

    public ArrayList<Pelicula> getCartelera() {
        return this.cartelera;
    }

    /**
     * Devuelve el código postal
     * 
     * @return
     */
    public int getCodigoPostal() {
        return this.codigoPostal;
    }

    /**
     * Devuelve dirección
     * 
     * @return
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Devuelve nombre
     * 
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve la población del cine
     * 
     * @return
     */
    public String getPoblacion() {
        return this.poblacion;
    }

    /**
     * Devuelve las salas del cine
     * 
     * @return
     */
    public ArrayList<Sala> getSalas() {
        return this.salas;
    }

    /**
     * Cambia la dirección del cine
     * 
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Actor> getActores() {
        return this.actores;
    }
    //////////////////////////////////////////////////////////////////////////////
    // A PARTIR DE AQUI ES TODO DE JMOCK
    /////////////////////////////////////////////////////////////////////////////

    public ArrayList<String> ListarPoblacionesConCine(Provincia provincia) {
        return provincia.ListarPoblaciones();

    }

    public void addPlobacionConCine(Provincia provincia, String poblacion) {

        provincia.addPoblacion(poblacion);
    }

    public void AsociarActorAPeli(Actor actor, Pelicula pelicula) {
        pelicula.addActor(actor);
        actores.add(actor);
        actor.addPelicula(pelicula);
    }

    public void BorrarActorAPeli(Actor actor, Pelicula pelicula) {
        pelicula.deleteActor(actor);
        actores.remove(actor);
        actor.deletePelicula(pelicula);
    }

    public ArrayList<Pelicula> BuscarPeliPorActor(Actor actor) {
        return actor.getPeliculas();

    }

    public ArrayList<Sesion> haySesion(Pelicula pelicula, int dia) throws Exception {
        int num_libres;
        ArrayList<Sesion> sesionesBusquedaFecha = new ArrayList<Sesion>();
        sesionesBusquedaFecha = getSesionesPorFechaYPelicula(dia, pelicula);
        ArrayList<Sesion> sesionesConPlazas = new ArrayList<Sesion>();
        ;
        for (Sesion s : sesionesBusquedaFecha) {
            num_libres = s.ConsultarPlazasLibres();
            if (num_libres > 0)
                sesionesConPlazas.add(s);
        }
        if (sesionesConPlazas.isEmpty())
            throw new Exception("No quedan sesiones libres");

        return sesionesConPlazas;
    }

    public boolean ComprarEntrada(Sesion sesion, int num_entradas) {
        if ((sesion.ConsultarPlazasLibres() - num_entradas) > 0) {
            sesion.DecrementarNumPlazasLibres(num_entradas);
            return true;
        } else
            return false;
    }

    public ArrayList<Sesion> getSesionesPorFechaYPelicula(int dia, Pelicula pelicula) {

        ArrayList<Sesion> sesionesBusqueda = new ArrayList<Sesion>();

        for (Sesion s : sesiones) {
            if (s.getDia() == dia && s.getPelicula().equals(pelicula.getTitulo()))
                sesionesBusqueda.add(s);
        }

        return sesionesBusqueda;
    }

}