package jira.assignment.task1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsString;

public class DeleteRandomIssue {
    @Test
    public void deleteRandomIssue(){
        RestAssured.baseURI = "https://veerkarriapiautomation.atlassian.net/rest/api/2/";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
        Response response = RestAssured.given().queryParams("jql","project = VEER").get("search");
        JsonPath jsonPath = response.jsonPath();
        List<String> list = jsonPath.getList("issues.key");
        int count = list.size();
        int index = (int) (Math.random() * count);
        String randomKey = list.get(index);
        System.out.println(randomKey);
        RestAssured.delete("issue/"+randomKey)
                .then().assertThat().statusCode(204);

    }
}
