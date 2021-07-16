package jira.chaining;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteIssue extends BaseClass{
    @Test(dependsOnMethods = {"jira.chaining.CreateIssueUsingJsonDataFile.createIssueWithDataFile","jira.chaining.UpdateIssue.updateIssue"})
    public void deleteIssue()
    {
        Response response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("key",key1)
                .delete("{key}")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(204)
                .extract().response();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
