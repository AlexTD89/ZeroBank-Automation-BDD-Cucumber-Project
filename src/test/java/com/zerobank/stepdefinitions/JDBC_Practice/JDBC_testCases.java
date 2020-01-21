package com.zerobank.stepdefinitions.JDBC_Practice;

/*
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
*/

/**
 * TestNG is required To Run this class
 */

import java.sql.*;

public class JDBC_testCases {
    Statement statement;
    ResultSet resultSet;

   // @BeforeMethod
    public void setUP(){
        String url = "jdbc:oracle:thin:@54.173.172.95:1521:xe", // taken from aws
                password = "hr",
                username = "hr";
        //Step 1 >> create connection
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            //Step 2 >> create statement
            statement = connection.createStatement();
        }catch (SQLException e){ }



    }

   // @Test(description = "Verify That Syfo salary is greater thnan Messi salary")
    public void test1() throws SQLException {

        int seyfoSalary = 0,
                messiSalary = 0;

        //Step 1 establish connection & retrieve the info from testers table
            // Connection is established in the BeforeMethod
        resultSet = statement.executeQuery("select * from testers");

        //Step 2,  retrieve the required information
        while (resultSet.next()) {
           String name = resultSet.getString(2);
           int salary = resultSet.getInt(3);
            System.out.println(name+" "+salary);

            if(name.equals("Seyfo")){
                seyfoSalary = salary;
            }else if(name.equals("Messi")){
                messiSalary = salary;
            }
        }

        System.out.println(seyfoSalary);
        System.out.println(messiSalary);
  //      Assert.assertTrue(seyfoSalary > messiSalary);

    }
}
