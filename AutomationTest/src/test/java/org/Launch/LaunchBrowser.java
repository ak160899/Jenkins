package org.Launch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.calendar.Calendars;
import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class LaunchBrowser extends Base {

	public static PageObjMan pom;
	public static JavascriptExecutor j;
	public static WebDriverWait ww;
	public static WebDriver driver;
	public String kpid;
	public static String url;
	static Calendars cal;
	String $current;

	public static Map<String, Object> openConnection() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		driver = setUp("chrome");
		pom = new PageObjMan(driver);
		j = (JavascriptExecutor) driver;
		ww = new WebDriverWait(driver, 20);
		cal = new Calendars(driver, pom);
		url = ConfigManager.getconfigManager().getInstanceConfigReader().getUrl();

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
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#home")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#home")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://localhost:8443/health/#list_ehr")) {
				break;
			}
		}
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		/*
		 * while (true) { if
		 * (!driver.getCurrentUrl().equals("https://localhost:8443/health/#home")) {
		 * click(pom.getInstanceLoginPage().login); break; } else { break; } }
		 */
		sleep(3000);

		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		implicitWait(70, TimeUnit.SECONDS);
		takeSnap();
		sleep(2000);

		return result;
	}

}
