package servicenow.incident;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateIncident {
    @Test
    public void createIncidentWithBody(){
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/incident";
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        //step3 : request type (get)
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"short_description\": \"Display issue\", \"category\": \"Hardware\" }")
                .post();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
