package Extentreport.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

	// public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;

	public static ExtentReports getReportInstance() {
		if (report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir")+"\\reports\\report1.html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

		}
		return report;

	}

}
