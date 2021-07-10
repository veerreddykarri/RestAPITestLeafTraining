package jira;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class GetAllIssues {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://veerkarriapiautomation.atlassian.net/rest/api/2/search";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
        Response response = RestAssured.get();
        // response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        List<Object> list = jsonPath.getList("issues.key");
        for (Object eachId:list) {
            System.out.println(eachId);
        }
    }
}
