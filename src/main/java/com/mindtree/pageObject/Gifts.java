package com.mindtree.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.GiftsUi;
import com.relevantcodes.extentreports.ExtentTest;

public class Gifts extends GiftsUi {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Gifts(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void orderGift(String type,String qunt,String item) throws ReusableComponentException, Exception
	{
		new Actions(driver).moveToElement(driver.findElement(giftsButton)).build().perform();
		List<WebElement>menu=driver.findElements(dropDown);
		for(WebElement temp:menu)
		{
			System.out.println(temp.getText());
			if(temp.getText().equalsIgnoreCase(type))
			{
				WebDriverSupport.clickByWebElement(driver, temp,"Home Page",type, log, test);
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement>listRec=driver.findElements(result);
		for(WebElement temp:listRec)
		{
			if(temp.getText().equalsIgnoreCase(item))
			{
				WebDriverSupport.clickByWebElement(driver, temp,"result page",item, log, test);
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(quantity).clear();
		WebDriverSupport.sendKeys(driver, quantity, "socks page", "quantity button ", log, test,qunt);
		WebDriverSupport.click(driver, cart, "socks page", "cart button", log, test);
		Thread.sleep(3000);
		if(driver.findElement(formCart).isDisplayed())
		{
			WebDriverSupport.click(driver,close,"Cart Page","Close Button", log, test);
		}
		WebDriverSupport.click(driver,getHome,"cart page","Bigsmall pic", log, test);
		Thread.sleep(5000);
	}
}
