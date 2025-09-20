package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;
import pages.MainPage;
import util.BrowserFactory;

/*Test Case - Automate first Menu link and print page title

Steps to Automate:
1. Launch browser
2. Open URL
3. Maximize or set size of browser window.
4. Get the page title and print it.
5. Now, click on first menu link say "Contact us"
6. Get the page title and print it.
7. Navigate back to Home Page.
8. Get the page title and print it. Verify that value matches with output of point no. 4
9. Close the browser.*/

public class ClickFirstMenuLinkAndPrintPageTitle {
	WebDriver driver;

	/*
	 * 1. Launch browser 2. Open URL 3. Maximize or set size of browser window.
	 */
	//Starting Browser
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

	//the actual test
	@Test
	public void ClickFirstMenuLinkAndPrintPageTitleTest() {

		MainPage MainP = PageFactory.initElements(driver, MainPage.class);
		// 4. Get the page title and print it.
		String MainPageTitle = MainP.GetPageTitle();
		System.out.println(MainPageTitle);

		// 5. Now, click on first menu link say "Contact us"
		// 6. Get the page title and print it.

		// 8. Get the page title and print it. Verify that value matches with output of
		// point no. 4
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase(MainPageTitle)) {
			System.out.println("Success! The page title we got matches the Main Page title");
		} else {
			System.out.println("Failure, The page title we got does not matche the Main Page title ");

		}
	}

	// 9. Close the browser.
	// Closing browser
	@AfterClass
	public void CloseBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}

	}


