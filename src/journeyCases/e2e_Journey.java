package journeyCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pomPages.BasicInfo;
import pomPages.LandingPage;
import pomPages.LeadForm;

public class e2e_Journey {
	private WebDriver myDriver;
	LandingPage objlandingpage;
	BasicInfo objbasicinfo;
	LeadForm objleadform;
	static Logger log = Logger.getLogger(e2e_Journey.class.getName()); 

	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		myDriver = new ChromeDriver();
		myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myDriver.get("https://csapp-uat01.cimet.io/broadband");
   		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Test
	public void fillAddress()throws Exception  {
		//Thread.sleep(2000);
		objlandingpage = new LandingPage(myDriver);
		objlandingpage.verifyText();
		objlandingpage.verifyLogo();
		objlandingpage.selectAdd();
		Thread.sleep(2000);
		objlandingpage.clickSubmit();
		log.info("Address Validates");
	}
	
	@Test(dependsOnMethods = "fillAddress")
	public void fillbasicinfo()throws Exception  {
		//Thread.sleep(10000);
		objbasicinfo = new BasicInfo(myDriver);
		objbasicinfo.verifyAddress();
		objbasicinfo.verifyTechType();
		objbasicinfo.verifyTncText();
		objbasicinfo.clickMoveNo();
		objbasicinfo.clickViewPlan();
		log.info("Basic Info page work fine");
	}
	
	@Test(dependsOnMethods = "fillbasicinfo")
	public void createLead()throws Exception  {
		//Thread.sleep(10000);
		objleadform = new LeadForm(myDriver);
		//objleadform.comparePlan();
		objleadform.lead();
		objleadform.comparePlan();
		log.info("Plan Listing page showing correct");
		log.error("Could nto go ahead");
		
	}
}
	
