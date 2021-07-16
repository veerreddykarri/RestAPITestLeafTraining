package jira.assignment.task1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CreateJiraIssue {
    @Test
    public void createJiraIssue(){
        RestAssured.baseURI = "https://veerkarriapiautomation.atlassian.net/rest/api/2/";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"fields\": {\n" +
                        "    \"project\": {\n" +
                        "      \"key\": \"VEER\"\n" +
                        "    },\n" +
                        "    \"summary\": \"create issue in Veer project by Veer using RA\",\n" +
                        "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\n" +
                        "    \"issuetype\": {\n" +
                        "      \"name\": \"Bug\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}")
                .when()
                .post("issue")
                .then()
                .assertThat()
                .body("key",containsString("VEER"));
    }
}
