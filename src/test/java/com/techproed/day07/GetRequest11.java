package com.techproed.day07;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static  org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest11 extends JsonPlaceHolderTestBase {
    /*
    https://jsonplaceholder.typicode.com/todos/2 url ‘ine istek gönderildiğinde,
   Dönen response un
   Status kodunun 200, dönen body de,
       "completed": değerinin false
       "title”: değerinin “quis ut nam facilis et officia qui”
       "userId" sinin 1 ve header değerlerinden
      " Via" değerinin “1.1 vegur” ve
       "Server" değerinin “cloudflare” olduğunu test edin…
     */

    @Test
    public void test() {

        spec01.pathParams("first", "todos",
                           "second","2");

        HashMap<String,Object> expectedData = new HashMap<String,Object>();

          expectedData.put("statusCode",200);
          expectedData.put("via","1.1 vegur");
          expectedData.put("Server","cloudflare");
          expectedData.put("userId",1);
          expectedData.put("title","quis ut nam facilis et officia qui");
          expectedData.put("completed",false);

        System.out.println(expectedData);

      Response response = given().
                                           accept("application/json").
                                            spec(spec01).
                                            when().
                                            get("/{first}/{second}");

        response.prettyPrint();

        // 1. yontem Matchers class ile assertion yapalim :

        response.then().assertThat().statusCode((Integer)expectedData.get("statusCode")).
                headers("via", equalTo(expectedData.get("via")),
                        "Server",equalTo(expectedData.get("Server"))).
                body("userId",equalTo(expectedData.get("userId")),
                        "title",equalTo(expectedData.get("title")),
                        "completed",equalTo(expectedData.get("completed")));

         // 2. yontem

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(200,response.getStatusCode());



    }
}