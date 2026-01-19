package steps;

import api.ApiService;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class CarsShowroomAPISteps
{

    Response response;
    @Test
    public void getCarList()
    {
        ApiService.getCarList().
                then().
                assertThat().
                statusCode(200).
                body("name",containsStringIgnoringCase("Renault Clio"));
    }
    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
         response=ApiService.getCarList();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the response should contain {string}")
    public void the_response_status_should_be(String field) {
        response.then().assertThat().body("name",containsStringIgnoringCase(field));
    }

    @Then("each car contains, name, price, and image")
    public void each_car_contains_required_fields() {
        response.then()
                .body("cars.id", everyItem(notNullValue()))
                .body("cars.name", everyItem(notNullValue()))
                .body("cars.price", everyItem(notNullValue()))
                .body("cars.image", everyItem(notNullValue()));

    }

    @Then("the cars list should not be empty")
    public void the_cars_list_should_not_be_empty() {
        response.then()
                .body("cars.size()", greaterThan(0));
    }

}
