package unitTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 date : 2019.03.05
 control 입력 상태에서 마우스로 버튼 선택하기
 */

public class control_click {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void test() throws Exception {
		driver.get("E:\\Selenium WebDriver Practical Guide\\Chapter 2\\HTML/selectable.html");
		WebElement one = driver.findElement(By.name("one"));
		WebElement three = driver.findElement(By.name("three"));
		WebElement five = driver.findElement(By.name("five"));
		
		// control 누른 후 마우스로 숫자 클릭
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(one).click(three).click(five)
				.keyUp(Keys.CONTROL);
		builder.perform();
		Thread.sleep(3000);
		driver.quit();
		System.out.println("control_click success");
	}
	
	@After
    public void tearDown()throws Exception {
		
    }

}