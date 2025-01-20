package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadForm {
	WebDriver driver;
	
    @FindBy(name="name")
    WebElement name;
    @FindBy(name="email")
    WebElement email;
    @FindBy(name="phone")
    WebElement phone;
    @FindBy(xpath="//button[contains(text(),'Compare Now')]")
    WebElement compare;

    
    public LeadForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);           //This initElements method will create all WebElements
    }
    
    public void lead() {
    	name.sendKeys("Aj Singh test");
    	email.sendKeys("ajay.singh@cimet.com.au");
    	phone.sendKeys("0420580919");
    }
    
    public void comparePlan() {
    	compare.click();
    }
    
}
