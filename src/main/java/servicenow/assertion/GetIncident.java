package servicenow.assertion;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetIncident {
    @Test
    public void getIncident() {
        //step1: get url
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/incident";
        //step2 : Authentication
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        Map<String,String> params = new HashMap<String,String>();
        params.put("sysparm_fields","number");
        params.put("category","software");
        //step3 : request type (get)
        Response response = RestAssured.given()
                .queryParams(params)
                .get()
                .then()
                .body("result.number[0]", Matchers.equalTo("INC0000006"))//To match specific when you know the index
                .extract().response();
        //Step4 : print response body
        response.prettyPrint();
        //Step5 : print status code
        System.out.println(response.statusCode());
    }
}
