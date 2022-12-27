package com.healthRec;

import java.util.concurrent.TimeUnit;

import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.data.ConfigManager;
import com.pageObjeman.PageObjMan;

public class Reuse extends Base {

	public WebDriver driver;
	public PageObjMan pom;
	public JavascriptExecutor j;
	public WebDriverWait ww;
	public String kpid;
	public String ur;

	/*
	 * public Reuse() throws Exception { // TODO Auto-generated constructor stub
	 * //driver = setUp("chrome"); pom = new PageObjMan(driver); j =
	 * (JavascriptExecutor) driver; ww = new WebDriverWait(driver, 60); ur =
	 * ConfigManager.getconfigManager().getInstanceConfigReader().getUrl();
	 * 
	 * while (true) { if (ur.equals("https://localhost:8443/")) {
	 * 
	 * driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl(
	 * )); sleep(3000); driver.findElement(By.id("details-button")).click();
	 * sleep(3000);
	 * 
	 * driver.findElement(By.id("proceed-link")).click(); sleep(4000);
	 * implicitWait(60, TimeUnit.SECONDS);
	 * 
	 * break; } else if (ur.equals("https://www.75health.com/login.jsp")) {
	 * driver.get("https://www.75health.com/login.jsp");
	 * 
	 * break; }
	 * 
	 * }
	 * 
	 * click(pom.getInstanceLoginPage().sigIn); sleep(2000);
	 * sendkeys(pom.getInstanceLoginPage().email,
	 * ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
	 * sendkeys(pom.getInstanceLoginPage().pass,
	 * ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
	 * click(pom.getInstanceLoginPage().login);
	 * 
	 * ww.until(ExpectedConditions.urlToBe("https://localhost:8443/health/#home"));
	 * // https://localhost:8443/health/#home // //
	 * https://www.75health.com/health/#home
	 * 
	 * }
	 */
	public WebDriver getBrowser() {
		return driver = setUp("chrome");

	}

	public PageObjMan getPageobj() {

		return pom;

	}

	public JavascriptExecutor getJavascriptExecutor() {
		return j;
	}

	public String getKpid() {
		return kpid;
	}

	public String getUr() {
		return ur;
	}

}
