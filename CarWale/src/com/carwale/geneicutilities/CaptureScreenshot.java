package com.carwale.geneicutilities;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CaptureScreenshot implements ITestListener {

	public void onTestFailure(ITestResult result) {
		try {
			LocalDateTime now = LocalDateTime.now();
			String methodName = result.getMethod().getMethodName();
			EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
			File src = event.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(".//ScreenShots//" + methodName + ".png"));

		} catch (Exception e) {

		}
	}

}
