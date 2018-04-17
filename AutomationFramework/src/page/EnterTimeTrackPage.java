package page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import genric.AUL;
import genric.BaseTest;

public class EnterTimeTrackPage extends BaseTest
{
	@FindBy(xpath= "//div[contains(.,'Help')]")
	private WebElement help;
	
	@FindBy(xpath ="//a[contains(.,'About your actiTIME')]")
	private WebElement AboutActTime;

	@FindBy(xpath ="//span[contains(.,'actiTIME')]")
	private WebElement Productversion;
	
	@FindBy(id = "aboutPopupCloseButtonId")
	private WebElement closeBtn;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickHelp()
	{
		help.click();
	}
	public void clickAboutActitime()
	{
		AboutActTime.click();
	}
	public void verifyProductVersion(String eversion)
	{
		String aversion = Productversion.getText();
		Assert.assertEquals(aversion, eversion);
	}
	public void clickCloseBtn()
	{
		closeBtn.click();
	}
	public void clickLogoutlink()
	{
		logoutLink.click();
	}
	public void verifyTitle(WebDriver driver , String etitle)
	{
		String strETO = AUL.getProperties(SETTING_PATH, "ETO");
		Long ETO = Long.parseLong(strETO);
		WebDriverWait wait = new WebDriverWait(driver,ETO);
		try
		{
			wait.until(ExpectedConditions.titleIs(etitle));
			Reporter.log("Tittle is matching", true);
		} catch (Exception e) 
		{
			Reporter.log("Tittle is not matching", true);
		}
	}
}
