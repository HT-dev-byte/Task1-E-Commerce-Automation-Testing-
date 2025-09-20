package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import pages.CreateAnAccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import util.BrowserFactory;
import util.ExcelReader;

/*Test Case - Automate User Registration Process

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter your email address in 'Create and account' section.
4. Click on Create an Account button.
5. Enter your Personal Information, Address and Contact info.
6. Click on Register button.
7. Validate that user is created.*/

public class UserRegistrationProcess {
	WebDriver driver;

	// 1. Open this url http://automationpractice.com/index.php
	// 2. Click on sign in link.
	// Starting browser and navigating to website
	@BeforeMethod
	public void StartBrowser() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaust\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

	        System.out.println(">>> Starting browser...");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Open the target website
	        driver.get("http://automationpractice.com/index.php");

	        System.out.println(">>> Browser started successfully");
	}

	@Test
	public void TestUserRegistrationProcess() {

		ExcelReader reader = new ExcelReader("./data/testdata.xlsx");
		String FirstName = reader.getCellData("Sheet3", "FirstName", 2);
		String LastName = reader.getCellData("Sheet3", "LastName", 2);
		String Password = reader.getCellData("Sheet3", "Password", 2);
		String day = reader.getCellData("Sheet3", "day", 2);
		String month = reader.getCellData("Sheet3", "month", 2);
		String year = reader.getCellData("Sheet3", "year", 2);
		String Company = reader.getCellData("Sheet3", "Company", 2);
		String Address = reader.getCellData("Sheet3", "Address", 2);
		String City = reader.getCellData("Sheet3", "City", 2);
		String State = reader.getCellData("Sheet3", "State", 2);
		String ZipCode = reader.getCellData("Sheet3", "ZipCode", 2);
		String Country = reader.getCellData("Sheet3", "Country", 2);
		String alias = reader.getCellData("Sheet3", "alias", 2);

		MainPage MainP = PageFactory.initElements(driver, MainPage.class);
LoginPage LoginP = PageFactory.initElements(driver, LoginPage.class);

		MyAccountPage MyAccP = PageFactory.initElements(driver, MyAccountPage.class);
	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
	    // Attempt to shut down BrowserFactory's driver if it exists — but don't let it throw
	    try {
	        try {
	            // Keep the call, but guard it — if BrowserFactory.CloseBrowser() throws NPE, we continue
	            util.BrowserFactory.CloseBrowser();
	        } catch (Throwable t) {
	            System.out.println("BrowserFactory.CloseBrowser() failed or BrowserFactory.driver was null — continuing. (" + t.getClass().getSimpleName() + ": " + t.getMessage() + ")");
	        }

	        // Quit the local driver created in this test class
	        if (driver != null) {
	            try {
	                driver.quit(); // quit is safer than close (closes session)
	                System.out.println(">>> Local driver quit successfully.");
	            } catch (Throwable t) {
	                System.out.println("Error while quitting local driver: " + t.getMessage());
	            } finally {
	                driver = null;
	            }
	        } else {
	            System.out.println(">>> Local driver was already null; nothing to quit.");
	        }
	    } catch (Throwable outer) {
	        outer.printStackTrace();
	    }
	}
}
