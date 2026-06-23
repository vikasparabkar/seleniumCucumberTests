package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import featureFilePOMClasses.OrangeHRM_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DriverFactory;



public class OrangeHRMStepDefination {
	//WebDriver driver;
	OrangeHRM_POM hrm;
	
	
	@Given("Navigate to Orange HRM url")
	public void navigate_to_orange_hrm_url() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "D:\\ExeFiles\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.manage().window().maximize();
//	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	    System.out.println("Orange HRM page URL = "+ driver.getCurrentUrl());
		
//		Hooks.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		hrm = new OrangeHRM_POM(Hooks.driver);
		
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		hrm = new OrangeHRM_POM(DriverFactory.getDriver());
		
	    Thread.sleep(3000);
	}

	@When("Login into OrangeHRM application")
	public void login_into_orange_hrm_application() {
//	    WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
//	    WebElement pwdField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
//	    WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
//	    
//	    userName.sendKeys("Admin");
//	    pwdField.sendKeys("admin123");
//	    loginButton.click();
		
		//hrm = new OrangeHRM_POM(driver);
		hrm.enterLoginDetails("Admin", "admin123");
	}

	@Then("Validate homepage url")
	public void validate_homepage_url() {
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", DriverFactory.getDriver().getCurrentUrl());
		System.out.println("HomePage url is verified");
		
	}
	
	
	@Given("Navigate to Orange HRM url {string}")
	public void navigate_to_orange_hrm_url(String url) throws InterruptedException {
//	    Hooks.driver.get(url);
//	    hrm = new OrangeHRM_POM(Hooks.driver);
//	    Thread.sleep(3000);
		
		DriverFactory.getDriver().get(url);
		hrm = new OrangeHRM_POM(DriverFactory.getDriver());
		Thread.sleep(30);
	}

	@When("Login into OrangeHRM application with {string} and {string}")
	public void login_into_orange_hrm_application_with_and(String userName, String pwd) {
	    hrm.enterLoginDetails(userName, pwd);
	}

	@Then("Validate homepage url {string}")
	public void validate_homepage_url(String homePageUrl) {
	    hrm.validateHomePageUrl(homePageUrl);
	}

}
