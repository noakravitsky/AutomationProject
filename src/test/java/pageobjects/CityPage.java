package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CityPage extends HomePage {

	@FindBy(css = "h2.destination-description__heading")
	private WebElement cityPageTitle;
	// Recommended trips
	@FindBy(css = ".destination-page-nav__list a:nth-child(1)")
	private WebElement recommendedTripsBtn;
	@FindBy(css = "div.destination-cta-banner__button-body")
	private WebElement startPlanningBtn;
	@FindBy(css = "div.destination-cta-banner__image")
	private WebElement tripsBanner;
	@FindBy(css = "h1.trip2-hero__title")
	private WebElement cityTripTitle;
	// Top places
	@FindBy(css = ".destination-page-nav__list a:nth-child(2)")
	private WebElement topPlacesBtn;
	@FindBy(css = "h3.places__title")
	private WebElement topPlacesTitle;
	@FindBy(css = "div.poi-card2")
	private List<WebElement> placesList;
	@FindBy(css = ".poi-page__title")
	private WebElement placeTitle;
	// Daily routes
	@FindBy(css = ".destination-page-nav__list a:nth-child(3)")
	private WebElement dailyRoutesBtn;
	@FindBy(css = "h3.destination-routes__title")
	private WebElement routesTitle;
	@FindBy(css = ".destination-cta-card__button .btn-blue")
	private WebElement createTripBtn;
	// Experiences
	@FindBy(css = ".destination-page-nav__list a:nth-child(4)")
	private WebElement experiencesBtn;
	@FindBy(css = "h3.destination-attractions__title")
	private WebElement experiencesTitle;
	@FindBy(css = "div.attraction-card__content")
	private List<WebElement> attractionList;
	@FindBy(css = ".header-logo.fill-blue")
	private WebElement attractionsLogo;

	public CityPage(WebDriver driver) {
		super(driver);
	}

	// Go to the trip page by click of a button start planning
	public void goToTripPage() {
		click(recommendedTripsBtn);
		waitForVisibilityOf(startPlanningBtn);
		waitForClickable(startPlanningBtn);
		waiting(2000);
		click(startPlanningBtn);
		waitForVisibilityOf(cityTripTitle);
	}

	public void returnCityPage() {
		driver.navigate().back();
		waitForVisibilityOf(cityPageTitle);
	}

	// Opening a place page from a list of Top places
	public void openTopPlace() {
		waitForClickable(topPlacesBtn);
		click(topPlacesBtn);
		waitForVisibilityOf(topPlacesTitle);
		waiting(2000);
		waitForClickable(placesList.get(2));
		click(placesList.get(2));
		moveToNewWindow();
		waitForVisibilityOf(placeTitle);
	}

	// Validation to place page
	public boolean isPlacePage() {
		return validitionByEl(placeTitle);
	}

	// Go to the trip page by click of a button create trip
	public void openDailyRoutes() {
		driver.navigate().refresh();
		waiting(2000);
		click(dailyRoutesBtn);
		waitForVisibilityOf(routesTitle);
		waiting(2000);
		waitForClickable(createTripBtn);
		click(createTripBtn);
		moveToNewWindow();
		waitForVisibilityOf(cityTripTitle);
	}

	// Opening an attraction page from a list of attractions
	public void openExperiences() {
		driver.navigate().refresh();
		waiting(2000);
		click(experiencesBtn);
		waitForVisibilityOf(experiencesTitle);
		waiting(2000);
		click(attractionList.get(1));
		moveToNewWindow();
		waitForVisibilityOf(attractionsLogo);
	}

	// Validation to attraction page
	public boolean isAttractionPage() {
		return validitionByEl(attractionsLogo);
	}

}
