package unitTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 date : 2019.03.05
 숫자 버튼 선택하여 옮기기(버튼 위치 변경)
 */

public class clickAndHold {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void ClickAndHold() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/Sortable.html");
		WebElement two = driver.findElement(By.name("two"));
		WebElement three = driver.findElement(By.name("three"));
		
		// 숫자 이동
		Actions builder = new Actions(driver);
		//builder.clickAndHold(three).moveByOffset(120,0).release().perform();
		/*Action dragAndDrop = builder.clickAndHold(three).moveToElement(two).release().build();
		 dragAndDrop.perform();*/
		builder.clickAndHold(three).release(two).perform();
		
		 Thread.sleep(3000);
		 driver.quit();
		System.out.println("clickAndHold success");
	}
	
	@After
    public void tearDown()throws Exception {
		
    }
}