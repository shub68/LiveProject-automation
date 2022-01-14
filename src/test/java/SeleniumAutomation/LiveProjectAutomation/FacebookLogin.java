package SeleniumAutomation.LiveProjectAutomation;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Extentreport.utils.ExtentReportManager;

public class FacebookLogin extends BaseUi2{
	ExtentReports report;
	@Test
	public void testOne() throws IOException {
		
	    report=ExtentReportManager.getReportInstance();
		ExtentTest logger=report.createTest("testone");
		launchBrowser("chrome");
		openURL("browserURL");
		createAccount("createAccount_Xpath");
		logger.log(Status.FAIL,"Statement not executed successfully");
		enterInfo("name_Xpath","sirName_Xpath","mobNumber_Xpath","password_Xpath");
		dropdownValues("dropdown_Xpath","mm_Xpath","yy_Xpath");
		logger.log(Status.PASS,"Test passed succssfully");
		takeScreenShotOnFailure();
		/*enterUserName("userName","shubham123");
		enterPass("password","shubham123");*/
	}
	@AfterTest
	public void endReport() {
		report.flush();
	}

}
