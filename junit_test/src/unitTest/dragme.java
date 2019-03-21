package unitTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 date : 2019.03.07
 dragme
  */

public class dragme {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void test() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/DragMe.html");
		WebElement dragme = driver.findElement(By.id("draggable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(dragme, 300, 200).perform();
		
		 Thread.sleep(2000);
		 driver.quit();
		 System.out.println("DargMEe success");   	
	}
	
	@After
    public void tearDown()throws Exception {		
    }
}