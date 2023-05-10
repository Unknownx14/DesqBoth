package Academy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponent.AbstractComponent;

public class BookingsPagePO extends AbstractComponent {
	
	WebDriver driver;
	
	public BookingsPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent
		this.driver = driver; //The left driver is from this PO class, the right driver is from StandAloneTestAGAIN156
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	
	//driver.findElement(By.cssSelector("button[class*='h-10']")).click();
/*	String actualErrorMessage = driver.findElement(By.cssSelector(".text-red-600")).getText();*/
		
		
		//PageFactory		
			@FindBy(css="label[class*='bg-brand_black']")
			List<WebElement> allDatesList;
			
			@FindBy(css="button[class*='bg-white']")
			List<WebElement> allTimesList;
			
			@FindBy(css="button[type*='submit']")
			WebElement findDeskButton;
			
			@FindBy(css="label[class*='bg-brand_black']")
			List<WebElement> allDatesList02;
			
			@FindBy(xpath="(//p[contains(@class, 'text-red-600')])[1]")
			WebElement dateNotPickedMessage;
			
			
			
			
			//By
			By searchBarBy = By.cssSelector(".searchBar");
			By dateNotPickedBy = By.xpath("(//p[contains(@class, 'text-red-600')])[1]");
			
			
			
			
			//Action Methods
			
			public List<WebElement> getListAllDates()
			{
				return allDatesList;
			}
			
			
			public void selectDate(String wantedDate)
			{
				for(int i=0;i<getListAllDates().size();i++)
				{
					String numbers = getListAllDates().get(i).getText();
					System.out.println(numbers);
						if(numbers.equals(wantedDate))
						{
							getListAllDates().get(i).click();
						}
				}
			}
			
			
			public List<WebElement> getListAllArrivaltimes()
			{
				return allTimesList;
			}
			
			
			public void selectArrivalTime(String wantedTime)
			{
				for(int i=0;i<getListAllArrivaltimes().size();i++)
				{
					String numbers = getListAllArrivaltimes().get(i).getText();
					System.out.println(numbers);
						if(numbers.equals(wantedTime))
						{
							getListAllArrivaltimes().get(i).click();
						}
				}
			}
			
			
			public void clickFindDesk()
			{
				findDeskButton.click();
				waitForElementToAppear(searchBarBy);
				
			}
			
			
			public List<WebElement> getListAllDates02()
			{
				return allDatesList02;
			}
			
			
			public Boolean isDateClickable(String wantedDate)
			{
				
				for(int i=0;i<getListAllDates02().size();i++)
				{
					String numbers = getListAllDates02().get(i).getText();
					
						if(numbers.equals(wantedDate))
						{
							System.out.println(numbers);
							Boolean clickableDate = getListAllDates02().get(i).isEnabled();
							System.out.println(clickableDate);
							return clickableDate;
						}
				}
				return false;
				
				
			}
			
			public void clickFindDeskDateNotPicked()
			{
				findDeskButton.click();
				waitForElementToAppear(dateNotPickedBy);
				
			}
			
			public String getDateNotPickedMessage()
			{
				String actualErrorMessage = dateNotPickedMessage.getText();
				return actualErrorMessage;
			}
			
			
			
			
}
