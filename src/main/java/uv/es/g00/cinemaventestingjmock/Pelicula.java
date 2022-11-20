package uv.es.g00.cinemaventestingjmock;

import java.util.*;

/**
 * @author Grupo3
 */
public class Pelicula {

    private ArrayList<Integer> valoraciones;
   private ArrayList<Actor> actores;
   private ArrayList<Sesion> sesiones;
    /**
     * Esta es la sinopsis de la pelicula
     */
    private String sinopsis;
    /**
     * Ese es la fecha de estreno
     */
    private String fecha_estreno;
    /**
     * Esta variable determina de que tipo es la pelicula
     */
    private String tipo_pelicula;
    /**
     * Esta variable determina de que categoría es la pelicula
     */
    private String clasificacion;
    /**
     * Este atributo determina el titulo de la pelicula
     */
    private String titulo;
    /**
     * Este atributo determina la duración en minutos de la pelicula
     */
    private int duracion;
    
    public static final int INFANTIL = 0, COMEDIA = 1, DRAMA = 2, CIENCIAFICCION = 3, ACCION = 4, AVENTURA = 5, TERROR = 6, SUSPENSE = 7, MUSICAL = 8, FANTASIA = 9, DOCUMENTAL = 10, ADULTOS = 11;
    public static final String[] nombresGeneros = {"Infantil", "Comedia", "Drama", "Ciencia ficción", "Acción", "Aventura", "Terror", "Suspense", "Musical", "Fantasia", "Documental", "Adultos"};

    /**
     * Constructor por defecto
     */
    public Pelicula() {
        this.sinopsis = "";
        this.fecha_estreno = "";
        this.tipo_pelicula = "";
        this.clasificacion = "";
        this.titulo = "";
        this.duracion = 0;
        this.valoraciones = new ArrayList<Integer>();
        this.actores=new ArrayList<Actor>();
    }

    /**
     * Constructor con argumentos. Titulo, siopsis, fecha_estreno, tipo_pelicula, clasificacion y duracion
     * @param titulo
     * @param sinopsis
     * @param fecha_estreno
     * @param tipo_pelicula
     * @param clasificacion
     * @param duracion
     */
    public Pelicula(String titulo, String sinopsis, String fecha_estreno, String tipo_pelicula, String clasificacion, int duracion, ArrayList<Actor> actors) {
        this.sinopsis = sinopsis;
        this.fecha_estreno = fecha_estreno;
        this.tipo_pelicula = tipo_pelicula;
        this.clasificacion = clasificacion;
        this.titulo = titulo;
        this.duracion = duracion;
        this.valoraciones = new ArrayList<Integer>();
        this.actores=new ArrayList<Actor>();
        this.actores=actors;
    }

    
    
    public void addValoracion(int valoracion) throws Exception{
        
        if (valoracion>10 || valoracion <0)
            throw new Exception("Valoracion fuera de rango");
        else
         this.valoraciones.add(valoracion);
    }

   
   public int NumValoracion (){
       return this.valoraciones.size();
   }
  

    /**
     * Este método devuelve el titulo de la peli
     * @return 
     */
    public String getTitulo() {
        return this.titulo;
    }
    
    public ArrayList<Integer> getValoraciones(){
        return this.valoraciones;
    }

    /**
     * Este método cambia la clasificación por edades de la película
     * @param clasificacion
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * Este método cambia la duración de la pelicula
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Este método cambia la fecha de estreno de la película
     * @param fecha_estreno
     */
    public void setFecha_estreno(String fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }
     public void deleteValoracion (int valoracion){
       
       this.valoraciones.remove(valoracion);
          }
     
     public ArrayList<Actor> getActores (){
       
       return this.actores;
          }
//////////////////////////////////////////////////////////////////////////////
    //A PARTIR DE AQUI ES TODO DE JMOCK
/////////////////////////////////////////////////////////////////////////////
    
    public void addActor (Actor actor){
       actores.add(actor);
   }
   
   public void deleteActor (Actor actor){
       actores.remove(actor);
   }
  
   
   public ArrayList<String> MostrarNombresSesiones (){
       ArrayList<String> Nom_Sesiones=new ArrayList<String>(); 
       
       for (Sesion s:sesiones){
         Nom_Sesiones.add(s.GetNombre());
       }
   return Nom_Sesiones;
   }
}