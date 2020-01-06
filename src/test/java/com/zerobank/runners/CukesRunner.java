package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-cucumber-reports",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/zerobank/stepdefinitions",
        dryRun = false,
//        tags = "@LoginTest"
//        tags = "@AccountSummaryPageTest"
//        tags = "@AccountActivityPageTest"
//        tags = "@PayBillPageTest"
//        tags = "@AccountActivityNavigationTest"
//        tags = "@FindTransactionsTest"
//        tags = "@addNewPayeeTest"
//        tags = "@PurchaseForeignCurrencyTest"
//        tags = "@Statements&DocumentsTest"
        tags = "@wip" // work in progress

)
public class CukesRunner {
}
