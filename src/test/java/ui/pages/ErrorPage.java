package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErrorPage
{
    //*[@id="hd-close-button"]/svg/path

    @FindBy(id = "hd-close-button")
    WebElement xpathCloseAdButton;

    @FindBy(xpath = "//*[@id='hd-content-container']/iframe")
    WebElement xpathAdIframe;

    public static WebDriver driver = null;

    public ErrorPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void closeAdPopup() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(xpathCloseAdButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", xpathCloseAdButton);
        //xpathCloseAdButton.click();
    }
    public void switchFrame() {
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(xpathAdIframe));
        driver.switchTo().frame(xpathAdIframe);
    }
}
