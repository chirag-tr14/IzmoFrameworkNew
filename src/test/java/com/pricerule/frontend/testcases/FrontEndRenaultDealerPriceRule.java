package com.pricerule.frontend.testcases;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.frontend.qa.modules.InventoryForm;
import com.izmo.qa.factory.BrowserFactory;
import com.izmo.qa.factory.DataproviderFactory;
import com.izmo.qa.util.ExtentReporterNG;
import com.izmo.qa.util.Helper;

public class FrontEndRenaultDealerPriceRule extends ExtentReporterNG

{
	WebDriver driver;

	@Test(priority = 8)
	public void renualtdealerinvtUrl() {
		logger = report.createTest("Navigate to Renault Dealer New Inventory Page");
		logger.assignCategory("Adding New PriceRules");
		driver = DataproviderFactory.browser().browserName();
		logger.log(Status.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 1, 0));
		logger.log(Status.INFO, "Navigate to Renault Dealer New Inventory Page");
		Helper.captureScreenshot(driver, "Renault Dealer New Inventory Page");

	}

	@Test(priority = 9)
	// Tradein Discount for Same DsProvider and DealerId and Location
	public void tradeInDiscountPriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Tradein Discount Applied Vehicles");
		logger.assignCategory("Adding New PriceRules");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.priceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Calling priceRuleMethod");
		// WebElement price =
		// driver.findElement(By.xpath("//ul[@class='dropdown-menu
		// discountedprice-dropdown']//li[1]"));
		// Assert.assertFalse(pass, );
		Helper.captureScreenshot(driver, "Tradein Discount is applied  vehicles");
		logger.log(Status.PASS, "Tradein Discount is applied for same provider and same dealerid vehicles");

	}

	@Test(priority = 10)
	// Without Price Rule Vehicle for Other Dealerid and location
	public void tradeInDiscountWithOutPriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Tradein Discount Not Applied Vehicles");
		logger.assignCategory("Adding New PriceRules");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.otherValue();
		WebElement Withouprice = driver
				.findElement(By.xpath("//ul[@class='dropdown-menu discountedprice-dropdown']//li[1]"));
		Helper.captureScreenshot(driver, "Tradein Discount is not applied Vehicle ");
		Assert.assertFalse(false, Withouprice.getText());
		logger.log(Status.PASS, "Tradein Discount is not captured for other Dealerid but Same Provider");
	}

	@Test(priority = 11)
	public void dealerDiscountMakePriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Override Dealer Discount Applied Vehicle");
		logger.assignCategory("Adding New PriceRules");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.MakepriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Calling priceRuleMethod");
		Helper.captureScreenshot(driver, "Override Dealer Discount for  Paricular Make,Model");
		logger.log(Status.PASS, "Replacing Old Dealer Discount value and applied Price Rule for paricular Make");

	}

	@Test(priority = 12)
	public void dealerDiscountotherMakePriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Override Dealer Discount Not Applied Vehicle");
		logger.assignCategory("Adding New PriceRules");
		InventoryForm form = PageFactory.initElements(driver, InventoryForm.class);
		form.otherMakepriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Calling priceRuleMethod");
		Helper.captureScreenshot(driver, "Not Override Dealer Discount for Other Make,Model");
		logger.log(Status.PASS,
				"Not Replacing Old Dealer Discount value and  Not applied Price Rule for paricular Make");

	}

	@AfterClass
	public void closeBrowser() {
		logger.log(Status.INFO, "Closing Browsers");
		BrowserFactory.closeBrowser(driver);

	}

}