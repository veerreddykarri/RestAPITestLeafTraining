package servicenow.chaining_incident;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateIncidentWithoutBody extends BaseClass {
    @Test
    public void createIncidentWithoutBody() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .post();
        response.prettyPrint();
        System.out.println(response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        sysID = jsonPath.get("result.sys_id").toString();
    }
}
