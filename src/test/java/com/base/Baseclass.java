package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass implements OR {

	public static WebDriver driver;
	public static Properties pro;

	@BeforeSuite
	public void setup() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions Options=new ChromeOptions();
	//	Options.addArguments("---headless");
	//	Options.addArguments("window-size=1366,786");
		Options.addArguments("start-maximized");
		Options.addArguments("disable-notifications");
		Options.addArguments("disable-geolocation");
		Options.addArguments("disable-camera");
		Options.addArguments("disable-popup-blocking");
		Options.addArguments("use-fake-device-for-media-stream");
		Options.addArguments("use-fake-ui-for-media-stream");
		Options.addArguments("--disable-web-security");
		Options.addArguments("--no-proxy-server");
		Options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		Options.addArguments("--remote-allow-origins=*");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
	//	prefs.put("download.default_directory",  System.getProperty("user.dir") + "\\DownloadedFiles");
	//	prefs.put("credentials_enable_service", false);
	//	prefs.put("profile.password_manager_enabled", false);

		Options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(Options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(getproperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


	}

	//	@AfterSuite
	//	public void teardown() {
	//		driver.quit();
	//	}

	public static String TimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	}

	public static Properties readconfig() {

		try {
			pro= new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "/Configuration/Config.properties");
			pro.load(fis);
		} catch
		(FileNotFoundException e) 
		{
			e.printStackTrace(); 
		}catch (IOException e) {
			e.printStackTrace();
		} return pro;
	}

	public static String getproperty(String Data) {
		readconfig();
		String data=pro.getProperty(Data);
		return data;
	}

	public static String TakeScreenshot(WebDriver driver) throws IOException {

		File source =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + TimeStamp() + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}


}
