package com.healthRec;

import org.Launch.LaunchBrowser;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

public class Tc_021_AttachFile extends LaunchBrowser {

	@Test
	public static void attachFileAdd_SaveAndEdit() throws Throwable {
		while (true) {
			if (pom.getInstanceAttachFile().addIcon.isDisplayed()) {
				visbility(driver, pom.getInstanceAttachFile().addIcon, 30);
				clickIntercept(pom.getInstanceAttachFile().addIcon, 30);
				break;
			} else if (!pom.getInstanceAttachFile().addIcon.isDisplayed()) {
				actions("move to element", pom.getInstanceAttachFile().addIcon);
			}
		}

		visbility(driver, pom.getInstanceAttachFile().selectType, 30);
		dropDown("text", pom.getInstanceAttachFile().selectType, "Web link");

		visbility(driver, pom.getInstanceAttachFile().link, 30);
		sendkeys(pom.getInstanceAttachFile().link, "https://www.75health.com/");
		clickIntercept(pom.getInstanceAttachFile().save, 30);

		try {
			visbility(driver, pom.getInstanceAttachFile().edit, 30);
			clickIntercept(pom.getInstanceAttachFile().edit, 30);

		} catch (StaleElementReferenceException e) {
			visbility(driver, pom.getInstanceAttachFile().edit, 30);
			clickIntercept(pom.getInstanceAttachFile().edit, 30);
		}

		visbility(driver, pom.getInstanceAttachFile().link, 30);
		clear(pom.getInstanceAttachFile().link);
		sendkeys(pom.getInstanceAttachFile().link, "https://www.75health.com/");
		clickIntercept(pom.getInstanceAttachFile().save, 30);
	}

}
