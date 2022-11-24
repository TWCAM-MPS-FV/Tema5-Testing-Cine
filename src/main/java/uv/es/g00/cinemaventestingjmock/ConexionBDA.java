package uv.es.g00.cinemaventestingjmock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jopana
 */
public class ConexionBDA {

    public Connection conectar() {
        // create our mysql database connection
        Connection conn = null;
        try {

            String myUrl = "jdbc:mysql://localhost/cinedbunit?serverTimezone=UTC";
            conn = DriverManager.getConnection(myUrl, "udb", "pudb");
        } catch (Exception e) {
            System.err.println("Got an exception in connect! ");
            System.err.println(e.getMessage());
        }
        return conn;

    }

    public void cerrar(Statement st) {
        try {
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception in close! ");
            System.err.println(e.getMessage());
        }

    }

    public ResultSet consultar(Connection conn, String query, Statement st) {
        ResultSet rs = null;
        try {

            // execute the query, and get a java resultset
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Got an exception in query! ");
            System.err.println(e.getMessage());
        }
        return rs;

    }

    public void ejecutar(String sentencia, Statement st) {
        try {
            st.executeUpdate(sentencia);
        } catch (Exception e) {
            System.err.println("Got an exception in ejecutar! ");
            System.err.println(e.getMessage());
        }

    }

}
