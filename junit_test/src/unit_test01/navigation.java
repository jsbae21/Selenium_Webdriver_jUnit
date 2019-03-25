package unit_test01;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;


/*
 date : 2019.03.07
 click on web element
 */

public class navigation {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void Click() throws Exception {
		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		
		WebElement searchbutton = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]"));
		searchbutton.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		/*searchBox.sendKeys("driver");
		Thread.sleep(2000);
		searchbutton.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);*/
		
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.quit();
		System.out.println("Navigation Handling success");
	}
	
	@After
    public void tearDown()throws Exception {
		
    }
}