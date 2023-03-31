package org.PageModules;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Message extends LaunchBrowser {

	@Test
	public static void messageModule() {
		clickIntercept(pom.getInstanceMessage().clickMessage, 30);
		sleep(2500);
		visbility(driver, pom.getInstanceMessage().clickComposemMessage, 30);
		clickIntercept(pom.getInstanceMessage().clickComposemMessage, 30);

		try {
			visbility(driver, pom.getInstanceMessage().search, 40);
			sendkeys(pom.getInstanceMessage().search, kpid);

		} catch (Exception e) {
			visbility(driver, pom.getInstanceMessage().search, 40);
			sendkeys(pom.getInstanceMessage().search, kpid);
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement msg = driver.findElement(By.xpath("(//td[@id='nameh'])[1]//following::td[1]"));
				if (msg.isDisplayed()) {
					clickIntercept(msg, 30);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		visbility(driver, pom.getInstanceMessage().enterSubject, 60);
		sendkeys(pom.getInstanceMessage().enterSubject, "GOOD MORNING");

		sendkeys(pom.getInstanceMessage().enterMessage, "hello welcome to chennai");
		visbility(driver, pom.getInstanceMessage().sendMessage, 60);
		clickIntercept(pom.getInstanceMessage().sendMessage, 30);
		sleep(2500);

		visbility(driver, pom.getInstanceMessage().seeSentMessage, 60);
		clickIntercept(pom.getInstanceMessage().seeSentMessage, 30);

		sleep(3000);

		WebElement $msgtext = driver.findElement(By.xpath("(//div[text()='hello welcome to chennai'])[1]"));
		visbility(driver, $msgtext, 60);
		clickIntercept($msgtext, 30);

		WebElement $del = driver.findElement(By.xpath("(//span[@id='msg-del-btn'])[2]"));

		System.out.println("MESSAGE FIND");
		visbility(driver, $del, 30);
		clickIntercept($del, 30);

		WebElement $delmsgTickIcon = driver.findElement(By.xpath("(//span[@id='msg-del-btn'])[2]//following::span[1]"));

		clickIntercept($delmsgTickIcon, 30);
		sleep(2500);

		WebElement $showFavMesageKpopIcon = driver
				.findElement(By.xpath("//div[@id='message_list']/div[1]/div[1]/div[2]/i"));

		visbility(driver, $showFavMesageKpopIcon, 30);
		clickIntercept($showFavMesageKpopIcon, 30);

		WebElement $favmsgAddicon = driver
				.findElement(By.xpath("//div[@id='MessageFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
		visbility(driver, $favmsgAddicon, 60);
		clickIntercept($favmsgAddicon, 30);

		WebElement $msgTextbox = driver.findElement(By.xpath("//textarea[@id='message1']"));
		visbility(driver, $msgTextbox, 40);
		sendkeys($msgTextbox, "FAVORITE MESSAGE KPOP");

		WebElement $savefavmsg = driver.findElement(By.xpath("//textarea[@id='message1']//following::button[2]"));
		visbility(driver, $savefavmsg, 40);
		clickIntercept($savefavmsg, 30);
		sleep(2000);
		try {
			WebElement $addfavMsgToListIcon = driver.findElement(
					By.xpath("(//div[text()='FAVORITE MESSAGE KPOP'])[1]//parent::div[1]//parent::div[1]/div/span"));
			visbility(driver, $addfavMsgToListIcon, 40);
			clickIntercept($addfavMsgToListIcon, 30);
		} catch (StaleElementReferenceException e) {
			WebElement $addfavMsgToListIcon = driver.findElement(
					By.xpath("(//div[text()='FAVORITE MESSAGE KPOP'])[1]//parent::div[1]//parent::div[1]/div/span"));
			visbility(driver, $addfavMsgToListIcon, 40);
			clickIntercept($addfavMsgToListIcon, 30);
		}

		visbility(driver, pom.getInstanceMessage().search, 40);
		sendkeys(pom.getInstanceMessage().search, kpid);

		sleep(2000);

		WebElement msg = driver.findElement(By.xpath("(//td[@id='nameh'])[1]//following::td[1]"));
		visbility(driver, msg, 30);
		clickIntercept(msg, 30);

		clickIntercept(pom.getInstanceMessage().sendMessage, 30);

	}

}
