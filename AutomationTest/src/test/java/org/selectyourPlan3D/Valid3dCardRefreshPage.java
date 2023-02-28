package org.selectyourPlan3D;

import java.io.IOException;

import org.Launch.LaunchBrowser;
import org.testng.annotations.Test;

public class Valid3dCardRefreshPage extends LaunchBrowser {

	@Test
	public void valid3dCardRefeshPage() throws IOException {
		Valid3dcardFailAuth.valid3dCard();
		driver.navigate().refresh();
		visbility(driver, pom.getInstanceSelectYourPlan().proceedPaymentButton, 50);
		elementClickable(pom.getInstanceSelectYourPlan().proceedPaymentButton);
		click(pom.getInstanceSelectYourPlan().proceedPaymentButton);

	}

}
