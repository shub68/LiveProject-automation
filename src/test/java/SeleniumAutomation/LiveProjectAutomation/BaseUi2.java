package SeleniumAutomation.LiveProjectAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class BaseUi2 {
	WebDriver driver;
	Properties prop;
	

	public void launchBrowser(String browserName) throws IOException {
		// C:\Users\User\Desktop\DOMINATORS\LiveProjectAutomation
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (prop == null) { 
			prop=new Properties();
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\objectRepo\\config.properties");
			prop.load(file);
		}

	}

	public void openURL(String URLKey) {
		driver.get(prop.getProperty(URLKey));
	}

	public void tearDown() {
		driver.close();
	}

	/*
	 * public void enterUserName(String xPathUserNameKey, String email) {
	 * driver.findElement(By.xpath(prop.getProperty(xPathUserNameKey))).sendKeys(
	 * email); }
	 * 
	 * public void enterPass(String idPasswordKey, String pass) { WebElement ele =
	 * driver.findElement(By.id(prop.getProperty(idPasswordKey)));
	 * ele.sendKeys("shub1232"); ele.sendKeys(Keys.ENTER); }
	 */
	public void createAccount(String Idkey) {
		getElement(Idkey).click();
	}

	public void enterInfo(String nameKey, String sirNameKey, String mobKey, String password) {
		getElement(nameKey).sendKeys("shubham");
		getElement(sirNameKey).sendKeys("Lokare");
		getElement(mobKey).sendKeys("7040069525");
		getElement(password).sendKeys("123");

	}

	public void dropdownValues(String xpathDDKey, String xpathMMKey, String xpathYYKey) {
		WebElement ele1 = getElement(xpathDDKey);
		Select sel = new Select(ele1);
		sel.selectByIndex(3);

		List<WebElement> li = sel.getOptions();
		for (WebElement li2 : li) {
			System.out.println(li2.getText());
		}

		WebElement ele2 = getElement(xpathMMKey);
		Select sel1 = new Select(ele2);
		sel1.selectByVisibleText("Nov");

		WebElement ele3 = getElement(xpathYYKey);
		Select sel3 = new Select(ele3);
		sel3.selectByIndex(12);
	}

	public WebElement getElement(String Key) {
		WebElement ele = null;
		try {
			if (Key.endsWith("_Xpath")) {
				ele = driver.findElement(By.xpath(prop.getProperty(Key)));
			} else if (Key.endsWith("_Id")) {
				ele = driver.findElement(By.id(prop.getProperty(Key)));
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
			Assert.fail("failing the testcase:" + e.getMessage());
		}
		return ele;

	}

	public void reportFail(String reportString) {

	}

	public void reportPass(String reportString) {

	}

	public void takeScreenShotOnFailure() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File soueceFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "\\screnshot\\sc1.png");
		FileUtils.copyFile(soueceFile, destFile);
	}

}
