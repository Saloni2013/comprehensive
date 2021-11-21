package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.CorporateGiftsUi;
import com.relevantcodes.extentreports.ExtentTest;

public class CorporateGifts extends CorporateGiftsUi{


	WebDriver driver;
	Logger log;
	ExtentTest test;

	public CorporateGifts(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void fillDetails(String name,String Gmail,String phno) throws ReusableComponentException, Exception
	{
		try
		{
			WebDriverSupport.click(driver, corporateButton,"Home Page","Corporate Button", log, test);
			Thread.sleep(2000);
			WebDriverSupport.sendKeys(driver, fname, name, Gmail, log, test, name);
			WebDriverSupport.sendKeys(driver,email, name, Gmail, log, test, Gmail);
			WebDriverSupport.sendKeys(driver,phn, name, Gmail, log, test, phno);
			WebDriverSupport.click(driver, submit,"Corporate Page","Submit Button", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver,getHome,"cart page","Bigsmall pic", log, test);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			throw new PageObjectException(e.getMessage());
		}
	}


}
