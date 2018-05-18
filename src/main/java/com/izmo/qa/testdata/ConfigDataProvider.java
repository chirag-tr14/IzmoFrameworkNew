package com.izmo.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider

{
	Properties prop;

	public ConfigDataProvider() {

		try {

			File src = new File("F:\\IZMO FrameWork\\com.izomweb.com\\Configuration\\config.properties");

			FileInputStream fin = new FileInputStream(src);

			prop = new Properties();

			prop.load(fin);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String euroApplicationUrl() {
		String url = prop.getProperty("EuroUrl");
		return url;
	}

	public String indiaApplicationUrl() {
		String url = prop.getProperty("IndiaUrl");
		return url;
	}

	public String mxApplicationUrl() {
		String url = prop.getProperty("MxUrl");
		return url;
	}

	public String getChromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getIePath() {
		String iepath = prop.getProperty("iepath");
		return iepath;
	}

	// Contactus Form

	public String contactusFormUrl() {
		String curl = prop.getProperty("curl");
		return curl;
	}

	public String FormUrl1() {
		String curl = prop.getProperty("curl");
		return curl;
	}
	
	public String browserName(){
		String browser=prop.getProperty("browserName");
		return browser;
	}

	public String databseUserName(){
		String userName=prop.getProperty("userName");
		return userName;
	}
	
	public String passWord(){
		String passWord=prop.getProperty("passWord");
		return passWord;
	}
	
	
	
	
}