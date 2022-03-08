package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CityPage;
import pageobjects.DestinationsPage;

public class CityTest extends BaseTest {

	@Test(description = "Open city page")
	public void tc01_selectDestinationFromPopularList() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.openDestinationsPage();
		dp.selectCity("Budapest");
		String actual = dp.returnCityTitle();
		Assert.assertEquals(actual, "Explore Budapest");
	}

	@Test(description = "Go to the trip page by click of a button start planning")
	public void tc02_openCityTripPage() {
		CityPage cp = new CityPage(driver);
		cp.goToTripPage();
		Assert.assertTrue(cp.isTripPage("trip"));
		cp.returnCityPage();
	}

	@Test(description = "Opening a place page from a list of Top places")
	public void tc03_openTopPlace() {
		CityPage cp = new CityPage(driver);
		cp.openTopPlace();
		Assert.assertTrue(cp.isPlacePage());
		cp.bachToMainPage();
	}

	@Test(description = "Opening an attraction page from a list of attractions")
	public void tc04_openExperiences() {
		CityPage cp = new CityPage(driver);
		cp.openExperiences();
		Assert.assertTrue(cp.isAttractionPage());
		cp.bachToMainPage();
	}

	@Test(description = "Go to the trip page by click of a button create trip")
	public void tc05_openDailyRoutes() {
		CityPage cp = new CityPage(driver);
		cp.openDailyRoutes();
		Assert.assertTrue(cp.isTripPage("trip"));
	}

}
