package jira.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.containsString;

public class JiraIssues extends BaseClass{
    Response response;
    @When("place the post request with key as (.*) and summary as (.*) and description as (.*) and name as (.*)$")
    public void createJiraIssue(String key, String summary,String description, String name) {
        response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body("{ \"fields\": { \"project\": { \"key\": \""+key+"\" }, \"summary\": \""+summary+"\", \"description\": \""+description+"\", \"issuetype\": { \"name\": \""+name+"\" } } }")
                .post("issue");
    }

    @Then("verify the status code for jira as {int}")
    public void verifyTheStatusCodeForJiraAs(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @And("verify jira content type as (.*)$")
    public void verifyJiraContentTypeAsJson(String contentType) {
        if (contentType.toLowerCase().contains("json")) {
            response.then().assertThat().contentType(ContentType.JSON);
        } else if (contentType.toLowerCase().contains("xml")) {
            response.then().assertThat().contentType(ContentType.XML);
        }
    }

    @And("verify key as (.*)$")
    public void verifyKeyAsKey(String key) {
        response.then()
                .assertThat()
                .body("key",containsString(key));
    }

    @And("print response for jira")
    public void printResponseForJira() {
        JsonPath jsonPath = response.jsonPath();
        id = jsonPath.get("id");
        response.prettyPrint();
    }

    @When("place the put request with key as (.*) and summary as (.*) and description as (.*) and name as (.*)$")
    public void updateJiraIssue(String key, String summary,String description, String name) {
        response=RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .body("{ \"fields\": { \"project\": { \"key\": \""+key+"\" }, \"summary\": \""+summary+"\", \"description\": \""+description+"\", \"issuetype\": { \"name\": \""+name+"\" } } }")
                .put("issue/{id}");
    }

    @When("Place the delete request with id")
    public void deleteJiraIssue() {
        response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .delete("issue/{id}");
    }

    @And("print response for jira for update")
    public void printResponseForJiraForUpdate() {
        response.prettyPrint();
    }

    @And("print response for jira delete")
    public void printResponseForJiraDelete() {
        response.prettyPrint();
    }
}
