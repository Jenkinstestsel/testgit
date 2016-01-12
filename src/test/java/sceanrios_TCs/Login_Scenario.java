package sceanrios_TCs;

import generic_library.Base_Class;
import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;


import PageObjectRepository.POM_LoginScenario;


public class Login_Scenario extends Base_Class{


static Logger log = Logger.getLogger(Login_Scenario.class);
	
	@Test(dataProvider = "DP_invalid_login", dataProviderClass = DataProviderObjects.DP_LoginScenario.class)
	public void invalid_login(String TC_ID, String Order, String Uname, String Pwd, String expected ) throws Exception
	{
		//SoftAssert assert1 = new SoftAssert();
		log.info("Starting invalid_login scenario"+ TC_ID+" "+ Order);
		Initialize_browser();
		
		log.info("Browser Initialized"+ TC_ID+" "+ Order);
		
		POM_LoginScenario pom_invalid  = new POM_LoginScenario(driver);
		pom_invalid.execute_common_methods_log(Uname, Pwd);	
		if (driver.getTitle().equalsIgnoreCase("Buy Books Online | Online Bookstore India | Online Book Shopping | Free Shipping Across India"))
		{
			log.error("The user has  loggedin, the page the user currently is " +driver.getTitle());
			Assert.fail();
			tear_down();
		}
		String actual = pom_invalid.get_invalid_log_msg();
		//assert1.assertEquals(actual, expected ,"The actual found is"+ actual+" The expected is "+ expected);
		if(actual.equalsIgnoreCase(expected))
		{
			log.info("The validation has passed");
		}
		else
		{
			log.error("THe validation has failed");
		}
		tear_down();
		//assert1.assertAll();
		log.info("Completed invalid_login scenario"+ TC_ID+" "+ Order);
	}	
	@Test (dataProvider = "DP_valid_login", dataProviderClass = DataProviderObjects.DP_LoginScenario.class , groups={"SmokeTest"})
	public void avalid_login(String TC_ID, String Order, String Uname, String Pwd, String expected ) throws Exception
	{
		//SoftAssert assert1 = new SoftAssert();
		Initialize_browser();
		POM_LoginScenario pom_valid  = new POM_LoginScenario(driver);
		pom_valid.execute_common_methods_log(Uname, Pwd);
		if (!driver.getTitle().equalsIgnoreCase("Buy Books Online | Online Bookstore India | Online Book Shopping | Free Shipping Across India"))
		{
			log.error("The user has failed to login, the page the user currently is " +driver.getTitle());
			Assert.fail();
			tear_down();
		}
		String actual = pom_valid.get_valid_log_msg();
		//assert1.assertEquals(actual, expected ,"The actual found is"+ actual+" The expected is "+ expected);
		if(actual.equalsIgnoreCase(expected))
		{
			log.info("The validation has passed");
		}
		else
		{
			log.error("THe validation has failed");
		}
		pom_valid.click_signout();
		tear_down();
		//assert1.assertAll();
	}

}
