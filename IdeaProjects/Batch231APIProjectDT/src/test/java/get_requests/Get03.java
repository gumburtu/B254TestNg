package get_requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get03 {
      /*
       Given
           http://petstore/swagger/io/v2/pet/313
       When
           Kullanici URL'e bir get request gonderir.
       Then
           Http Status code 200 olmali
        And
           Content Type "application/json" olmali"
        And
           "name" degeri su metni icermeli : "Tekir"
        And
           Status degeri "available" olmali
        And
           "category" altindaki "name" degeri "CAT" olmali
        And
           "tags" altindaki ilk datanin "name" degeri "bird" olmali
       */

    @Test
    public void test01() {
        //set the url
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/313";
        //Set the expected data / payload

        //Send request and get response
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", containsString("ELMAS"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("CAT"))
                .body("tags[0].name", equalTo("string"))
                .log().all();

        //Do assertion
    }

    @Test
    public void test02() {
        //set the url
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/313";
        //Set the expected data / payload

        //Send request and get response
        Response response = given().when().get();
        //Do assertion
        Assertions.assertTrue(response.asString().contains("ELMAS"));
        Assertions.assertFalse(response.asString().contains("TechProEd"));
    }
}

