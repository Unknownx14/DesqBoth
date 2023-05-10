package Academy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponent.AbstractComponent;

public class LandingPagePO extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent
		this.driver = driver; //The left driver is from this PO class, the right driver is from StandAloneTestAGAIN156
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	
	//driver.findElement(By.cssSelector("#userNameInput")).sendKeys(userEmail);
		//String actualErrorMessage = driver.findElement(By.cssSelector(".ng-trigger-flyInOut")).getText();
		
		
		//PageFactory
			@FindBy(css="#userNameInput")
			WebElement email;
			
			@FindBy(css="#passwordInput")
			WebElement password;
			
			@FindBy(css="#submitButton")
			WebElement submit;
			
			
			
			//By
			By personalBookingsBy = By.cssSelector(".flex.flex-row.items-center h5");
			
			
			//Action Methods
			public void loginToApplication(String userEmail, String userPassword)
			{
				email.sendKeys(userEmail);
				password.sendKeys(userPassword);
				submit.click();
			}
			
			public void goTo()
			{
				driver.get("http://test-deskreservation.createq.space/booking");
			}
			

			
			
}
