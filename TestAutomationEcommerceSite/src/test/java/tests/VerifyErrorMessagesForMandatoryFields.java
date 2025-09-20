package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import pages.CreateAnAccountPage;
import pages.LoginPage;
import pages.MainPage;
import util.BrowserFactory;

/*Test Case - Verify error messages for mandatory fields.

Steps to Automate:
1. Open url
2. Click on sign in link.
3. Enter email address and click Register button.
4. Leave the mandatory fields (marked with *) blank and click Register button.
5. Verify that error has been displayed for the mandatory fields.*/

public class VerifyErrorMessagesForMandatoryFields {

	WebDriver driver;

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
	public void TestVerifyErrorMessagesForMandatoryFields() {
		MainPage mainp = PageFactory.initElements(driver, MainPage.class);
		

		LoginPage loginp = PageFactory.initElements(driver, LoginPage.class);

		CreateAnAccountPage createaccp = PageFactory.initElements(driver, CreateAnAccountPage.class);

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

