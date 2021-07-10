package servicenow.incident;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class CreateIncidentUsingJsonDataFile {
    @Test
    public void createIncidentWithBodyWithDataFile(){
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/incident";
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        File file = new File("./data/CreateIncident.json");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(file)
                .post();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
