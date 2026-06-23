package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryClass {
	WebDriver driver;
	
	@FindBy(xpath = "")
	WebElement element;
	
	@FindBy(xpath = "")
	WebElement element1;
	
	public PageFactoryClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void testMethod() {
		element.click();
		System.out.println("Element clicked.");
	}

}
