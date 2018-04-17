package script;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import genric.BaseTest;
import genric.excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class validLogin extends BaseTest
{
	@Test(priority =1, groups="smoke")
	public void testvalidLogin() throws Exception
	{
		String un = excel.getCellvalue(XL_PATH, "validLogin", 1, 0);
		String pw = excel.getCellvalue(XL_PATH, "validLogin", 1, 1);
		String etitle = excel.getCellvalue(XL_PATH, "validLogin", 1, 2);
		
		//ENTER VALID USERNAME A
		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		
		//ENTER VALID PASSWORD
		l.setPassword(pw);
		
		//CLICK LOGIN
		l.clickLogin();
		
		//VERIFY THAT HOMEPAGE IS DISPLAYED
		EnterTimeTrackPage E = new EnterTimeTrackPage(driver);
		E.verifyTitle(driver, etitle);
	}
}
