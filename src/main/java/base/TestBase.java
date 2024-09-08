package base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtil;


public class TestBase {

	public static WebDriver driver;
	public static  Properties prop;
	public static JavascriptExecutor jse;
	
	
	
	public  void OpenBrowser() throws IOException {
		FileInputStream fi = new FileInputStream("C:\\QA\\Selenium_WorkSpace\\TddFrameworkProject\\src\\main\\java\\config\\config.properties");
		 prop = new Properties();
		prop.load(fi);
		
		String browser = prop.getProperty("browser"); 
		System.out.println(browser);
		
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver(); 
		}else if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}else {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(WaitUtil.Implicit_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(WaitUtil.Page_load, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		 jse= (JavascriptExecutor)driver;
		}
	
}
		