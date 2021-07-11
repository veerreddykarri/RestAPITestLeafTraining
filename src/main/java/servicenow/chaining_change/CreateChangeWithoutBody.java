package servicenow.chaining_change;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;

public class CreateChangeWithoutBody extends BaseClass {
    @Test
    public void createChangeWithoutBody() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .post()
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(201)
                //import static io.restassured.module.jsv.JsonSchemaValidator.*;(You have to import to use matchesJsonSchema class)
                //Also you should have json-schema-validator dependency in POM.xml
                .body(matchesJsonSchema(new File("./data/ChangeSchema.json")))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        sysID = jsonPath.get("result.sys_id");
        System.out.println(response.statusCode());
    }
}
