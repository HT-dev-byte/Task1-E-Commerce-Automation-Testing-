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
import pages.MainPage;
import pages.TshirtsPage;
import util.BrowserFactory;

/*Test Case - Verify that 'Add to Wishlist' only works after login.
Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Move your cursor over Women's link.
3. Click on sub menu 'T-shirts'.
4. Mouse hover on the second product displayed.
5. 'Add to Wishlist' will appear on the bottom of that product, click on it.
6. Verify that error message is displayed 'You must be logged in to manage your wishlist.'*/

public class WishListWorksAfterLogin {
	WebDriver driver;

	//1. Open link http://automationpractice.com/index.php
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
	public void TestWishListWorksAfterLogin() throws InterruptedException {

		MainPage MainP = PageFactory.initElements(driver, MainPage.class);
		Thread.sleep(3000);
	}

	@AfterClass
	public void CloseBrowser() {
		 if (driver != null) {
		        driver.quit();   
		        driver = null;
		    }
	}
	}

