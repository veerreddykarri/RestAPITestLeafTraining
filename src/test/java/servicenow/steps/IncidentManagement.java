package servicenow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class IncidentManagement {
    Response response;
//    @Given("setup the endpoint")
//    public void setEndpoint(){
//        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/incident";
//    }
//    @And("setup the Authentication")
//    public void setAuth(){
//        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
//    }
    @When("place the post request")
    public void createIncident(){
         response= RestAssured.given()
                .contentType(ContentType.JSON)
                .post("incident");
    }
    @Then("verify the status code as {int}")
    public void verifyTheStatusCodeAs(int code) {
        response.then().assertThat().statusCode(code);
    }
    @And("verify content type as (.*)$")
    public void verifyContentType(String type) {
        if (type.toLowerCase().contains("json")) {
            response.then().assertThat().contentType(ContentType.JSON);
        } else if (type.toLowerCase().contains("xml")) {
            response.then().assertThat().contentType(ContentType.XML);
        }
    }

    @When("place the post request with short_description as (.*) and category as (.*)$")
    public void createIncidentWithBody(String description,String category) {
        response= RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"short_description\": \""+description+"\", \"category\": \""+category+"\" }")
                .post("incident");
    }

    @And("verify short_description as (.*) and category as (.*)$")
    public void verifyResponseBody(String description, String category) {
        response.then().assertThat()
                .body("result.short_description", Matchers.equalTo(description))
                .body("result.category", Matchers.equalTo(category));
    }

    @And("print response")
    public void printResponse() {
        response.prettyPrint();
    }
}
