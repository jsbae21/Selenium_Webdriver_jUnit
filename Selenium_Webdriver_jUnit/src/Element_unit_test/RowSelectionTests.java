package Element_unit_test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class RowSelectionTests {
	static WebDriver driver;
	WebDriverWait wait;
	
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://component-showcase.icesoft.org/component-showcase/showcase.iface");
		wait = new WebDriverWait(driver, 10);
		driver.findElement(By.linkText("Table")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Row Selection")));
		driver.findElement(By.linkText("Row Selection")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='iceSelOneRb']/tbody/tr/td[2]/label")));
		driver.findElement(By.xpath("//*[@id=\"iceform:icepnltabset:0:multipleSelection:_2\"]")).click();
		System.out.println("Before success");
	}
	
	@Test
	public void testRowSelectionUsingcontrolKey() throws Exception{
		List<WebElement> tablerows = driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr")); //Row Index start at 0
		//*[@id="iceform:icepnltabset:0:employeeList:0"]
		Actions builder = new Actions(driver);
		builder.click(tablerows.get(1)).keyDown(Keys.CONTROL)
				.click(tablerows.get(3)).keyUp(Keys.CONTROL)
				.build().perform();
		System.out.println("control key success");
		Thread.sleep(2000);
		
		//Verify Selected Row Table shows two rows selected
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"), 1));
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
		assertEquals(2, rows.size());
		System.out.println("row table : 2");
	}
	
	@Test
	public void testRowSelectionUsingshiftKey() throws Exception{
		List<WebElement> tablerows = driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr"));
		//*[@id="iceform:icepnltabset:0:employeeList"]
		//*[@id="iceform:icepnltabset:0:selectedRows"]
		
		
		Actions builder = new Actions(driver);
		builder.click(tablerows.get(1)).keyDown(Keys.SHIFT)
				.click(tablerows.get(2))
				.click(tablerows.get(3)).keyUp(Keys.SHIFT)
				.build().perform();
		System.out.println("shift key success");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"), 1));
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
		assertEquals(3, rows.size());
		System.out.println("row table : 3");
	}
	

	@After
	public void tearDown()
	{
		driver.close();
	}
}