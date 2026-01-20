package utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.CarShowroomPage;
import ui.ErrorPage;

public class Hooks
{

    public static WebDriver driver;
    public static CarShowroomPage carShowroomPage;
    public static ErrorPage errorPage;

    @Before("@ui")
    public void setUpUI() {
        DriverFactory driverFactory = new DriverFactory();

        driver = driverFactory.browserchoice(ConfigReader.getProperty("web.url"), ConfigReader.getProperty("web.browser"));

        carShowroomPage = PageFactory.initElements(driver, CarShowroomPage.class);

        errorPage = PageFactory.initElements(driver, ErrorPage.class);
    }

    @After("@ui")
    public void tearDownUI()
    {
        driver.quit();
    }
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


