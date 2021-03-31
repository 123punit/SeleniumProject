package com.carwale.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carwale.geneicutilities.BasePage;
import com.carwale.geneicutilities.Xls_Reader;

public class HyundaiVenuePage extends BasePage {
	@FindBy(xpath = "(//a/span[text() = 'Home'])[2]")
	private WebElement goToHomePage;

	public HyundaiVenuePage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void storeHyundaiPriceVersions() {
		try {

			String beforeXpath_versions = " (//div[@id='root']//tr[";
			String afterXpath_versions = "]/td[1])[2]";

			String beforeXpath_price = "(//div[@id='root']//tr[";
			String afterXpath_price = "]/td[2])[1]";

			Xls_Reader reader = new Xls_Reader("/Users/Sunit/eclipse-workspace/CarWale/Inputdata/SUV_Details.xlsx");

			if (!reader.isSheetExist("HyundaiVenue")) {
				reader.addSheet("HyundaiVenue");

				reader.addColumn("HyundaiVenue", "VersionsOfVehicle");
				reader.addColumn("HyundaiVenue", "PriceOfVehicles");
			}

			for (int i = 2; i <= 4; i++) {
				String acutalXpath_versions = beforeXpath_versions + i + afterXpath_versions;
				String versionsOfVehicle = driver.findElement(By.xpath(acutalXpath_versions)).getText();
				logger.info(versionsOfVehicle);

				reader.setCellData("HyundaiVenue", "VersionsOfVehicle", i, versionsOfVehicle);

				String actualXpath_price = beforeXpath_price + i + afterXpath_price;
				String priceOfVehicles = driver.findElement(By.xpath(actualXpath_price)).getText();
				logger.info(priceOfVehicles);

				reader.setCellData("HyundaiVenue", "PriceOfVehicles", i, priceOfVehicles);
			}

		}

		catch (Exception e) {
			logger.error("unable to store the valur and versions of HyundaiVehicle : " + e);

		}

	}

	public void goToHomePage() {
		try {
			Thread.sleep(1000);
			if (goToHomePage.isDisplayed()) {
				verifyElementPresent(goToHomePage);
				mouseHover(goToHomePage);
				logger.info("Successfully able to find HomePageLink :" + goToHomePage.getText());
				goToHomePage.click();

				logger.info("Successfully able to click on Homepage :" + driver.getCurrentUrl() + driver.getTitle());
			}

		} catch (Exception e) {
			logger.error("unable to naviggate on HomePage : " + e);
		}

	}

}
