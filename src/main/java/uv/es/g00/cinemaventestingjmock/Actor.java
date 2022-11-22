package uv.es.g00.cinemaventestingjmock;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jopana
 */
public interface Actor {

    public void Actor();

    public void addPelicula(Pelicula pelicula);

    public void deletePelicula(Pelicula pelicula);

    public String getNombreActor();

    public void setNombreActor(String actor);

    public ArrayList<Pelicula> getPeliculas();
}
