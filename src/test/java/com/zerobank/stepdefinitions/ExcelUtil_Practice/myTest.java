package com.zerobank.stepdefinitions.ExcelUtil_Practice;

import com.zerobank.utilities.ExcelUtil;
// import org.testng.annotations.Test;

import java.util.List;

public class myTest {

//    @Test
    public void readExcelPractice(){

        ExcelUtil qa1Read = new ExcelUtil("/Users/alex/Desktop/Keyword Driven Framework example.xlsx", "Keywords");

        System.out.println("step 1");
        System.out.println(qa1Read.rowCount());

        System.out.println("step 2");
        System.out.println(qa1Read.getDataList());

        System.out.println("step 3");
        List<String> list = qa1Read.getColumnsNames();
        System.out.println(list);
        System.out.println(list.size());

        System.out.println("step 4");
        System.out.println(qa1Read.getCellData(5,0));






    }


}
