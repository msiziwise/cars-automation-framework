package ui;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static utils.DriverFactory.driver;

public class Hooks {

    @AfterStep
    public void tearDown(Scenario scenario) {
        // This method will be executed after each scenario
        if (scenario.isFailed()) {
            // Take a screenshot and attach it to the report
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
//        driver.quit();
    }
}
