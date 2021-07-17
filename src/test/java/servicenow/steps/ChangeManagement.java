package servicenow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class ChangeManagement {
    Response response;

    @When("place the post request with short_description as (.*) and type as (.*)$")
    public void createIncidentWithBody(String description, String type) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"short_description\": \"" + description + "\", \"type\": \"" + type + "\" }")
                .post("change_request");
    }

//    @Given("setup the endpoint for change")
//    public void setupTheEndpointForChange() {
//        RestAssured.baseURI = "https://dev104727.service-now.com/api/now/table/change_request";
//    }

    @And("verify short_description as (.*) and type as (.*)$")
    public void verifyResponseBody(String description, String type) {
        response.then().assertThat()
                .body("result.short_description", Matchers.equalTo(description))
                .body("result.type", Matchers.equalTo(type));
    }

//    @And("setup the Authentication for change")
//    public void setupTheAuthenticationForChange() {
//        RestAssured.authentication = RestAssured.basic("admin", "Kt903723.");
//    }

    @Then("verify the status code for change as {int}")
    public void verifyTheStatusCodeForChangeAs(int status) {
        response.then().assertThat().statusCode(status);
    }

    @And("verify change content type as (.*)$")
    public void verifyChangeContentTypeAsJson(String contentType) {
        if (contentType.toLowerCase().contains("json")) {
            response.then().assertThat().contentType(ContentType.JSON);
        } else if (contentType.toLowerCase().contains("xml")) {
            response.then().assertThat().contentType(ContentType.XML);
        }
    }

    @And("print response for change")
    public void printResponseForChange() {
        response.prettyPrint();
    }
}
