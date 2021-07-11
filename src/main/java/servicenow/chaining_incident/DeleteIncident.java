package servicenow.chaining_incident;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass {
    @Test(dependsOnMethods = {"servicenow.chaining_incident.UpdateIncident.updateIncident"})
    public void deleteIncident() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("sys_id", sysID)
                .delete("{sys_id}");
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
