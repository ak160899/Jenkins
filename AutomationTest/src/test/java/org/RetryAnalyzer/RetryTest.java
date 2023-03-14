package org.RetryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

	int min = 1;
	int max = 4;

	@Override
	public boolean retry(ITestResult result) {

		if (min < max) {
			min++;
			return true;
		}

		return false;
	}

}
