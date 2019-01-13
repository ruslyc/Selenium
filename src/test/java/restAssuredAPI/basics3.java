package restAssuredAPI;

import apiFiles.payLoad;
import apiFiles.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class basics3 {
    Properties prop = new Properties();
    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\rusly\\IdeaProjects\\seleniumchicago10\\src\\test\\java\\apiFiles\\env.properties");
        prop.load(fis);
       // prop.get("HOST");
    }
    @Test
    public void addAndDeletePlace(){

        //Task 1 -Grab the response
                RestAssured.baseURI=prop.getProperty("HOST");
                Response res = given().
                queryParam("key",prop.getProperty("key")).
                body(payLoad.getPostData()).
                when().
                post(resources.placePostData()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status",equalTo("OK")).
                extract().response();
        //Task 2 - Brag the place ID from the response
                String responseString =  res.asString();
                System.out.println(responseString);
                JsonPath js = new JsonPath(responseString);
                String placeId = js.get("place_id");
                System.out.println(placeId);

        //Task 3 - place this place ID in the delete request

        given().
                queryParam("key","qaclick123").
                body("{"+
                        "\"place_id\": \"" +placeId + "\"" +
                        "}").
                when().
                post("/maps/api/place/delete/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status",equalTo("OK"));
    }

}
