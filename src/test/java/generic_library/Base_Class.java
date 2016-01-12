package generic_library;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base_Class {
	public WebDriver driver = null;
		public void Initialize_browser() throws Exception
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(UtilityClass.getpropertyvalue("URL"));
	}
	
	public void tear_down()
	{
		driver.quit();
	}

}
