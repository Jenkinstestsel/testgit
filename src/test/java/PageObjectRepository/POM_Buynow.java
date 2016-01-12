package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Buynow {
	
	WebDriver driver = null;
	@FindBy(className = "addtocartbtn")
	WebElement button_buynow;
	
	public POM_Buynow(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_buynow()
	{
		button_buynow.click();
	}

}
