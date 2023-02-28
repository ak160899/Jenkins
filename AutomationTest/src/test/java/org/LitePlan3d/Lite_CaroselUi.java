package org.LitePlan3d;

import org.Launch.LaunchBrowser;
import org.selectyourPlan3D.Invalidcard;
import org.testng.annotations.Test;

public class Lite_CaroselUi extends LaunchBrowser {

	@Test
	private void run() throws InterruptedException {

		Carosel.linktextUpgradePlanActiveuser();
		Carosel.basicCaroselUi();
		Carosel.premium55CaroselUi();
		Carosel.premium79carsolUi();

	}

}
