package com.techproed.day05;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class GetRequest06 {

    @Test

    public void test() {

//        https://jsonplaceholder.typicode.com/todos/123 url'ine
//        accept type'i "application/json" olan GET request'i yolladigimda
//        gelen response’un
//        status kodunun 200
//        ve content type'inin "application/json"
//        ve Headers'daki "Server" in "cloudflare"
//        ve response body'deki "userId"'nin 7
//        ve "title" in "esse et quis iste est earum aut impedit"
//        ve "completed" bolumunun false oldugunu test edin

        String url = " https://jsonplaceholder.typicode.com/todos/123";
        String url2 = " spec01/todos/123";


        Response response = given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();

        response.then().
               assertThat().
               statusCode(200).
              contentType("application/json").
               header("Server",equalTo("cloudfare")).

    }
}
