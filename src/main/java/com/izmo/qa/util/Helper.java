package com.izmo.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper

{
	//public static DateFormat dateformat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		String datename = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = "F:\\IZMO FrameWork\\com.izomweb.com\\Screenshots\\" +screenshotName  + 
				datename+  ".png";
		
		
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshots" + e.getMessage());
		}

		return destination;
	}
	
	/*public static String generateFileName(ITestResult result){
		Date date=new Date();
		String fileName=result.getName()+ "_" + dateformat.format(date);
		return fileName;
	}*/
	
	
	public static void WaitFor(long Seconds)
	{
		long miliseconds;
		try
		{
			miliseconds=Seconds*1;
			Thread.sleep(miliseconds);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}
