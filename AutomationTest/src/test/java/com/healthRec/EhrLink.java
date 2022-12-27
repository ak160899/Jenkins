package com.healthRec;

import org.base.*;

public class EhrLink extends Base {

	public String $ehrLink(String link) {
		String Link = "";
		if (link.equals("https://localhost:8443/")) {
			Link = "https://localhost:8443/health/#list_ehr";
		} else if (link.equals("https://www.test.75health.com/")) {
			Link = "https://www.test.75health.com/health/#list_ehr";
		} else if (link.equals("https://www.75health.com/login.jsp")) {
			Link = "https://www.75health.com/health/#list_ehr";
		}
		return Link;
	}

}
