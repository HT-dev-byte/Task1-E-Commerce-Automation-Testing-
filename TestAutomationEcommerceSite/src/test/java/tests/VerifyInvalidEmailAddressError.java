package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import util.BrowserFactory;

/*Test Case - Verify invalid email address error.

Steps to Automate:
1. Open url
2. Click on sign in link.
3. Enter invalid email address in the email box and click enter.
4. Validate that an error message is displaying saying "Invalid email address."*/

public class VerifyInvalidEmailAddressError {

	WebDriver driver;

	// Starting browser and navigating to website
	// 1. Open link
	@BeforeClass
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
	public void TestVerifyInvalidEmailAddressError() {
		MainPage mainp = PageFactory.initElements(driver, MainPage.class);
		// 2. Click on sign in link.

		LoginPage loginp = PageFactory.initElements(driver, LoginPage.class);
		// 3. Enter invalid email address in the email box and click enter.
	}

	// Closing browser
	@AfterClass
	public void CloseBrowser() {
		 if (driver != null) {
		        driver.quit();   
		        driver = null;
		    }
	}

}
