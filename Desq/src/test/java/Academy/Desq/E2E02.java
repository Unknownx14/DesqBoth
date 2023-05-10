package Academy.Desq;

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

import Academy.PageObjects.BookingsPagePO;
import Academy.PageObjects.LandingPagePO;
import Academy.PageObjects.PersonalBookingsPagePO;
import Academy.PageObjects.ResultsPagePO;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup(); // WebDriver manager for invoking the chromedriver that is not on our local machine
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String userEmail = "joko2909@enjoying.rs";
		String userPassword = "6zZchkrfQyLHEw3333";
		
		LandingPagePO lppo = new LandingPagePO(driver);
		lppo.goTo();
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
