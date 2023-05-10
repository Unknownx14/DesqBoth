package Academy.Desq;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.PageObjects.BookingsPagePO;
import Academy.PageObjects.PersonalBookingsPagePO;
import Academy.PageObjects.ResultsPagePO;
import Academy.TestComponents.BaseTest03;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EwithoutDeletion02 extends BaseTest03 {

	@Test(dataProvider="getData")
	public void submitAndDoNotCancelReservation(HashMap<String, String> input) throws InterruptedException
	{

		
		lppo.loginToApplication(input.get("emailHash"), input.get("passwordHash"));
		
		//Verify successful login
		String expectedH5 = "Personal bookings";
		
		PersonalBookingsPagePO pppo = new PersonalBookingsPagePO(driver);
		String actualPersonalBookings = pppo.verifyLogin();
	
		Assert.assertEquals(actualPersonalBookings, expectedH5);
		
		//AddBooking
		pppo.clickAddBooking();
		BookingsPagePO bppo = new BookingsPagePO(driver);
			
		//String wantedDate ="14";
		bppo.selectDate(input.get("wantedDateHash"));
		
		//String wantedTime ="10:00"; 
		bppo.selectArrivalTime(input.get("wantedTimeHash"));
		
		bppo.clickFindDesk();
		
		//Results page
		ResultsPagePO rppo = new ResultsPagePO(driver);
		rppo.clickBookThisButton();
		
		//Personal bookings page
		//String expectedBookedDate = "14.04. ×";
		String expectedPopUpQuestion = "Are you sure you want to cancel booking for "+pppo.readableDate(input.get("expectedBookedDateHash"))+"?";
		pppo.clickCancelReservation(input.get("expectedBookedDateHash"));
		//Here create a method to stream all dates and cancel just wanted
						
		String popUpQuestion = pppo.getPopUpMessage();
		Assert.assertEquals(popUpQuestion, expectedPopUpQuestion);
		pppo.cancelBookingNo();
		
		pppo.clickAddBooking();
		
		
		String expectedErrorMessage = "Date not picked";
		//String wantedDate ="14";
		bppo.selectDate(input.get("wantedDateHash"));
				
		//String wantedTime ="10:00"; 
		bppo.selectArrivalTime(input.get("wantedTimeHash"));
				
		bppo.clickFindDeskDateNotPicked();
		
		String actualErrorMessage = bppo.getDateNotPickedMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}
	
	
			//Here we use a simple DataProvider for a small amount of data we want to send
			//All data to put into a key-value pairs and directly send them as hashmaps
			//Our TCs should not have any data, therefore we create a json file and create a utility that scans that json and creates a HashMap out of it
			@DataProvider
			public Object[][] getData() throws IOException
			{
				
				List<HashMap<String, String>> data = getJsonDataToHashMap(System.getProperty("user.dir") + "\\src\\test\\java\\Academy\\Data\\SubmitAndNoCancelReservation.json");
				//Now we have all the data we need in one json file and for this TC we state the path of this josn file
				
				return new Object [][] {{data.get(0)}}; //, {data.get(1)}, {data.get(2)}}; //{{hmap}, {hmap02}, {hmap03}};
				
				/*return new Object [][]  {{"joko2909@enjoying.rs", "6zZchkrfQyLHEw3333", "14", "10:00", "14.04. ×" }, 
											{"joko2909@enjoying.rs", "6zZchkrfQyLHEw3333", "17", "07:00", "17.04. ×" },
											{"joko2909@enjoying.rs", "6zZchkrfQyLHEw3333", "24", "10:00", "24.04. ×" }};*/ //Object is a generic type so we can place there int, String, boolean
			}

}
