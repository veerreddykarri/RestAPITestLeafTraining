package servicenow.chaining_incident;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public static String sysID ="";
@BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://dev104727.service-now.com/api/now/table/incident";
        RestAssured.authentication = RestAssured.basic("admin", "Kt903723.");
    }
}
