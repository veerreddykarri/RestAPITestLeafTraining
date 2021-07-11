package servicenow.chaining_change;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateChange extends BaseClass {
    @Test(dependsOnMethods = {"servicenow.chaining_change.CreateChangeWithoutBody.createChangeWithoutBody"})
    public void updateChange() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"short_description\": \"Veer updated Change Request\", \"type\": \"normal\" }")
                .pathParam("sys_id", sysID)
                .put("{sys_id}")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().response();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
