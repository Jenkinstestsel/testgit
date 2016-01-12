package sceanrios_TCs;

import generic_library.Base_Class;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectRepository.POM_Buynow;
import PageObjectRepository.POM_HomePage;
import PageObjectRepository.POM_LoginScenario;
import PageObjectRepository.POM_Online_shopping;
import PageObjectRepository.POM_shopping;

public class Cart_Scenario extends Base_Class {
	
	@Test(dataProvider = "DP_addcart",dataProviderClass = DataProviderObjects.DP_CartScenario.class)
	public void addcart(String TC_ID, String Order, String Uname, String Pwd, String Search_Item, String Quantity, String expected ) throws Exception
	{
		SoftAssert assert1 = new SoftAssert();
		Initialize_browser();
		POM_LoginScenario pom_login = new POM_LoginScenario(driver);
		pom_login.execute_common_methods_log(Uname, Pwd);
		System.out.println("Login Complete");
		POM_HomePage pom_home = new POM_HomePage(driver);
		pom_home.execute_comm_methods(Search_Item);
		System.out.println("Item found");
		pom_home.click_img();
		System.out.println("item selected");
		POM_Buynow pom_buy = new POM_Buynow(driver);
		pom_buy.click_buynow();
		System.out.println("buynow successfull");
		POM_shopping pom_shopping = new POM_shopping(driver);
		pom_shopping.Enter_quantity(Quantity);
		String actual = pom_shopping.get_booktext();
		assert1.assertEquals(actual, expected ,"The actual found is"+ actual+" The expected is "+ expected);
		pom_shopping.click_redifflink();
		System.out.println("Get book text and quantity completed");
		POM_Online_shopping pom_online = new POM_Online_shopping(driver);
		pom_online.click_signout();
		System.out.println("Signout completed");
		tear_down();		
		System.out.println("Addcart TC completed");
		assert1.assertAll();
	}
	
	@Test(dataProvider = "DP_deletecart",dataProviderClass = DataProviderObjects.DP_CartScenario.class)
	public void deletecart(String TC_ID, String Order, String Uname, String Pwd, String Search_Item, String Quantity, String expected ) throws Exception
		{
		    SoftAssert assert1 = new SoftAssert();
			Initialize_browser();
			POM_LoginScenario pom_login = new POM_LoginScenario(driver);
			pom_login.execute_common_methods_log(Uname, Pwd);
			System.out.println("Login Complete");
			POM_HomePage pom_home = new POM_HomePage(driver);
			pom_home.execute_comm_methods(Search_Item);
			System.out.println("Item found");
			pom_home.click_img();
			System.out.println("item selected");
			POM_Buynow pom_buy = new POM_Buynow(driver);
			pom_buy.click_buynow();
			System.out.println("buynow successfull");
			POM_shopping pom_shopping = new POM_shopping(driver);
			pom_shopping.click_deleteicon();
			String actual = pom_shopping.get_emptycartmsg();
			assert1.assertEquals(actual, expected ,"The actual found is"+ actual+" The expected is "+ expected);
			tear_down();
			assert1.assertAll();
		}
	

}
