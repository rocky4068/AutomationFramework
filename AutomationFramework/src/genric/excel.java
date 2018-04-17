package genric;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel 
{
	public static String getCellvalue(String path, String sheet, int r, int c) throws Exception
	{
		String s = "";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet("sheet").getRow(r).getCell(c).toString();
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return s;
	}
	public static int getRowcount(String path, String sheet)
	{
		int rc = 0;
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getLastRowNum();
			
		} 
		catch (Exception e) 
		{
			
		}
		return rc;
		
	}
}
