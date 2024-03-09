package base.object;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.base.com.Driver;
public class Health extends Driver {
	
	Driver driver;
	public Health(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	@FindBy(how=How.XPATH,using="//*[@class='ruby-menu-mega shade mr']/a")
	public WebElement MenuButton;
	
	public void clickMenuButton()
	{
		MenuButton.click();
	}
	
	@FindBy(how=How.XPATH,using="//ul//div[3]/ul/li/a/span")
	public static List<WebElement> HealthMenuList;
	
	
}
