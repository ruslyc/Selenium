package apiFiles;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class reusableMethods {

    public static XmlPath rawToXml(Response r){
        String respon = r.asString();
        XmlPath x = new XmlPath(respon);
        return x;
    }

    public static JsonPath rawToJson(Response r){
        String respon = r.asString();
        JsonPath x = new JsonPath(respon);
        return x;
    }
}
