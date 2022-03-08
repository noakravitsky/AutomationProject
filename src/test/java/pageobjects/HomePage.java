package pageobjects;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends NavigationPage {

	@FindBy(css = ".btn-secondary.cookies-policy-banner__button.btn")
	private WebElement gotItBtn;
	// Area bar - Start planning + Destination suggestion
	// Common elements
	@FindBy(css = ".hero-dates-form__value>div")
	private WebElement choosedatesFiled;
	@FindBy(css = ".search-dates-menu__controls >button")
	private WebElement flexibleDatesBtn;
	@FindBy(css = ".rs-select2__indicator.rs-select2__loading-indicator")
	private WebElement indicatorImg;
	// Start planning bar
	@FindBy(css = ".hero-desktop__tabs > button:nth-child(1)")
	private WebElement startPlanningBtn;
	@FindBy(css = "[id='search-bar.to']")
	private WebElement destinationFiled;
	@FindBy(css = ".home-hero-place-option")
	private List<WebElement> destinationsResultList;
	@FindBy(css = ".rs-select2__clear-indicator")
	private WebElement xbutton;
	@FindBy(css = ".rs-select2__menu-notice")
	private WebElement noOptionsResult;
	@FindBy(css = "[type='submit']")
	private WebElement planTripBtn;
	@FindBy(css = ".Toastify__toast-container")
	private WebElement errorDatesMsg;
	@FindBy(css = ".Toastify__close-button svg path")
	private WebElement errorXBtn;
	@FindBy(css = "h1.trip2-hero__title")
	private WebElement tripTitle;
	// Destination suggestion bar
	@FindBy(css = ".hero-desktop__tabs > button:nth-child(2)")
	private WebElement destinationSuggestionBtn;
	@FindBy(css = ".hero-desktop__field:nth-child(1) div div .value")
	private WebElement purposeBtn;
	@FindBy(css = ".search-purpose__list>li")
	private List<WebElement> purposeList;
	@FindBy(css = ".hero-desktop__field:nth-child(5) div div .value")
	private WebElement interestsBtn;
	@FindBy(css = ".hero-interests__item")
	private List<WebElement> interestsList;
	@FindBy(css = "[type='submit']")
	private WebElement searchBtn;
	@FindBy(css = "h1.go-go-page__title")
	private WebElement searchResultsTitle;
	// Search results page
	@FindBy(css = "a.trip-card-link")
	private List<WebElement> tripCardsList;
	// Area of 4 destinations recommended
	@FindBy(css = ".home-destination-card a")
	private List<WebElement> recDestinationsList;
	@FindBy(css = "h2.destination-description__heading")
	private WebElement destinationTitle;
	// Go to the Bank Leumi website
	@FindBy(css = ".home-loan__button a")
	private WebElement takeloanBtn;
	@FindBy(css = ".logo img")
	private WebElement logoLeumiSite;
	// Area of articles
	@FindBy(css = ".home-articles__list a")
	private List<WebElement> articleslist;
	@FindBy(css = "h1.article-page__title")
	private WebElement pageArticleTitle;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// If a cookie message is displayed, press on the got it button
	// This method is part of the base test
	public void pressMessageCookies() {
		if (gotItBtn.isDisplayed()) {
			click(gotItBtn);
		}
	}

	// Start planning bar
	// Open start planning bar
	public void openStartPlanningBar() {
		click(startPlanningBtn);
	}

	// Search for a destination by writing search letters
	public void searchDestination(String search) {
		click(destinationFiled);
		fillText(destinationFiled, search);
		waitForInVisibilityOf(indicatorImg);
	}

	// Select a destination from a list of results
	public void selectFromResult() {
		waitForVisibilityOf(destinationsResultList.get(0));
		click(destinationsResultList.get(0));
		destinationFiled.submit();
	}

	// Validation that displays text - no options
	public boolean isNoOptionsResult() {
		return validiateByText(noOptionsResult, "No options");
	}

	// Validation that an error message is displayed
	public boolean isMessageErrorDisplayed() {
		return validitionByEl(errorDatesMsg);
	}

	// If an error message is displayed - press the X to close it
	public void closeErrorMessage() {
		if (errorDatesMsg.isDisplayed()) {
			waitForInVisibilityOf(errorDatesMsg);
		}
	}

	// Pressing the X button to delete the selected destination
	public void deleteSelectedDestination() {
		click(destinationFiled);
		click(xbutton);
	}

	// Validation that an empty destination field
	public boolean isEmptyDestinationField() {
		return validiateByText(destinationFiled, "");
	}

	// Choose dates to trip by flexible dates button
	public void chooseDates() {
		click(choosedatesFiled);
		click(flexibleDatesBtn);
	}

	public void pressPlanTrip() {
		click(planTripBtn);
		waitForVisibilityOf(tripTitle);
	}

	// Validation
	public boolean isTripPage(String value) {
		return validiateByTextContain(tripTitle, value);
	}

	// Destination suggestion
	// Open destination suggestion bar
	public void openSuggestionBar() {
		click(destinationSuggestionBtn);
	}

	// Choose purpose
	public void choosePurpose(String purpose) {
		click(purposeBtn);
		for (WebElement el : purposeList) {
			if (el.getText().equalsIgnoreCase(purpose)) {
				click(el);
			}
		}
	}

	// Set interests by numbers - integer
	public void setInterests(int galler, int attract, int show, int gastro, int shop, int night, int rec, int sport) {
		List<Integer> list = Arrays.asList(galler, attract, show, gastro, shop, night, rec, sport);
		int counter = 0;
		click(interestsBtn);
		for (WebElement el : interestsList) {
			dragAndDropBy(el.findElement(By.cssSelector(".rc-slider")), list.get(counter), 0);
			counter++;
		}
	}

	public void pressSearch() {
		click(searchBtn);
		waitForVisibilityOf(searchResultsTitle);
	}

	// Validation
	public String isSearchResultsPage() {
		return searchResultsTitle.getText();
	}

	// Select a destination from a list of search results page
	public void selectFromResultsPage() {
		click(tripCardsList.get(2));
		waitForVisibilityOf(tripTitle);
	}

	// Select a destination from a list of recommended destinations
	public void selectRecDestination() {
		waitForClickable(recDestinationsList.get(1));
		click(recDestinationsList.get(1));
	}

	// Click on the Take a Loan button and go to the Bank Leumi website
	public void takeLoan() {
		waitForClickable(takeloanBtn);
		click(takeloanBtn);
		moveToNewWindow();
		waitForVisibilityOf(logoLeumiSite);
	}

	// Validation
	public boolean isLeumiPage() {
		return validitionByEl(logoLeumiSite);
	}

	// Open Article
	public void viewArticle() {
		articleslist.get(0).click();
		waitForVisibilityOf(pageArticleTitle);
	}

	// Validation
	public boolean isArticlePage() {
		return validitionByEl(pageArticleTitle);
	}

}
