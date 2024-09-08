package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;



public class WaitUtil extends TestBase{
	
	public static long Page_load= 20;
	public static int Implicit_wait=20;
	

	public void ScreenShoot() throws IOException {
		
		Date currentdate=new Date();
		String scfilename=currentdate.toString();
		File Screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot, new File("C:\\QA\\Selenium_WorkSpace\\TddFrameworkProject\\screenshot.png"));
	}
	
}
