package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DestinationsPage extends NavigationPage {

	@FindBy(css = ".btn-secondary.destinations-header__btn")
	private WebElement SearchBtn;
	@FindBy(css = ".form-input__input.destinations-header__input")
	private WebElement SearchField;
	@FindBy(css = "#react-autowhatever-1>div:nth-child(2)>ul>li>div>div>span")
	private WebElement resultsField;
	@FindBy(css = "h1.destination-description__title")
	private WebElement destinationTitle;
	@FindBy(css = "h2.destination-description__heading")
	private WebElement cityTitle;
	@FindBy(css = ".destinations-page-list li")
	private List<WebElement> citiesList;
	@FindBy(css = ".form-error")
	private WebElement errorMsg;
	@FindBy(css = "div.destinations-page__no-results-message")
	private WebElement notFindMsg;
	// Services buttons
	@FindBy(css = ".destinations-page-services li:nth-child(5) a")
	private WebElement attractionsBtn;
	@FindBy(css = ".header-logo")
	private WebElement attractionsSiteLogo;
	@FindBy(css = ".destinations-page-services li:nth-child(4) a")
	private WebElement flightsBtn;
	@FindBy(css = ".destinations-page-services li:nth-child(3) a")
	private WebElement hotelsBtn;
	@FindBy(css = ".destinations-page-services li:nth-child(2) a")
	private WebElement insuranceBtn;
	@FindBy(css = ".destinations-page-services li:nth-child(1) a")
	private WebElement carBtn;

	public DestinationsPage(WebDriver driver) {
		super(driver);
	}

	// The method is for searching with incorrect data
	public void search(String characters) {
		waitForClickable(SearchField);
		doubleClick(SearchField);
		SearchField.sendKeys(characters);
		click(SearchBtn);
		waiting(2500);
	}

	// Validation for error message
	public String returnError() {
		String actual = errorMsg.getText();
		return actual;
	}

	// Validation for notification that there are no results
	public boolean notFindResult() {
		return validitionByEl(notFindMsg);
	}

	// Search destination by some of the letters of the destination
	public void searchByLetters(String letters) {
		waitForClickable(SearchField);
		doubleClick(SearchField);
		SearchField.sendKeys(letters);
		waitForClickable(resultsField);
		click(resultsField);
		waiting(3000);
	}

	// Validation
	public String returnTitle() {
		String actual = destinationTitle.getText();
		return actual;
	}

	// Select a city from a list of destinations in the country
	public void selectCity(String city) {
		waiting(3000);
		for (WebElement el : citiesList) {
			if (el.getText().contains(city)) {
				waitForClickable(el);
				click(el);
				break;
			}
		}
		waiting(3000);
	}

	// Validation
	public String returnCityTitle() {
		String actual = cityTitle.getText();
		return actual;
	}

	// Services buttons - Go to the service web site by clicking on the service
	public void openAttractions() {
		waitForClickable(attractionsBtn);
		click(attractionsBtn);
		moveToNewWindow();
	}

	public void openFlights() {
		waitForClickable(flightsBtn);
		click(flightsBtn);
		moveToNewWindow();
	}

	public void openHotels() {
		waitForClickable(hotelsBtn);
		click(hotelsBtn);
		moveToNewWindow();
	}

	public void openInsurance() {
		waitForClickable(insuranceBtn);
		click(insuranceBtn);
		moveToNewWindow();
	}

	public void openCars() {
		waitForClickable(carBtn);
		click(carBtn);
		moveToNewWindow();
	}

	// Validation
	public boolean validateTiltle(String titleContains) {
		if (driver.getTitle().contains(titleContains)) {
			return true;
		}
		return false;
	}

}
