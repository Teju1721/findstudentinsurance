package base.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.base.com.Driver;

public class Car extends Driver {
	
	public void Website(WebDriver driver)
	{
		driver.get(Carbutton);
	}
	public String Carbutton="https://ci.policybazaar.com/?utm_content=home_v11";
	Driver driver;
	 public Car(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }
	 @FindBy(how=How.XPATH, using="/html/body/main/div[2]/section/div[4]/a/div[1]/div/i")
	 public WebElement CarInsuranceButton;
	 
	 public void clickCarInsuranceButton()
	 {
		 CarInsuranceButton.click();

	 }
	 
	 @FindBy(how=How.XPATH,using="//*[@id='before-tp']/div[2]/a" )
	 public WebElement WithoutCarNumber;
	 
	 public void clickWithoutCarNumber()
	 {
		 WithoutCarNumber.click();
	 }
	 
	 @FindBy(how=How.XPATH,using="//*[@id='searchInput']/div/input")
	 public WebElement SearchButton;
	 
	 public void clickSearchButton()
	 {
		 SearchButton.click();
	 }
	 
	 @FindBy(how=How.XPATH,using="//*[@id='react-autowhatever-1--item-9']/span")
	 public WebElement RtoButton;
	 
	 public void clickRtoButton()
	 {
		 RtoButton.click();
	 }
	 
	 @FindBy(how=How.XPATH, using="//*[@id='dvMake']/div/ul/div/li[4]/span" )
	 public WebElement CarBrandButton;
	 
	 public void clickCarBrandButton()
	 {
		 CarBrandButton.click();
	 }
	 @FindBy(how=How.XPATH,using="//*[@id=\"searchInput\"]/div/input")
	 public WebElement CarSearchButton;
	 
	 public void clickCarSearchButton() {
		 
		 CarSearchButton.click();
	 }
	 
	 @FindBy(how=How.XPATH,using="//*[@id=\"modelScroll\"]/li[5]/span")
	 public WebElement CarSelectButton;
	 
	 public void clickCarSelectButton()
	 {
		 CarSelectButton.click();
	 }
	 
	 @FindBy(how=How.XPATH,using="//*[@id='Petrol']")
	 public WebElement CarFuelType;
	 
	 public void clickCarFuelType() {
		 CarFuelType.click();
	 }
	 
	 @FindBy(how=How.XPATH,using="//*[@id='variantScroll']/li[1]")
	 
	 public WebElement CarVariant;
	 
	 public void clickCarVariant()
	 {
		 CarVariant.click();
	 }
	 @FindBy(how = How.ID, using = "name")
	    public WebElement FillingDetails_Name;

	    public void enterName(String name) {
	        FillingDetails_Name.clear(); // Clear the field before entering new text
	        FillingDetails_Name.sendKeys(name);
	    }

	    @FindBy(how = How.ID, using = "email")
	    public WebElement FillingDetails_Email;

	    public void enterEmail(String email) {
	        FillingDetails_Email.clear(); // Clear the field before entering new text
	        FillingDetails_Email.sendKeys(email);
	    }
	 
	 @FindBy(how=How.XPATH,using="//*[@id='dvVariant']/div[2]/div[1]/div[2]/div[2]")
	 public WebElement CaptureEmail_Error;
	 
	 public void clickCaptureEmail_Error()
	 {
		
		 System.out.println("---------------------------Error Message---------------------------------");
 		System.out.println();
 		System.out.println("-----------Email Id Error---------------");
 	
	 }
	 
	 @FindBy(how=How.XPATH,using ="//*[@id='mobileNo']")
	 public WebElement FillingDetails_MobileNumber;
	 
	 public void clickFillingDetails_MobileNumber(String mobileno)
	 {
		 FillingDetails_MobileNumber.sendKeys(mobileno);
	 }
	 
	 @FindBy(how=How.XPATH,using ="//*[@id=\"btnLeadDetails\"]/span")
	 public WebElement ApplyButton;
	 
	 public void clickApplyButton()
	 {
		 ApplyButton.click();
	 }
	 
	 @FindBy(how=How.XPATH,using="//*[@id='rootSubDiv']/div[1]/div[1]/div[1]/a[2]")
	 public WebElement NavigateBackTo_HomePage;
	 
	 public void clickNavigateBackTo_HomePage()
	 {
		 NavigateBackTo_HomePage.click();
	 }
	 
	 
	 
	 

}
