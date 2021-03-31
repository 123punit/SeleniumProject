package com.carwale.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carwale.geneicutilities.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath = "//li[@class ='_2TEfMi']/div[text() = 'NEW CARS']")
	private WebElement mhNewCar;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void hoverOnFindNewCar() {
		try {
			Thread.sleep(1000);
			verifyElementPresent(mhNewCar);
			mouseHover(mhNewCar);
			/* mhNewCar.click(); */
			String name = driver.getCurrentUrl();
			logger.info("Element is successfully hover on Find New CARS :" + name);
			driver.get("https://www.carwale.com/new-cars/");
		} catch (Exception e) {
			logger.error("unable to hover on Find New CARS :" + e);
		}
	}
}
