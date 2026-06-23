package TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "D:\\ExeFiles\\chromedriver.exe");	//This is now deprecated and we can use WebDriverManager
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
		
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Test Data");
		
		//JavascriptExecutor and its methods
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("")));
		js.executeScript("arguments[0].value='Vikas';", driver.findElement(By.xpath("")));
		
		driver.close();
		
		
	}

}
