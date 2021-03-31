package com.carwale.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.carwale.geneicutilities.BasePage;
import com.carwale.geneicutilities.Xls_Reader;

public class RenaultKigerPage extends BasePage {

	public RenaultKigerPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void storeRenaultKigerPriceVerions() throws InterruptedException {
		Thread.sleep(1000);

		String beforeXpath_versions = " (//div[@id='root']//tr[";
		String afterXpath_versions = "]/td[1])[2]";

		String beforeXpath_price = "(//div[@id='root']//tr[";
		String afterXpath_price = "]/td[2])[1]";

		Xls_Reader reader = new Xls_Reader("/Users/Sunit/eclipse-workspace/CarWale/Inputdata/SUV_Details.xlsx");

		if (!reader.isSheetExist("RenaultKiger")) {
			reader.addSheet("RenaultKiger");

			reader.addColumn("RenaultKiger", "VersionsOfVehicle");
			reader.addColumn("RenaultKiger", "PriceOfVehicles");
		}

		for (int i = 2; i <= 4; i++) {
			String acutalXpath_versions = beforeXpath_versions + i + afterXpath_versions;
			String versionsOfVehicle = driver.findElement(By.xpath(acutalXpath_versions)).getText();
			logger.info(versionsOfVehicle);

			reader.setCellData("RenaultKiger", "VersionsOfVehicle", i, versionsOfVehicle);

			String actualXpath_price = beforeXpath_price + i + afterXpath_price;
			String priceOfVehicles = driver.findElement(By.xpath(actualXpath_price)).getText();
			logger.info(priceOfVehicles);

			reader.setCellData("RenaultKiger", "PriceOfVehicles", i, priceOfVehicles);

		}
		logger.info("Current Page Title is :" + driver.getTitle());
	}

	public void goToPrevoiusPage() {
		try {
			driver.navigate().back();
			logger.info("Current Page url is :" + driver.getCurrentUrl());
			logger.info("Curent Page title is :" + driver.getTitle());
		} catch (Exception e) {
			logger.error("unable to naviggate on previous Page : " + e);
		}
	}
}
