package servicenow.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class CucumberAnnotations {
    @Before
    public void init(){
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
    }
    @After
    public void tearDown(Scenario sc){
        System.out.println(sc.getName()+" : "+sc.getStatus());
        System.out.println(sc.getId());
    }
}
