package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class HomePageTest extends BaseTest {

	@Test(description = "Negative Scenario - Search without selecting dates")
	public void tc01_planTripWitoutDates() {
		HomePage hp = new HomePage(driver);
		hp.openStartPlanningBar();
		hp.searchDestination("lon");
		hp.selectFromResult();
		Assert.assertTrue(hp.isMessageErrorDisplayed());
		hp.deleteSelectedDestination();
		Assert.assertTrue(hp.isEmptyDestinationField());
		hp.closeErrorMessage();
	}

	@Test(description = "Negative scenario - Search by numbers - no results")
	public void tc02_planTripWithoutDestination() {
		HomePage hp = new HomePage(driver);
		hp.openStartPlanningBar();
		hp.chooseDates();
		hp.searchDestination("123");
		Assert.assertTrue(hp.isNoOptionsResult());
	}

	@Test(description = "Plan a trip - start plannig bar")
	public void tc03_planTrip() {
		HomePage hp = new HomePage(driver);
		hp.openStartPlanningBar();
		hp.chooseDates();
		hp.searchDestination("lon");
		hp.selectFromResult();
		hp.pressPlanTrip();
		Assert.assertTrue(hp.isTripPage("London"));
		hp.backToHomePage();
	}

	@Test(description = "Search destination - destination suggestion bar")
	public void tc04_searchDestination() {
		HomePage hp = new HomePage(driver);
		hp.openSuggestionBar();
		hp.choosePurpose("Family trip");
		hp.chooseDates();
		hp.setInterests(50, 85, 20, 30, 70, -40, -20, 0);
		hp.pressSearch();
		String actual = hp.isSearchResultsPage();
		Assert.assertEquals(actual, "Search results");
		hp.backToHomePage();
	}

	@Test(description = "Search in the destination suggestion bar without search parameters")
	public void tc05_searchWithoutParameters() {
		HomePage hp = new HomePage(driver);
		hp.openSuggestionBar();
		hp.pressSearch();
		String actual = hp.isSearchResultsPage();
		Assert.assertEquals(actual, "Search results");
	}

	// A sequel scenario to the previous scenario
	@Test(description = "Select a destination from a search results page")
	public void tc06_selectFromResults() {
		HomePage hp = new HomePage(driver);
		hp.selectFromResultsPage();
		Assert.assertTrue(hp.isTripPage("Special trip for you"));
	}

	@Test(description = "Select from recommended sites")
	public void tc07_selectRecDestination() {
		HomePage hp = new HomePage(driver);
		hp.selectRecDestination();
	}

	@Test(description = "Click on the Take a Loan button and go to the Leumi website")
	public void tc08_takeLoan() {
		HomePage hp = new HomePage(driver);
		hp.takeLoan();
		Assert.assertTrue(hp.isLeumiPage());
		hp.bachToMainPage();
	}

	@Test(description = "View the article from the list of articles")
	public void tc09_viewArticle() {
		HomePage hp = new HomePage(driver);
		hp.viewArticle();
		Assert.assertTrue(hp.isArticlePage());
	}

}
