package unitTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 date : 2019.03.07
 click on web element
 */

public class click {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void Click() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/Selectable.html");
		WebElement one = driver.findElement(By.name("one"));
		WebElement eleven = driver.findElement(By.name("eleven"));
		WebElement five = driver.findElement(By.name("five"));
		
		// 숫자 이동
		Actions builder = new Actions(driver);
		builder.click(one).click(eleven).click(five).perform();
		
		 Thread.sleep(2000);
		 driver.quit();
		System.out.println("click success");
	}
	
	@After
    public void tearDown()throws Exception {
		
    }
}