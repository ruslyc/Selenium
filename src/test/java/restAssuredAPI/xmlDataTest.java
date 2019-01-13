package restAssuredAPI;

import apiFiles.payLoad;
import apiFiles.resources;
import apiFiles.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class xmlDataTest {

    Properties prop = new Properties();
    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\rusly\\IdeaProjects\\seleniumchicago10\\src\\test\\java\\apiFiles\\env.properties");
        prop.load(fis);
        // prop.get("HOST");
    }
    @Test
    public void postData() throws IOException {
        //Task 1 -Grab the response
        String postdata = generateStringFromResource("C:\\Users\\rusly\\Desktop\\postdata.xml");
        RestAssured.baseURI=prop.getProperty("HOST");
        Response resp = given().
                queryParam("key",prop.getProperty("key")).
                body(postdata).
                when().
                post(resources.placeXmlPostData()).
                then().assertThat().statusCode(200).and().contentType(ContentType.XML).
                extract().response();
        XmlPath x = reusableMethods.rawToXml(resp);
        x.get("response.place_id");

//        //Task 2 - Brag the place ID from the response
//        String responseString =  res.asString();
//        System.out.println(responseString);
//        JsonPath js = new JsonPath(responseString);
//        String placeId = js.get("place_id");
//        System.out.println(placeId);
//
//        //Task 3 - place this place ID in the delete request
//
//        given().
//                queryParam("key","qaclick123").
//                body("{"+
//                        "\"place_id\": \"" +placeId + "\"" +
//                        "}").
//                when().
//                post("/maps/api/place/delete/json").
//                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
//                body("status",equalTo("OK"));
    }

    public static String generateStringFromResource(String path) throws IOException{
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
