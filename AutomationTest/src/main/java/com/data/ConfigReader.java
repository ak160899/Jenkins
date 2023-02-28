package com.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties p;
	FileInputStream fis;

	public ConfigReader() {
		File f = new File(System.getProperty("user.dir") + "\\Login.properties");
		// FileInputStream fis;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getvalid3dCard() {
		String validcrd = p.getProperty("validcard");
		return validcrd;

	}

	public String getUrl() {
		String url = p.getProperty("url");
		return url;

	}

	public String getCvcfail() {
		String cvcFail = p.getProperty("cvcfail");
		return cvcFail;

	}

	public String getPostalFail() {
		String ps = p.getProperty("postal");
		return ps;

	}

	public String getExpiredCard() {
		String expcrd = p.getProperty("expcard");
		return expcrd;

	}

	public String insufficient3dCard() {

		String insufficientcard = p.getProperty("insuffientcard");
		return insufficientcard;
	}

	public String declinePayment() {
		String decline = p.getProperty("Decline");
		return decline;

	}

	public String fraudPrevention() {
		String fraud = p.getProperty("AlwaysBlocked");
		return fraud;

	}

	public String getEmail() {
		String email = p.getProperty("email");
		return email;

	}

	public String getpass() {
		String pass = p.getProperty("password");
		return pass;

	}

	public String newpassword() {
		String newpass = p.getProperty("newpassword");
		return newpass;

	}

	public String patientkpid() {
		String patientkpid = p.getProperty("patient");
		return patientkpid;

	}

	public String doctorKpid() {
		String doctorKpid = p.getProperty("Doctor");

		return doctorKpid;

	}

	public String getBrowser() {
		String $browser = p.getProperty("browser");
		return $browser;

	}

	public String accountType() {
		String $accStatus = p.getProperty("user");
		return $accStatus;

	}

}