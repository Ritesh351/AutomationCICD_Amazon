package MashreqAssignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import MashreqAssignment.pageobjects.HomePage;

public class HomePageTest03 extends BaseTest {

    @Test(description = "Verify clicking Amazon logo navigates to home")
    public void testAmazonLogoNavigation() {
    	log.info("************* HOMEPAGE FUNCTIONALITY TEST STARTED *************");
        test.log(Status.INFO, "Starting test: Click Amazon Logo and verify navigation");
        
        HomePage homePage = new HomePage(driver);
        homePage.handleOptionalContinueButton();
        test.log(Status.INFO, "Handled optional continue button if present");
        
        homePage.ClickAmazonLogo();
        test.log(Status.INFO, "Clicked on Amazon Logo");

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("amazon.in"), "Did not navigate to Amazon home");
        test.log(Status.PASS, "Navigated to Amazon home page successfully");
    }

    @Test(description = "Verify clicking Next Slide")
    public void testClickNextSlide() {
        test.log(Status.INFO, "Starting test: Click Next Slide on home page");
        
        HomePage homePage = new HomePage(driver);
        homePage.clickNextSlide();
        
        test.log(Status.PASS, "Clicked Next Slide successfully");
    }

    @Test(description = "Verify selecting Books category from dropdown")
    public void testSelectBooksFromDropdown() {
        test.log(Status.INFO, "Starting test: Select 'Books' from search dropdown");

        HomePage homePage = new HomePage(driver);
        homePage.clickSearchInDropdown();
        test.log(Status.INFO, "Clicked search dropdown");

        homePage.selectBooksCategory();
        test.log(Status.PASS, "Books category selected successfully");
    }

    @Test(description = "Verify Return Orders click navigates correctly")
    public void testReturnOrdersClick() {
        test.log(Status.INFO, "Starting test: Click 'Returns & Orders' link");

        HomePage homePage = new HomePage(driver);
        homePage.clickreturnorder();
        test.log(Status.INFO, "Clicked 'Returns & Orders'");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("return_to"), "Did not navigate to Return Page");
        test.log(Status.PASS, "Navigated to Return Page successfully");
    }

    @Test(description = "Verify NavBar links are visible")
    public void testNavBarLinksVisible() throws InterruptedException {
        test.log(Status.INFO, "Starting test: Verify NavBar links visibility");

        HomePage homePage = new HomePage(driver);
        List<WebElement> navLinks = homePage.getNavBarLinks();
        test.log(Status.INFO, "Found " + navLinks.size() + " NavBar links");
        System.out.println("Test");

        Assert.assertTrue(navLinks.size() > 0, "No nav bar links found");

        for (WebElement link : navLinks) {
            String text = link.getText();
            System.out.println(text);
            Assert.assertTrue(link.isDisplayed(), "Link not displayed: " + text);
            test.log(Status.INFO, "Verified link displayed: " + text);
        }
        test.log(Status.PASS, "All NavBar links are visible");
    }
}
