package unit_test01;
import java.util.Set;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*
 date : 2019.03.25
  ������ �� �ڵ鸵
  */

public class window_handle {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void test() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/chapter%203/HTML/Window.html");

		String window1 = driver.getWindowHandle(); //���� â�� �ĺ��ڸ� ����
		System.out.println("First Window Handle");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/a")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println("second Window Handle");
		Thread.sleep(3000);

		driver.switchTo().window(window1);
		Thread.sleep(2000);
		driver.quit();
		System.out.println("getWindowHandle success");   
	}
	
	@After
    public void tearDown()throws Exception {		
    }
}