package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.pages.CarShowroomPage;
import ui.pages.ErrorPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class Base
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
    public void tearDownUI() {
        if (driver != null) {
            driver.quit();
        }

    }

}
