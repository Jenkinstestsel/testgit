package DataProviderObjects;

import generic_library.ExcelReadWrite;
import generic_library.UtilityClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class DP_CartScenario {
	
	@DataProvider(name = "DP_addcart")
	public static Iterator<String[]> addcart() throws Exception
	{
		DP_CartScenario add = new DP_CartScenario();
		List<String[]> ls = add.excelhandler("AddCart");
		return ls.iterator();
	}
	
	@DataProvider(name = "DP_deletecart")
	public static Iterator<String[]> deletecart() throws Exception
	{
		DP_CartScenario add = new DP_CartScenario();
		List<String[]> ls = add.excelhandler("DeleteCart");
		return ls.iterator();
	}
	
	public List<String[]> excelhandler(String Scriptname) throws Exception
	{
		ExcelReadWrite xl = new ExcelReadWrite(System.getProperty("user.dir")+UtilityClass.getpropertyvalue("XLPATH"));
		XSSFSheet sheet = xl.Setsheet("Scenario_Cart");
		List<String[]> ls = new ArrayList<String[]>();
		int rowcount = xl.getrowcount(sheet);
		String[] s = new String[7];
		for(int i =1;i<= rowcount;i++)
		{
			if(xl.Readvalue(sheet, i, "Scriptname").equalsIgnoreCase(Scriptname))
			{
				if(xl.Readvalue(sheet, i, "Execute_Flag").equalsIgnoreCase("Y"))
				{
					s[0] = xl.Readvalue(sheet, i, "TC_ID");
					s[1] = xl.Readvalue(sheet, i, "Order");
					s[2] = xl.Readvalue(sheet, i, "Uname");
					s[3] = xl.Readvalue(sheet, i, "Pwd");
					s[4] = xl.Readvalue(sheet, i, "Search_Item");
					s[5] = xl.Readvalue(sheet, i, "Quantity");
					s[6] = xl.Readvalue(sheet, i, "Exp_Res");
					ls.add(s);
				}
			}
		}return ls;
	}

}
