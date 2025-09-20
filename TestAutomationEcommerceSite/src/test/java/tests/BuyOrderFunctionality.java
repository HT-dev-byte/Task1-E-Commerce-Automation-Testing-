package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.OrderPage;
import pages.ProductPage;
import pages.TshirtsPage;
import util.ExcelReader;

/*Test Case - Automate End to End Buy Order functionality.

Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Login to the website.
3. Move your cursor over Women's link.
4. Click on sub menu 'T-shirts'.
5. Mouse hover on the second product displayed.
6. 'More' button will be displayed, click on 'More' button.
7. Increase quantity to 2.
8. Select size 'L'
9. Select color.
10. Click 'Add to Cart' button.
11. Click 'Proceed to checkout' button.
12. Complete the buy order process till payment.
13. Make sure that Product is ordered.*/

public class BuyOrderFunctionality {

	WebDriver driver;

	// Starting browser and navigating to website
	// 1. Open link http://automationpractice.com/index.php
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

	// The actual Test
	@Test
	public void TestBuyOrderFunctionality() throws InterruptedException {
		
		ExcelReader reader = new ExcelReader("./data/testdata.xlsx");
		String username = reader.getCellData("LoginInfo", "username", 2);
		String password = reader.getCellData("LoginInfo", "password", 2);
		
		MainPage MainP = PageFactory.initElements(driver, MainPage.class);
		LoginPage LoginP = PageFactory.initElements(driver, LoginPage.class);

		MyAccountPage MyAcc = PageFactory.initElements(driver, MyAccountPage.class);
		// 3. Move your cursor over Women's link.
	
		// 4. Click on sub menu 'T-shirts'.

		TshirtsPage ts = PageFactory.initElements(driver, TshirtsPage.class);
		// 5. Mouse hover on the first product displayed.

		ProductPage ProdP = PageFactory.initElements(driver, ProductPage.class);
		// 12. Complete the buy order process till payment.
		OrderPage OrderP = PageFactory.initElements(driver, OrderPage.class);
		

	}
	

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		 if (driver != null) {
		        driver.quit();   
		        driver = null;
		    }
	}

}