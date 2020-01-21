package com.zerobank.stepdefinitions.JDBC_Practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleConnection {


    public static void main(String[] args)throws SQLException {
/*
    hostname: 54.173.172.95 (taken from aws) (Always changes)
    port: 1521 (always same for Amazon aws)




 */

        String  url = "jdbc:oracle:thin:@54.173.172.95:1521:xe", // taken from aws
                password = "hr",
                username = "hr";

        //Step 1 >> create connection
        Connection connection = DriverManager.getConnection(url,username,password);

        //Step 2 >> create statement
        Statement statement = connection.createStatement();

        //Step 3 >> write query, execute , return resultSet
        ResultSet resultSet = statement.executeQuery("select * from employees");

        List<String> names = new ArrayList<>();
        while(resultSet.next()){
            names.add(resultSet.getString("first_name")+resultSet.getString("last_name"));

        }


        System.out.println("===================");



        System.out.println(names);
        resultSet = statement.executeQuery("select * from employees");
        while(resultSet.next()){
            System.out.println(resultSet.getString("first_name"));
        }


        System.out.println("===================");


        resultSet = statement.executeQuery("select * from countries");
        while(resultSet.next()){
            System.out.println(resultSet.getString("country_name"));

            if(resultSet.getString("country_name").equals("Germany")){
                System.out.println("Uraaaaaaaaaaaaaaaaaaaaa");
            }
        }



    }
}
