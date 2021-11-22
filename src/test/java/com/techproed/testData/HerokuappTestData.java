package com.techproed.testData;

import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestData {
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

    public HashMap<String ,Object> setUpTestData () {

        HashMap<String,Object> bookingdates = new HashMap<String,Object>();

        bookingdates.put("checkin","2015-11-14");
        bookingdates.put("checkout","2016-07-16");

        HashMap<String,Object> expectedData = new HashMap<String,Object>();

        expectedData.put("firstname","Mary");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",503);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdates);

            return expectedData;
    }

  public JSONObject  setUpTestAndRequestData () {

      JSONObject bookingDates = new JSONObject();
          bookingDates.put("checkin", "2020-09-01");
          bookingDates.put("checkout", "2020-09-21");

      JSONObject expectedRequest = new JSONObject();
      expectedRequest.put("firstname","Selim");
      expectedRequest.put("lastname","Ak");
      expectedRequest.put("totalprice",11111);
      expectedRequest.put("depositpaid",true);
      expectedRequest.put("bookingdates",bookingDates);
      return expectedRequest;


  }
}
