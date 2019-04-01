package webdriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;
/*
 date : 2019.04.01
 Check Element
 1. Element Text
 2. Element 속성
 3. Element CSS
 */

public class check_element {
	WebDriver driver;
	
	@Before
	  public void setUp(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		  }	
	  
	@Test
	public void testElementText() //element 텍스트 검사
	{
		
		WebElement message = driver.findElement(By.id("message")); //Get the message Element
		String messageText = message.getText(); //Get the message elements text
		
		//Verify message element's text displays "Click on me and my color will change"
		assertEquals("Click on me and my color will change", messageText);
		System.out.println("messageText success");
		
		WebElement area = driver.findElement(By.id("area")); //Get the area Element
		
		//Verify area element's text displays "Div's Text\nSpan's Text"
		assertEquals("Div's Text\nSpan's Text",area.getText());
		System.out.println("areaText success");
	}
	
	@Test
	public void testElementAttribute() //element 속성값 검사
	{
		WebElement message = driver.findElement(By.id("message"));
		assertEquals("justify",message.getAttribute("align"));
		System.out.println("check element success");
	}
	
	@Test
	public void testElementStyle() //element CSS 검사
	{
		WebElement message = driver.findElement(By.id("message"));
		String width = message.getCssValue("width");
		assertEquals("150px",width);
		System.out.println("check css element success");
	}
	
	@After
    public void tearDown() {
		driver.close();
    }
}