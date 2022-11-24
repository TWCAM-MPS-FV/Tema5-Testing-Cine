package uv.es.g00.cinemaventestingjmock;

import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.DataSource;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.assertion.DbUnitAssert;

//DBUnit
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.*;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class DBUnitTest {

}
