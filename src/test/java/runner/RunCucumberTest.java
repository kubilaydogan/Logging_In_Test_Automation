package runner;

import core.Driver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        tags = "@logs",
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions"},
        plugin = {"pretty",
                "html:target/cukes",
                "json:target/cucumber-report.json",
                "junit:target/cucumber-report.xml",
                "rerun:target/rerun.txt"},
        monochrome = true,
        publish = true,
        dryRun = false
)
public class RunCucumberTest {
    @AfterClass
    public static void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.getDriver().quit();
        }
    }
}