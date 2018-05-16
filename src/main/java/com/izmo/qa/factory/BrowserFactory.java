package com.izmo.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory

{
	static WebDriver driver;

	private static String browser = DataproviderFactory.getConfig().browserName();
	// public static WebDriver getBrowser(String browserName) {

	public WebDriver browserName() {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", DataproviderFactory.getConfig().getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", DataproviderFactory.getConfig().getChromePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			options.addArguments("--test-type");
			options.addArguments("--ignore-certificate-errors");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.edge.driver", DataproviderFactory.getConfig().getIePath());
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeBrowser(WebDriver ldriver) {
		ldriver.quit();
	}
}
