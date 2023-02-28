package com.data;

public class ConfigManager {

	public ConfigReader getInstanceConfigReader() {
		ConfigReader r = new ConfigReader();
		return r;

	}

	public static ConfigManager getconfigManager() {
		ConfigManager cm = new ConfigManager();
		return cm;
	}

	private ConfigManager() {
		// TODO Auto-generated constructor stub
	}
}
