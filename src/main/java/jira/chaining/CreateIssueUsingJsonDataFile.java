package jira.chaining;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class CreateIssueUsingJsonDataFile extends BaseClass {

    @Test
    public void createIssueWithDataFile() {
        File file = new File("./data/CreateIssue.json");
        Response response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(file)
                .post()
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(201)
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        key1 = jsonPath.get("key");
        System.out.println(key1);
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
