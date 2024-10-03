package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/313
    When
        Kullanici URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmal1
    And
       Content Type "application/json" olmali
       */

    @Test
    public void test01() {
        //Set te url
        spec.pathParams("first", "pet", "second", 313);

        //Set the expected data / payload

        //Send request and get response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        //Do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
