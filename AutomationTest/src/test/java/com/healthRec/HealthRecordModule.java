package com.healthRec;

import org.Launch.LaunchBrowser;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class HealthRecordModule extends LaunchBrowser {

	static Logger log;

	@Test
	private void vitalsModule() {

		try {
			Vitals.vitalsFeature();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	
	@Test
	private void visitReasonModule() {
		
		
		

	}
	
}
