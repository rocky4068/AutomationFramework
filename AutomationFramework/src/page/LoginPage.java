package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import genric.BaseTest;

public class LoginPage extends BaseTest
{
	@FindBy(id = "username")
	private WebElement untb;
	
	@FindBy(name = "pwd")
	private WebElement pwtb;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement loginbtn;
	
	@FindBy(xpath = "//span[contains(.,'invalid')]")
	private WebElement errmsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public  void setUsername(String un)
	{
		untb.sendKeys(un);
	}
	public void setPassword(String pw)
	{
		pwtb.sendKeys(pw);
	}
	public void clickLogin()
	{
		loginbtn.click();
	}
	public void verifyErrMsg(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(errmsg));
			Reporter.log("errmsg is displayed", true);
			
		} 
		catch (Exception e) 
		{
			Reporter.log("errmsg is not displayed", true);
			Assert.fail();
		}
	}
}
