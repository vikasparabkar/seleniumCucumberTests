package TestPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.apache.commons.io.FileUtils;


public class test {

	@DataProvider(name="LoginData")
	public Object[][] getData() {
		return new Object[][] {
			{"user1", "pwd1"},
			{"user2", "pwd2"}
		};
	}
	
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("UrlforBrowsing");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Code for Explicit Wait
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement userId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath for userId")));
		userId.sendKeys("testUser");
		
		WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		pwd.sendKeys("testUserPwd");
		
		
		// Code For Window Handle
		String currentWindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> list = new ArrayList<>(windows);
		
		for(String window: windows) {
			if(!window.equals(currentWindow)) {
				driver.switchTo().window(window);
			}
		}
		driver.switchTo().defaultContent();
		
		//code to switch to second last window
		
		int secondLastIndex = list.size()-2;
		String secondLastWindow = list.get(secondLastIndex);
		
		driver.switchTo().window(secondLastWindow);
		
		// Read username and password in config.properties file
		Properties prop = new Properties();		
		FileInputStream fis = new FileInputStream("src/main/resourses/config.properties");
		prop.load(fis);
		String userName = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("screenshot.png"));
	}
	
}

