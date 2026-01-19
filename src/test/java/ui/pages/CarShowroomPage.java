package ui.pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CarShowroomPage {
    public static WebDriver driver = null;

    public CarShowroomPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='core']//h1")
    WebElement xpathPageTitle;

    @FindBy(xpath = "//*[@id='core']//p[contains(text(),'demo')]")
    WebElement xpathPageDescription;

    @FindBy(xpath = "/html/body/header/nav")
    WebElement navigationBar;

    @FindBy(xpath = "//nav//li[contains(text(),'Cars')]")
    WebElement xpathBreadcrumbCars;

    @FindBy(xpath = "//a[normalize-space()='Buy us a coffee']")
    WebElement xpathBuyUsACoffeeLink;

//    @FindBy(xpath = "//a[contains(text(),'Do you enjoy this platform')]")
//    WebElement xpathEnjoyPlatformLink;

    @FindBy(xpath = "//*[@id='car-list']//div[contains(@class,'card')]")
    List<WebElement> xpathCarCards;

    @FindBy(xpath = "//*[@id='car-list']/div[1]")
    WebElement xpathFirstCarCard;

    @FindBy(xpath = "//*[@id='car-list']/div[1]//a")
    WebElement xpathFirstCarName;

    @FindBy(xpath = "//*[@id='car-list']/div[1]//p[.//text()]")
    WebElement xpathFirstCarPrice;

    @FindBy(xpath = "//*[@id='car-list']//span[position()=2]")
    WebElement xpathCarDealership;

    @FindBy(xpath = "//*[@id='fallback-title']")
    WebElement xpathNoResultsMessage;

    @FindBy(xpath = "//*[contains(text(),\"couldn't find results\")]")
    WebElement xpathNoResultsPartialMessage;

    @FindBy(xpath = "//*[@id='fallback-title']//b")
    WebElement xpathSearchedCarName;

    @FindBy(xpath = "//*[@id='skyscraper-editorial']//a")
    WebElement xpathPremiumRentalInsightsLink;

    @FindBy(xpath = "//*[@id='skyscraper-editorial']//*[contains(text(),'nilambur')]")
    WebElement xpathEditorialLocationText;

    public void clickCarCard() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", xpathFirstCarName);
        //new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(xpathFirstCarName));
        //xpathFirstCarName.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", xpathFirstCarName);


    }
    public void switchToNewWindow()
    {
        switchToNewWindow();
    }
     public void VerifyTitle()
     {
         Assert.assertEquals("Cars Showroom Test page for Automation Testing",xpathPageTitle.getText().trim());
     }
     public void verifyAtLeastOneCarCardIsVisible()
     {
         Assert.assertFalse("No car cards are visible", xpathCarCards.isEmpty());
     }
     public void verifyCardFields()
     {

         Assert.assertTrue("Car price is not visible",xpathFirstCarPrice.isDisplayed());
         Assert.assertTrue("Car make is not visible",xpathFirstCarName.isDisplayed());
     }
     public void verifyViewDetailLink()
     {
         Assert.assertTrue("Car details link is not visible",xpathFirstCarName.isDisplayed());
     }
    public void verifyNavigationBarIsDisplayed() {
        Assert.assertTrue("Navigation bar is not visible", navigationBar.isDisplayed());
    }
    public void verifyErrorMessage()
    {

        Assert.assertEquals("We couldn't find results for VW Golf.",xpathNoResultsMessage.getText());
    }

  }

