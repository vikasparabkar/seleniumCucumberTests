package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	
	@DataProvider(name = "browsers", parallel = true)
	public Object[][] getBrowser() {
		return new Object[][] {
			{"chrome"},
			{"firefox"},
			{"edge"}
		};
	}
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "browsers")
	public void testLogin(String browser) {
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		System.out.println("Running on: " + browser + " | Thread ID: "+ Thread.currentThread().getId());
		
		driver.quit();
	}

}
