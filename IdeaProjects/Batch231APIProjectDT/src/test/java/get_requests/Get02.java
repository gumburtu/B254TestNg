package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get02 {
    /*
       Given
           http://petstore/swagger/io/v2/pet/0
       When
           Kullanici URL'e bir get request gonderir.
       Then
           Http Status code 404 olmali
        And
           Status Line "HTTP/1.1 404 Not Found" olmali"
        And
           Respons body "Pet not found" icermeli
        And
           Response body "TechProEd" icermeli
        And
           Server degeri "Jetty(9.2.9.v20150224)" olmali
       */
    @Test
    public void test01() {
        //sert the url
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RestAssured.basePath="/pet/0";

        //set the expected data / payload
        //send request get response
        Response response = given().when().get();
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Pet not found"))
                .body(not(containsString("TechProEd")))
                .header("Server", "Jetty(9.2.9.v20150224)")
                .header("Connection", "keep-alive");
    }
}
