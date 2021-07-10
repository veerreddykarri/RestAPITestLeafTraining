package jira;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteIssue {
    @Test
    public void deleteIssue()
    {
        RestAssured.baseURI ="https://veerkarriapiautomation.atlassian.net/rest/api/2/issue/";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com","FCSKrY9P3E7b8Kc4qGiwB0F9");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("key","VEER-18")
                .delete("{key}");
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
