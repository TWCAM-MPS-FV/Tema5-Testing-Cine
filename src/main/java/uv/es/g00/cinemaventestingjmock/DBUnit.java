package uv.es.g00.cinemaventestingjmock;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.sql.DataSource;

import java.util.Date;
import org.h2.jdbcx.JdbcDataSource;

/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 * 
 * Created by Alvin Alexander, http://devdaily.com
 */
public class DBUnit {
    private static Vector cines;
    private ConexionBDA BDA;

    public DBUnit() {
        Connection conn;
        ResultSet rs;
        String nom_aux;
        Cine aux_Cine;

        BDA = new ConexionBDA();
        cines = new Vector(20);

        try {
            conn = BDA.conectar();

            String query = "SELECT * FROM cine";
            Statement st = conn.createStatement();

            rs = BDA.consultar(conn, query, st);
            while (rs.next()) {
                int id = rs.getInt("id_cine");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                int idProvincia = rs.getInt("id_provincia");
                aux_Cine = new Cine(idProvincia, nombre, direccion, direccion, null, null);
            }

            BDA.cerrar(st);
        }

        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    DBUnit(JdbcDataSource dataSource) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public DBUnit(DataSource ds) {
        BDA = new ConexionBDA();

    }

    public static void main(String[] args)

    {
        // crear ficheros de DataSet
        ExtractDataSet DS = new ExtractDataSet();

        try {
            DS.CrearDataSet();
            // Ejemplo de creacion de un dataSet a partir de contenido de una BDA
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}