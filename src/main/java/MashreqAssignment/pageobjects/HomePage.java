package MashreqAssignment.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MashreqAssignment.AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement AmazonLogo;
	
	@FindBy(xpath="//a[@class='a-carousel-goto-nextpage']")
	 WebElement NextSlide;
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	  WebElement SearchInDropdown;

	 @FindBy(xpath="//select[@id='searchDropdownBox']")
	  WebElement ChooseBooks;
	 
	 @FindBy(xpath="//a[@id='nav-orders']")
	  WebElement Returnorder;
	 
	// @FindBy(css = "#nav-xshop a")
	// @FindBy(xpath = "//div[@id='nav-xshop-container']//a")
	 @FindBy(xpath="//li[@class='nav-li']") 
	 List<WebElement> navBarLinks;
	
		
	 

	 
	public void ClickAmazonLogo() {
		AmazonLogo.click();
	}

	
	
	public void clickNextSlide() {
		NextSlide.click();
	}
	
	public void clickSearchInDropdown() {
		SearchInDropdown.click();
	}
	
	public void selectBooksCategory() {
	    Select select = new Select(SearchInDropdown);
	    select.selectByVisibleText("Books"); 
	}

	
	public void clickreturnorder() {
		waitForElementToAppear(By.id("nav-orders"));
		Returnorder.click();
	}
	
	  // Get list of visible navbar texts
    public List<WebElement> getNavBarLinks() {
        return navBarLinks;
    }
	
	

	
}
