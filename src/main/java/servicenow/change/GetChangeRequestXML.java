package servicenow.change;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetChangeRequestXML {
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
                .accept("application/xml")
                .get();
        XmlPath xmlPath = response.xmlPath();
        List<Object> list = xmlPath.getList("response.result.sys_id");
        for (Object eachId:list) {
            System.out.println(eachId);
        }
        //S
        //Step5 : print status code
        System.out.println(response.statusCode());
    }
}
