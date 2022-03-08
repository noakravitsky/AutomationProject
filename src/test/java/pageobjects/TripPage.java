package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripPage extends HomePage {

	// Save trip
	@FindBy(css = ".trip2-hero__button button")
	private WebElement saveTripBtn;
	@FindBy(css = ".toaster__title")
	private WebElement successMsg;
	// Editorial routes
	@FindBy(css = "div.trip-route")
	private List<WebElement> routesList;
	@FindBy(css = "div.poi-list-card")
	private List<WebElement> poiList;
	@FindBy(css = "button.trip-route-details-list__back-btn")
	private WebElement backBtn;
	@FindBy(css = "a.poi-map-card")
	private WebElement poiImg;
	@FindBy(css = ".mapboxgl-marker  div img")
	private List<WebElement> iconMapList;
	@FindBy(css = ".poi-page__title")
	private WebElement siteTitle;
	// Top places
	@FindBy(css = "div.poi-card2")
	private List<WebElement> placesList;
	// Search results page
	
	
	public TripPage(WebDriver driver) {
		super(driver);
	}
	
	public void saveTrip() {
		waitForVisibilityOf(saveTripBtn);
		click(saveTripBtn);
		waitForVisibilityOf(successMsg);
	}

	// Validation that success message is displayed
	public boolean isSaveTripMessage() {
		return validitionByEl(successMsg);
	}

	// Editorial routes
	// View the route and its sites on the map
	public void viewRoute() {
		waitForClickable(routesList.get(1).findElement(By.cssSelector("div .trip-route__button")));
		click(routesList.get(1).findElement(By.cssSelector("div .trip-route__button")));
		waitForVisibilityOf(backBtn);
		for (WebElement el : poiList) {
			waitForClickable(el);
			click(el);
			waitForVisibilityOf(poiImg);
			click(backBtn);
		}
	}

	// Enter to site page by clicking on its icon on the map
	public void goToSitePage() {
		waitForClickable(routesList.get(0));
		click(routesList.get(0));
		waitForClickable(iconMapList.get(2));
		click(iconMapList.get(2));
		waitForVisibilityOf(poiImg);
		click(poiImg);
		moveToNewWindow();
		waitForVisibilityOf(siteTitle);
		moveToMainWindow();
	}
	
	public void goPlacePage() {
		waitForClickable(placesList.get(1));
		click(placesList.get(1));
		moveToNewWindow();
		waitForVisibilityOf(siteTitle);
		moveToMainWindow();
	}

}
