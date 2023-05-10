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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Preferences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup(); // WebDriver manager for invoking the chromedriver that is not on our local machine
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://test-deskreservation.createq.space/booking");
		
		
		driver.findElement(By.cssSelector("#userNameInput")).sendKeys("joko2909@enjoying.rs");
		driver.findElement(By.cssSelector("#passwordInput")).sendKeys("6zZchkrfQyLHEw3333");
		driver.findElement(By.cssSelector("#submitButton")).click();
		
		//Explicit wait - define the object of the class
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flex.flex-row.items-center h5")));
		
		String expectedH5 = "Personal bookings";
		String personalBookings = driver.findElement(By.cssSelector(".flex.flex-row.items-center h5")).getText();
		System.out.println(personalBookings);
		Assert.assertEquals(personalBookings, expectedH5 );
		
		//Choose preferences
		driver.findElement(By.xpath("//button[@class='mt-2 mr-4 rounded-full']//img[@class='rounded-full']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shadow-dropdownMenu")));
		driver.findElement(By.xpath("//button[text()='Preferences']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4")));
		
		
		String wantedFavouriteTeam = "";
		String wantedFavouriteOffice= "";
		String wantedFavouriteDesk = "";
		
		List<WebElement> allSectionsList = driver.findElements(By.cssSelector(".wrapperChild.items-center"));
		WebElement favTeam = allSectionsList.stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Team"))
		.findFirst().orElse(null);
		favTeam.findElement(By.cssSelector(".bg-white")).click();
		
		WebElement favOffice = allSectionsList.stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Office"))
				.findFirst().orElse(null);
		favOffice.findElement(By.cssSelector(".bg-white")).click();
		
		WebElement favDesk = allSectionsList.stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Desk"))
				.findFirst().orElse(null);
		favDesk.findElement(By.cssSelector(".bg-white")).click();
		
		driver.findElement(By.cssSelector(".space-x-2 button:last-child")).click();
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
		
		
	}
	

}
