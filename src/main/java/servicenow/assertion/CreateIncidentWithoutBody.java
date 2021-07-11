package servicenow.assertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateIncidentWithoutBody {
    @Test
    public void createIncidentWithoutBody(){
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/incident";
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        //step3 : request type (get)
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .post()
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(201)
                .extract().response();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
