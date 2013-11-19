package com.kwc.testen.db;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseHandler will connect to the postgres database on Heroku.
 * @author Marius Kristensen
 */
public class DatabaseHandler implements Serializable {

    private Connection connection = null;
    private URI dbUri = null;
    private String username = null;
    private String password = null;
    private String dbUrl = null;

    public DatabaseHandler() {

        try {
            dbUri = new URI(System.getenv("DATABASE_URL"));
            username = dbUri.getUserInfo().split(":")[0];
            password = dbUri.getUserInfo().split(":")[1];
            dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            if (System.getenv("ENVIRONMENT") != null) {
                dbUrl += "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(dbUrl, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
