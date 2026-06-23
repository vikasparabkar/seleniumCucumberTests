package featureFilePOMClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrangeHRM_POM {
	
	WebDriver driver;
	
	// Locators
	@FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameField;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;
		
	// Constructor
	public OrangeHRM_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public void enterLoginDetails(String username, String pwd) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(pwd);
		loginButton.click();
	}
	
	public void validateHomePageUrl(String url) {
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}

}
