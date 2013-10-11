package com.kwc.testen.db;

import com.kwc.testen.model.TestResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marius Kristensen
 */
public class TestResultRepository {

    private static final String ONE_TESTRESULT = "SELECT * FROM TESTEN WHERE ID = ?";
    private static final String ADD_TESTRESULT = "INSERT INTO TESTEN (BRAND, MODEL, MODEL_YEAR, ENGINE_CC, HP, NM, WEIGHT, PASSENGERS_NUM, SPEED, ROAD_CONDITIONS, TEST_YEAR, DRIVER) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private final DatabaseHandler databaseHandler;

    public TestResultRepository() {
        databaseHandler = new DatabaseHandler();
    }

    public boolean addTestResult(TestResult testResult) {
        Connection connection = databaseHandler.getConnection();

        try {
            PreparedStatement pStmt = connection.prepareStatement(ADD_TESTRESULT);
            pStmt.setString(1, testResult.getBrand());
            pStmt.setString(2, testResult.getModel());
            pStmt.setString(3, testResult.getModel_year());
            pStmt.setString(4, testResult.getEngine_cc());
            pStmt.setInt(5, testResult.getHp());
            pStmt.setInt(6, testResult.getNm());
            pStmt.setString(7, testResult.getWeight());
            pStmt.setInt(8, testResult.getPassengers_num());
            pStmt.setInt(9, testResult.getSpeed());
            pStmt.setString(10, testResult.getRoad_conditions());
            pStmt.setString(11, testResult.getTest_year());
            pStmt.setString(12, testResult.getDriver());
            pStmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TestResult> getAllTestResults() {
        Connection connection = databaseHandler.getConnection();
        ArrayList<TestResult> testResults = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM TESTEN");
            while (rs.next()) {
                TestResult testResult = new TestResult(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)
                );
                testResults.add(testResult);
            }
            closeConnection(connection, rs, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testResults;
    }

    public Integer countRows() {
        Connection connection = databaseHandler.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM TESTEN");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

            closeConnection(connection, resultSet, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TestResult getTestResult(int id) {
        Connection connection = databaseHandler.getConnection();
        TestResult testResult = null;
        try {
            PreparedStatement pStmt = connection.prepareStatement(ONE_TESTRESULT);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                testResult = new TestResult(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)
                );

            }
            closeConnection(connection, rs, pStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testResult;
    }

    private void closeConnection(Connection connection, ResultSet resultSet, Statement statement) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}