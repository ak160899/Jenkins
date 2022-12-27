package com.LoginInfo;

import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class LoginDetails extends Base {

	public WebDriver driver;
	public PageObjMan pom;
	public JavascriptExecutor j;
	public WebDriverWait ww;
	public String kpid;
	public String ur;

	public WebDriver $login() throws Exception {
		driver = setUp(ConfigManager.getconfigManager().getInstanceConfigReader().getBrowser());
		pom = new PageObjMan(driver);
		j = (JavascriptExecutor) driver;
		ww = new WebDriverWait(driver, 20);
		ur = ConfigManager.getconfigManager().getInstanceConfigReader().getUrl();

		while (true) {
			if (ur.equals("https://localhost:8443/")) {

				driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
				sleep(3000);
				driver.findElement(By.id("details-button")).click();
				sleep(3000);

				driver.findElement(By.id("proceed-link")).click();
				sleep(4000);
				implicitWait(60, TimeUnit.SECONDS);

				break;
			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.get("https://www.75health.com/login.jsp");

				break;
			} else if (ur.equals("https://www.test.75health.com/")) {
				driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
				break;
			}

		}

		while (true) {
			try {
				click(pom.getInstanceLoginPage().sigIn);
				break;
			} catch (Exception e) {
				// TODO: handle exception
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
				// TODO: handle exception
			}
		}

		while (true) {
			if (driver.getCurrentUrl().equals("https://localhost:8443/health/#home")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.test.75health.com/health/#home")) {
				break;
			} else if (driver.getCurrentUrl().equals("https://www.75health.com/health/#home")) {
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

		// System.out.println("exit login detail function");
		return driver;

	}

}
