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
import Academy.PageObjects.LandingPagePO;
import Academy.PageObjects.PersonalBookingsPagePO;
import Academy.PageObjects.ResultsPagePO;
import Academy.TestComponents.BaseTest;
import Academy.TestComponents.BaseTest02;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E05 extends BaseTest02 {

	@Test(dataProvider="getData")
	public void submitAndCancelReservation(HashMap<String, String> input) throws IOException
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
		pppo.cancelBookingYes();
		
		pppo.clickAddBooking();
		
		Boolean isClickableDate = bppo.isDateClickable(input.get("wantedDateHash"));
		Assert.assertTrue(isClickableDate);

			
	}
	
	
	//Here we use a simple DataProvider for a small amount of data we want to send
		@DataProvider
		public Object[][] getData()
		{
			HashMap<String, String> hmap = new HashMap<String, String>();
			hmap.put("emailHash", "joko2909@enjoying.rs");
			hmap.put("passwordHash", "6zZchkrfQyLHEw3333");
			hmap.put("wantedDateHash", "14");
			hmap.put("wantedTimeHash", "10:00");
			hmap.put("expectedBookedDateHash", "14.04. ×");
			
			HashMap<String, String> hmap02 = new HashMap<String, String>();
			hmap02.put("emailHash", "joko2909@enjoying.rs");
			hmap02.put("passwordHash", "6zZchkrfQyLHEw3333");
			hmap02.put("wantedDateHash", "17");
			hmap02.put("wantedTimeHash", "07:00");
			hmap02.put("expectedBookedDateHash", "17.04. ×");
			
			HashMap<String, String> hmap03 = new HashMap<String, String>();
			hmap03.put("emailHash", "joko2909@enjoying.rs");
			hmap03.put("passwordHash", "6zZchkrfQyLHEw3333");
			hmap03.put("wantedDateHash", "24");
			hmap03.put("wantedTimeHash", "09:00");
			hmap03.put("expectedBookedDateHash", "24.04. ×");
			
			return new Object [][]  {{hmap}, {hmap02}, {hmap03}};
			
			/*return new Object [][]  {{"joko2909@enjoying.rs", "6zZchkrfQyLHEw3333", "14", "10:00", "14.04. ×" }, 
										{"joko2909@enjoying.rs", "6zZchkrfQyLHEw3333", "17", "07:00", "17.04. ×" },
										{"joko2909@enjoying.rs", "6zZchkrfQyLHEw3333", "24", "10:00", "24.04. ×" }};*/ //Object is a generic type so we can place there int, String, boolean
		}

}
