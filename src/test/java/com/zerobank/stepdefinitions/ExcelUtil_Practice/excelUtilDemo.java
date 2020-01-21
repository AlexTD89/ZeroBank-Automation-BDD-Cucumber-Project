package com.zerobank.stepdefinitions.ExcelUtil_Practice;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class excelUtilDemo {


    @Test
    public void readExcelTest(){

        //create an instance of excel utility
        // argument 1: location of the file
        // argument 2: sheet we want to open
        // when we create object of this utility it means we opened the file and accessed certain sheet inside it
        ExcelUtil qa1Short = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx", "QA1-short");

        //ExcelUtil has some built in methods, EXPLORE....
        // get number of columns
        System.out.println("Column Count: "+qa1Short.rowCount()); //Column Count: 16
        // get column names
        System.out.println("Column Names: "+qa1Short.getColumnsNames()); // Column Names: [username, password, firstname, lastname, result]
        // get all data
        System.out.println(qa1Short.getDataList()); // check in console

        List<Map<String, String>> datalist = qa1Short.getDataList();
        for (Map<String, String> stringStringMap : datalist) {
            System.out.println("stringStringMap = " + stringStringMap);
        }

        System.out.println("==================================\n");

        //get all data in 2nd array
        String[][] dataArray = qa1Short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));;

    }


}
