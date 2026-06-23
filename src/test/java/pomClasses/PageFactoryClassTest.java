package pomClasses;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class PageFactoryClassTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    private PageFactoryClass pageFactoryClass;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.openMocks(this);
        pageFactoryClass = new PageFactoryClass(driver);
        pageFactoryClass.element = element;
    }

    @Test
    public void testMethod_clicksElement() {
        pageFactoryClass.testMethod();
        verify(element).click();
    }
}
