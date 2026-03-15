package hooks;

import config.EnvironmentManager;
import driver.DriverFactory;
import utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {

        String browser = System.getProperty("browser", "chrome");
        String env = System.getProperty("env", "qc");

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