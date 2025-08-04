package MashreqAssignment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MashreqAssignment.AbstractComponents.AbstractComponent;

import java.util.List;

public class AddToCartPage extends AbstractComponent {
    WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


   //I was initially getting sponsored products, so I excluded them to retrieve only the actual search results.
    @FindBy(xpath= "//div[@data-component-type='s-search-result' and not(contains(@class,'AdHolder'))]//h2")
    List<WebElement> productLinks;

    // Add to Cart Button on Product Page
    @FindBy(xpath= "//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")
    WebElement addToCartButton;

    // Cart confirmation
    @FindBy(css = "#nav-cart-count")
    WebElement cartCount;

   

    public void selectFirstProduct() {
        waitForElementToAppear(By.xpath("//div[@data-component-type='s-search-result']"));
        productLinks.get(0).click();  // Clicking on the first product
    }

    public void addToCart() {
        waitForElementToAppear(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']"));
        addToCartButton.click();
    }

    public String getCartItemCount() {
        waitForElementToAppear(By.cssSelector("#nav-cart-count"));
        return cartCount.getText();  // should return number of items in cart
    }
}
