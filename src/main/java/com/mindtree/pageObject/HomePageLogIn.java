package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.HomePageLogInUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePageLogIn extends HomePageLogInUi{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public HomePageLogIn(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void login(String Uid,String Pw) throws ReusableComponentException, Exception
	{
		try
		{
		WebDriverSupport.click(driver,logInButton,"Home Page","Log In Button", log, test);
		Thread.sleep(5000);
		WebDriverSupport.sendKeys(driver,email,"Account Log in","Email field", log, test, Uid);
		WebDriverSupport.sendKeys(driver,pass,"Account Log in","password field", log, test, Pw);
		WebDriverSupport.click(driver,signin, "Account Log in","sign in button", log, test);
		if(!(driver.findElements(myAcc).size()>0))
		{
			ExtentLogUtilities.pass(driver, test,"Successfully logged in", log);
			WebDriverSupport.click(driver,getHome,"Log in page","Bigsmall pic", log, test);
		}
		else
		{
			ExtentLogUtilities.fail(driver, test,"logged in failed", log);
			throw new PageObjectException("Logged in failed");
		}
		}
		catch(Exception e)
		{
			throw new PageObjectException(e.getMessage());
		}
	}

}
