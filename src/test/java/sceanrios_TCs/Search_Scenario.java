package sceanrios_TCs;

import generic_library.Base_Class;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectRepository.POM_HomePage;

public class Search_Scenario extends Base_Class {
	
	@Test(dataProvider = "DP_invalid_search",dataProviderClass = DataProviderObjects.DP_SearchScenario.class)
	public void invalidSearch(String TC_ID, String Order, String Search_Item, String expected  ) throws Exception
	{
		SoftAssert assert1 = new SoftAssert();
		Initialize_browser();
		POM_HomePage pom_invalid = new POM_HomePage(driver);
		pom_invalid.execute_comm_methods(Search_Item);
		String actual = pom_invalid.get_invalidmsg();
		assert1.assertEquals(actual, expected ,"The actual found is"+ actual+" The expected is "+ expected);
		System.out.println(actual+ "  "+ expected);
		tear_down();
		assert1.assertAll();
	}
	
	@Test(dataProvider = "DP_valid_search",dataProviderClass = DataProviderObjects.DP_SearchScenario.class)
	public void validSearch(String TC_ID, String Order, String Search_Item, String expected ) throws Exception
	{		
		SoftAssert assert1 = new SoftAssert();
		Initialize_browser();
		POM_HomePage pom_valid = new POM_HomePage(driver);
		pom_valid.execute_comm_methods(Search_Item);
		String actual = pom_valid.get_validmsg();
		assert1.assertEquals(actual, expected.replace(".0", "") ,"The actual found is "+ actual+" The expected is "+ expected.replace(".0", ""));
		System.out.println(actual+ "  "+ expected.replace(".0", ""));		
		tear_down();
		assert1.assertAll();
	}

}
