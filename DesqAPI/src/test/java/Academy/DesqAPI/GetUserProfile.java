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

public class GetUserProfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IllzM00wYzNnNnNiNmo2bXJnaTFPMDU1aEFjTSJ9.eyJhdWQiOiJtaWNyb3NvZnQ6aWRlbnRpdHlzZXJ2ZXI6MjkxYzNlOTAtODNkZC00MTllLWE4NDQtZjZhYzBmMWI2NWM2IiwiaXNzIjoiaHR0cDovL3N0cy5lbmpveWluZy5ycy9hZGZzL3NlcnZpY2VzL3RydXN0IiwiaWF0IjoxNjc5NTAwNzE0LCJleHAiOjE2Nzk1MDQzMTQsInByaW1hcnlzaWQiOiJTLTEtNS0yMS0xMzA3MzUwODY2LTMzNjI0NTA5OTItMzAwNTEyODg1LTY2MjciLCJlbWFpbCI6Im5hdGFzYS5rb25jYXJldmljQGNyZWF0ZXEuc3BhY2UiLCJnaXZlbl9uYW1lIjoiTmF0YXNhIiwiZmFtaWx5X25hbWUiOiJLb25jYXJldmljIiwiQ2l0eSI6IkJlbGdyYWRlIiwic2FtYWNjb3VudG5hbWUiOiJuYWtvMjUwOCIsInN1YiI6InZES3FJaDNBdkVpcjN1NmJVd3dOOHc9PSIsImFwcHR5cGUiOiJQdWJsaWMiLCJhcHBpZCI6IjI5MWMzZTkwLTgzZGQtNDE5ZS1hODQ0LWY2YWMwZjFiNjVjNiIsImF1dGhtZXRob2QiOiJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YWM6Y2xhc3NlczpQYXNzd29yZFByb3RlY3RlZFRyYW5zcG9ydCIsImF1dGhfdGltZSI6IjIwMjMtMDMtMjJUMTU6NTg6MzQuODg0WiIsInZlciI6IjEuMCIsInNjcCI6ImVtYWlsIHByb2ZpbGUgb3BlbmlkIn0.Y6MDTlJh6MYSyOTa5hEoskjjlIFXEsI9bUNtzJXoRaxSnwjcfAxsk3ARoNQfA3reOwyl7s4V_fMrDh1jtmMdsc7RKV0YhQqwTSW1kkom3mN4b1FYCJBFD1K52wB-PriIgKwbCl2tGjVpthkEIMJS-wou0N3Zx0FNXzhUDD8YmzehvAQhed9AZ9ZJGAv1JCzOsa0bLsvoaPqYKFRx7VtD9rJ8NHi0fiYX41MSmE4MWB2x4Lw6sLHPMBT44SNAxuex1jDeEMaEitPpV2Ad6v7hujBRnoYmDckLYwq3O52HsknndxI2hei5sgoSOOoDwVFCUv_b35QIAfIOSVvra7aGFw";
String wantedUserID = "17";
		
		//Request Spec Builder
				RequestSpecification reqSB = new RequestSpecBuilder().setBaseUri("http://172.16.10.19:8080/deskreservation/api/v1").addHeader("Authorization", token).build();
				// RequestSpecification req for RequestSpecBuilder()
				
				//Response Spec Builder
				ResponseSpecification resSB = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
				
				//getUserProfile
				RequestSpecification response01 = given().log().all().spec(reqSB);
				
				String response02 = response01.when().get("/user/"+wantedUserID+"/profile")
						.then().log().all().spec(resSB).body("teamName", equalTo("Bench"))
						.header("Content-Type", "application/json").extract().response().asString();
				
				JsonPath jp01 = new JsonPath(response02);
				int deskId = jp01.getInt("deskId");
				System.out.println(deskId);
				
				
				
				//postSuggestedDesks
				SuggestedDesks sd = new SuggestedDesks();
				sd.setLocationId(2);
				sd.setArrivalTime("10:00");
				sd.setTeamId(12);
				
				List<String> myList = new ArrayList<String>();
				myList.add("2023-04-01");
				myList.add("2023-04-02");
				sd.setReservationDates(myList);
				
				
				RequestSpecification response01SuggestedDesks = given().log().all().spec(reqSB).header("Content-Type", "application/json").body(sd);
				
	/*			String response02SuggestedDesks = response01SuggestedDesks.when().post("/user/"+wantedUserID+"/suggestedDesks")
						.then().log().all().spec(resSB).body("user.firstName", equalTo("Jovan"))
						.header("Content-Type", "application/json").extract().response().asString();
				
				JsonPath jp02 = new JsonPath(response02SuggestedDesks);
				String myName = jp02.get("user.lastName");
				System.out.println(myName);
				int myID = jp02.get("user.id");
				System.out.println(myID);
				int deskIdagain = jp02.get("reservationDatesByDeskList.deskId");
				System.out.println(deskIdagain);
				*/
				
				suggestedDesksResponse response02SuggestedDesks = response01SuggestedDesks.when().post("/user/"+wantedUserID+"/suggestedDesks")
						.then().log().all().spec(resSB).body("user.firstName", equalTo("Jovan"))
						.header("Content-Type", "application/json").extract().response().as(suggestedDesksResponse.class);
				
				String myName = response02SuggestedDesks.getUser().getLastName();
				System.out.println(myName);
				int deskIdagain = response02SuggestedDesks.getReservationDatesByDeskList().get(0).getDeskId();
				System.out.println(deskIdagain); 
				
				
				//postCreateBookings
				String deskIdString = String.valueOf(deskId);
				
				CreateBookingBody cbb = new CreateBookingBody();
				cbb.setArrivalTime("10:00");
				cbb.setTeamId("12");
				cbb.setUserCreatedId("17");
				
				DatesByDesk dbd = new DatesByDesk();
				dbd.setDeskId(deskIdString);
				
				List<String> myList02 = new ArrayList<String>();
				myList02.add("2023-04-01");
				myList02.add("2023-04-02");
				
				dbd.setDates(myList02);
				
				List<DatesByDesk> myList03 = new ArrayList<DatesByDesk>();
				myList03.add(dbd);
				
				cbb.setDatesByDesk(myList03);
				
				
				//Response Spec Builder
				ResponseSpecification resSBCreateBookings = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
				
				RequestSpecification response01CreateBookings = given().log().all().spec(reqSB).header("Content-Type", "application/json").body(cbb);
				
				String response02CreateBookings = response01CreateBookings.when().post("/user/"+wantedUserID+"/bookings")
						.then().log().all().spec(resSBCreateBookings).body("status", equalTo(true))
						.header("Content-Type", "application/json").extract().response().asString();
							
	}

}
