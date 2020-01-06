package com.zerobank.stepdefinitions;


import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class FindTransactionsStepDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new LoginStepDefs().user_is_logged_in();
        accountActivityPage.AccountActivityModule.click();
        accountActivityPage.findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startDate, String endDate) {
        accountActivityPage.fromDate.clear();
        accountActivityPage.fromDate.sendKeys(startDate);
        accountActivityPage.toDate.clear();
        accountActivityPage.toDate.sendKeys(endDate);
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitForClickablility(accountActivityPage.find, 4);
        accountActivityPage.find.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startDate, String endDate) {
        int fromDate = Integer.parseInt(startDate.replace("-", ""));
        int toDate = Integer.parseInt(endDate.replace("-", ""));
        //wait() method will wait for the table(element of the table) to become present on the page
        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@id='filtered_transactions_for_account']//tr[1]/td[1]"), 10);
        List<Integer> list = new AccountActivityPage().convertListWEtoInteger(accountActivityPage.dateColumn);
        Collections.sort(list);
        Assert.assertTrue(list.get(0) >= fromDate && list.get(list.size() - 1) <= toDate);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<Integer> actualOrder = new AccountActivityPage().convertListWEtoInteger(accountActivityPage.dateColumn);
        List<Integer> expectedOrder = accountActivityPage.sortListDescending(actualOrder);
        Assert.assertEquals(expectedOrder, actualOrder);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        Integer temp = Integer.parseInt(date.replace("-", ""));
        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@id='filtered_transactions_for_account']//tr[1]/td[1]"), 5);
        List<Integer> list = new AccountActivityPage().convertListWEtoInteger(accountActivityPage.dateColumn);
        //compare each element of the list with the expected date result
        for (Integer each : list) {
            Assert.assertFalse(temp.equals(each));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String input) {
        accountActivityPage.descriptionBox.clear();
        accountActivityPage.descriptionBox.sendKeys(input);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String input) {
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@id='filtered_transactions_for_account']//tr[1]/td[1]"), 5);
            List<String> list = new AccountActivityPage().convertListWEtoString(accountActivityPage.descriptionColumn);
            for (String eachElement : list) {
                Assert.assertTrue(eachElement.contains(input));
            }
        } catch (NoSuchElementException e) {

        } catch (TimeoutException e) {
            System.out.println("0 search results");
            System.out.println("Table is not displayed on the page if the are no search results");
            Assert.fail("0 search results");
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String input) {
        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@id='filtered_transactions_for_account']//tr[1]/td[1]"), 5);
        List<String> list = new AccountActivityPage().convertListWEtoString(accountActivityPage.descriptionColumn);
        for (String eachElement : list) {
            Assert.assertFalse(eachElement.contains(input));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String column) {
        int totalResults;
        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@id='filtered_transactions_for_account']//tr[1]/td[1]"), 5);
        switch (column) {
            case "Deposit":
                totalResults = accountActivityPage.depositColumn.size();
                break;
            case "Withdrawal":
                totalResults = accountActivityPage.withdrawalColumn.size();
                break;
            case "Date":
                totalResults = accountActivityPage.dateColumn.size();
                break;
            case "Description":
                totalResults = accountActivityPage.descriptionColumn.size();
                break;
            default:
                System.out.println("no such column");
                throw new NoSuchElementException();
        }
        Assert.assertTrue(totalResults >= 1);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String selectType) {
        int totalResults;
        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@id='filtered_transactions_for_account']//tr[1]/td[1]"), 5);
        switch (selectType) {
            case "Deposit":
                for (WebElement webElement : accountActivityPage.depositColumn) {
                    Assert.assertTrue(webElement.getText().isEmpty());
                }
                break;
            case "Withdrawal":
                for (WebElement webElement : accountActivityPage.withdrawalColumn) {
                    Assert.assertTrue(webElement.getText().isEmpty());
                }
                break;
            case "Date":
                for (WebElement webElement : accountActivityPage.dateColumn) {
                    Assert.assertTrue(webElement.getText().isEmpty());
                }
                break;
            case "Description":
                for (WebElement webElement : accountActivityPage.descriptionColumn) {
                    Assert.assertTrue(webElement.getText().isEmpty());
                }
                break;
            default:
                System.out.println("no such column");
                throw new NoSuchElementException();
        }
    }

    @When("user selects type {string}")
    public void user_selects_type(String selectType) {
        Select select = new Select(accountActivityPage.selectType);
        select.selectByVisibleText(selectType);
        accountActivityPage.find.click();
    }

}
