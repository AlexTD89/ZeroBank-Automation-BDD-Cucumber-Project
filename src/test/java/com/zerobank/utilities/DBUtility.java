package com.zerobank.utilities;


import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class DBUtility {

    /**
     * will read the Configuration.properties file to get the:
     * user name
     * password
     * url
     *
     */
    private final static String username = ConfigurationReader.get("JDBC_Username"),
            password = ConfigurationReader.get("JDBC_Password"),
            url = ConfigurationReader.get("JDBC_URL");

    public static Connection connection;
    public static Statement statement;
    public static DatabaseMetaData metaData; // gets the info data about DataBase (username, dataBase type, DatabAse version, Driver name, Driver version, etc)

    /**
     * static block is activated automatically when the class is being called
     * static block that establishes the connection with DataBase using: url, username, password
     * creates statement to be passes to the ResultSet
     */
    static {
        try {
            connection= DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            metaData = connection.getMetaData();
        }catch(SQLException e) {
        }

    }


    /**
     *  this method will be called outside this class to execute connection & statement process
     *  will return a query from dataBase
     * @param sql
     * @return
     */
    public static ResultSet getResult(String sql) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(sql);
        }catch(SQLException e) {

        }
        return result;
    }

    /**
     * ???
     * @param sql
     * @return
     */
    public static PreparedStatement prepareResult(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
        }
        return preparedStatement;
    }


    /**
     *  this method closes the connection with the dataBase
     */
    public static void tearDown() {
        try {
            connection.close();
        }catch(Exception e) { }
    }

    /**
     * this method will update the table using sql query
     * INSERT, UPDATE, , DELETE, ALTER, TRUNCATE, DROP
     * @param sql
     */
    public static void UpdateQuery(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {

        }
    }


    /**
     * ???
     * @param myResults
     * @param fileName
     */
    public static void exportResults(ResultSet myResults, String fileName) {
        try {
            CSVWriter writer = new CSVWriter(
                    new OutputStreamWriter(new FileOutputStream(fileName + ".csv"), StandardCharsets.UTF_8),
                    ',',
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
            boolean includeHeaders = true;
            writer.writeAll(myResults, includeHeaders);
            writer.close();
            myResults.beforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * ??
     * @param myResults
     */
    public static void printToConsole(ResultSet myResults) {
        try {
            String file = "target.csv";
            CSVWriter writer = new CSVWriter(
                    new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8),
                    ',',
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
            boolean includeHeaders = true;
            writer.writeAll(myResults, includeHeaders);
            writer.close();
            BufferedReader br = null;
            String words = "";
            br = new BufferedReader(new FileReader(file));
            System.out.println();
            while ((words = br.readLine()) != null) {
                String[] code = words.split(",");
                int maxSize = 22;
                String formatter = "|\t%-" + maxSize + "s";
                for (String s : code) {
                    System.out.printf(formatter, s);
                }
                System.out.println("\n");
            }
            myResults.beforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
