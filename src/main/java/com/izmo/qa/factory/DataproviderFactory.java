package com.izmo.qa.factory;

import com.izmo.qa.testdata.ConfigDataProvider;
import com.izmo.qa.testdata.ExcelDataProvider;

public class DataproviderFactory

{
	public static ConfigDataProvider getConfig() {
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
	
	public static BrowserFactory browser(){
		BrowserFactory browser= new BrowserFactory();
		return browser;
	}

	public static ExcelDataProvider getExcel() {
		ExcelDataProvider excel = new ExcelDataProvider("F:\\IZMO FrameWork\\com.izomweb.com\\ApplicationTestData/PriceRule.xlsx");
		return excel;
	}

	public static ExcelDataProvider getScPages() {
		ExcelDataProvider formsxcel = new ExcelDataProvider("F:\\IZMO FrameWork\\com.izomweb.com\\ApplicationTestData/ScPages.xlsx");
		return formsxcel;
	}

}
