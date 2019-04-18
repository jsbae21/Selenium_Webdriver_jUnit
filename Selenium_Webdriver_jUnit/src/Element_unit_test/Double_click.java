package Element_unit_test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Double_click {
	static WebDriver driver;
	WebDriverWait wait;
	
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		System.out.println("Before success");
	}
	
	@Test
	public void doubleclicky() throws Exception{
		WebElement message = driver.findElement(By.id("message"));
		
		//Verify color is blue
		assertEquals("rgba(0, 0, 255, 1)",message.getCssValue("background-color"));
		System.out.println("Verify color is blue");
		
		Actions builder = new Actions(driver);
		builder.doubleClick(message).build().perform();
		
		//Verify color is yellow
		assertEquals("rgba(255, 255, 0, 1)",message.getCssValue("background-color"));
		System.out.println("Verify color is yellow");
	}

	@After
	public void tearDown()
	{
		driver.close();
	}
}