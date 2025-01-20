package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
    @FindBy(xpath="//input[@placeholder='Type in your address: 333 George st']")
    WebElement input;
    @FindBy(css=".sc-6d362b9d-6.fHKKLZ")
    WebElement add;
    @FindBy(tagName="button")
    WebElement btn;
    @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
    WebElement abvText;
    @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
    WebElement logo;
    @FindBy(xpath="(//div[@class='sc-77d6bfcb-0 gQAbFf'])[1]")
    WebElement validation;
    
    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);           //This initElements method will create all WebElements
    }
    
    public void verifyText(){   
    	String expectedText = "If you’re a savvy bargain hunter like us, you’ll l";
    	String actualText = abvText.getText();

    	if (actualText.contains(expectedText)) {
    	    System.out.println("Text matches: " + actualText);
    	} else {
    	    System.out.println("Text does not match. Actual text: " + actualText);
    	}
    }
    
    public void verifyLogo(){   
    	if (logo.isDisplayed()) {
    	    System.out.println("The logo is visible.");
    	} else {
    	    System.out.println("The logo is not visible.");
    	}
    }
    
    public void selectAdd() throws InterruptedException{
    	input.sendKeys("20 Nevada rd");
    	Thread.sleep(2000);
    	add.click();
    }
    
    public void clickSubmit(){   
    	btn.click();
    }
    
    public void verifyValidation() {
    	clickSubmit();
    	String expectedText = "Please enter your correct postcode or suburb";
    	String actualText = validation.getText();
    	
    	if (actualText.equals(expectedText)) {
    	    System.out.println("Text matches: " + actualText);
    	} else {
    	    System.out.println("Text does not match. Actual text: " + actualText);
    	}
    }
}

