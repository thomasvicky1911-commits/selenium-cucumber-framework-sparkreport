package pages.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.locators.LoginPageLocators;
import utils.WaitUtil;

public class LoginPage {

    private WebDriver driver;
    private WaitUtil wait;
    private LoginPageLocators locators;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtil(driver, 10);
        this.locators = new LoginPageLocators();
        PageFactory.initElements(driver, locators);
    }

    public void login(String user, String pass) {
        wait.waitForVisibility(locators.username).sendKeys(user);
        wait.waitForVisibility(locators.password).sendKeys(pass);
        wait.waitForClickable(locators.loginButton).click();
        wait.waitForTextToBePresentInElement(locators.adminLink, "Admin");
    }
}