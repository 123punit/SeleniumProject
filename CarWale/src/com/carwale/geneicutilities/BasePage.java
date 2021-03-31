package com.carwale.geneicutilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	protected WebDriver driver = null;
	public Logger logger = Logger.getLogger(getClass());

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	// boolean verifyElementPresent(WebElement ele)
	public void verifyElementPresent(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, 30);
		try {
			w.until(ExpectedConditions.visibilityOf(ele));
			logger.info("WebElement " + ele + " found");
			// return true;
		} catch (Exception e) {
			// System.out.println(e);
			logger.error("WebElement not found" + e);
			// return false;
		}
	}

	public void verifyElementNotPresent(WebElement ele) {

		try {
			if (!(ele.getText()).contains("4")) {
				logger.info("WebElement " + ele + " not found");
			}

			// return true;
		} catch (Exception e) {
			// System.out.println(e);
			logger.error("WebElement found" + e);
			// return false;
		}
	}

	public void verifyPartialTitle(String expTitle, String partialTitle) {
		WebDriverWait w = new WebDriverWait(driver, 30);
		try {
			w.until(ExpectedConditions.titleContains(partialTitle));
			String actTitle = driver.getTitle();
			Assert.assertEquals(actTitle, expTitle);
			logger.info(actTitle + "and the " + expTitle + " matched ");
		} catch (Exception e) {
			logger.error("Titles didnot match");
		}

	}

	public void verifyActualTitle(String expTitle) {
		WebDriverWait w = new WebDriverWait(driver, 30);
		try {
			w.until(ExpectedConditions.titleContains(expTitle));
			String actTitle = driver.getTitle();
			Assert.assertEquals(actTitle, expTitle);
			logger.info(actTitle + "and the " + expTitle + " matched ");
		} catch (Exception e) {
			logger.error("Titles didnot match");
		}

	}

	public void mouseHover(WebElement mhele) {
		WebDriverWait w = new WebDriverWait(driver, 30);
		try {
			Actions action = new Actions(driver);
			w.until(ExpectedConditions.elementToBeClickable(mhele));
			action.moveToElement(mhele).build().perform();
			logger.info("mousehovered on " + mhele);
		} catch (Exception e) {
			logger.error("unable to mousehover on " + e);
		}
	}

	public void scrollTo(WebElement scrollTo) {
		WebDriverWait w = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			w.until(ExpectedConditions.visibilityOf(scrollTo));

			js.executeScript("arguments[0].scrollIntoView(true);", scrollTo);
			logger.info("Scroll Successfully" + scrollTo);
		} catch (Exception e) {
			logger.error("unable to scroll the element" + e);
		}
	}
}
