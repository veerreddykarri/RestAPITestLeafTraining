package jira;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class CreateIssueUsingJsonDataFileMulti {
    @DataProvider
    public String[] fetchData(){
        String[] filePath = new String[2];
        filePath[0] = "./data/CreateIssue.json";
        filePath[1] = "./data/CreateIssue1.json";
        return filePath;
    }
    @Test(dataProvider ="fetchData" )
    public void createIssueWithDataFileMulti(String filePath){
        RestAssured.baseURI = "https://veerkarriapiautomation.atlassian.net/rest/api/2/issue/";
        RestAssured.authentication = RestAssured.preemptive().basic("veerreddykarri@gmail.com", "FCSKrY9P3E7b8Kc4qGiwB0F9");
        File file = new File(filePath);
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(file)
                .post();
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    }
