package Academy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponent.AbstractComponent;

public class ResultsPagePO extends AbstractComponent {
	
	WebDriver driver;
	
	public ResultsPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent
		this.driver = driver; //The left driver is from this PO class, the right driver is from StandAloneTestAGAIN156
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	
	//driver.findElement(By.cssSelector("button[class*='h-10']")).click();
		
		
		//PageFactory		
	
			@FindBy(css="button[type*='submit']")
			WebElement bookThisButton;
			
			
			
			
			//By
			By personalBookingsBy = By.cssSelector(".flex.flex-row.items-center h5");
			
			
			
			//Action Methods
			
			public void clickBookThisButton()
			{
				bookThisButton.click();
				waitForElementToAppear(personalBookingsBy);
			}
			
			
			
			
			
}
