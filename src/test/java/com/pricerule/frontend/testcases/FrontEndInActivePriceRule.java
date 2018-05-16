package com.pricerule.frontend.testcases;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.frontend.qa.modules.InventoryForm;
import com.izmo.qa.factory.BrowserFactory;
import com.izmo.qa.factory.DataproviderFactory;
import com.izmo.qa.util.ExtentReporterNG;
import com.izmo.qa.util.Helper;


public class FrontEndInActivePriceRule extends ExtentReporterNG {

	WebDriver driver;

	@Test(priority = 19)
	public void expiredPriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Expired Price Rule");
		logger.assignCategory("Expired and InActive PriceRules");
		driver = DataproviderFactory.browser().browserName();;
		logger.log(Status.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 2, 0));
		logger.log(Status.INFO, "Opening Front End URL");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.citroenExpiredpriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Calling priceRuleMethod");
		Helper.captureScreenshot(driver, "Expired Price value not Captured Front End");
		logger.log(Status.PASS, "Expired price Rule Value Should not Capture for  respective  vehicles");
		BrowserFactory.closeBrowser(driver);

	}
	

	@Test(priority = 20)
	public void inActivePriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Inactive Price rule for Renault Dealer ");
		logger.assignCategory("Expired and InActive PriceRules");
		driver = DataproviderFactory.browser().browserName();
		logger.log(Status.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 1, 0));
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.inactivepriceRuleValue();
		logger.log(Status.INFO, "Calling priceRuleMethod");
		Helper.captureScreenshot(driver, "InActive Price Value not Captured in Front End");
		logger.log(Status.PASS, "InActive price Rule Value Not Capture for  respective  vehicles");
		BrowserFactory.closeBrowser(driver);
	}

	@Test(priority = 21)
	public void withoutIsPrimary() throws ClassNotFoundException, SQLException {
		logger = report.createTest("PriceRule is not applying Without isPrimary");
		logger.assignCategory("Expired and InActive PriceRules");
		driver = DataproviderFactory.browser().browserName();
		logger.log(Status.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 3, 0));
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.withousIsPrimary();
		// driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Helper.captureScreenshot(driver, "Price Rule is not Applying without isPrimary");
		logger.log(Status.PASS, "Price Rule is not Applying without isPrimary");
		BrowserFactory.closeBrowser(driver);
	}
	
	@Test(priority = 22)
	public void deletedPriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Deleted Price Rule for Citroen Dealer");
		logger.assignCategory("Expired and InActive PriceRules");
		driver = DataproviderFactory.browser().browserName();
		logger.log(Status.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 2, 0));
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.deletecitroenpriceRuleValue();
		Helper.captureScreenshot(driver, "Deleted Price Value not Captured in Front End");
		logger.log(Status.PASS, "Deleted price Rule Value Not Capture for  respective  vehicles");
		BrowserFactory.closeBrowser(driver);
	}
	
	
	
}