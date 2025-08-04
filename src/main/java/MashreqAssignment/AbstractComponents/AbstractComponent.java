package MashreqAssignment.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	// Locator for Continue Button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueButton;

	// Method to handle it
	public void handleOptionalContinueButton() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        wait.until(ExpectedConditions.visibilityOf(continueButton));
	        continueButton.click();
	        System.out.println("Clicked on Continue button.");
	    } catch (Exception e) {
	        System.out.println("Continue button not displayed. Continuing without click.");
	    }
	}
	

	//Wait
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

}
