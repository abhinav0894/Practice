package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import pages.SignUpPage;

public class LoginTest {
	LoginPage lp=new LoginPage();
	DataFile df= new DataFile();
	
  @BeforeMethod
  public  void beforeMethod() throws InterruptedException, IOException {
	  lp.OpenBrowser();
	  lp.OpenLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.CloseBrowser();
  }
  
  @Test(priority=1)
  public void SoctiabankLoginTest() throws InterruptedException {
	
	  		lp.Login(df.emailWithSpecialChar,df.wrongPassword);
			String expectedErr=df.spacialCharEmmailErr;
			String actualErr=lp.ReadEmailErr();
			Assert.assertEquals(expectedErr, actualErr);	
  		}
  
		@Test(priority=2)
		  public void EmptyEmailTest() throws InterruptedException {
			 
			lp.Login("",df.wrongPassword);
			String expectedErr=df.emptyEmailErr;
			String actualErr=lp.ReadEmailErr();
			Assert.assertEquals(expectedErr, actualErr);
			}
		
		 @Test(priority=3)
		  public void EmptyPasswordTest() throws InterruptedException {
		
			lp.Login(df.wrongEmail,"");
			String expectedErr=df.emptyPasswordErr;
			String actualErr=lp.ReadPassworderr();
			Assert.assertEquals(expectedErr, actualErr);				
		 }
		 
		 @Test(priority=4)
		  public void WrongemailpasswordTest() throws InterruptedException {
			lp.Login(df.wrongEmail,df.wrongPassword);
			String expectedErr=df.globalErr;
			String actualErr=lp.ReadGlobalerr();
			Assert.assertEquals(expectedErr, actualErr);
		 }
				
}
