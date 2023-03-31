package org.Launch;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.patientPomClass.PageObjectManager;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.calendar.Calendars;
import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class LaunchBrowser extends Base {

	public static PageObjMan pom;
	public static JavascriptExecutor j;
	public static WebDriverWait ww;
	public static WebDriver driver;
	public static String kpid;
	public static String url;
	public static Calendars cal;
	public String $current;
	public static PageObjectManager pm;
	public static org.apache.log4j.Logger log;
	public static ExtentSparkReporter repoter;
	public static ExtentReports reports;
	public static ExtentTest extentTest;
	public static String path;

	@BeforeSuite(groups = "before")
	public static Map<String, Object> openConnection() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		log = org.apache.log4j.Logger.getLogger(LaunchBrowser.class);
		BasicConfigurator.configure();
		driver = setUp(ConfigManager.getconfigManager().getInstanceConfigReader().getBrowser());
		pom = new PageObjMan(driver);
		j = (JavascriptExecutor) driver;
		ww = new WebDriverWait(driver, 55);
		cal = new Calendars(driver, pom);
		url = ConfigManager.getconfigManager().getInstanceConfigReader().getUrl();
		pm = new PageObjectManager(driver);
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

		reports = new ExtentReports();
		repoter = new ExtentSparkReporter("./ExtentReports/TestResult.html");

		reports.attachReporter(repoter);

		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Java version", System.getProperty("java.version"));
		reports.setSystemInfo("Browser", cap.getBrowserName() + cap.getVersion());

		result.put("driver", driver);
		result.put("pom", pom);
		result.put("j", j);
		result.put("cal", cal);
		result.put("url", url);
		result.put("ww", ww);

		while (true) {
			if (url.equals("https://localhost:8443/")) {

				driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
				sleep(3000);
				driver.findElement(By.id("details-button")).click();
				sleep(3000);

				driver.findElement(By.id("proceed-link")).click();
				sleep(4000);
				implicitWait(60, TimeUnit.SECONDS);

				break;
			} else if (url.equals("https://www.75health.com/login.jsp")) {
				driver.get("https://www.75health.com/login.jsp");

				break;
			} else if (url.equals("https://www.test.75health.com/")) {
				driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
				break;
			}

		}

		while (true) {
			try {
				click(pom.getInstanceLoginPage().sigIn);
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		sleep(2000);

		while (true) {
			try {
				sendkeys(pom.getInstanceLoginPage().email,
						ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
				sendkeys(pom.getInstanceLoginPage().pass,
						ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
				click(pom.getInstanceLoginPage().login);
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		while (true) {
			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#home")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#home")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#home")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#list_ehr")) {
				break;
			}
		}

		implicitWait(70, TimeUnit.SECONDS);

		return result;
	}

	@BeforeTest
	public void getTheTestName(ITestContext context) {

		extentTest = reports.createTest(context.getName()).assignAuthor("AKASH").assignCategory("SMOKE TESTING")
				.assignDevice("WINDOWS");
		;
	}

	@BeforeMethod
	public void verifyTheName(Method m) {

		extentTest.info(MarkupHelper.createLabel("<b>" + m.getName() + "</b>", ExtentColor.GREY));

	}

	@AfterMethod

	public void checkStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass("<b>TEST PASSED</B>");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
			extentTest.addScreenCaptureFromPath(Screenshot(result.getName()));
			extentTest.fail(result.getThrowable());
		}

	}

	@AfterSuite(groups = "before")
	public void tear_Down() {
		System.out.println("AFTER TEST");

		// close();
		// quite();
		reports.flush();

		try {
			Desktop.getDesktop().browse(new File("ExtentReports/TestResult.html").toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
