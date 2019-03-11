package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst{
	static{
		System.setProperty("webdriver.chrome.driver","./Allexe/chromedriver.exe");
	}
	public WebDriver driver=new ChromeDriver();
	@BeforeMethod 
	public void setup(){

		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public  void teardown(ITestResult result) throws IOException{
		String name = result.getName();
		int status = result.getStatus();
		if(status==2){
			Utils.photo(driver, PHOTOPATH);
			Reporter.log("Test failed is:"+name,true);
		}else{
			Reporter.log("passed",true);
		}
		driver.close();
	}

}
