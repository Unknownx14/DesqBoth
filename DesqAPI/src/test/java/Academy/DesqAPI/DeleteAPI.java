package Academy.DesqAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import Academy.POJO.CreateBookingBody;
import Academy.POJO.DatesByDesk;
import Academy.POJO.SuggestedDesks;
import Academy.POJO.suggestedDesksResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DeleteAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IllzM00wYzNnNnNiNmo2bXJnaTFPMDU1aEFjTSJ9.eyJhdWQiOiJtaWNyb3NvZnQ6aWRlbnRpdHlzZXJ2ZXI6MjkxYzNlOTAtODNkZC00MTllLWE4NDQtZjZhYzBmMWI2NWM2IiwiaXNzIjoiaHR0cDovL3N0cy5lbmpveWluZy5ycy9hZGZzL3NlcnZpY2VzL3RydXN0IiwiaWF0IjoxNjc2Mzg4MjQ4LCJleHAiOjE2NzYzOTE4NDgsInByaW1hcnlzaWQiOiJTLTEtNS0yMS0xMzA3MzUwODY2LTMzNjI0NTA5OTItMzAwNTEyODg1LTY2MjAiLCJlbWFpbCI6ImpvdmFuLmtvdmFjZXZpY0BjcmVhdGVxLnNwYWNlIiwiZ2l2ZW5fbmFtZSI6IkpvdmFuIiwiZmFtaWx5X25hbWUiOiJLb3ZhY2V2aWMiLCJDaXR5IjoiQmVsZ3JhZGUiLCJzYW1hY2NvdW50bmFtZSI6Impva28yOTA5Iiwic3ViIjoia1c2c0FmY0RnRXVSU0VSZWJMeE1ZZz09IiwiYXBwdHlwZSI6IlB1YmxpYyIsImFwcGlkIjoiMjkxYzNlOTAtODNkZC00MTllLWE4NDQtZjZhYzBmMWI2NWM2IiwiYXV0aG1ldGhvZCI6InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphYzpjbGFzc2VzOlBhc3N3b3JkUHJvdGVjdGVkVHJhbnNwb3J0IiwiYXV0aF90aW1lIjoiMjAyMy0wMi0xNFQxNToyNDowOC42OTBaIiwidmVyIjoiMS4wIiwic2NwIjoiZW1haWwgcHJvZmlsZSBvcGVuaWQifQ.NIWvK7sgXFCV4mZSa6_0MlDJFCxJsD34Ko8HdNjYRPtRxyya1Dgbyd73H_uujJHBs_6oSi2nhqMPay9U--caLpUnyyZUkqH7Cai-QNQid7b8rvyVnwTFFK0p-JCfLe6VXxnD4H_uBm6Kcsf530l2ngDlyvgkLJTiUv7HIScm1myrTn8ApvjyFFPgkkzt-aPgSZRmmZmmPMStr8SGJIwULL9Kc5p4rJZS6nUbzlZ3F_QRA5KxGDRKFJa5RcAoa0OzJ5JCoI-UR4vMXE0Ohc9LSkp4wPN__YUfEwrD7tI6FRILF23BJHZByDLE3aXQ-t2zpKWG1dDcZ75pA7hGblgoVw";
		String wantedUserID = "17";
				
				//Request Spec Builder
						RequestSpecification reqSB = new RequestSpecBuilder().setBaseUri("http://172.16.10.19:8080/deskreservation/api/v1").addHeader("Authorization", token).build();
						// RequestSpecification req for RequestSpecBuilder()
						
						//Response Spec Builder
						ResponseSpecification resSB = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
						
						//getUserBookings
						RequestSpecification response01 = given().log().all().spec(reqSB);
						
						String response02 = response01.when().get("/user/"+wantedUserID+"/bookings")
								.then().log().all().spec(resSB)
								.header("Content-Type", "application/json").extract().response().asString();
						
						JsonPath jp01 = new JsonPath(response02);
						String userEmail = jp01.getString("user.email");
						System.out.println(userEmail);
						
						
						
						
						
		
	}

}
