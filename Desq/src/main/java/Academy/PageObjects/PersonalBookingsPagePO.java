package Academy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponent.AbstractComponent;

public class PersonalBookingsPagePO extends AbstractComponent {
	
	WebDriver driver;
	
	public PersonalBookingsPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent
		this.driver = driver; //The left driver is from this PO class, the right driver is from StandAloneTestAGAIN156
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	
	//driver.findElement(By.cssSelector("button[class*='h-10']")).click();
	/*
	  By.cssSelector("button[class*='h-10']")
	 */
		
		
		
		//PageFactory		
			@FindBy(css=".flex.flex-row.items-center h5")
			WebElement personalBookings;
			
			@FindBy(css="button[class*='h-10']")
			WebElement addBookingButton;
			
			@FindBy(css=".flex.flex-wrap div")  //@FindBy(css=".flex.flex-col.justify-end")
			List<WebElement> allBookedCardsList;
			
			@FindBy(css="h4")
			WebElement popupInsideQuestion;
			
			@FindBy(css="button[type='submit']")
			WebElement submitButton;
			
			@FindBy(css="button[type='button']")
			WebElement closeButton;
			
			
			//By
			By personalBookingsBy = By.cssSelector(".flex.flex-row.items-center h5");
			By h4By = By.cssSelector("h4");
			By popupInsideBy = By.cssSelector(".popupInside");
			By addBookingBy = By.cssSelector("button[class*='h-10']");
			
			
			//Action Methods
			
			public String verifyLogin()
			{
				waitForElementToAppear(personalBookingsBy);
				String actualPersonalBookings = personalBookings.getText();
				System.out.println(actualPersonalBookings);
				return actualPersonalBookings;
			}
			
			public void clickAddBooking()
			{
				scrollTillBottomPage();
				waitForElementToAppear(addBookingBy);
				addBookingButton.click();
				waitForElementToAppear(h4By);
			}
			
			public String readableDate(String expectedBookedDate)
			{
				
				String[] splitted01 = expectedBookedDate.split("×");
				String trimmedDate = splitted01[0].trim();
				System.out.println(trimmedDate);
				return trimmedDate;
			}
			
			public List<WebElement> getAllBookedCardsList()
			{
				return allBookedCardsList;
			}
			
			public WebElement dateForCancelReservation(String expectedBookedDate)
			{
				WebElement myDate = getAllBookedCardsList().stream().filter(oneCard -> oneCard.findElement(By.cssSelector("button[class*='bg-brand_black']")).getText().equals(expectedBookedDate))
						.findFirst().orElse(null);
				return myDate;
			}
			
			public void clickCancelReservation(String expectedBookedDate)
			{
				dateForCancelReservation(expectedBookedDate).click();  //dateForCancelReservation(expectedBookedDate).findElement(By.cssSelector("button[class*='bg-brand_black']")).click();
			}
			
			public String getPopUpMessage()
			{
				waitForElementToAppear(popupInsideBy);
				String popUpQuestion = popupInsideQuestion.getText();
				return popUpQuestion;
				
			}
			
			public void cancelBookingYes()
			{
				submitButton.click();
				waitForElementToAppear(personalBookingsBy);
			}
			
			public void cancelBookingNo()
			{
				closeButton.click();
				waitForElementToAppear(personalBookingsBy);
			}
			
			
}
