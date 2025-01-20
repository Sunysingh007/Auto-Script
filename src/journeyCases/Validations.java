package journeyCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pomPages.LandingPage;

public class Validations {
	private WebDriver myDriver;
	LandingPage objlandingpage;
	static Logger log = Logger.getLogger(Validations.class.getName()); 
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		myDriver = new ChromeDriver();
		myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myDriver.manage().window().maximize();
		myDriver.get("https://csapp-uat01.cimet.io/broadband");
   		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Test
	public void validateAddress()throws Exception  {
		objlandingpage = new LandingPage(myDriver);
		objlandingpage.verifyValidation();
		objlandingpage.selectAdd();
		Thread.sleep(2000);
		objlandingpage.clickSubmit();
		log.info("Address Validates");
		log.error("Could not get forward");
	}
	
	
}

