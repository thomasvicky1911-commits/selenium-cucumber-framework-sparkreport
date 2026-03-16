package hooks;

import config.EnvironmentManager;
import driver.DriverFactory;
import org.testng.Reporter;
import utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {

        String browser = Reporter.getCurrentTestResult()
                .getTestContext()
                .getCurrentXmlTest()
                .getParameter("browser");

        String env = Reporter.getCurrentTestResult()
                .getTestContext()
                .getCurrentXmlTest()
                .getParameter("env");

        // STRICT validation
        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser parameter is missing in testng.xml");
        }

        if (env == null || env.isEmpty()) {
            throw new RuntimeException("Environment parameter is missing in testng.xml");
        }

        EnvironmentManager.loadEnvironment(env);
        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(scenario);
        }
        DriverFactory.quitDriver();
    }
}