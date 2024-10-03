package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class PetStoreBaseUrl {
    /*
    Bu class in amaci her testten once calisarak baseurl ve content type... gibi ortak request yapilandirmalarini yapmak
    testlerin daha bakimi kolay yapilabilir hale getirmektir.
    */
    protected RequestSpecification spec;

    @BeforeEach
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2") //basUrl ayarladik
                .setContentType(ContentType.JSON)
                .build();
    }
}
