package jira.schema;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class CreateIssue {
    @Test
    public void createIssue()
    {
        RestAssured.baseURI = "https://veerkarriapiautomation.atlassian.net/rest/api/2/issue/";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"fields\": { \"project\": { \"key\": \"VEER\" }, \"summary\": \"create issue in Veer project by Veer\", \"description\": \"Creating of an issue using project keys and issue type names using the REST API\", \"issuetype\": { \"name\": \"Bug\" } } }")
                .post()
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(201)
                .body(matchesJsonSchema(new File("./data/JiraCreateIssueSchema.json")))
                .extract().response();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
