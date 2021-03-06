package com.sc.pages.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.izmo.qa.factory.BrowserFactory;
import com.izmo.qa.factory.DataproviderFactory;
import com.izmo.qa.util.ExtentReporterNG;
import com.sc.qa.modules.Login;
import com.sc.qa.modules.Pages;

public class AddPages extends ExtentReporterNG

{
	private WebDriver driver;
	Login login;
	Pages pages;

	@Test(priority = 1)
	public void loginSc() {
		logger = report.createTest("Login SC");
		logger.assignCategory("Adding Pages");
		driver = DataproviderFactory.browser().browserName();
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getConfig().euroApplicationUrl());
		login = PageFactory.initElements(driver, Login.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));
		logger.log(Status.INFO, "Application is up and running");
		logger.log(Status.INFO, "Welcome to site Admin");
		String Actual = "https://qadealeradminv2fr.izmocars.com/dashboard.htm";
		String Expected = driver.getCurrentUrl();
		Assert.assertEquals(Actual, Expected);
		// Helper.captureScreenshot(driver, "SuccessFully Login SC");
	}

	@Test(priority = 2)
	public void contentPageAdd() {
		logger = report.createTest("Content Page Add");
		logger.assignCategory("Adding Pages");
		pages = PageFactory.initElements(driver, Pages.class);
		login.selectDealer();
		login.searchDealerCitroen(DataproviderFactory.getScPages().getData("DealersData", 1, 0));
		pages.pageBuidler();
		pages.contentPage();
	}

	@Test(priority = 3)
	public void campaignPageAdd() throws InterruptedException {
		logger = report.createTest("Campaign Page Add");
		logger.assignCategory("Adding Pages");
		pages = PageFactory.initElements(driver, Pages.class);
		pages.pageBuidler();
		pages.campaignPage();
	}

	@Test(priority = 4)
	public void specialPageAdd() throws InterruptedException {
		logger = report.createTest("Special Page Add");
		logger.assignCategory("Adding Pages");
		pages = PageFactory.initElements(driver, Pages.class);
		pages.pageBuidler();
		pages.specialPage();
	}

	@Test(priority = 5)
	public void aboutusPageAdd() {
		logger = report.createTest("Aboutus Page ");
		logger.assignCategory("Adding Pages");
		pages = PageFactory.initElements(driver, Pages.class);
		pages.pageBuidler();
		pages.aboutUsPage();
		driver.get(DataproviderFactory.getScPages().getData("DealersData", 2, 0));
	}
	
	@Test(priority=6)
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}
	
	
	

}
