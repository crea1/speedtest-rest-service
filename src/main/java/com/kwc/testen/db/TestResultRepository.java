package com.kwc.testen.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Marius Kristensen
 */
public class TestResultRepository implements TestResultService {

    private final DatabaseHandler databaseHandler;

    public TestResultRepository() {
        databaseHandler = new DatabaseHandler();
    }

    @Override
    public Integer countRows() {
        Connection connection = null;
        connection = databaseHandler.getConnection();
        Statement statement = null;
        if (connection == null) {
            return 9001;
        }
        try {
            statement = connection.prepareStatement("select * from testen");
            ResultSet resultSet = statement.getResultSet();
            return resultSet.getInt(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
