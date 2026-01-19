package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.pages.CarShowroomPage;
import ui.pages.ErrorPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class Base
{

    DriverFactory driverFactory = new DriverFactory();

    final WebDriver driver = driverFactory.browserchoice(ConfigReader.getProperty("web.url"),ConfigReader.getProperty("web.browser"));

    CarShowroomPage carShowroomPage = PageFactory.initElements(driver, CarShowroomPage.class);

    ErrorPage errorPage = PageFactory.initElements(driver, ErrorPage.class);


}
