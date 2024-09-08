package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

	public class SignUpPage extends  TestBase{
		
	
	// Page Factory
    @FindBy(xpath = "//select[@id='activateAccount']")
	public WebElement sel;
    
    @FindBy(xpath = "//select[@id='activateAccount']//option")
   	public List<WebElement> dropdown;
    
    @FindBy(id="activateCardNumber-input")
    public WebElement CardNumber;
    
    @FindBy(className="ButtonCore__icon")
    public WebElement click;
    
    
    @FindBy(xpath="//span[contains(text(),'Please enter your Credit Card number.')]")
    public WebElement emailErr;
    
    @FindBy(xpath="//span[contains(text(),'Please enter your 16-digit ScotiaCard number.')]")
    public WebElement DebitErr;
    
    @FindBy(id="onetrust-accept-btn-handler")
	public WebElement acceptall;
    

	public void OpenSignUpPage() throws InterruptedException{
		driver.get("https://auth.scotiaonline.scotiabank.com/activation/");
		acceptall.click();
	}
	
	public void CloseBrowser() {
		 driver.quit();
	}
	
	public void AccountType(String a) throws InterruptedException {
		
		System.out.println(dropdown.size());
		Select s= new Select(sel);
		s.selectByIndex(0);//
		CardNumber.sendKeys(a);
		jse.executeScript("arguments[0].click();",click);
	}
	public String ReadEmailErr() {
		String actualErr=emailErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	public void AccountTypeDebit(String a) throws InterruptedException {
		
		System.out.println(dropdown.size());
		Select s= new Select(sel);
		s.selectByIndex(1);//
		Thread.sleep(3000);
		CardNumber.sendKeys(a);
		jse.executeScript("arguments[0].click();",click);
	}
	public String ScotiabankErr() {
	String actualErr=DebitErr.getText();
	System.out.println(actualErr);
	return actualErr;
	}
}