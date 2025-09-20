package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;


public class LoginPage extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}
	

	
	//Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement Email_Address_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement Password_Field;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement SignIn_Button;
	
	//InteractiveMethods
	public void EnterEmailAddress(String email) {

	    List<WebElement> emailFields = driver.findElements(By.xpath("//input[@id='email_create']"));
	    

	    WebElement emailInput = emailFields.get(0);
	    emailInput.sendKeys(email);
	}

	
		public void Enter_Password(String password) {
	        try {
	            // Wait for the password input to be visible and clickable
	            WebElement passwordInput = wait.until(
	                ExpectedConditions.elementToBeClickable(By.id("passwd"))
	            );

	            // Scroll into view (in case something is overlaying it)
	            ((org.openqa.selenium.JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView(true);", passwordInput);

	            // Clear any pre-filled text and enter password
	            passwordInput.clear();
	            passwordInput.sendKeys(password);

	            System.out.println("Password entered successfully.");

	        } catch (org.openqa.selenium.TimeoutException e) {
	            throw new RuntimeException(
	            );
	        }
	    }
	
	
	public void Click_Signin_Button() {
		SignIn_Button.click();
	}
	
	
		
	}
