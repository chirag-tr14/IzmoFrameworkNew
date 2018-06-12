package com.sc.qa.modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.izmo.qa.factory.DataproviderFactory;

public class Pages

{

	WebDriver driver;
	

	public Pages(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//a[text()='Site Builder']")
	WebElement SiteBuilder;

	@FindBy(xpath = "//a[contains(@onclick,'d.s(1)')]")
	WebElement PageBuilder;

	@FindBy(xpath = "//a[@class='submit_btn_gray'][contains(text(),'Add new Page')]")
	WebElement AddPageButton;

	@FindBy(css = "#pageType1")
	WebElement ContentPage;

	@FindBy(css = "#pageType2")
	WebElement IfrmePage;

	@FindBy(css = "#pageType3")
	WebElement CampignPage;

	@FindBy(css = "#pageType5")
	WebElement SpecialPage;

	@FindBy(css = "#pageType6")
	WebElement AboutusPage;

	@FindBy(css = "#pageType6")
	WebElement PrivacyPage;

	@FindBy(css = "#pageType8")
	WebElement RssPage;

	@FindBy(css = "input[id*='pageTitle'][name^='pageTitle']")
	WebElement Title;

	@FindBy(css = "input[id^='pageUrl'][name*='pageUrl']")
	WebElement Url;

	@FindBy(css = "select[id*='pageDepartments'][name^='pageDepartments']")
	WebElement Departments;

	@FindBy(xpath = "//iframe[@id='idContent_editorobj1']")
	WebElement ResponsiveContent;

	@FindBy(xpath = "//select[@name='formCategoryId'][@id='formCategoryId']")
	WebElement FormCategory;

	@FindBy(xpath = "//input[@value='BelowCampaignImage']")
	WebElement FormPosition;

	@FindBy(xpath = "//html/body[1]")
	WebElement EditorBody;

	@FindBy(xpath = "//input[@value='Save Page and Close']")
	WebElement SavePage;

	public void pageBuidler() {
		SiteBuilder.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageBuilder.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		AddPageButton.click();
	}

	public void contentPage() {
		ContentPage.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Title.sendKeys(DataproviderFactory.getScPages().getData("TestData", 2, 0));
		Url.sendKeys(DataproviderFactory.getScPages().getData("TestData", 2, 1));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select Deaprtment = new Select(Departments);
		Deaprtment.selectByVisibleText(DataproviderFactory.getScPages().getData("TestData", 2, 2));
		driver.switchTo().frame("idContent_editorobj1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		EditorBody.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		EditorBody.sendKeys(DataproviderFactory.getScPages().getData("TestData", 2, 3));
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SavePage.click();
	}

	public void campaignPage() {
		CampignPage.click();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Title.sendKeys(DataproviderFactory.getScPages().getData("TestData", 5, 0));
		Url.sendKeys(DataproviderFactory.getScPages().getData("TestData", 5, 1));
		
		Select Deaprtment = new Select(Departments);
		Deaprtment.selectByVisibleText(DataproviderFactory.getScPages().getData("TestData", 5, 2));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("formCategoryId")));
		Select category = new Select(FormCategory);
		category.selectByVisibleText(DataproviderFactory.getScPages().getData("TestData", 5, 3));
		FormPosition.click();
		driver.switchTo().frame("idContent_editorobj1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		EditorBody.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		EditorBody.sendKeys(DataproviderFactory.getScPages().getData("TestData", 5, 4));
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SavePage.click();
	}

	public void specialPage() {
		SpecialPage.click();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Title.sendKeys(DataproviderFactory.getScPages().getData("TestData", 8, 0));
		Url.sendKeys(DataproviderFactory.getScPages().getData("TestData", 8, 1));
		Select Deaprtment = new Select(Departments);
		Deaprtment.selectByVisibleText(DataproviderFactory.getScPages().getData("TestData", 8, 2));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='formCategoryId'][@id='formCategoryId']")));
		Select category = new Select(FormCategory);
		category.selectByVisibleText(DataproviderFactory.getScPages().getData("TestData", 8, 3));
		SavePage.click();
	}

	public void aboutUsPage() {
		AboutusPage.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Title.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 5, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Url.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 5, 2));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select dropdown = new Select(driver.findElement(By.cssSelector("Deaprtments")));
		dropdown.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet1", 5, 3));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ResponsiveContent.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 5, 4));
		SavePage.click();
	}

	public void privacyPage() {
		PrivacyPage.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Title.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 10, 1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Url.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 10, 2));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select dropdown = new Select(driver.findElement(By.cssSelector("Deaprtments")));
		dropdown.selectByVisibleText(DataproviderFactory.getExcel().getData("Sheet1", 10, 3));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ResponsiveContent.sendKeys(DataproviderFactory.getExcel().getData("Sheet1", 10, 4));
		SavePage.click();
	}

}
