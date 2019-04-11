package unitTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 date : 2019.03.07
 click 
 clickAndHold
 control_click
 double_click
 right_click
 dragAndDrop
 dragme
 MoveByOffset
 */

public class Test_sum {
	private WebDriver driver;
	
	@Before
	  public void setUp()throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  }	
	  
	@Test
	public void click() throws Exception {
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
	
	@Test
	public void clickAndHold() throws Exception {
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
	
	@Test
	public void control_click() throws Exception {
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
	
	@Test
	public void double_click() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/DoubleClick.html");
		WebElement dblclick = driver.findElement(By.name("dblClick"));
		
		Actions builder = new Actions(driver);
		//builder.moveToElement(dblclick).doubleClick().perform();
		builder.doubleClick(dblclick).perform();
		
		 Thread.sleep(2000);
		 driver.quit();
		 System.out.println("double click success");   	
	}
	
	@Test
	public void right_click() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/ContextClick.html#");
		WebElement contextMenu = driver.findElement(By.xpath("//*[@id=\"div-context\"]"));
		
		Actions builder = new Actions(driver);
		builder.contextClick(contextMenu).click(driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"))).perform();
		//builder.moveToElement(contextMenu).contextClick().click(driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"))).perform();
		
		 Thread.sleep(2000);
		 driver.quit();
		System.out.println("right click success");
	}
	
	@Test
	public void DargAndDrop() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/DragAndDrop.html");
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement trgt = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(src,trgt).perform();
		
		 Thread.sleep(2000);
		 driver.quit();
		 System.out.println("DargAndDrop click success");   	
	}
	
	@Test
	public void DargMEe() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/DragMe.html");
		WebElement dragme = driver.findElement(By.id("draggable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(dragme, 300, 200).perform();
		
		 Thread.sleep(2000);
		 driver.quit();
		 System.out.println("DargMEe success");   	
	}
	
	@Test
	public void MoveByOffset() throws Exception {
		driver.get("file:///E:/Selenium%20WebDriver%20Practical%20Guide/Chapter%202/HTML/Selectable.html");
		WebElement three = driver.findElement(By.name("three"));
		
		System.out.println("X coordinate: " + three.getLocation().getX()
				+ "  Y coordinate: " + three.getLocation().getY());
		Actions builder = new Actions(driver);
		builder.moveByOffset(three.getLocation().getX() + 1, three
				.getLocation().getY() + 1).click();
		builder.perform();
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("MoveByOffset success");  
	}
	
	@After
    public void tearDown()throws Exception {
		
    }
}
