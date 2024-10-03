package get_requests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class RequestResponse {
  /*  1) Manuel API testleri icin Postman Kullanacagiz
      2) Otomasyon testleri icin Rest Asseured kullanacagiz.
      3) Rest Asseured, Gherkin dilinden faydalanarak hazir methodlar olusturmustur.
        a) Given : ProConditions (On kosullar)
        b) When  : Actions get(), post()...
        c) Then  : Assertions(dogrulamalar)
        d) And   : Coklu durumlari baglarken okunurluk acisindan kullanilabilir

      4) API Otomasyon testlerini yazarken asagidaki adimlari ezberle
        a) Set the URL : API'in URL'ini ayarla
        b) Set the expected Data : Beklenen datayi ayarla
        c) Send the request and get the response : Request gonderilir ve response alinir
        d) Do assertion : Responstan dogrulamalar yapariz
      */

    /**
     * Bu bizim ilk kodumuzdur.
     */
    @Test
    public void test01() {
        //1) Set the URL
        String url = "https://petstore.swagger.io/v2/pet/10";

        //2) Set teh expected data /payload

        //3) Send request get response
        Response response = given().when().get(url);
        response.prettyPrint();
        response.statusCode();

        //Response icerisindeki status code nasil yazdirilir.
        System.out.println("Status-Code() = " + response.statusCode());

        //Response icindeki content-type nasil yazdirilir?
        System.out.println("Content-Type Bilgisi = " + response.contentType());

        //Response icindeki status line nasil yazdirilir?
        System.out.println("Status-Line = " + response.getStatusLine());

        //Response icindeki Header bolumundeki tum headerlar nasil yazdirilir?
        System.out.println("Headers Bilgileri = " + response.headers());

        //Response icindeki Header bolumundeki bir baslik bilgisi nasil yazdirilir?
        System.out.println("Server Header bilgisi = " + response.header("Server"));

        //Response icindeki Time bilgisi nasil yazdirilir?
        System.out.println("Time Bilgisi = " + response.time());
        /*
        1) print() : methodu responseta bulunan body kismini consele a yazdirmaya yarar.
        2)prettyPrint(): methodu responseta bulunan body kismini console a daha okunakli bir formatta yazdirir.
         */

        //4) Do assertion


    }
}
