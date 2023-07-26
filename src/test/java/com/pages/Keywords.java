package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.base.Baseclass;
import com.utilities.TestListeners;


public class Keywords extends TestListeners{

	public int WaitElementSeconds = 30;
	public int ElementWait = 30;

	public String[] splitXpath(String path) {
		String[] a = path.split(">");
		return a;
	}

	public void wait(WebDriver driver, String inputData) {
		try {
			int time = Integer.parseInt(inputData);
			int seconds = time * 1000;
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			Reporter.log("Unable to wait ", false );
		}
	}


	public void click(WebDriver driver , String xpath, Enum locator) throws Exception {
		String[] values= splitXpath(xpath);
		WebElement elem=null;
		try {

			switch (locator) {
			case ID:
				elem = driver.findElement(By.id(values[1]));
				break;
			case NAME:
				elem = driver.findElement(By.name(values[1]));
				break;
			case CLASSNAME:
				elem = driver.findElement(By.className(values[1]));
				break;
			case XPATH:
				elem = driver.findElement(By.xpath(values[1]));
				break;
			default:
				break;
			}
			elem.click();
			extentTest.get().log(Status.PASS, "clicked on " + values[0]);
			Reporter.log("Clicked on"  + values[0], true);
		}
		catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			extentTest.get().log(Status.FAIL, "Not clicked on "+ values[0], MediaEntityBuilder.
					createScreenCaptureFromPath(TakeScreenshot(Baseclass.driver)).build());
			Assert.fail();
			Reporter.log("Not Clicked on"  + values[0], false);
		}
	}


	public String sendKeys(WebDriver driver, String xpaths, String keysToSend, Enum locator) throws Exception {
		String[] values = splitXpath(xpaths);
		WebElement elem=null;
		try {		
			switch (locator) {
			case ID:
				elem = driver.findElement(By.id(values[1]));
				break;
			case NAME:
				elem = driver.findElement(By.name(values[1]));
				break;
			case CLASSNAME:
				elem = driver.findElement(By.className(values[1]));
				break;
			case XPATH:
				elem = driver.findElement(By.xpath(values[1]));
				break;
			default:
				break;
			}
			
			elem.sendKeys(keysToSend);
			extentTest.get().log(Status.PASS, "Entered " + values[0]);
			Reporter.log("Type On" + values[0], true);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			extentTest.get().log(Status.PASS, "Not Typed on " + values[0], MediaEntityBuilder.
					createScreenCaptureFromPath(TakeScreenshot(Baseclass.driver)).build());
			Reporter.log("[INFO] Not Type On" + values[0], true);
		}
		return keysToSend;
	}
	
	
	public void dragAndDropWithOffset(WebDriver driver) throws Exception {
			
		List<WebElement> elem= driver.findElements(By.xpath("//div[@class='list js-list-content']"));
		WebElement from= elem.get(0);
		WebElement to= elem.get(1);

		Point xvalue=	from.getLocation();
		int xpos= xvalue.getX();
		int ypos= xvalue.getY();

		try {
			Actions act= new Actions(driver);
			System.out.println("Before moving x is: " + xpos+ "Y pos is : " + ypos);
			act.dragAndDropBy(from, xpos, ypos).release(to).build().perform();
			System.out.println("After moving x is: " + xpos+ "Y pos is : " + ypos);
			Reporter.log("Element moved from A TO B psotion", true);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		}

	
	}


