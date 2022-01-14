package SeleniumAutomation.LiveProjectAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTest2_createPortfolio {
	WebDriver driver=null;
	@Test(priority=0)
	public void launch() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void rediff() throws InterruptedException {
		driver.get("https://www.rediff.com");
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/span[2]/a[1]")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/input")).sendKeys("shubhamlokare6855@gmail.com");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/div[3]/input[1]")).sendKeys("Shubham@6855");
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/form/div/div[3]/input[1]")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div[5]/b/div/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("/html/body/b/div[5]/form/div[2]/div/div[1]/div[1]/input")).clear();
		driver.findElement(By.xpath("/html/body/b/div[5]/form/div[2]/div/div[1]/div[1]/input")).sendKeys("Portfolio19");
		
		driver.findElement(By.xpath("/html/body/b/div[5]/form/div[2]/div/div[1]/div[2]/div/input")).click();
	}	
	@Test(priority=2)
	public void PortfolioVerification() throws InterruptedException {
		try {
			Thread.sleep(5000);
	 WebElement opt=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div[5]/b/div/div/select"));
	 
	 Thread.sleep(10000);
	 
	 Select select=new Select(opt);
	 String Text= select.getFirstSelectedOption().getText();
	 System.out.println("Name of Portfolio is:-"+Text);
	 Assert.assertEquals(Text,"Portfolio1");
	}catch(Exception e) {
	System.out.println(e);	
	}
	}
	@Test(priority=3)
		public void deletePortfolio() throws InterruptedException {
			driver.findElement(By.xpath("//a[@id='deletePortfolio']")).click();
			driver.switchTo().alert().accept();
			System.out.println("Success");
			Thread.sleep(5000);
			WebElement ele=driver.findElement(By.xpath("//select[@id='portfolioid']"));
			Select sel=new Select(ele);
			List<WebElement> li=sel.getOptions();
			for(WebElement lup:li) {
				System.out.println("Options are"+lup.getText());
			}
		}
		
	}
