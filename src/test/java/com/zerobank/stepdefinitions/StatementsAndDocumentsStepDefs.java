package com.zerobank.stepdefinitions;

import com.zerobank.pages.OnlineStatementsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.OtherUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class StatementsAndDocumentsStepDefs {

    OnlineStatementsPage onlineStatementsPage = new OnlineStatementsPage();
    static int yearCopy;
    String path;

    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_Statements_Documents_tab() {
        new LoginStepDefs().user_is_logged_in();
        onlineStatementsPage.onlineStatementsModule.click();
    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer year) {
        switch (year) {
            case 2009:
                onlineStatementsPage._2009.click();
                break;
            case 2010:
                onlineStatementsPage._2010.click();
                break;
            case 2011:
                onlineStatementsPage._2011.click();
                break;
            case 2012:
                onlineStatementsPage._2012.click();
                break;
            default:
                Assert.fail("no Statements for this year");
        }
        yearCopy = year;
    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(Integer count) {
        String path = "//div[@id='os_" + yearCopy + "']//a";
        List<WebElement> statements = Driver.get().findElements(By.xpath(path));
        switch (yearCopy) {
            case 2009:
                Assert.assertEquals(count, Integer.valueOf(statements.size()));
                break;
            case 2010:
                Assert.assertEquals(count, Integer.valueOf(statements.size()));
                break;
            case 2011:
                Assert.assertEquals(count, Integer.valueOf(statements.size()));
                break;
            case 2012:
                Assert.assertEquals(count, Integer.valueOf(statements.size()));
                break;
            default:
                Assert.fail("no Statements for this year");
        }
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String statementName) {
        Driver.get().findElement(By.linkText(statementName)).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String fileName) {
        path = System.getProperty("user.home")+"/Downloads/8534567-" + fileName + ".pdf";
        Assert.assertTrue(FilenameUtils.getName(path).contains(fileName));
    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
        Assert.assertEquals("pdf", FilenameUtils.getExtension(path));
        OtherUtils.deleteFile(path);
    }

}
