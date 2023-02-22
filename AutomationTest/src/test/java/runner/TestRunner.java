package runner;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args) {
		TestNG test = new TestNG();

		// test.setTestClasses(new Class[] {
		// subscriptionValidation.Lite_Basic_premium55_premium79.class });
		// test.setTestClasses(new Class[] {
		// subscriptionValidation.SelctyourPlan_Premiumplus.class });
		test.setTestClasses(new Class[] { runner.Dr_userLogin.class });
		test.run();

	}

}
