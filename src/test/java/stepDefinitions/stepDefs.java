package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;

public class stepDefs {

    private static Logger log = LogManager.getLogger(stepDefs.class);

    @Given("^I login as (admin|manager|practitioner)$")
    public void loginToApp(String profile) {
        LoginPage.login(profile);
    }

    @When("I devide {int} to {int}")
    public void iDevideTo(int n1, int n2) {

        try{
            System.out.println(n1/n2);
        }catch(ArithmeticException e){
            log.error(String.format("Error occurred when doing the transaction: %s", e));
            log.error(String.format("Error occurred when doing the transaction: %s", e.getMessage()));
        }

    }
}
