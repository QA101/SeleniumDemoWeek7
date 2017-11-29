package googleSearch;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleFeelingLuckyTest {
	static WebDriver driver;
	static WebElement search;
	static WebElement lucky;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Before
	public void setUp() throws Exception{
		driver.get("http://www.google.com");
		search = driver.findElement(By.id("lst-ib"));
		lucky = driver.findElement(By.id("gbqfbb"));
		synchronized (driver)
		{
		    driver.wait(2000);
		}
	}
	

	@After
	public void tearDown() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
	
	@Test
	public void AdeleTest() throws InterruptedException {	
		//Test steps
		search.sendKeys("Hello");
		lucky.sendKeys(Keys.RETURN);
		synchronized (driver)
		{
		    driver.wait(2000);
		}
		
		//Validation
		assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/watch?v=YQHsXMglC9A");
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void DaftPunkTest() throws InterruptedException{	
		//Test steps
		search.sendKeys("Daft Punk - Instant Crush");
		lucky.sendKeys(Keys.RETURN);
		synchronized (driver)
		{
		    driver.wait(2000);
		}
		
		//Validation
		assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/watch?v=a5uQMwRMHcs");
		System.out.println(driver.getCurrentUrl());
	}
}
