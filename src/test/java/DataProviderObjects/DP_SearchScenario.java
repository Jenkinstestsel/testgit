package DataProviderObjects;

import generic_library.ExcelReadWrite;
import generic_library.UtilityClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class DP_SearchScenario {
	
	@DataProvider(name = "DP_valid_search")
	public static Iterator<String[]> valid_search() throws Exception
	{
		DP_SearchScenario valid = new DP_SearchScenario();
		List<String[]> ls = valid.excelhandler("Valid_Search");
		return ls.iterator();
	}
	
	@DataProvider(name = "DP_invalid_search")
	public static Iterator<String[]> invalid_search() throws Exception
	{
		DP_SearchScenario invalid = new DP_SearchScenario();
		List<String[]> ls = invalid.excelhandler("Invalid_Search");
		return ls.iterator();
	}
	
	public List<String[]> excelhandler(String Scriptname) throws Exception
	{
		ExcelReadWrite xl = new ExcelReadWrite(System.getProperty("user.dir")+UtilityClass.getpropertyvalue("XLPATH"));
		XSSFSheet sheet = xl.Setsheet("Scenario_Search");
		List<String[]> ls = new ArrayList<String[]>();
		int rowcount = xl.getrowcount(sheet);
		for (int i =1;i<=rowcount;i++)
		{
			if(xl.Readvalue(sheet, i, "Scriptname").equalsIgnoreCase(Scriptname))
			{
				if (xl.Readvalue(sheet, i, "Execute_Flag").equalsIgnoreCase("Y"))
				{
					String[] s = new String[4];
					s[0] = xl.Readvalue(sheet, i, "TC_ID");
					s[1] = xl.Readvalue(sheet, i, "Order");
					s[2] = xl.Readvalue(sheet, i, "Search_Item");
					s[3] = xl.Readvalue(sheet, i, "Exp_Res");
					ls.add(s);
				}
			}
		}return ls;
	}

}
