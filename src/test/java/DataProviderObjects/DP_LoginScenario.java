package DataProviderObjects;

import generic_library.ExcelReadWrite;
import generic_library.UtilityClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;


public class DP_LoginScenario {
	@DataProvider(name = "DP_invalid_login")
	public static Iterator<String[]> invalid_login_DP() throws Exception
	{
		DP_LoginScenario invalid = new DP_LoginScenario();
		List<String[]> ls = invalid.excelhandler("Invalid_Login_test");		
		return ls.iterator();
	}
	
	@DataProvider(name = "DP_valid_login")
	public static Iterator<String[]> valid_login_DP() throws Exception
	{
		DP_LoginScenario valid = new DP_LoginScenario();
		List<String[]> ls = valid.excelhandler("Valid_Login_test");		
		return ls.iterator();
	}

	public List<String[]> excelhandler(String scriptname) throws Exception	
	{
		ExcelReadWrite xl  = new ExcelReadWrite(System.getProperty("user.dir")+UtilityClass.getpropertyvalue("XLPATH"));
		XSSFSheet Sheet = xl.Setsheet("Scenario_Login");
		List<String[]> ls = new ArrayList<String[]>();
		int rowCount = xl.getrowcount(Sheet);
		for(int i = 1;i<=rowCount;i++)
		{
			if (xl.Readvalue(Sheet, i, "Scriptname").equalsIgnoreCase(scriptname))
			{
			if(xl.Readvalue(Sheet, i, "Execute_Flag").equalsIgnoreCase("Y"))
			{
				String[] s = new String [5];
				s[0] = xl.Readvalue(Sheet, i, "TC_ID");
				s[1] = xl.Readvalue(Sheet, i, "Order");
				s[2] = xl.Readvalue(Sheet, i, "Uname");
				s[3] = xl.Readvalue(Sheet, i, "Pwd");
				s[4] = xl.Readvalue(Sheet, i, "Exp_Res");
				ls.add(s);				
			}
			
		}
		}
		return ls;
				
	}
}
