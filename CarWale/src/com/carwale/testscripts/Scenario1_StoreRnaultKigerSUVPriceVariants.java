package com.carwale.testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.carwale.geneicutilities.BaseTest;
import com.carwale.pompages.CompactSUVPage;
import com.carwale.pompages.FindNewCarPage;
import com.carwale.pompages.HomePage;
import com.carwale.pompages.HyundaiVenuePage;
import com.carwale.pompages.RenaultKigerPage;

public class Scenario1_StoreRnaultKigerSUVPriceVariants extends BaseTest {

	HomePage hp = null;
	FindNewCarPage fncp = null;
	CompactSUVPage csuvp = null;
	RenaultKigerPage rkp = null;
	HyundaiVenuePage hvp = null;

	@Test
	public void TC_01_NavigatetoHomePage() {
		try {

			hp = new HomePage(driver);
			fncp = new FindNewCarPage(driver);
			csuvp = new CompactSUVPage(driver);
			rkp = new RenaultKigerPage(driver);
			hvp = new HyundaiVenuePage(driver);

			hp.hoverOnFindNewCar();
			String name = driver.getTitle();
			Reporter.log("You are Succesfully Navigate to :" + name);
			fncp.scrollToBodyType();
			fncp.clickToCompactSUV();
			String title = driver.getTitle();
			Reporter.log("You are Navigate to :" + title);
			csuvp.clicktoRenaultKiger();
			String text = driver.getTitle();
			Reporter.log("You are on RenaultKiger Page : " + text);
			/*
			 * rkp.captureSUVPrice(); rkp.captureSUVModel();
			 */
			/* rkp.scrollToViewMoreOpt(); */
			rkp.storeRenaultKigerPriceVerions();
			rkp.goToPrevoiusPage();
			csuvp.clickToHyundaiVenue();
			hvp.storeHyundaiPriceVersions();
			rkp.goToPrevoiusPage();
			hvp.goToHomePage();

			Reporter.log("Scenario 01 passed: ", true);

		} catch (Exception e) {
			Reporter.log("Scenario 01 - failed " + e);
		}
	}
}
