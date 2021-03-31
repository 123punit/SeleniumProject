package com.carwale.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carwale.geneicutilities.BasePage;

public class FindNewCarPage extends BasePage {

	@FindBy(xpath = "//span[.='BODY TYPE']")
	private WebElement txt_BodyType;

	@FindBy(xpath = "//div/a[@href='/new/best-compact-suvs-in-india/']")
	private WebElement txt_CompactSUV;

	public FindNewCarPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void scrollToBodyType() {
		try {

			verifyElementPresent(txt_BodyType);
			mouseHover(txt_BodyType);
			if (txt_BodyType.isDisplayed()) {
				txt_BodyType.click();
				logger.info("Element is successfully ScrollTo on BodyType");
			}

			Thread.sleep(5000);
		} catch (Exception e) {
			logger.error("unable to scroll the element" + e);
		}
	}

	public void clickToCompactSUV() {
		try {
			if (txt_BodyType.isEnabled()) {
				verifyElementPresent(txt_CompactSUV);
				mouseHover(txt_CompactSUV);
				txt_CompactSUV.click();
				driver.getCurrentUrl();
				driver.getTitle();
				logger.info("Successfully click on CompactSUV");
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			logger.error("unable to click on CompactSUV" + e);
		}
	}

}
