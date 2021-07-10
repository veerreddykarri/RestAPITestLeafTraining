package servicenow.change;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class CreateChangeUsingJsonDataFileMulti {
    @DataProvider
    public String[] fetchData(){
        String[] filePath = new String[2];
        filePath[0] = "./data/CreateChange.json";
        filePath[1] = "./data/CreateChange1.json";
        return filePath;
    }
    @Test(dataProvider ="fetchData" )
    public void createChangeWithBodyWithDataFileMulti(String filePath){
        RestAssured.baseURI ="https://dev104727.service-now.com/api/now/table/change_request";
        RestAssured.authentication = RestAssured.basic("admin","Kt903723.");
        File file = new File(filePath);
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(file)
                .post();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
