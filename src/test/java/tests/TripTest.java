package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TripPage;

public class TripTest extends BaseTest {

	@Test(description = "Save trip")
	public void tc01_saveTrip() {
		TripPage tp = new TripPage(driver);
		tp.openSuggestionBar();
		tp.pressSearch();
		tp.saveTrip();
		Assert.assertTrue(tp.isSaveTripMessage());
	}

}
