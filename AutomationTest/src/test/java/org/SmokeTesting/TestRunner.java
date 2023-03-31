package org.SmokeTesting;

import java.util.List;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args) {
		TestNG test = new TestNG();

		// test.setTestClasses(new Class[] {
		// subscriptionValidation.Lite_Basic_premium55_premium79.class });
		// test.setTestClasses(new Class[] {
		// subscriptionValidation.SelctyourPlan_Premiumplus.class });
		test.setTestClasses(new Class[] { org.SmokeTesting.Local_Host.class });

		/*
		 * List suite = Lists.newArrayList();
		 * 
		 * suite.add(System.getProperty("user.dir") + "\\3dSuiteFile\\3DTesting.xml");
		 * suite.add(System.getProperty("user.dir") + "\\3dSuiteFile\\Lite.xml.xml");
		 * 
		 * test.setTestSuites(suite);
		 */
		test.run();

	}

}
