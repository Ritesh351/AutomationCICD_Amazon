package MashreqAssignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup(); // As I have added the dependency of WebDriverManager , so chromedriver will be automatically downloaded into my system based upon my chrome browser version.
		
		WebDriver driver = new ChromeDriver(); //Here I am creating object for ChromeDriver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//SignIn
		driver.findElement(By.xpath("//div[@id='nav-link-accountList']")).click();
		driver.findElement(By.cssSelector("input[id='ap_email_login']")).sendKeys("test123@gmail.com");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.cssSelector("input[id='ap_password']")).sendKeys("Password123@");
		
		//Again back to HomePage
		driver.get("https://www.amazon.in/");
		
		//SearchResultPage
		////input[@id='twotabsearchtextbox']
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptop");
		////input[@id='nav-search-submit-button']
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		List<WebElement> results = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2[contains(@aria-label, 'Laptop')]"));
		// Validate presence of results
        if (!results.isEmpty()) {
            System.out.println("Search results for 'laptop' are present. Total items: " + results.size());
        } else {
            System.out.println("No search results found for 'laptop'.");
        }
		
		driver.close();
		
		
		
		
		
	}

}
