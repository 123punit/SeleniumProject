package com.carwale.geneicutilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements AutoConstant {
	public static WebDriver driver = null;
	public WebDriverWait wait = null;

	@BeforeMethod
	public void launchApplication() {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Implicit Wait
		driver.get(APP_URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.getTitle();
		driver.manage().deleteAllCookies();

	}

	@AfterMethod
	public void closeApplication() {
		driver.quit();
	}

}
