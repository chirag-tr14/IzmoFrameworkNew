package com.frontend.pages.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.database.Database;
import com.izmo.qa.factory.BrowserFactory;
import com.izmo.qa.factory.DataproviderFactory;
import com.izmo.qa.util.ExtentReporterNG;
import com.izmo.qa.util.Helper;
public class FrontendPages extends ExtentReporterNG{

	private WebDriver driver;

	@Test(priority = 7)
	public void siteUrl() {
		logger = report.createTest("Navigate to Citroen Dlr HomePage");
		logger.assignCategory("FrontEnd Pages");
		driver = DataproviderFactory.browser().browserName();
		driver.manage().deleteAllCookies();
		driver.get(DataproviderFactory.getScPages().getData("DealersData", 4, 0));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@Test(priority = 8)
	public void contentPage() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Navigate to ContentPage");
		logger.assignCategory("FrontEnd Pages");
		String Query = "select page_url from idw_dealer_webpages where fk_dealer_id=102880 and status='ACTV' and page_type='CONT' "
				+ "and user_added=1737 order by date_added  desc  limit 05 ;";
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String pageurl = "";
		if (firstData) {
			pageurl = data.getString(1);
			// System.out.println(ID);
		}
		driver.get(DataproviderFactory.getScPages().getData("DealersData", 4, 0) + pageurl);
		Helper.WaitFor(100);
		
		logger.log(Status.INFO, "Contetn page   for citeroen dealer");
		Helper.captureScreenshot(driver, "Citroen Dealer ContentPage");
		driver.navigate().back();
	}

	@Test(priority = 9)
	public void campaignPage() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Navigate to CampaignPage");
		logger.assignCategory("FrontEnd Pages");
		String Query = "select page_url from idw_dealer_webpages where fk_dealer_id=102880 and status='ACTV' and page_type='CAMP' "
				+ "and user_added=1737 order by date_added  desc  limit 05 ;";
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String pageurl = "";
		if (firstData) {
			pageurl = data.getString(1);
			// System.out.println(ID);
		}
		driver.get(DataproviderFactory.getScPages().getData("DealersData", 4, 0) + pageurl);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		logger.log(Status.INFO, "Camapign  page   for citeroen dealer");
		Helper.captureScreenshot(driver, "Citroen Dealer CampaignPage");
		driver.navigate().back();
	}

	@Test(priority = 10)
	public void specialPage() throws ClassNotFoundException, SQLException {
		logger = report.createTest("Navigate to SpecialPage");
		logger.assignCategory("FrontEnd Pages");
		String Query = "select page_url from idw_dealer_webpages where fk_dealer_id=102880 and status='ACTV' and page_type='SPEL' "
				+ "and user_added=1737 order by date_added  desc  limit 05 ;";
		ResultSet data = Database.getData(Query);
		boolean firstData = data.next();
		String pageurl = "";
		if (firstData) {
			pageurl = data.getString(1);
			// System.out.println(ID);
		}
		driver.get(DataproviderFactory.getScPages().getData("DealersData", 4, 0) + pageurl);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		logger.log(Status.INFO, "Special page   for citeroen dealer");
		Helper.captureScreenshot(driver, "Citroen Dealer SpecialPage");
		driver.navigate().back();
	}
	
	@Test(priority=11)
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}
}