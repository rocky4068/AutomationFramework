package script;

import org.testng.annotations.Test;

import genric.BaseTest;
import genric.excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class checkProductVersion extends BaseTest
{
	@Test(priority = 3 , groups = "version")
	public void testcheckPriductversion() throws Exception
	{
		String un = excel.getCellvalue(XL_PATH, "ProductVersion", 1, 0);
		String pw = excel.getCellvalue(XL_PATH, "ProductVersion", 1, 1);
		String eVersion = excel.getCellvalue(XL_PATH, "ProductVersion", 1, 2);
		
		//ENTER VALID USERNAME
		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		
		//ENTER VALID PASSWORD
		l.setPassword(pw);
		
		//CLICK LOGIN
		l.clickLogin();
		
		//CLICK HELP
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.clickHelp();
		
		//CLICK ABOUTACTITIME
		e.clickAboutActitime();
		
		//VERIFY PRODUCT VERSION
		e.verifyProductVersion(eVersion);
		
		//CLICK CLOSE
		e.clickCloseBtn();
		
		//CLICK ON LOGOUTLINK
		e.clickLogoutlink();
	}
}
