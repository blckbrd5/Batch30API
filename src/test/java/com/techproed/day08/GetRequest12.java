package com.techproed.day08;

import com.techproed.testBase.HerokuAppTestBase;
import com.techproed.testData.HerokuappTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends HerokuAppTestBase {
    /*
    https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
      dönen response body nin
          {
           "firstname": "Eric",
           "lastname": "Smith",
           "totalprice": 555,
           "depositpaid": false,
           "bookingdates": {
               "checkin": "2016-09-09",
               "checkout": "2017-09-21"
            }
        } gibi olduğunu test edin
     */

 @Test
    public  void test () {
     // url olusturulur.. spec ile
     spec02.pathParams("first","booking"
             ,"second",1);

     //expected data olusturulur
     HerokuappTestData expectedObje=new HerokuappTestData();
         HashMap<String,Object> expectedDataMap = expectedObje.setUpTestData();
            expectedObje.setUpTestData();
             System.out.println(expectedDataMap);

             // request gonder
     Response response=given().
             accept("application/json").
             spec(spec02).
             when().
             get("/{first}/{second}");
     response.prettyPrint();

     //de serialization yapilir

     // 1. yol olarak de serialization yapalim

//     HashMap<String,Object> actualDataMap = response.as(HashMap.class);
//     System.out.println(actualDataMap);
//
//     Assert.assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
//     Assert.assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
//     Assert.assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
//     Assert.assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
//     Assert.assertEquals(  ((Map)expectedDataMap.get("bookingdates")).get("checkin"),
//                                           ((Map)actualDataMap.get("bookingdates")).get("checkin") );
//    Assert.assertEquals(  ((Map)expectedDataMap.get("bookingdates")).get("checkout"),
//                                           ((Map)actualDataMap.get("bookingdates")).get("checkout") );

     // 2.yol olarak JsonPath yapalim

     JsonPath jsonPath = response.jsonPath();

     Assert.assertEquals(expectedDataMap.get("firstname"),jsonPath.getString("firstname"));
     Assert.assertEquals(expectedDataMap.get("lastname"),jsonPath.getString("lastname"));
     Assert.assertEquals(expectedDataMap.get("totalprice"),jsonPath.getInt("totalprice"));
     Assert.assertEquals(expectedDataMap.get("depositpaid"),jsonPath.getBoolean("depositpaid"));
     Assert.assertEquals( ( (Map)expectedDataMap.get("bookingdates") ).get("checkin"),
                                                       jsonPath.getString("bookingdates.checkin"));
     Assert.assertEquals( ( (Map)expectedDataMap.get("bookingdates") ).get("checkout"),
                                                       jsonPath.getString("bookingdates.checkout"));

 }
}
