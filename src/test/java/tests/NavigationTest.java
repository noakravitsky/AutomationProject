package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.NavigationPage;

public class NavigationTest extends BaseTest {

	@Test(description = "Open destinations Page - displays a list of popular sites")
	public void tc01_openDestination() {
		NavigationPage np = new NavigationPage(driver);
		np.openDestinationsPage();
		Assert.assertTrue(np.isDenstinationsPage());
	}

	@Test(description = "Open My Trips Page - Displays user favorites")
	public void tc02_openMyTrips() {
		NavigationPage np = new NavigationPage(driver);
		np.openMytrips();
		Assert.assertTrue(np.isMyTripsPage());
	}

	@Test(description = "Go to the hotels page and back to the main site")
	public void tc03_openHotelsPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openHotelsPage();
		Assert.assertTrue(np.isHotelsPage());
		np.bachToMainPage();
	}

	@Test(description = "Go to the flights page and back to the main site")
	public void tc04_openFlightsPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openFlightsPage();
		Assert.assertTrue(np.isFlightsPage());
		np.bachToMainPage();
	}

	@Test(description = "Go to the experiences page and back to the main site")
	public void tc05_openExperiencesPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openExperiencesPage();
		Assert.assertTrue(np.isExperiencesPage());
		np.bachToMainPage();
	}

	@Test(description = "Go to the insurance page and back to the main site")
	public void tc06_openInsurancePage() {
		NavigationPage np = new NavigationPage(driver);
		np.openInsurancePage();
		Assert.assertTrue(np.isInsurancePage());
		np.bachToMainPage();
	}

	@Test(description = "Go to the car rental page and back to the main site")
	public void tc07_openCarRenatalPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openCarRentalPage();
		Assert.assertTrue(np.isCarRentalPage());
		np.bachToMainPage();
	}

	@Test(description = "Open about page and click on a link to create a vacation")
	public void tc08_openAboutPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openAboutPage();
		String actual = np.isAboutPage();
		Assert.assertEquals(actual, "About");
		np.createVacationUrl();
		Assert.assertTrue(np.isHomePage());
		np.bachToMainPage();
	}

	@Test(description = "Open contact us and sending a message")
	public void tc09_opencontactUs() {
		NavigationPage np = new NavigationPage(driver);
		np.contactUs("aa@gmail.com", "message test");
		Assert.assertTrue(np.isMsgSent());
		np.bachToMainPage();
	}

	@Test(description = "Select a destination from a list of destinations by categories - the user enters the destination")
	public void tc10_viewDestination() {
		NavigationPage np = new NavigationPage(driver);
		np.viewDestination("Madrid");
		String actual = np.isDestinationPage();
		String expected = "Explore Madrid";
		Assert.assertEquals(actual, expected);
		np.backToHomePage();
	}

}
