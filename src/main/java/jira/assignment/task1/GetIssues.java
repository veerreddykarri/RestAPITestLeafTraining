package jira.assignment.task1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class GetIssues {
    @Test
    public void getIssues(){
        RestAssured.baseURI = "https://veerkarriapiautomation.atlassian.net/rest/api/2/search";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
        RestAssured.given()
                .contentType(ContentType.JSON)
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }
}
