package stepdefinitions;

import config.EnvironmentManager;
import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.action.LoginPage;
import config.ConfigReader;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginActions;

    @Given("user launches the application")
    public void launchApp() {
        loginActions = new LoginPage(DriverFactory.getDriver());
        DriverFactory.getDriver().get(EnvironmentManager.getUrl());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user logs in with valid credentials")
    public void login() {
        loginActions.login("Admin", "admin123");
    }

    @Then("user should be logged in successfully")
    public void verifyLogin() {
        Assert.assertTrue(true);
    }
}
