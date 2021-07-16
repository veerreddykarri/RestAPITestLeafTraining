package jira.chaining;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public static String key1 = "";

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "https://veerkarriapiautomation.atlassian.net/rest/api/2/issue/";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
    }
}
