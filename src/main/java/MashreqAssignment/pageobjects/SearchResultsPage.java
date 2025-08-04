package MashreqAssignment.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MashreqAssignment.AbstractComponents.AbstractComponent;

public class SearchResultsPage extends AbstractComponent {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement clickOnSearchBar;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement inputText;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement clickOnSearchIcon;

    @FindBy(xpath = "//div[@data-component-type='s-search-result' and not(contains(@class,'AdHolder'))]//h2")
    List<WebElement> productTitles;
    
    ////h2/span[text()='No results for ']
    @FindBy(xpath="//h2/span[text()='No results for ']")
    WebElement ResultNotFound;

    public void clickOnSearch() {
        clickOnSearchBar.click();
    }

    public void inputText(String productName) {
        waitForElementToAppear(By.id("twotabsearchtextbox"));
        inputText.clear();
        inputText.sendKeys(productName);
    }

    public void clickOnIcon() {
        clickOnSearchIcon.click();
    }

 
    public void searchProduct(String productName) {
        clickOnSearch();
        inputText(productName);
        clickOnIcon();
    }

    public int getSearchResultCount() {
        return productTitles.size();
    }

    public void validateSearchResults(String keyword) {
        if (!productTitles.isEmpty()) {
            System.out.println("Search results for '" + keyword + "' are present. Total items: " + productTitles.size());
        } else {
            System.out.println("No search results found for '" + keyword + "'.");
        }
    }

    public boolean isNoResultsMessageDisplayed() {
        return true; // Intentionally I returned true for getting failed scenarios.
    }


}
