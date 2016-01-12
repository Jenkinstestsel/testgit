package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_shopping {
	
	WebDriver driver = null;
	@FindBy(xpath = ".//span[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]/input")
	WebElement textbox_Quantity;
	
	@FindBy(xpath = ".//span[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]/div[2]/span[2]")
	WebElement text_fire_flood;
	
	@FindBy(linkText = "rediff.com")
	WebElement link_rediff;
	
	@FindBy(xpath = ".//span[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]/div[1]/div")
	WebElement icon_delete;
	
	@FindBy(xpath= "//span[@id='currentcartdiv']/div[3]/form/div[1]/span")
	WebElement text_emptymsg;
	
	
	public POM_shopping(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_quantity(String quantity)
	{
		textbox_Quantity.clear();
		textbox_Quantity.sendKeys(quantity.replace(".0", ""));
	}
	
	public String get_booktext()
	{
		return text_fire_flood.getText();
	}
	
	public void click_redifflink()
	{
		link_rediff.click();
	}
	
	public void click_deleteicon()
	{
		icon_delete.click();
	}
	
	public String  get_emptycartmsg()
	{
		return text_emptymsg.getText();
	}
	
	

}
