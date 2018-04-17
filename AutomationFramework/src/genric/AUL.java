package genric;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AUL 
{
	public static String getProperties(String path , String Key)
	{
		String v = "";
		try
		{
			Properties p = new  Properties();
			p.load(new FileInputStream(path));
			v = p.getProperty(Key);
		}
		catch (Exception e)
		{
			
		}
		return v;
	}
	public static void takephoto(String folder, String Testname , WebDriver driver)
	{
		String dateTime = new Date().toString().replaceAll(":", "_");
		TakesScreenshot t = (TakesScreenshot)driver ;
		File srcfile = t.getScreenshotAs(OutputType.FILE);
		String dstpath = folder + Testname + dateTime+ "png";
		try
		{
			FileUtils.copyFile(srcfile, new File(dstpath));
		} 
		catch (Exception e)
		{

		}
		
	}
}
