package Academy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Academy.AbstractComponent.AbstractComponent;

public class PreferencesPagePO extends AbstractComponent {
	
	WebDriver driver;
	
	public PreferencesPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent
		this.driver = driver; //The left driver is from this PO class, the right driver is from StandAloneTestAGAIN156
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	
	//driver.findElement(By.cssSelector("#userNameInput")).sendKeys(userEmail);
		/*List<WebElement> allSectionsList = driver.findElements(By.cssSelector("section[class*='bg-brand_gray']"));
		WebElement favTeam = allSectionsList.stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Team"))
		.findFirst().orElse(null);
		favTeam.findElement(By.cssSelector(".bg-white")).click();
		
		WebElement favOffice = allSectionsList.stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Office"))
				.findFirst().orElse(null);
		favOffice.findElement(By.cssSelector(".bg-white")).click();
		
		WebElement favDesk = allSectionsList.stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Desk"))
				.findFirst().orElse(null);
		favDesk.findElement(By.cssSelector(".bg-white")).click();*/
		
		
		//PageFactory
			@FindBy(xpath="//button[@class='mt-2 mr-4 rounded-full']//img[@class='rounded-full']")
			WebElement profilePicture;
			
			@FindBy(xpath="//button[text()='Preferences']")
			WebElement preferencesButton;
			
			@FindBy(css="section[class*='bg-brand_gray']")
			List<WebElement> allSectionsList;
			
			
			
			//By
			By profilePictureMenuBy = By.cssSelector(".shadow-dropdownMenu");
			By firstLastNameBy = By.cssSelector("h4");
			
			
			//Action Methods
			
			public void goToReferences()
			{
				profilePicture.click();
				waitForElementToAppear(profilePictureMenuBy);
				preferencesButton.click();
				waitForElementToAppear(firstLastNameBy);
			}
			
			public List<WebElement> getListAllSections()
			{
				return allSectionsList;
			}
			
			public WebElement favouriteTeamSection()
			{
				WebElement favTeam = getListAllSections().stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Team"))
						.findFirst().orElse(null);
				return favTeam;
			}
			
			public void selectFavTeam()
			{
				favouriteTeamSection().findElement(By.cssSelector(".bg-white")).click();
			}
			
			public WebElement favouriteOfficeSection()
			{
				WebElement favOffice = allSectionsList.stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Office"))
						.findFirst().orElse(null);
				return favOffice;
			}
			
			public void selectFavOffice()
			{
				favouriteOfficeSection().findElement(By.cssSelector(".bg-white")).click();
			}
			
			public WebElement favouriteDeskSection()
			{
				WebElement favDesk = allSectionsList.stream().filter(oneSection -> oneSection.findElement(By.cssSelector("h5")).getText().equals("Favourite Desk"))
						.findFirst().orElse(null);
				return favDesk;
			}
			
			public void selectFavDesk()
			{
				favouriteDeskSection().findElement(By.cssSelector(".bg-white")).click();
			}

			
			
}
