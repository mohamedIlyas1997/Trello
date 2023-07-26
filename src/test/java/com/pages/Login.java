package com.pages;

public class Login extends Keywords {



	public void logintest() throws Exception {


		click(driver, login, Enum.XPATH);
		wait(driver, "1");
		sendKeys(driver, emailId, getproperty("EmailID"), Enum.ID);
		wait(driver, "1");
		click(driver, continuebtn, Enum.ID);
		wait(driver, "2");
		sendKeys(driver, password, getproperty("Password"), Enum.XPATH);
		wait(driver, "1");
		click(driver, loginbtn, Enum.XPATH);
		wait(driver, "2");
		click(driver, createboard, Enum.XPATH);
		wait(driver, "2");
		sendKeys(driver, boardtext, getproperty("Boardname"), Enum.XPATH);
		wait(driver, "2");
		click(driver, createbtn, Enum.XPATH);
		wait(driver, "1");
		sendKeys(driver, listname1, getproperty("Firstlistname"), Enum.XPATH);
		click(driver, addlist1, Enum.XPATH);
		wait(driver, "1");
		sendKeys(driver, listname2, getproperty("Secondlistname"), Enum.XPATH);
		click(driver, addlist2, Enum.XPATH);
		wait(driver, "2");
		click(driver, xbutton, Enum.XPATH);
		wait(driver, "2");
		dragAndDropWithOffset(driver);
		wait(driver, "1");
		click(driver, accountbtn, Enum.XPATH);
		click(driver, logout, Enum.XPATH);
		click(driver, logout, Enum.XPATH);
		driver.close();



	}
}
