package MashreqAssignment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MashreqAssignment.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	 WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//PageFactory
	
	@FindBy(xpath="//div[@id='nav-link-accountList']")
	WebElement SignInOption;
	
	@FindBy(xpath="//input[@id='ap_email_login']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement userPassword;
	
	
public void clickSignInOption() {
	SignInOption.click();
}

public void sendMaildId(String email) {
	userEmail.sendKeys(email);
}

public void clickContinue() {
	submitButton.click();
	
}

public void sendPassword(String password) {
	waitForElementToAppear(By.id("ap_password"));
	userPassword.sendKeys(password);
}


	

}
