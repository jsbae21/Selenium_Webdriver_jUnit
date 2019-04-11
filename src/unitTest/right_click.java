package unitTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 date : 2019.03.07
 right click
 contextClick
 */

public class right_click {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void test() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/ContextClick.html#");
		WebElement contextMenu = driver.findElement(By.xpath("//*[@id=\"div-context\"]"));
		
		Actions builder = new Actions(driver);
		builder.contextClick(contextMenu).click(driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"))).perform();
		//builder.moveToElement(contextMenu).contextClick().click(driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"))).perform();
		
		 Thread.sleep(2000);
		 driver.quit();
		System.out.println("right click success");
	}
	
	@After
    public void tearDown()throws Exception {
		
    }
}