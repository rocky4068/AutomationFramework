package genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst
{
	public WebDriver driver;
	static 
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void openAplication(String browser)
	{
		if (browser.equals("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else
		{
			driver = new FirefoxDriver();
		}
		driver = new ChromeDriver();
		String AUT = AUL.getProperties(SETTING_PATH, "AUT");
		driver.get(AUT);
		String strITO = AUL.getProperties(SETTING_PATH, "AUT");
		Long ITO = Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
		@AfterMethod
		public void closeAplication(ITestResult res)
		{
			String TestName = res.getName();
			if (res.getStatus()==2) 
			{
				AUL.takephoto(PHOTO_PATH, TestName, driver);
			}
			driver.quit();
			
		}
}
