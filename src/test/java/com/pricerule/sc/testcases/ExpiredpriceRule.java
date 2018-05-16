package com.pricerule.sc.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.database.Database;
import com.izmo.qa.factory.BrowserFactory;
import com.izmo.qa.factory.DataproviderFactory;
import com.izmo.qa.util.ExtentReporterNG;
import com.izmo.qa.util.Helper;
import com.sc.qa.modules.Login;
import com.sc.qa.modules.PriceruleDealer;

public class ExpiredpriceRule extends ExtentReporterNG {
	WebDriver driver;
	Database databse = new Database();

	@Test(priority = 13)
	public void loginSc() {
		logger = report.createTest(("Login SC"));
		logger.assignCategory("Expired and InActive PriceRules");
		driver = DataproviderFactory.browser().browserName();
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getConfig().euroApplicationUrl());
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1", 1, 0),
				DataproviderFactory.getExcel().getData("Sheet1", 1, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Application is up and running");
		logger.log(Status.INFO, "Welcome to site Admin");
		Helper.captureScreenshot(driver, "SuccesFully Login SC");

	}

	@Test(priority = 14)
	public void expiredDatePriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Expired Oem Discount for Citroen Dealer");
		logger.assignCategory("Expired and InActive PriceRules");
		String Query = "select *from inventory_price_rules where level='DLR' and fk_dealer_id=102878 and "
				+ "inv_provider='IZMOVN-PGA-CITROEN' and  status='ACTV'";
		ResultSet data = databse.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}

		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.selectDealer();
		login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 3, 0));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String PriceRuleURl = DataproviderFactory.getExcel().getData("Sheet6", 1, 1);
		String ScUrl = DataproviderFactory.getExcel().getData("Sheet6", 1, 0);
		driver.get(ScUrl + PriceRuleURl + ID);
		logger.log(Status.INFO, "Getting Price Rule ID from DataBase");
		Invt.expiredPriceRule();
		Helper.captureScreenshot(driver, "Expire Tab  Price Rule List BackEnd");
		logger.log(Status.INFO, "Expired Price Rule  appear in 'Inactive and Expired' tab in SC");
		driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));

	}

	@Test(enabled=false)
	//@Test(priority = 15)
	public void inactivePriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("InActive Dealer Discount for Renault Dealer");
		logger.assignCategory("Expired and InActive PriceRules");
		String Query = "select *from inventory_price_rules where level='DLR' and fk_dealer_id=103209 and status='ACTV' ";
		ResultSet data = databse.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1); //
			System.out.println(ID);
		}
		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.selectDealer();
		login.searchDealerRenault((DataproviderFactory.getExcel().getData("Sheet2", 1, 0)));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String PriceRuleURl = DataproviderFactory.getExcel().getData("Sheet6", 1, 1);
		String ScUrl = DataproviderFactory.getExcel().getData("Sheet6", 1, 0);
		logger.log(Status.INFO, "Getting Price Rule ID from DataBase");
		driver.get(ScUrl + PriceRuleURl + ID);
		Invt.inactivePriceRule();
		Helper.captureScreenshot(driver, "Inactive Tab  Price Rule List BackEnd");
		logger.log(Status.INFO, "InActive Price Rule  appear in 'Inactive and Expired' tab in SC");
		driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));
	}

	@Test(enabled=false)
	//@Test(priority = 16)
	public void deletePriceRule() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Delete GreenDiscount for Citroen Dealer");
		logger.assignCategory("Expired and InActive PriceRules");
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectDealer();
		login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 3, 0));
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		logger.log(Status.INFO, "Getting Price Rule ID from DataBase");
		Invt.deletePriceRule();
		Helper.captureScreenshot(driver, "Deleted PriceRule in BackEnd");
		logger.log(Status.INFO, "Deleted Price Rule is not appearing in PriceRuleList");

	}

	@Test(enabled=false)
	//@Test(priority = 17) // Adding Price Rule Without is primary for Citroen Dealer
	public void withouisPrimary() {
		logger = report.createTest("Adding PriceRule  Without is Primary Dealer BackEnd ");
		logger.assignCategory("Expired and InActive PriceRules");
		Login login = PageFactory.initElements(driver, Login.class);
		PriceruleDealer Invt = PageFactory.initElements(driver, PriceruleDealer.class);
		login.selectDealer();
		login.searchDealerCitroen(DataproviderFactory.getExcel().getData("Sheet2", 4, 0));
		Invt.manageInventory();
		Invt.citroentDlrGreenDiscount();
		Helper.captureScreenshot(driver, "Adding PriceRule  Without is Primary Dealer");
		driver.get(DataproviderFactory.getExcel().getData("Sheet5", 1, 0));
	}

	@Test(enabled=false)
	//@Test(priority = 18)
	public void tearDown1() {
		logger = report.createTest("Logout SC ");
		logger.assignCategory("Expired and InActive PriceRules");
		Login login = PageFactory.initElements(driver, Login.class);
		login.logOut();
		Helper.captureScreenshot(driver, "Logout SC");
		logger.log(Status.INFO, "Logout the application ");
		BrowserFactory.closeBrowser(driver);
		logger.log(Status.INFO, "Closing the Browser");

	}

}