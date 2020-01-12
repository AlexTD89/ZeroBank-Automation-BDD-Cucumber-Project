package com.zerobank.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OtherUtils {

    /**
     * This method will delete permanently a file from the given folder
     * using costume build path (have to provide the path)
     * @param path
     */
    public static void deleteFile(String path){
        try
        {
            Files.deleteIfExists(Paths.get(path));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty.");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }
        System.out.println("Deletion successful.");
    }

    /**
     * This method will pass a List of WebElements and converts it to List of Integers
     * @param listWeb
     * @return
     */
    public static List<Integer> convertListWEtoInteger(List<WebElement> listWeb){
        List<Integer> list = new ArrayList<>();
        for (WebElement webElement : listWeb) {
            String str = webElement.getText().replace("-","");
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    /**
     * This method will pass a list of WebElements and converts it to List of Strings
     * @param listweb
     * @return
     */
    public static List<String> convertListWEtoString(List<WebElement> listweb){
        List<String> list = new ArrayList<>();
        for (WebElement webElement : listweb) {
            list.add(webElement.getText());
        }
        return list;
    }

    /**
     * This method will pass a List of Integers and will sort it in Descending order
     * @param list
     * @return
     */
    public static List<Integer> sortListDescending(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        Collections.sort(list1);
        List<Integer> newList = new ArrayList<>();
        for (int i = list.size()-1; i >=0; i--) {
            newList.add(list1.get(i));
        }

        return newList;
    }

    /**
     * This method will return the first selected option in dropdown Select menu
     * @return
     */
    public static String getFirstSelectedOption(WebElement webElement){
        Select select = new Select(webElement);
        return select.getFirstSelectedOption().getText();
    }
}
