package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Online_shopping {
	WebDriver driver = null;
	@FindBy(linkText = "Sign out")
	WebElement link_signout;
	
	public POM_Online_shopping(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_signout()
	{
		link_signout.click();
	}

}
