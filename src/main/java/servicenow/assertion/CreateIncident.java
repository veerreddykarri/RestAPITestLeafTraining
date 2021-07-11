package servicenow.assertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateIncident {
    @Test
    public void createIncidentWithBody(){
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/incident";
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        //step3 : request type (get)
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"short_description\": \"Display issue\", \"category\": \"Hardware\" }")
                .post()
                .then()
                .body("result.short_description", Matchers.equalTo("Display issue"))
                .body("result.short_description", Matchers.containsString("Display"))
                .extract().response();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
