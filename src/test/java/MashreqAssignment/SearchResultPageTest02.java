package MashreqAssignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import MashreqAssignment.pageobjects.SearchResultsPage;

public class SearchResultPageTest02 extends BaseTest {

    @Test(description = "Verify search results are displayed for given product")
    public void verifySearchResultsDisplayed() {
    	log.info("************* SEARCH FUNCTIONALITY TEST STARTED *************");
    	
        test.log(Status.INFO, "Starting test: Verify search results are displayed");

        SearchResultsPage searchPage = new SearchResultsPage(driver);
        searchPage.handleOptionalContinueButton();
        test.log(Status.INFO, "Handled optional continue button if present");

        searchPage.clickOnSearch();
        test.log(Status.INFO, "Clicked on search bar");

        String productName = prop.getProperty("productName");
        searchPage.inputText(productName);
        test.log(Status.INFO, "Entered product name: " + productName);

        searchPage.clickOnIcon();
        test.log(Status.INFO, "Clicked search icon");

        int count = searchPage.getSearchResultCount();
        test.log(Status.INFO, "Total results found: " + count);

        searchPage.validateSearchResults(productName);
        test.log(Status.INFO, "Validated search results visibility");

        Assert.assertTrue(count > 0, "No search results found!");
        test.log(Status.PASS, "Search results are displayed successfully");
    }
    
    @Test(description = "Search for invalid product and expect results (Expected to fail)")
    public void searchInvalidProduct_shouldReturnResults() {
        log.info("************* INVALID PRODUCT SEARCH TEST STARTED *************");

        test.log(Status.INFO, "Starting test: Search with gibberish keyword");

        SearchResultsPage searchPage = new SearchResultsPage(driver);
        searchPage.handleOptionalContinueButton();

        test.log(Status.INFO, "Handled optional continue button if present");
        searchPage.clickOnSearch();

        String invalidProduct = "asdfaslkdfjaslkdfjasdf";  // Gibberish text
        searchPage.inputText(invalidProduct);
        test.log(Status.INFO, "Entered invalid product name: " + invalidProduct);

        searchPage.clickOnIcon();
        test.log(Status.INFO, "Clicked search icon");

        //a.jfndkdjf
        boolean isNoResultDisplayed = searchPage.isNoResultsMessageDisplayed();
        test.log(Status.INFO, "No results message visible: " + isNoResultDisplayed);

        // This will intentionally fail because the system is not supposed to show results
        Assert.assertFalse(isNoResultDisplayed, "Intentional Failure: Search returned no results when we expected results.");

    }

}
