package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class GetRequest01 {

//    https://restful-booker.herokuapp.com/booking/3
//    adresine  bir request gonderildiginde donecek cevap(response)
//    icin
//    HTTP status kodunun    200
//    Content Type'in           Json
//    Ve Status Line'in           HTTP/1.1 200 OK
//    Oldugunu test edin.

    //  ============  API TESTI YAPILIRKEN YAPILACAK ADIMLAR    =========
    //  1. URL  (endpoint) belirlenmeli.
    //    2. Beklenen sonuc (expected result) olusturulur.
    //   {bu case de bu adima gerek yok , cunku body dogrulanmasi istenmedi}
    //    3. Request gonderilir.
    //   4. Actual result olusturulur.
    //   5. Dogrulama (assertion) yapilir.
    // =============================================================
 @Test

 public  void test01 () {

     // 1. URL  (endpoint) belirlenmeli.

     String  url ="https://restful-booker.herokuapp.com/booking/3";

     // 3. Request gonderilir.

    Response response = given().
                                            accept("application/json").
                                            when().
                                            get(url);

          response.prettyPrint();  // yazdirilmasa da  test calisir

     //   4. Actual result olusturulur.
     // { response body ile ilgili islem yapmayacagimiz icin simdi oludturmadik }

     // 5. Dogrulama (assertion) yapilir.
     System.out.println(" Status code    ==> "+response.getStatusCode());      // response dan gelen status code  u verir
     System.out.println(" Content type  ==> "+ response.getContentType());  // response dan gelen content type u verir
     System.out.println(" Status line         ==> "+response.getStatusLine());       // response dan gelen status line i  verir

     // Postmandeki headers in tamami icin
     System.out.println("response.getHeaders() ==>" + response.getHeaders());

     /*
     Assert.assertEquals(200,response.getStatusCode());
     // expected kismi bize task olarak verilen degerdir , actual kismi ise responde dan donen
     // degerdir.. status code int deger dondurur

     Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
     Assert.assertEquals( "HTTP/1.1 200 OK",response.getStatusLine());

    */

    //2. yol ile yapalim

    response.
            then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).    // bu da olur contentType("application/json").
            statusLine("HTTP/1.1 200 OK");
 }

}
