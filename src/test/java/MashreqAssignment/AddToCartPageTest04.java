package MashreqAssignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import MashreqAssignment.pageobjects.AddToCartPage;
import MashreqAssignment.pageobjects.SearchResultsPage;

public class AddToCartPageTest04 extends BaseTest {

    @Test
    public void testAddProductToCart() throws InterruptedException {
        log.info("************* ADD TO CART FUNCTIONALITY TEST STARTED *************");
        
        SearchResultsPage home = new SearchResultsPage (driver);
        home.handleOptionalContinueButton();
        home.clickOnSearch();
        home.inputText("Laptop");       
        home.clickOnIcon();
	    

        AddToCartPage cartPage = new AddToCartPage(driver);

        cartPage.selectFirstProduct();
        test.log(Status.INFO, "Clicked on the first product from search results");

        // Switch to the new product window tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        cartPage.addToCart();
        test.log(Status.INFO, "Clicked on Add to Cart button");

        String itemCount = cartPage.getCartItemCount();
        System.out.println("Cart Item Count: " + itemCount);

        Assert.assertTrue(Integer.parseInt(itemCount) > 0, "Cart item count is zero after adding product.");
        test.log(Status.PASS, "Product successfully added to cart");
        System.out.println("Test 6 Pass: Product added to cart successfully");
    }
}
