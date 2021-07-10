package jira;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class UpdateIssue {
    @Test
    public void updateIssue(){
        RestAssured.baseURI = "https://veerkarriapiautomation.atlassian.net/rest/api/2/issue/";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("key","VEER-18")
                .body("{ \"fields\": { \"project\": { \"key\": \"VEER\" }, \"summary\": \"updated issue in RA project by Veer\", \"description\": \"Updating an issue using project keys and issue type names using the REST API\", \"issuetype\": { \"name\": \"Epic\" } } }")
                .put("{key}");
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
