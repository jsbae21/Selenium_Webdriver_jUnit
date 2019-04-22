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
import static org.junit.Assert.*;
public class DragAndDrop {
	static WebDriver driver;
	WebDriverWait wait;
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/DragDropDemo.html");
	}
	
	@Test
	public void dragAnddrop() throws Exception{
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggable, droppable).perform();
		assertEquals("Dropped!", droppable.getText());
		System.out.println("Dropped Success");
		
		/*try {
			assertEquals("Dropped!", droppable.getText());
			System.out.println("Dropped Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		--------------------------------------------------------
		try
		{
			assertEquals("Dropped!", droppable.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}*/
	}
						
		@After
		public void tearDown()
		{
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
		}
}