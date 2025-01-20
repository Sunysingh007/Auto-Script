package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicInfo {
	WebDriver driver;
	    
    @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/p[2]")
    WebElement address;
    @FindBy(xpath="//p[contains(text(),'Your address is eligible for NBN FTTP services! Ad')]")
    WebElement techinfo;
    @FindBy(xpath="//span[contains(text(),'No')]")
    WebElement moveno;
    @FindBy(name="termConditionAgree")
    WebElement tncchkbox;
    @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[5]/label[1]/span[1]/p[1]")
    WebElement tnctext;
    @FindBy(xpath="//button[contains(text(),'View Plans')]")
    WebElement viewplan;
    
    public BasicInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);           //This initElements method will create all WebElements
    }
    
    public void verifyAddress(){
    	String expectedText = "20 Nevada Rd, PARK RIDGE QLD, 4125";
    	String actualText = address.getText();

    	if (actualText.equals(expectedText)) {
    	    System.out.println("Address matches: " + actualText);
    	} else {
    	    System.out.println("Address does not match. Actual text: " + actualText);
    	}
    }
    
    public void verifyTechType(){
    	String expectedText = "Your address is eligible for NBN FTTP services! Additional NBN™ New Development Charge may be applicable";
    	String actualText = techinfo.getText();

    	if (actualText.equals(expectedText)) {
    	    System.out.println("Tech Info matches: " + actualText);
    	} else {
    	    System.out.println("Tech Info does not match. Actual text: " + actualText);
    	}
    }
    
    public void verifyTncText(){
    	String expectedText = "I have read, understood and accept CIMET's Terms and Conditions and Privacy Policy";
    	String actualText = tnctext.getText();

    	if (actualText.contains(expectedText)) {
    	    System.out.println("TnC matches: " + actualText);
    	} else {
    	    System.out.println("TnC does not match. Actual text: " + actualText);
    	}
    	tncchkbox.click();
    }
    
    public void clickMoveNo(){
    	moveno.click();
    }
    
    public void clickViewPlan(){
    	viewplan.click();
    }

}
