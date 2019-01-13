package restAssuredAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class basics {

    @Test
    public void test(){

        //Base URL or Host

        //Checking the response:
        //Status code of the response
        //Content type
        //Body
        //Header responses
        RestAssured.baseURI = "http://googleapi.com";

        given().
                param("location","").
                param("radius","500").
                param("key","").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("",equalTo(""));

    }
}
