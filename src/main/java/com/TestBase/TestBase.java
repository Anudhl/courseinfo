package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.TestUtil.TestUtil;

public class TestBase {

public static 	Properties prop;

public static  WebDriver driver;

public static final Logger logger = Logger.getLogger(TestBase.class.getName());

public TestBase() {	
	
 prop = new Properties();	
	
try {
	FileInputStream fle = new FileInputStream("//Users//ashishpaudyal//eclipse-workspace//tffolder//dell.qa//src//main//java//com//Config//Config.properties");	
		
		prop.load(fle);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}	


public static void initil() {
	
	String browser = prop.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome")) {

System.setProperty("webdriver.chrome.driver" ,"seleone//chromedriver" );
	
driver = new ChromeDriver();
	
}
	
else if(browser.equalsIgnoreCase("FF")) {
	
System.setProperty("webdriver.gecko.driver" ,"seleone//geckodriver" );
	
driver = new FirefoxDriver();
	
}	
	
driver.manage().window().maximize();	
	
driver.manage().deleteAllCookies();	
	
driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADTIMEOUT, TimeUnit.SECONDS)	;

driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);

driver.get(prop.getProperty("url"));

}

@BeforeTest

public void log() {
	
	String log4jConfPath = System.getProperty("user.dir")+"//src//main//java//log4j.properties";
	PropertyConfigurator.configure(log4jConfPath);
	
	
}







}










