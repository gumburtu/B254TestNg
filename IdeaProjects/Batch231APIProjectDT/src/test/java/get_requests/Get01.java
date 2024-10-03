package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    Given
        https://petstore.swagger.is/v2/pet/313
    When
        Kullanici URL'e bir GET request gonderir
    Then
        HTTP Status Code 200 olmali
    AND
        Content Type "application/json" olmalu
    */

    /**
     * Birinci ve uzun yol
     */
    @Test
    public void get01() {
        //1) Set the URL
        //ilk yol
       /* String baseUrl = "https://petstore.swagger.io/v2";
        String pathParameter = "/pet/313";*/

        //Ikinci yol
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/10";

        //2) Set the expected data / payload

        //3) Send request ger response
        Response response = given().when().get();
        response.prettyPrint();

        //4) Do assertion
        response.
                then().assertThat().statusCode(200) //Status code un 200 oldugunu dogrular.
                .and().assertThat().contentType("application/json") //Content Type in application/json oldugunu dogrular.
                .and().assertThat().statusLine("HTTP/1.1 200 OK"); //Status Line inn HTTP/1.1 200 OK oldugunu dogrular.
    }

    /**
     * 2. ve kisa yol
     */
    @Test
    public void get02() {
        //1) Set the URL
        //ilk yol
       /* String baseUrl = "https://petstore.swagger.io/v2";
        String pathParameter = "/pet/313";*/

        //Ikinci yol
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/10";

        //2) Set the expected data / payload

        //3) Send request ger response
        Response response = given().when().get();
        response.prettyPrint();

        //4) Do assertion
        response.
                then()
                .statusCode(200)//Status code un 200 oldugunu dogrular.
                .contentType("application/json")//Content Type in application/json oldugunu dogrular.
                .statusLine("HTTP/1.1 200 OK");//Status Line inn HTTP/1.1 200 OK oldugunu dogrular.
    }
    @Test
    public void get03() {
        //1) Set the URL
        //ilk yol
       /* String baseUrl = "https://petstore.swagger.io/v2";
        String pathParameter = "/pet/313";*/

        //Ikinci yol
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/10";

        //2) Set the expected data / payload

        //3) Send request ger response


        //4) Do assertion
        given().when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK")
                //.log().body()
                .log().all();
    }
}
