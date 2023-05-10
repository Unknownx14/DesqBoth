package Academy.Desq;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup(); // WebDriver manager for invoking the chromedriver that is not on our local machine
		WebDriver driver = new ChromeDriver();
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
		
		//String expectedInitials = "JK";
		String expectedH5 = "Personal bookings";
		//String avatarInitials = driver.findElement(By.cssSelector(".avatarInitials h5")).getText();
		String personalBookings = driver.findElement(By.cssSelector(".flex.flex-row.items-center h5")).getText();
		//System.out.println(avatarInitials);
		System.out.println(personalBookings);
		//Assert.assertEquals(avatarInitials, expectedInitials);
		Assert.assertEquals(personalBookings, expectedH5 );
		
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
		
	}
	
	//For choosing an office
	// (//div[@class='wrapperChild items-center'])[2]

}
