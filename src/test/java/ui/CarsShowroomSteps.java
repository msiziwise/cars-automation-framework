package ui;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Hooks;

import static utils.Hooks.carShowroomPage;
import static utils.Hooks.errorPage;
import static utils.DriverFactory.driver;

public class CarsShowroomSteps
{

    @Given("I navigate to the Cars Showroom page")
    public void navigateToCarsShowroomPage() {

        Hooks hooks = new Hooks();
        hooks.setUpUI();
    }
    // -----------------------
    // Smoke Tests
    // -----------------------

    @Then("the page title should contain {string}")
    public void verifyPageTitle(String expectedTitle) {
        carShowroomPage.VerifyTitle();
    }

    @Then("at least one car card should be displayed")
    public void verifyAtLeastOneCarCardVisible() {
        carShowroomPage.verifyAtLeastOneCarCardIsVisible();
    }

    @Then("the navigation bar should be displayed")
    public void verifyNavigationBarDisplayed() {
        // TODO: implement check for navigation bar visibility
    }

    @Then("the Cars menu item should be visible")
    public void verifyCarsMenuItemVisible() {
        // TODO: implement check for Cars menu item visibility
    }

    // -----------------------
    // Functional Tests
    // -----------------------

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

    @Then("the car details page should be displayed")
    public void verifyCarDetailsPageDisplayed() {
        // TODO: implement check that car details page is displayed
    }

    @Then("the car name should be visible")
    public void verifyCarNameVisible() {
        // TODO: implement check for car name visibility
    }

    @Then("the car brand should be visible")
    public void verifyCarBrandVisible() {
        // TODO: implement check for car brand visibility
    }

    @Then("the car price should be visible")
    public void verifyCarPriceVisible() {
        // TODO: implement check for car price visibility
    }

    @Then("the car image should be displayed")
    public void verifyCarImageDisplayed() {
        // TODO: implement check for car image visibility
    }

    @When("I navigate back to the Cars Showroom")
    public void navigateBackToCarsShowroom() {
        // TODO: implement navigation back to Cars Showroom page
    }

    @Then("the cars list page should be displayed")
    public void verifyCarsListPageDisplayed() {
        // TODO: implement verification that cars list is displayed
    }

    // -----------------------
    // Negative & Edge Cases
    // -----------------------

    @When("I perform a search without entering a value")
    public void performEmptySearch() {
        // TODO: implement search with empty input
    }

    @Then("the full list of cars should be displayed")
    public void verifyFullCarListDisplayed() {
        // TODO: implement check that full list is displayed
    }

    @When("I refresh the page")
    public void refreshPage() {
        // TODO: implement page refresh
    }

    @Then("the cars list should still be displayed")
    public void verifyCarListVisible() {
        // TODO: implement check that car list is visible after refresh
    }

    // -----------------------
    // API to UI Cross Validation
    // -----------------------

    @Given("I retrieve the list of cars from the API")
    public void retrieveCarsFromAPI() {
        // TODO: implement API call to get list of cars
    }

    @When("I view the Cars Showroom page")
    public void viewCarsShowroomPage() {
        // TODO: implement step to view Cars Showroom page
    }

    @Then("the number of cars displayed should match the API response")
    public void verifyCarCountMatchesAPI() {
        // TODO: implement check that UI car count matches API response
    }

    @Given("I retrieve a car by id from the API")
    public void retrieveCarByIdFromAPI() {
        // TODO: implement API call to get car by ID
    }

    @When("I open the same car details page in the UI")
    public void openCarDetailsPageInUI() {
        // TODO: implement step to open car details page
    }

    @Then("the car name should match the API response")
    public void verifyCarNameMatchesAPI() {
        // TODO: implement check that car name matches API
    }

    @Then("the car brand should match the API response")
    public void verifyCarBrandMatchesAPI() {
        // TODO: implement check that car brand matches API
    }

    @Then("the car price should match the API response")
    public void verifyCarPriceMatchesAPI() {
        // TODO: implement check that car price matches API
    }

    @Then("I should see a message containing {string}")
    public void iShouldSeeAMessageContaining(String arg0) {
        errorPage.switchFrame();
        carShowroomPage.verifyErrorMessage();
    }

    @And("the page should remain visible and usable")
    public void thePageShouldRemainVisibleAndUsable() {
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


