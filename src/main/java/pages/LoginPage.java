package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory
    @FindBy(id = "usernameInput-input")
	public WebElement email;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(id = "signIn")
	public WebElement signInButton;

	@FindBy(xpath = "//h1[@class='TextHeadlinestyle__Text-canvas-core__sc-rml86m-0 bkAjVU']")
	public WebElement globalErr;

	@FindBy(id = "UsernameTextField__errors-usernameInput")
	public WebElement emailErr;

	@FindBy(id = "PasswordTextField__errors-password")
	public WebElement passwordErr;
	
	@FindBy(id="onetrust-accept-btn-handler")
	public WebElement acceptall;
	
	
	
public void OpenLoginPage() throws InterruptedException {
	 driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=qRrUwr6BMZI&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5nb29nbGUuY29tXC8iLCJvYXV0aF9rZXkiOiJxUnJVd3I2Qk1aSSIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNzE3MzUwMDAyLCJpYXQiOjE3MTczNDg4MDIsImp0aSI6IjBkN2ZhYTgxLTYyZWQtNDliZC1iNDE0LTdhYjY2MGRkNjJjNiIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.mdtDMy_RWH5l8yPn_IC4O-zz_Rhgf1C4Hj3rch7b5RbrfY7zzlVqJ4YRKht4vCJBC1w_Cp-967A6sFtxbSkal3HTv1qBhE9yW7dJlAKl0f9cGQBHXbTMje8uurwbHr9VHwOwmrECX61MC6qtJBiyXwduevZrnuOl9ZbDhKvrLL1yXxro5X2cTj5sktj5sLwGt9KoRsAVlYDkbyNwR1BAVtRIwIl4KaCkupa0u6XkbekY12X_DEtq2tIlHtBCVTDt_tCQinWywa14HNQF37NIoCYVGvvEllwG2OoMx3gAtQCT8jnem8qvvxIw6U_riUycpZFd6Bz5dXZh6eSosPhUaA&preferred_environment=");
		Thread.sleep(6000);
		acceptall.click();
}
public void CloseBrowser() {
	 driver.quit();
}

public void Login(String a, String b) throws InterruptedException {
	email.sendKeys(a);
	password.sendKeys(b);
	signInButton.click();
	Thread.sleep(3000);
}
public String ReadEmailErr() {
	String actualErr=emailErr.getText();
	System.out.println(actualErr);
	return actualErr;
}
public String ReadPassworderr() {
	String actualErr=passwordErr.getText();
	System.out.println(actualErr);
	return actualErr;
}
public String ReadGlobalerr() {
	String actualErr=globalErr.getText();
	System.out.println(actualErr);
	return actualErr;
}
}
