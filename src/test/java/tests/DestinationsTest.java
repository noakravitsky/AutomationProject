package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.DestinationsPage;
import pageobjects.NavigationPage;

public class DestinationsTest extends BaseTest {

	@Test(description = "Clicking Search without value - returns an error")
	public void tc01_searchWithoutValue() {
		NavigationPage np = new NavigationPage(driver);
		np.openDestinationsPage();
		DestinationsPage dp = new DestinationsPage(driver);
		dp.search("");
		String actual = dp.returnError();
		String expected = "Required";
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Search with only one letter - return an error")
	public void tc02_incorrectSearch() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.search("a");
		String actual = dp.returnError();
		String expected = "Required 2 or more symbols to search";
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Search by numbers - will not find destinations")
	public void tc03_searcNumbers() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.search("123");
		Assert.assertTrue(dp.notFindResult());
	}

	@Test(description = "Search destination by some of the letters of the country")
	public void tc04_searchDestination() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.searchByLetters("it");
		String actual = dp.returnTitle();
		Assert.assertEquals(actual, "Italy");
	}

	@Test(description = "Select a destination from a list of popular destinations")
	public void tc05_selectDestinationFromPopularList() {
		NavigationPage np = new NavigationPage(driver);
		np.openDestinationsPage();
		DestinationsPage dp = new DestinationsPage(driver);
		dp.selectCity("Budapest");
		String actual = dp.returnCityTitle();
		Assert.assertEquals(actual, "Explore Budapest");
	}

	@Test(description = "Go to the attractions page in a new window and back to the main window")
	public void tc06_openAttractions() {
		NavigationPage np = new NavigationPage(driver);
		np.openDestinationsPage();
		DestinationsPage dp = new DestinationsPage(driver);
		dp.openAttractions();
		Assert.assertTrue(dp.validateTiltle("Attractions"));
		dp.bachToMainPage();
	}

	@Test(description = "Go to the flights page in a new window and back to the main window")
	public void tc07_openFlights() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.openFlights();
		Assert.assertTrue(dp.validateTiltle("Flights"));
		dp.bachToMainPage();
	}

	@Test(description = "Go to the hotels page in a new window and back to the main window")
	public void tc08_openHotels() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.openHotels();
		Assert.assertTrue(dp.validateTiltle("Booking"));
		dp.bachToMainPage();
	}

	@Test(description = "Go to the insurance page in a new window and back to the main window")
	public void tc09_openInsurance() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.openInsurance();
		Assert.assertTrue(dp.validateTiltle("מגדל"));
		dp.bachToMainPage();
	}

	@Test(description = "Go to the car rental page in a new window and back to the main window")
	public void tc10_openCars() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.openCars();
		Assert.assertTrue(dp.validateTiltle("Shichor"));
		dp.bachToMainPage();
		dp.backToHomePage();
	}

}
