package org.setFavorites;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.Launch.LaunchBrowser;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calendar.Calendars;
import com.healthRec.Problems;
import com.pageObjeman.PageObjMan;

public class Favorites extends Base {

	public PageObjMan pom;
	public JavascriptExecutor j;
	public WebDriverWait ww;
	public WebDriver driver;
	public String kpid = "";
	public String ur;
	Calendars cal;
	String $current;

	@BeforeClass
	public void LaunchBrwoser() throws Exception {

		Map<String, Object> getConnection = LaunchBrowser.openConnection();

		pom = (PageObjMan) getConnection.get("pom");
		j = (JavascriptExecutor) getConnection.get("j");
		ww = (WebDriverWait) getConnection.get("ww");
		cal = (Calendars) getConnection.get("cal");
		ur = (String) getConnection.get("url");
		driver = (WebDriver) getConnection.get("driver");

	}

	@Test(priority = 7, groups = "settings")
	public void Settings() throws InterruptedException, IOException {

		while (true) {

			if (ur.equals("https://localhost:8443/")) {
				driver.navigate().to("https://localhost:8443/health/#setting");
				driver.navigate().refresh();
				break;

			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.navigate().to("https://www.75health.com/health/#setting");
				driver.navigate().refresh();
				break;
			} else if (ur.equals("https://www.test.75health.com/")) {
				javascriptclick(pom.getInstanceSetting().clickSettings);
				driver.navigate().refresh();
				break;
			}

		}

		WebElement cdsclick = driver.findElement(By.xpath("//button[contains(text(),'Clinical Decision')]"));
		visbility(driver, cdsclick, 60);
		ww.until(ExpectedConditions.elementToBeClickable(cdsclick));

		WebElement clicksett = driver.findElement(By.xpath("//td[text()='Settings']"));
		visbility(driver, clicksett, 60);
		javascriptclick(clicksett);
		visbility(driver, cdsclick, 60);
		ScriptExecutor(cdsclick);

		sleep(3000);

		// Set Favorities..

		driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
		sleep(3000);
		List<WebElement> setfav1 = driver.findElements(By.xpath("//ul[@id='setfavoritesul']/li"));
		for (WebElement w : setfav1) {
			if (w.getText().trim().equals("fgdggd")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement clickadditem = driver.findElement(By.xpath(
						"//div[@id='referral']//following::div[4]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, clickadditem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(clickadditem));
				click(clickadditem);
				WebElement sdf = driver.findElement(By.xpath(
						"(//div[contains(text(),'Type or select item/service and price')])[1]//following::input[1]"));
				visbility(driver, sdf, 60);
				sendkeys(sdf, "test");
				WebElement sdf2 = driver.findElement(By.xpath(
						"(//div[contains(text(),'Type or select item/service and price')])[1]//following::input[2]"));
				visbility(driver, sdf2, 60);
				sendkeys(sdf2, "5");
				WebElement saveitem = driver.findElement(By.xpath("(//div[@id='ItemKpop2']//following::button[2])[1]"));
				visbility(driver, saveitem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(saveitem));
				click(saveitem);

				sleep(2000);
				WebElement edititem = driver.findElement(By.xpath("//span[text()='test']"));
				visbility(driver, edititem, 60);
				ww.until(ExpectedConditions.elementToBeClickable(edititem));
				actions("click", edititem);
				while (true) {
					try {
						WebElement deleteitem = driver
								.findElement(By.xpath("//div[@id='ItemKpop2']/div[1]/div[2]/span[1]"));
						if (deleteitem.isDisplayed()) {
							click(deleteitem);
							break;
						}

					} catch (Exception e) {

					}
				}

				WebElement itemservicebackarrow = driver
						.findElement(By.xpath("//div[@id='ItemFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, itemservicebackarrow, 60);
				ww.until(ExpectedConditions.elementToBeClickable(itemservicebackarrow));
				javascriptclick(itemservicebackarrow);
				sleep(2500);
				while (true) {
					try {
						driver.findElement(By.xpath("//button[@onclick='setfavdropdown();']")).click();
						break;
					} catch (Exception e) {

					}
				}

			} else if (w.getText().trim().contentEquals("dgdgdg")) {
				while (true) {
					try {
						visbility(driver, w, 60);
						w.click();
						break;
					} catch (Exception e) {

					}
				}

				WebElement addnewfavmessage = driver
						.findElement(By.xpath("(//div[@id='message'])[1]/div[1]/div//following::td[4]/span[2]"));
				visbility(driver, addnewfavmessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(addnewfavmessage));
				javascriptclick(addnewfavmessage);

				WebElement msf = driver.findElement(By.xpath("//textarea[@id='message1']"));

				visbility(driver, msf, 60);
				sendkeys(msf, "hello");
				WebElement savemesssage = driver
						.findElement(By.xpath("//textarea[@id='message1']//following::button[2]"));
				visbility(driver, savemesssage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(savemesssage));
				javascriptclick(savemesssage);
				sleep(2500);
				WebElement editmessage = driver.findElement(By.xpath("//div[text()='hello']"));
				ww.until(ExpectedConditions.elementToBeClickable(editmessage));
				actions("click", editmessage);
				WebElement deletemessage = driver
						.findElement(By.xpath("//div[@id='MessageKpop2']/div[1]/div[2]/span[1]"));
				visbility(driver, deletemessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(deletemessage));
				javascriptclick(deletemessage);

				sleep(3000);
				WebElement gobackmessage = driver
						.findElement(By.xpath("(//span[text()='Favorite Message'])[1]//following::div[1]/span"));
				visbility(driver, gobackmessage, 60);
				ww.until(ExpectedConditions.elementToBeClickable(gobackmessage));
				javascriptclick(gobackmessage);

				sleep(3000);

			} else if (w.getText().trim().equals("Status")) {

				visbility(driver, w, 60);
				ww.until(ExpectedConditions.elementToBeClickable(w));
				click(w);

				WebElement statusSetfavsAddIcon = driver
						.findElement(By.xpath("(//div[@id='StatusFavKpop2']//following::span[5])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(statusSetfavsAddIcon));
				click(statusSetfavsAddIcon);

				WebElement statusdropdwn = driver
						.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select"));
				visbility(driver, statusdropdwn, 60);
				dropDown("index", statusdropdwn, "2");

				WebElement statusdiscription = driver
						.findElement(By.xpath("(//div[@id='StatusKpop2']//following::input[1])[1]"));
				visbility(driver, statusdiscription, 60);

				sendkeys(statusdiscription, "test");

				List<WebElement> $statusicddrp$;
				;
				while (true) {
					try {
						$statusicddrp$ = driver.findElements(By.xpath(
								"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
						if ($statusicddrp$.size() > 5) {
							break;
						}
					} catch (Exception e) {

					}
				}
				for (WebElement we : $statusicddrp$) {
					if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality (finding)")) {
						visbility(driver, we, 60);
						javascriptclick(we);
						break;
					}

				}

				WebElement saveStatusSetFav = driver
						.findElement(By.xpath("(//div[@id='StatusKpop2']/div[2]//following::button[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(saveStatusSetFav));
				click(saveStatusSetFav);
				sleep(2500);
				WebElement editStatusSetFav = driver
						.findElement(By.xpath("(//div[text()='134374006: Hearing test bilateral abnormality'])[1]"));
				visbility(driver, editStatusSetFav, 40);
				ww.until(ExpectedConditions.elementToBeClickable(editStatusSetFav));
				click(editStatusSetFav);

				WebElement deleteStatussetfav = driver
						.findElement(By.xpath("(//div[@id='StatusKpop2']//following::span[2])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(deleteStatussetfav));
				click(deleteStatussetfav);

				WebElement closeAdvanceDirSetFav = driver
						.findElement(By.xpath("(//div[@id='Advance_DirectivesFavKpop2']//following::span[1])[1]"));
				ww.until(ExpectedConditions.elementToBeClickable(closeAdvanceDirSetFav));
				click(closeAdvanceDirSetFav);
			}

		}

	}

}
