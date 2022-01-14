package SeleniumAutomation.LiveProjectAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AutomationTest1 {
	WebDriver driver=null;
	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@Test
	public void rediff() {
		driver.get("https://www.rediff.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/span[2]/a[1]")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/input")).sendKeys("shubhamlokare6855@gmail.com");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/div[3]/input[1]")).sendKeys("Shubham@6855");
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/div[3]/input[1]")).sendKeys(Keys.ENTER);
		
		//driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/div[3]/input[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div[1]/div[2]/span[1]/a")).isDisplayed();
	}
}
