package servicenow.incident;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteIncident {
    @Test
    public void deleteIncident(){
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("sys_id","a46b480507513010eeb1f61d7c1ed05c")
                .delete("incident/{sys_id}");
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
