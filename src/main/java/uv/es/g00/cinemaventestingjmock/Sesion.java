package uv.es.g00.cinemaventestingjmock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jopana
 */
public interface Sesion {

  public void Sesion();

  public int getDia();

  public String getPelicula();

  public int ConsultarPlazasLibres();

  public void DecrementarNumPlazasLibres(int NumEntradas);

  public void IncrementarNumPlazasLibres(int NumEntradas);

  public String GetNombre();
}
