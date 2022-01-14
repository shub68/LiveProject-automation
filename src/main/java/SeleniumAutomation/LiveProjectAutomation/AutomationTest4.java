package SeleniumAutomation.LiveProjectAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AutomationTest4 {
	WebDriver driver=null;
	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@Test
	public void selectStock() throws InterruptedException {
		driver.get("https://www.rediff.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/span[2]/a[1]")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/input")).sendKeys("shubhamlokare6855@gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/div[3]/input[1]")).sendKeys("Shubham@6855");
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/div[3]/input[1]")).sendKeys(Keys.ENTER);
		
	  //adding stock
		driver.findElement(By.id("addStock")).click();
		
		driver.findElement(By.xpath("/html/body/b/div[6]/form/div[2]/div/div[1]/div[1]/input[1]")).sendKeys("bajaj");
	    driver.findElement(By.xpath("/html/body/div[5]/div[1]")).click();
		driver.findElement(By.id("stockAddDate")).sendKeys("14/12/2021");
		
		driver.findElement(By.id("addstockqty")).sendKeys("100");
		
		driver.findElement(By.id("addstockprice")).sendKeys("5000");
		
		driver.findElement(By.id("addStockButton")).click();
		System.out.println("Pass 1");
		Thread.sleep(5000);
		
		WebElement ele1=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/b/div[2]/div[3]/table/tbody/tr/td[2]/span/a"));
		String text=ele1.getText();
		System.out.println("Text is:-"+text);
		System.out.println("Pass 2");
		Assert.assertEquals(text,"Bajaj Finance L");
	}

}
