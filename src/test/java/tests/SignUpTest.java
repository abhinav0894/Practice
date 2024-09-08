package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.SignUpPage;
import utilities.WaitUtil;


public class SignUpTest{
	
	SignUpPage sp= new SignUpPage();
	DataFile df= new DataFile();
	WaitUtil wt= new WaitUtil();
	
	 @BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
		 sp.OpenBrowser();
		 sp.OpenSignUpPage();
	 }

	 @AfterMethod
	  public void afterMethod() throws IOException {
		 wt.ScreenShoot();
		  sp.CloseBrowser();
	  }
	 
	 @Test(priority=1)
	  public void SoctiabankSignUpTest() throws InterruptedException{
		 
		 sp.AccountType(df.CardNumber);
		 String expectedErr=df.SignUpErr;
		 String actualErr=sp.ReadEmailErr();
		 Assert.assertEquals(expectedErr, actualErr);
	 }
	 @Test(priority=2)
	  public void DebitCardTest() throws InterruptedException {
		 
		sp.AccountTypeDebit(df.CardNumber);
		String expectedErr=df.DebitCardErr;
		String actualErr=sp.ScotiabankErr();
		Assert.assertEquals(expectedErr, actualErr);
		}
	}

