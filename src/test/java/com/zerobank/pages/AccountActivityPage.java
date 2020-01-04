package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountActivityPage extends BasePage{


    @FindBy(id = "aa_accountId")
    public WebElement dropdownMenu;

    @FindAll(@FindBy(xpath = "//thead//th"))
    public List<WebElement> tableHeader;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = "[type='submit']")
    public WebElement find;

    // all results after "Find Transactions" search, under Date Column
    @FindAll(@FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]"))
    public List<WebElement> dateColumn;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    // all results after "Find Transactions" search, under Description Column
    @FindAll(@FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]"))
    public List<WebElement> descriptionColumn;

    @FindBy(css = "div.well")
    public WebElement noResultsMSG;

    @FindAll(@FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[3]"))
    public List<WebElement> depositColumn;

    @FindAll(@FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[4]"))
    public List<WebElement> withdrawalColumn;

    @FindBy(id = "aa_type")
    public WebElement selectType;


    /**
     * This method will return the first selected option in dropdown Select menu
     * @return
     */
    public String getFirstSelectedOption(){
        Select select = new Select(dropdownMenu);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * This method will pass a List of WebElements and converts it to List of Integers
     * @param listWeb
     * @return
     */
    public List<Integer> convertListWEtoInteger(List<WebElement> listWeb){
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
    public List<String> convertListWEtoString(List<WebElement> listweb){
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
    public List<Integer> sortListDescending(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        Collections.sort(list1);
        List<Integer> newList = new ArrayList<>();
        for (int i = list.size()-1; i >=0; i--) {
             newList.add(list1.get(i));
        }

        return newList;
    }


}
