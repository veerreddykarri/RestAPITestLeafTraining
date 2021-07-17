package jira.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class CucumberAnnotations {
    @Before
    public void init(){
        RestAssured.baseURI ="https://veerkarriapiautomation.atlassian.net/rest/api/2/";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
    }
    @After
    public void tearDown(Scenario sc){
        System.out.println(sc.getName()+" : "+sc.getStatus());
        System.out.println(sc.getId());
    }
}
