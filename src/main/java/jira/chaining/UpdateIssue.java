package jira.chaining;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateIssue extends BaseClass {
    @Test(dependsOnMethods = {"jira.chaining.CreateIssueUsingJsonDataFile.createIssueWithDataFile"})
    public void updateIssue(){
        Response response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("key",key1)
                .body("{ \"fields\": { \"project\": { \"key\": \"VEER\" }, \"summary\": \"updated issue in RA project by Veer\", \"description\": \"Updating an issue using project keys and issue type names using the REST API\", \"issuetype\": { \"name\": \"Epic\" } } }")
                .put("{key}")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(204)
                .extract().response();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
