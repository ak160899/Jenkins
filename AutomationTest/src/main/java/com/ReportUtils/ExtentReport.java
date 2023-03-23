package com.ReportUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	ExtentReports reports;

	public void startReport() {
		ExtentSparkReporter repoter = new ExtentSparkReporter("./ExtentReports/TestResult.html");

		reports = new ExtentReports();
		reports.attachReporter(repoter);

	}

	public void stopReport() {

		reports.flush();

	}

	public void createTest(String testName, String dis, String author) {
		ExtentTest test = reports.createTest(testName);
		test.assignCategory(dis);
		test.assignAuthor(author);

	}

}
