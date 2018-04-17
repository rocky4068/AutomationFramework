package script;

import org.testng.annotations.Test;

import genric.BaseTest;
import genric.excel;
import page.LoginPage;

public class invalidLogin extends BaseTest
{
	@Test(priority= 2 , groups = "Login")
	public void tesinvalidLogin() throws Exception
	{
		String un = excel.getCellvalue(XL_PATH, "invalidLogin", 1, 0);
		String pw = excel.getCellvalue(XL_PATH, "invalidLogin", 1, 1);
		
		// ENTER INVALID USERNAME
		LoginPage l = new LoginPage(driver);
		l.setUsername(un);
		
		//ENTER INVALID PASSWORD
		l.setPassword(pw);
		
		// VERIFY ERROR MESSAGE
		l.verifyErrMsg(driver);
	}
}
