package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GetRequest01 {

//    https://restful-booker.herokuapp.com/booking/3
//    adresine  bir request gonderildiginde donecek cevap(response)
//    icin
//    HTTP status kodunun    200
//    Content Type'in           Json
//    Ve Status Line'in           HTTP/1.1 200 OK
//    Oldugunu test edin.

    // ||============  API TESTI YAPILIRKEN YAPILACAK ADIMLAR    =============||
    // ||   1. URL  (endpoint) belirlenmeli.                                                                                ||
    // ||   2. Beklenen sonuc (expected result) olusturulur.                                                   ||
    // ||   {bu case de bu adima gerek yok , cunku body dogrulanmasi istenmedi}     ||
    // ||   3. Request gonderilir.                                                                                                 ||
    // ||   4. Actual result olusturulur.                                                                                         ||
    // ||   5. Dogrulama (assertion) yapilir.                                                                              ||
    //================================================================||
 @Test

 public  void test01 () {

     // 1. URL  (endpoint) belirlenmeli.

     String  url ="https://restful-booker.herokuapp.com/booking/3";

     // 3. Request gonderilir.

    Response response = given().accept("application/json").when().get(url);

     // 5. Dogrulama (assertion) yapilir.

     response.prettyPrint();
 }

}
