package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utils;


public class LoginTest extends BaseTest{

	@Test
	public void tc_001() throws InterruptedException, IOException {
		String un = Utils.readXLData(XLPATH,"Sheet1", 1, 0);
		String PWD = Utils.readXLData(XLPATH,"Sheet1", 1, 1);
		
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(PWD);
		driver.findElement(By.id("loginButton")).click();
		
		//Thread.sleep(10000);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains("submit_tt.do"));
		String url = driver.getCurrentUrl();
		if(url.contains("submit_tt.do"))
		{

			Reporter.log("success",true);
		}else{
			Reporter.log("failed",true);
			/*TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("./photos/image.png");
			FileUtils.copyFile(src, dest);*/
			Assert.fail();
			
		}
		
		
		
		
	}

}
