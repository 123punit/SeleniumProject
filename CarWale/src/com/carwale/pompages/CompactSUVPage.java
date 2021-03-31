package com.carwale.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carwale.geneicutilities.BasePage;

public class CompactSUVPage extends BasePage {
	@FindBy(xpath = "//span[text() = 'Renault Kiger']")
	private WebElement CarRenaultKiger;

	@FindBy(xpath = "//span[text() = 'Hyundai Venue']")
	private WebElement CarHyundaiVenue;

	public CompactSUVPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clicktoRenaultKiger() {
		try {
			Thread.sleep(1000);
			verifyElementPresent(CarRenaultKiger);
			driver.getTitle();
			driver.getCurrentUrl();
			if (CarRenaultKiger.isDisplayed()) {
				CarRenaultKiger.click();
				logger.info("Successfully click on the element :" + CarRenaultKiger.getText());
			}
		} catch (Exception e) {
			logger.error("Element is not clickable to RnaultKiger :" + e);
		}

	}

	public void clickToHyundaiVenue() {
		try {
			Thread.sleep(1000);
			verifyElementPresent(CarHyundaiVenue);
			if (CarHyundaiVenue.isDisplayed()) {
				mouseHover(CarHyundaiVenue);
				CarHyundaiVenue.click();
				logger.info("Successfully click on the element :" + CarHyundaiVenue.getText());
				logger.info("We are on Compact SUC Page : " + driver.getCurrentUrl());
			}
		} catch (Exception e) {
			logger.error("Element is not clickable to HyundaiVenue :" + e);
		}
	}

}
