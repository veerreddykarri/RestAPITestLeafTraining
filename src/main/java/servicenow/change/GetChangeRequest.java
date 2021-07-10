package servicenow.change;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetChangeRequest {
    public static void main(String[] args) {
        //step1: get url
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/change_request";
        //step2 : Authentication
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        Map<String,String> params = new HashMap<String,String>();
        params.put("sysparm_fields","number,sys_id,category,short_description,type");
     //   params.put("category","normal");
        //step3 : request type (get)
        Response response = RestAssured.given()
                .queryParams(params)
//                .queryParam("sysparm_fields","number,sys_id,category,short_description")
//                .queryParam("category","software")
                .get();
        JsonPath jsonPath = response.jsonPath();
        List<Object> list = jsonPath.getList("result.type");
        for (Object eachId:list) {
            System.out.println(eachId);
        }
        //Step5 : print status code
        System.out.println(response.statusCode());
    }
}
