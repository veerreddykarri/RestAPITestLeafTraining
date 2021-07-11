package servicenow.chaining_change;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteChange extends BaseClass {
    @Test(dependsOnMethods = {"servicenow.chaining_change.CreateChangeWithoutBody.createChangeWithoutBody",
            "servicenow.chaining_change.UpdateChange.updateChange"})
    public void deleteChange() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
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
