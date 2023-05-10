package Academy.Desq;

import java.io.IOException;
import java.time.Duration;
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
import org.testng.annotations.Test;

import Academy.PageObjects.BookingsPagePO;
import Academy.PageObjects.LandingPagePO;
import Academy.PageObjects.PersonalBookingsPagePO;
import Academy.PageObjects.ResultsPagePO;
import Academy.TestComponents.BaseTest;
import Academy.TestComponents.BaseTest02;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E03 extends BaseTest02 {

	@Test
	public void submitAndCancelReservation() throws IOException
	{

		//initializeDriver();
		String userEmail = "joko2909@enjoying.rs";
		String userPassword = "6zZchkrfQyLHEw3333";
		
		//LandingPagePO lppo = new LandingPagePO(driver);
		//lppo.goTo();
		lppo.loginToApplication(userEmail, userPassword);
		
		//Verify successful login
		String expectedH5 = "Personal bookings";
		
		PersonalBookingsPagePO pppo = new PersonalBookingsPagePO(driver);
		String actualPersonalBookings = pppo.verifyLogin();
	
		Assert.assertEquals(actualPersonalBookings, expectedH5);
		
		//AddBooking
		pppo.clickAddBooking();
		BookingsPagePO bppo = new BookingsPagePO(driver);
			
		String wantedDate ="14";
		bppo.selectDate(wantedDate);
		
		String wantedTime ="10:00"; 
		bppo.selectArrivalTime(wantedTime);
		
		bppo.clickFindDesk();
		
		//Results page
		ResultsPagePO rppo = new ResultsPagePO(driver);
		rppo.clickBookThisButton();
		
		//Personal bookings page
		String expectedBookedDate = "14.04. ×";
		String expectedPopUpQuestion = "Are you sure you want to cancel booking for "+pppo.readableDate(expectedBookedDate)+"?";
		pppo.clickCancelReservation(expectedBookedDate);
		//Here create a method to stream all dates and cancel just wanted
		
		
		String popUpQuestion = pppo.getPopUpMessage();
		Assert.assertEquals(popUpQuestion, expectedPopUpQuestion);
		pppo.cancelBookingYes();
		
		pppo.clickAddBooking();
		
		Boolean isClickableDate = bppo.isDateClickable(wantedDate);
		Assert.assertTrue(isClickableDate);

			
	}

}
