
package uv.es.g00.cinemaventestingjmock;
import java.util.*;

/**
 * @author Grupo3
 */
public class Sala {

    private Cine cine;
   
    /**
     * Este atributo indica el numero de asientos de esa sala
     */
    private int num_asientos;
    /**
     * Este atributo es el numero de la sala
     */
    private int num_sala_del_cine;

    /**
     * Constructor con parámetros. Cine, numero de sala y numero de asientos
     * @param cine
     * @param num_sala
     * @param num_asientos
     */
    public Sala(Cine cine, int num_sala, int num_asientos) {
        this.num_sala_del_cine = num_sala;
        this.num_asientos = num_asientos;
        this.cine = cine;
    }

      
    /**
     * Este método devuelve el numero de asientos de la sala
     * @return 
     */
    
    
    public int getNum_asientos() {
        return this.num_asientos;
    }

    /**
     * Este método devuelve el numero de la sala
     * @return 
     */
    public int getNum_sala() {
        return this.num_sala_del_cine;
    }

   

    /**
     * Este método cambia el cine de la sala
     * @param cine
     */
    public void setCine(Cine cine) {
        this.cine = cine;
    }

    /**
     * Este método cambia el numero de asientos de la sala
     * @param num_asientos
     */
    public void setNum_asientos(int num_asientos, int max_capacidad) throws Exception {
        
        if (num_asientos>max_capacidad)
            throw new Exception("Demadiados asientos");
        else
        this.num_asientos = num_asientos;
    }

    /**
     * Este método cambia el numero de la sala
     * @param num_sala
     */
    public void setNum_sala(int num_sala) {
        this.num_sala_del_cine = num_sala;
    }

    

}