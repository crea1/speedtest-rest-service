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
    private final URI dbUri;
    private final String username;
    private final String password;
    private final String dbUrl;

    public DatabaseHandler() throws SQLException, URISyntaxException {

        dbUri = new URI(System.getenv("DATABASE_URL"));

        username = dbUri.getUserInfo().split(":")[0];
        password = dbUri.getUserInfo().split(":")[1];
        dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(dbUrl, username, password);
        }
        return connection;
    }

    public boolean isConnected() {
        return connection != null;
    }
}