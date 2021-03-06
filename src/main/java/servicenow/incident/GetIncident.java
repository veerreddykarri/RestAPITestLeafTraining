package servicenow.incident;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GetIncident {
    public static void main(String[] args) {
        //step1: get url
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/incident";
        //step2 : Authentication
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        Map<String,String> params = new HashMap<String,String>();
        params.put("sysparm_fields","number,sys_id,category,short_description");
        params.put("category","software");
        //step3 : request type (get)
        Response response = RestAssured.given()
                .queryParams(params)
//                .queryParam("sysparm_fields","number,sys_id,category,short_description")
//                .queryParam("category","software")
                .get();
        //Step4 : print response body
        response.prettyPrint();
        //Step5 : print status code
        System.out.println(response.statusCode());
    }
}
