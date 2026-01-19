package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public static Response post(String endpoint, Object body) {
        Response response = given()
                .when()
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();

        return  response;
    }

    public static Response get(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response put(String endpoint, Object body) {

        return given()
                .when()
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response delete(String endpoint) {
        return given()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response patch(String endpoint, Object body) {
        return given()
                .when()
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .patch(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}
