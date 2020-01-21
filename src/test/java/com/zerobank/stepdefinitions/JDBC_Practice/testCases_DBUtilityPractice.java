package com.zerobank.stepdefinitions.JDBC_Practice;

import Utility.DBUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

public class testCases_DBUtilityPractice {

    @Test
    public void test1() throws SQLException {

        ResultSet resultSet = DBUtility.getResult("select * from employees");

        while(resultSet.next()){
            String fullName = resultSet.getString(2)+" "+resultSet.getString(3);
            int salary = resultSet.getInt(8);
            System.out.println(fullName + " "+ salary);
        }
    }

    @Test(description = "Verify that Steven King has the biggest salary")
    public void test2() throws SQLException {
        ResultSet resultSet = DBUtility.getResult("select * from employees");
        int salaryMax = 0;
        String maxName ="";

        //get the max salary
        while (resultSet.next()){
            if(resultSet.getInt(8)>salaryMax)
                salaryMax=resultSet.getInt(8);
        }
        System.out.println(salaryMax);

        resultSet = DBUtility.getResult("select * from employees");
        //get the name that has salary that matches with maxSalary
        while (resultSet.next()){

            if(resultSet.getInt(8)==salaryMax){
                maxName = resultSet.getString(2)+" "+resultSet.getString(3);
            }
        }
        System.out.println(maxName);


        // find richest guy using query
        resultSet = DBUtility.getResult("select first_name||' '||last_name from employees where salary = "+salaryMax);
        String richMan="";
        while (resultSet.next())
        richMan = resultSet.getString(1);

        Assert.assertEquals(richMan, "Steven King", "Steven King is not the richest");
    }

    @Test
    public void test3() throws SQLException {
        ResultSet resultSet = DBUtility.getResult("select * from locations");
        ResultSetMetaData rsm = resultSet.getMetaData();
        System.out.println("Total number of Columns: "+rsm.getColumnCount());
            // Total number of Columns: 6
        System.out.println("Name of the postal_code column:  "+ rsm.getColumnName(3));
            // Name of the postal_code column:  POSTAL_CODE
        String[] ColumnNames = new String[rsm.getColumnCount()];
        for (int i = 0; i < ColumnNames.length; i++) {
             ColumnNames[i]=rsm.getColumnName(i+1);

        }
        System.out.println(Arrays.asList(ColumnNames));
        // [LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID]
    }
}
