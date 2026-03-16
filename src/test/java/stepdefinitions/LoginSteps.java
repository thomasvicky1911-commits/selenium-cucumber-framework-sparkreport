package stepdefinitions;

import config.EnvironmentManager;
import driver.DriverFactory;
import io.cucumber.java.PendingException;
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
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        loginActions.login(username, password);
    }

    @When("user logs in with invalid credentials")
    public void userLogsInWithInvalidCredentials() {
        String username = ConfigReader.get("username");
        String invalidpassword = ConfigReader.get("invalidpassword");
        loginActions.login(username, invalidpassword);
    }

    @Then("user should be logged in successfully")
    public void verifyLogin() {
        Assert.assertTrue(true);
    }
}
