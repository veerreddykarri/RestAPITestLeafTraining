package servicenow.chaining_incident;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass {
    @Test(dependsOnMethods = {"servicenow.chaining_incident.CreateIncidentWithoutBody.createIncidentWithoutBody"})
    public void updateIncident() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"short_description\": \"Display issue\", \"category\": \"Hardware\" }")
                .pathParam("sys_id", sysID)
                .patch("{sys_id}");
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
