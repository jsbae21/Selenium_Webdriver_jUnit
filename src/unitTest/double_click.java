package unitTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 date : 2019.03.07
 double click
 */

public class double_click {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void test() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/DoubleClick.html");
		WebElement dblclick = driver.findElement(By.name("dblClick"));
		
		Actions builder = new Actions(driver);
		//builder.moveToElement(dblclick).doubleClick().perform();
		builder.doubleClick(dblclick).perform();
		
		 Thread.sleep(2000);
		 driver.quit();
		 System.out.println("double click success");   	
	}
	
	@After
    public void tearDown()throws Exception {		
    }
}