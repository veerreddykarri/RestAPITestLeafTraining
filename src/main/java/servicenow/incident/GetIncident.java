package servicenow.incident;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncident {
    public static void main(String[] args) {
        //step1: get url
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/incident";
        //step2 : Authentication
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        //step3 : request type (get)
        Response response = RestAssured.get();
        //Step4 : print response body
        response.prettyPrint();
        //Step5 : print status code
        System.out.println(response.statusCode());
    }
}
