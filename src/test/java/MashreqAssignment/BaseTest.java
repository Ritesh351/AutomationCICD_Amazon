package MashreqAssignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MashreqAssignment.reports.ExtentReportManager;
import MashreqAssignment.utils.Screenshots;

public class BaseTest {

    public WebDriver driver;
    public Properties prop;
    public Logger log = Logger.getLogger(BaseTest.class);
    public ExtentReports extent = ExtentReportManager.getReportObject();
    public ExtentTest test;

    @BeforeClass
    public void setup() throws IOException {
        // Load config.properties
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);

    
        String browserName = prop.getProperty("browser").toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless"));

        log.info("Browser selected: " + browserName + ", Headless mode: " + isHeadless);

        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                    // I have set window size just because I was getting error in HomePageTest in the last Test, As i need navLinks till Books and i was getting only till New Releases
                  //  chromeOptions.addArguments("--window-size=1920,1080");
                }
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                // Force viewport size even in normal mode
              //  driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                }
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser name in config.properties: " + browserName);
        }

        driver.get(prop.getProperty("url"));
        log.info("Browser launched and navigated to URL: " + prop.getProperty("url"));
        
        // Set global implicit wait
        int waitTime = Integer.parseInt(prop.getProperty("waitTime"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
        log.info("Implicit wait of " + waitTime + " seconds set");
    }
    

    @BeforeMethod
    public void startTest(Method method) {
        // Initialize ExtentTest for each test method
        test = extent.createTest(method.getName());
        log.info("Starting test: " + method.getName());
        driver.get(prop.getProperty("url"));
        
    }

    @AfterMethod
    public void attachScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            log.info("Test Failed: " + result.getName());
            // Capture screenshot and attach to Extent Report
            String screenshotPath = Screenshots.captureScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                test.log(Status.FAIL, "Test Failed: " + result.getThrowable() + 
                        test.addScreenCaptureFromPath(screenshotPath));
            } else {
                test.log(Status.FAIL, "Test Failed: " + result.getThrowable() + 
                        " [Screenshot capture failed]");
                log.error("Failed to capture screenshot for test: " + result.getName());
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped");
        }
        extent.flush(); // Flush report after each test method
       
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser Closed");
        }
        extent.flush();
    }
}