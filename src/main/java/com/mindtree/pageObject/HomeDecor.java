package com.mindtree.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.HomeDecorUi;
import com.relevantcodes.extentreports.ExtentTest;

public class HomeDecor extends HomeDecorUi {
	WebDriver driver;
	Logger log;
	ExtentTest test;
	
	public HomeDecor(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
		}

		public void homeDec(String qunt,String item) throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, HomeDecorButton, " Home page", "Home decor button", log, test);
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
		WebDriverSupport.sendKeys(driver, quantity, "lamp page", "quantity button", log, test, qunt);
		WebDriverSupport.click(driver, cart, "lamp page", "cart button", log, test);
		Thread.sleep(3000);
		if(driver.findElement(formCart).isDisplayed())
		{
			WebDriverSupport.click(driver,close,"Cart Page","Close Button", log, test);
		}
		WebDriverSupport.click(driver,getHome,"cart page","Bigsmall pic", log, test);
		Thread.sleep(5000);
		}
}
