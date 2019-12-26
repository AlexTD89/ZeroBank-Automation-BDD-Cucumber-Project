package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-cucumber-reports"
        },
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        dryRun = false,
//        tags = "@driver", // will execute only this the given scenarios/test with the given tag
//        tags = {"@driver", "@VYT-123"} // will execute only this the given scenarios/test with the given tags
//        tags = {"@sales_manager and @VYT-123"} // another way to give 2 tags
//        tags = {"@sales_manager or @VYT-123"} // will execute scenarios/test with the given 1st tag or 2nd tag
//        tags = "@login" // will run all the tests that have this tag, in this case this tag is before Feature keyword, means all scenarios
//        tags = "@login and not @driver" // run all tests with this text except/ignore @driver tag
//        tags = {"@login"," ~@driver"} // run all tests with this text except/ignore @driver tag
        tags = "@wip"
)
public class CukesRunner {
}
