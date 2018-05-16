package com.pricerule.sc.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.izmo.qa.factory.BrowserFactory;
import com.izmo.qa.factory.DataproviderFactory;
import com.izmo.qa.util.ExtentReporterNG;
import com.izmo.qa.util.Helper;
import com.sc.qa.modules.Login;
import com.sc.qa.modules.PriceruleDealer;


public class AddingpriceRuleDlr extends ExtentReporterNG

{
	
	WebDriver driver;
	 Login login;
	private PriceruleDealer Invt;

	@Test(priority = 1)
	public void loginSc() throws IOException {
		logger = report.createTest("Login SC");
		logger.assignCategory("Adding New PriceRules");
		driver = DataproviderFactory.browser().browserName();
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getConfig().euroApplicationUrl());
		login = PageFactory.initElements(driver, Login.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Application is up and running");
		logger.log(Status.INFO, "Welcome to site Admin");
		String Actual = "https://qadealeradminv2fr.izmocars.com/dashboard.htm";
		String Expected = driver.getCurrentUrl();
		Assert.assertEquals(Actual, Expected);
		Helper.captureScreenshot(driver, "SuccessFully Login SC");

	}

	@Test(priority = 2)
	public void tradeinDiscount() {
		logger = report.createTest("Adding Tradein Discount");
		logger.assignCategory("Adding New PriceRules");
		login = PageFactory.initElements(driver, Login.class);
		Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		login.selectDealer();
		login.searchDealerRenault(DataproviderFactory.getExcel().getData("Sheet2", 1, 0));
		logger.log(Status.INFO, "Passed Dealer Name");
		Invt.manageInventory();
		Invt.renaultDlrTradeinDiscount();
		Helper.captureScreenshot(driver, "SuccesFully Added Trade in Discount");
	}

	@Test(priority = 3)
	public void dealerDiscount() {
		logger = report.createTest("Adding Dealer Discount");
		logger.assignCategory("Adding New PriceRules");
		Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		Invt.manageInventory();
		String priceUrl = driver.getTitle();
		Assert.assertTrue(priceUrl.contains(priceUrl));
		logger.log(Status.INFO, "Calling AddPrice Rule Method");
		Invt.renaultDlrDealerDiscount();
		Helper.captureScreenshot(driver, "SuccesFully Added Dealer Discount");
		driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));

	}

	@Test(priority = 4)
	public void oemDiscount(){ 
		logger = report.createTest("Adding OEM Discount"); 
		logger.assignCategory("Adding New PriceRules");
		Login  login = PageFactory.initElements(driver, Login.class);
		Invt = PageFactory.initElements(driver, PriceruleDealer.class); // Selecting Dealer
        login.selectDealer(); 
        logger.log(Status.INFO,"Clicking Select Organization Button");
        login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 3,0));
        logger.log(Status.INFO, "Passed Dealer Name"); // Calling
        Invt.manageInventory(); logger.log(Status.INFO,"Calling AddPrice Rule Method");
        Invt.citroentDlrOemDiscount();
        Helper.captureScreenshot(driver, "SuccesFully Added Oem Discount");
  
  }

	@Test(priority = 5)
	public void greenDiscount() {
		logger = report.createTest("Adding Green Discount");
		logger.assignCategory("Adding New PriceRules");
		Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		Invt.manageInventory();
		String priceUrl = driver.getTitle();
		Assert.assertTrue(priceUrl.contains(priceUrl));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Calling AddPrice Rule Method");
		Invt.citroentDlrGreenDiscount();
		Helper.captureScreenshot(driver, "SuccesFully Added Green Discount");
		driver.navigate().to(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));

	}

	@Test(priority = 6) 
	public void tearDown()	{ 
		logger = report.createTest(  "LogOut SC "); 
		logger.assignCategory("Adding New PriceRules"); 
		Login login =  PageFactory.initElements(driver, Login.class); logger.log(Status.INFO,  "Logout the application "); 
		login.logOut(); Helper.captureScreenshot(driver,"SuccesFully Logout SC");
		BrowserFactory.closeBrowser(driver);
        logger.log(Status.INFO, "Closing the Browser");
  
}
}