package com.pricerule.frontend.testcases;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.frontend.qa.modules.InventoryForm;
import com.izmo.qa.factory.BrowserFactory;
import com.izmo.qa.factory.DataproviderFactory;
import com.izmo.qa.util.ExtentReporterNG;
import com.izmo.qa.util.Helper;

public class FrontEndCitroenDealerPriceRule extends ExtentReporterNG {
	private WebDriver driver;
	private InventoryForm form;

	@BeforeMethod
	public void citroenpriceRuleDlr() {
		logger = report.createTest("Navigate to Citroen Dlr New Inventory Page");
		logger.assignCategory("Adding New PriceRules");
		driver = DataproviderFactory.browser().browserName();
		logger.log(Status.INFO, "BrowserLaunch");
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getExcel().getData("Sheet4", 2, 0));
		form = PageFactory.initElements(driver, InventoryForm.class);
		logger.log(Status.INFO, "Navigate to Citroen Dlr New Inventory Page");
		Helper.captureScreenshot(driver, "Citroen Dealer New Inventory Page");

		/*
		 * List<WebElement> links = driver.findElements(By.tagName("a"));
		 * System.out.println("Total links are " + links.size()); int counter =
		 * 1; for (int i = 0; i < links.size(); i++) {
		 * 
		 * WebElement ele = links.get(i); String url = ele.getAttribute("href");
		 * if (!BrokenLinks.verifyLinkActive(url)) {
		 * DataproviderFactory.setExcel().setCellData("Sheet3", 1, counter,
		 * url); counter++;
		 * 
		 * }
		 * 
		 * }
		 */

	}

	@Test(priority = 7)
	public void withPriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Applied OEM and Green Discount");
		logger.assignCategory("Adding New PriceRules");
		form.citroenpriceRuleValue();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Calling priceRuleMethod");
		logger.log(Status.PASS, "OEM and Green Discount Values Applied for Citroen Make");
		Helper.captureScreenshot(driver, "OEM and Green Discount Values Applied for Citroen Make");
		BrowserFactory.closeBrowser(driver);
		logger.log(Status.INFO, "Closing Browsers");

	}

}