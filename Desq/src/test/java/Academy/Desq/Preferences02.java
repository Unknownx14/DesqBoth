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

import Academy.PageObjects.PersonalBookingsPagePO;
import Academy.PageObjects.PreferencesPagePO;
import Academy.TestComponents.BaseTest03;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Preferences02 extends BaseTest03 {

	@Test(dataProvider="getData")
	public void changePreferences(HashMap<String, String> input) throws InterruptedException
	{

		lppo.loginToApplication(input.get("emailHash"), input.get("passwordHash"));
		
		//Verify successful login
		String expectedH5 = "Personal bookings";
		
		PersonalBookingsPagePO pppo = new PersonalBookingsPagePO(driver);
		String actualPersonalBookings = pppo.verifyLogin();
	
		Assert.assertEquals(actualPersonalBookings, expectedH5);
		
		
		//Choose preferences
		PreferencesPagePO prpo = new PreferencesPagePO(driver);
		prpo.goToReferences();
		
		String wantedFavouriteTeam = "";
		String wantedFavouriteOffice= "";
		String wantedFavouriteDesk = "";
		
		prpo.selectFavTeam();
		prpo.selectFavOffice();
		prpo.selectFavDesk();
		
		Thread.sleep(3000);
		
	/*	driver.findElement(By.cssSelector(".space-x-2 button:last-child")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flex.flex-row.items-center h5")));
		
		//Book a desk
		driver.findElement(By.cssSelector("button[class*='h-10']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
		
		
		String wantedDate ="14";
		List<WebElement> allDatesList = driver.findElements(By.cssSelector("label[class*='bg-brand_black']"));
		for(int i=0;i<allDatesList.size();i++)
		{
			String numbers = allDatesList.get(i).getText();
			System.out.println(numbers);
				if(numbers.equals(wantedDate))
				{
					allDatesList.get(i).click();
				}
		}
		
		String wantedTime ="10:00"; 
		List<WebElement> allTimesList = driver.findElements(By.cssSelector("button[class*='bg-white']"));
		for(int i=0;i<allTimesList.size();i++)
		{
			String numbers = allTimesList.get(i).getText();
			System.out.println(numbers);
				if(numbers.equals(wantedTime))
				{
					allTimesList.get(i).click();
				}
		}
		
		
		driver.findElement(By.cssSelector("button[type*='submit']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".searchBar")));
		
		driver.findElement(By.cssSelector("button[type*='submit']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flex.flex-row.items-center h5")));
		
		//Personal bookings page
		String expectedBookedDate = "14.04. ×";
		String[] splitted01 = expectedBookedDate.split("×");
		String trimmedDate = splitted01[0].trim();
		System.out.println(trimmedDate);
		String expectedPopUpQuestion = "Are you sure you want to cancel booking for "+trimmedDate+"?";
		
		List<WebElement> allBookedCardsList = driver.findElements(By.cssSelector(".flex.flex-col.justify-end"));
		WebElement myDate = allBookedCardsList.stream().filter(oneCard -> oneCard.findElement(By.cssSelector("button[class*='bg-brand_black']")).getText().equals(expectedBookedDate))
		.findFirst().orElse(null);
		myDate.findElement(By.cssSelector("button[class*='bg-brand_black']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popupInside")));
		String popUpQuestion = driver.findElement(By.cssSelector("h4")).getText();
		Assert.assertEquals(popUpQuestion, expectedPopUpQuestion);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flex.flex-row.items-center h5")));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)"); //jse.executeScript("window.scrollBy(0,250)");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='h-10']")));
		driver.findElement(By.cssSelector("button[class*='h-10']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
		
		List<WebElement> allDatesList02 = driver.findElements(By.cssSelector("label[class*='bg-brand_black']"));
		for(int i=0;i<allDatesList02.size();i++)
		{
			String numbers = allDatesList02.get(i).getText();
			
				if(numbers.equals(wantedDate))
				{
					System.out.println(numbers);
					Boolean clickableDate = allDatesList02.get(i).isEnabled();
					System.out.println(clickableDate);
					Assert.assertTrue(clickableDate);
				}
		}
		*/
		
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
