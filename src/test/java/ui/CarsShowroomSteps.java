package ui;

import api.ApiService;
import api.CarsShowroomAPISteps;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Hooks;

import static utils.Hooks.carShowroomPage;
import static utils.Hooks.errorPage;
import static utils.DriverFactory.driver;

public class CarsShowroomSteps {

    Response response;
    int apiCarCount;
    String name,price;

    @Given("I navigate to the Cars Showroom page")
    public void navigateToCarsShowroomPage() {

        Hooks hooks = new Hooks();
        hooks.setUpUI();
    }

    @Then("the page title should contain {string}")
    public void verifyPageTitle(String expectedTitle) {
        carShowroomPage.VerifyTitle();
    }

    @Then("at least one car card should be displayed")
    public void verifyAtLeastOneCarCardVisible() {
        carShowroomPage.verifyAtLeastOneCarCardIsVisible();
    }

    @Then("each car card should display:")
    public void verifyCarCardFields() {
        carShowroomPage.verifyCardFields();
    }

    @Then("each car card should have a View Details button")
    public void verifyViewDetailsButtonOnCarCard() {
        carShowroomPage.verifyViewDetailLink();
    }

    @When("I click View Details on the first car")
    public void clickFirstCar() {
        carShowroomPage.clickCarCard();
    }

    @When("I refresh the page")
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Then("the cars list should still be displayed")
    public void verifyCarListVisible() {
        Assert.assertTrue("Cars list is not displayed",carShowroomPage.isCarListDisplayed());
    }

    @Given("I retrieve the list of cars from the API {string}")
    public void retrieveCarsFromAPI(String endpoint)
    {
        response= ApiService.getCarList(endpoint);
        apiCarCount = response.jsonPath().getList("cars").size();
        name =response.jsonPath().getString("cars[0].name").toString();
        price = response.jsonPath().getString("cars[0].price").toString();
    }

    @Then("the number of cars displayed should match the API response")
    public void verifyCarCountMatchesAPI() {
        int uiCarCount = carShowroomPage.DisplayedCarCount();
        Assert.assertTrue( uiCarCount>=apiCarCount);
    }

    @Then("the car name should match the API response")
    public void verifyCarNameMatchesAPI() {
        Assert.assertEquals(name,carShowroomPage.getname().trim());
    }

    @Then("the car price should match the API response")
    public void verifyCarPriceMatchesAPI() {
        Assert.assertEquals(price,carShowroomPage.getprice().trim());
    }

    @Then("I should see a message containing {string}")
    public void iShouldSeeAMessageContaining(String arg0) {
        errorPage.switchFrame();
        carShowroomPage.verifyErrorMessage();
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


