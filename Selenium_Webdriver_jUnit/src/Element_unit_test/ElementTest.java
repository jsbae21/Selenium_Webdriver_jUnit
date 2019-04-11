package Element_unit_test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElementTest {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void setUp()
	{
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	
	@Test
	public void testElementText() throws Exception
	{
		//Get the message Element
		WebElement message = driver.findElement(By.id("message"));
		
		//Verify message element's text displays "Click on me and my color will change"
		assertEquals("Click on me and my color will change", message.getText());
		System.out.println("Element Text 검사 success");
		Thread.sleep(3000);
		
		/*Get the message elements text
		String messageText = message.getText();
		assertEquals("Click on me and my color will change", messageText);*/
		
		//Get the area Element
		WebElement area = driver.findElement(By.id("area"));
		assertEquals("Div's Text\nSpan's Text",area.getText());
		System.out.println("Element Text1 검사 success");
	}
	
	@Test
	public void testElementAttribute()
	{
		WebElement message = driver.findElement(By.id("message"));
		assertEquals("justify",message.getAttribute("align"));
		System.out.println("Element 속성 값 검사 success");
	}
	
	@Test
	public void testElementStyle()
	{
		WebElement message = driver.findElement(By.id("message"));
		//String width = message.getCssValue("width");
		assertEquals("150px",message.getCssValue("width")); //엘리먼트의 너비가 150px 인지 확인
		System.out.println("Css_width success");
	}
	
	@Test
	public void testElementStyle1()
	{
		WebElement area = driver.findElement(By.id("area"));
		assertEquals("150px",area.getCssValue("width"));;
		System.out.println("Css_background1 success");
	}
	
	@AfterClass
	public static void tearDown()
	{
		driver.close();
	}
}