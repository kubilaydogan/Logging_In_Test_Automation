package stepDefinitions;
import core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class hooks {
    private static final Logger log = LoggerFactory.getLogger(hooks.class);
    private static boolean setUpIsDone = false;

    @Before(order=1)
    public void setup1(Scenario scenario) {
        // This will be logged only once
        if (setUpIsDone) {
        } else {
            log.info("===============================================================");
            log.info("|          Test is Starting...");
            log.info("|          Operating System : " + System.getProperty("os.name"));
            log.info("===============================================================\n");
            setUpIsDone = true;
        }
    }

    @Before(order=2)
    public void setup2(Scenario scenario) {
        log.info("===============================================================");
        log.info("|          Scenario Name: " + scenario.getName());
        log.info("===============================================================");
    }

    @Before(order=2, value="not @hookless")
    public void setup() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Driver.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
        Driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @After("not @hookless")
    public void takeScreenShotOnFailedScenario(Scenario scenario) {
        if ((scenario.isFailed())) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
