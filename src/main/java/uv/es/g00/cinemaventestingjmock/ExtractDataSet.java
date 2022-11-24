package uv.es.g00.cinemaventestingjmock;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

/**
 *
 * @author jopana
 */
public class ExtractDataSet {

    public ExtractDataSet() {
    }

    public void CrearDataSet() throws Exception {
        // Ejemplo de cómo crear un dataset a partir de contenido de una BDA

        // conexion a la base de datos

        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost/cinedbunit?serverTimezone=UTC", "udb", "pudb");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        // exportar un dataset parcial
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("users", "SELECT * FROM cine");
        // partialDataSet.addTable("recipe_ext_xref");
        // Se pueden añadir tantas tablas como sean necesarias al Dataset
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("partial-dataset.xml"));
        // exportacion de la base de datos completa!!
        IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full-dataset.xml"));
    }

}
