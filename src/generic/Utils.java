package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
	public static String readXLData(String path,String sheet,int row, int col)
	{
		String xlpath="";
		Workbook wb;
		
		try {
			wb=WorkbookFactory.create(new FileInputStream(path));
			xlpath = wb.getSheet(sheet).getRow(row).getCell(col).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xlpath;
	}
	public static String photo(WebDriver driver,String folder) throws IOException{
		String path="";
		
		Date d = new Date();
		String date = d.toString();
		String dateTime = date.replaceAll(":", "_");	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		path=folder+dateTime+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	
	
	
}
