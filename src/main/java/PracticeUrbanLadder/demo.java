package PracticeUrbanLadder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class demo {
	WebDriver driver;
	@Test
	public void invoke() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.urbanladder.com");
		WebElement ele=driver.findElement(By.xpath("//span[normalize-space()='Sale']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		
		List<WebElement> ele1=driver.findElements(By.xpath("//ul[@class='topnav bodytext']"));
		for(WebElement lup:ele1) {
			System.out.println(lup.getText());
		}
	}

}
