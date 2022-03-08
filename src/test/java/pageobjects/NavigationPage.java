package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage {

	// Navigator - Top
	@FindBy(css = ".nav-right__user button")
	private WebElement signInBtn;
	@FindBy(css = ".form-submit.btn")
	private WebElement logInBtn;
	@FindBy(css = ".app-header__logo")
	private WebElement logoBtn;
	@FindBy(css = "h1.hero-desktop__title")
	private WebElement homePageTitle;
	// Destinations
	@FindBy(css = ".app-header__desktop >nav > div >a:nth-child(1)")
	private WebElement destinationsBtn;
	@FindBy(css = ".form-input__input.react-autosuggest__input")
	private WebElement SearchField;
	// My trips
	@FindBy(css = ".app-header__desktop >nav > div >a:nth-child(2)")
	private WebElement myTripsBtn;
	@FindBy(css = "div .loader__spinner img")
	private WebElement loaderImg;;
	@FindBy(css = ".react-tabs__tab-list li:nth-child(1)")
	private WebElement myTripsTab;
	// Services
	@FindBy(css = ".app-header__desktop > nav > div > div > span")
	private WebElement servicesBtn;
	@FindBy(css = ".app-header__desktop > nav > div > div > div > div > div > a:nth-child(1) > div")
	private WebElement hotelsBtn;
	@FindBy(css = ".-streamline-booking_logo_dark_bg_mono")
	private WebElement bookingIcon;
	@FindBy(css = ".app-header__desktop > nav > div > div > div > div > div > a:nth-child(2) > div")
	private WebElement flightsBtn;
	@FindBy(css = ".FullWidthPageTitlestyled__Title-sc-baj8m7-1")
	private WebElement flightPageTitle;
	@FindBy(css = ".app-header__desktop > nav > div > div > div > div > div > a:nth-child(3) > div")
	private WebElement experiencesBtn;
	@FindBy(css = ".logo__W3p1")
	private WebElement viatorIcon;
	@FindBy(css = ".app-header__desktop > nav > div > div > div > div > div > a:nth-child(4) > div")
	private WebElement insuranceBtn;
	@FindBy(css = ".top-banner a img")
	private WebElement migdalBanner;
	@FindBy(css = ".app-header__desktop > nav > div > div > div > div > div > a:nth-child(5) > div")
	private WebElement carRentalBtn;
	@FindBy(css = ".country_tooltip")
	private WebElement carRentalTitle;
	// Navigator - Bottom
	// About us
	@FindBy(css = "div:nth-child(1) > div > ul > li:nth-child(4) > a")
	private WebElement aboutUsBtn;
	@FindBy(css = ".flat-page__title")
	private WebElement aboutPageTitle;
	@FindBy(css = "p:nth-child(9) > a")
	private WebElement createVacationUrl;
	// Contact us
	@FindBy(css = " div:nth-child(1) > .footer-list ul > li:nth-child(5) > a")
	private WebElement contactUsBtn;
	@FindBy(css = ".contact-us-form__title")
	private WebElement contactUstitle;
	@FindBy(css = "#from_email")
	private WebElement mailField;
	@FindBy(css = "#text")
	private WebElement messageField;
	@FindBy(css = ".btn-secondary")
	private WebElement submitBtn;
	@FindBy(css = ".Toastify__toast-body")
	private WebElement successMsg;
	// Destinations
	@FindBy(css = ".footer__destinations ul li a")
	private List<WebElement> destinationslist;
	@FindBy(css = ".destination-description h2")
	private WebElement pageDestinationTitle;

	public NavigationPage(WebDriver driver) {
		super(driver);
	}

	// Navigator - Top
	public void openLogInWindow() {
		click(signInBtn);
		waitForVisibilityOf(logInBtn);
	}

	// Click on the site logo and return to the home page from anywhere
	public void backToHomePage() {
		click(logoBtn);
		waitForVisibilityOf(homePageTitle);
	}

	// General method for returning to the main page
	public void bachToMainPage() {
		moveToMainWindow();
	}

	// Open destinations page
	public void openDestinationsPage() {
		click(destinationsBtn);
		waitForVisibilityOf(SearchField);
	}

	// Validation to destinations page
	public boolean isDenstinationsPage() {
		return validitionByEl(SearchField);
	}

	// Open my trips page
	public void openMytrips() {
		click(myTripsBtn);
		waitForInVisibilityOf(loaderImg);
		waitForVisibilityOf(myTripsTab);
	}

	// Validation to my trips page
	public boolean isMyTripsPage() {
		return validitionByEl(myTripsTab);
	}

	// Open hotels page
	public void openHotelsPage() {
		click(servicesBtn);
		click(hotelsBtn);
		moveToNewWindow();
		waitForVisibilityOf(bookingIcon);
	}

	// Validation to hotels page
	public boolean isHotelsPage() {
		return validitionByEl(bookingIcon);
	}

	// Open flights page
	public void openFlightsPage() {
		click(servicesBtn);
		click(flightsBtn);
		moveToNewWindow();
		waitForVisibilityOf(flightPageTitle);
	}

	// Validation to flights page
	public boolean isFlightsPage() {
		return validitionByEl(flightPageTitle);
	}

	// Open experiences page
	public void openExperiencesPage() {
		click(servicesBtn);
		click(experiencesBtn);
		moveToNewWindow();
		waitForVisibilityOf(viatorIcon);
	}

	// Validation to experiences page
	public boolean isExperiencesPage() {
		return validitionByEl(viatorIcon);
	}

	// Open insurance page
	public void openInsurancePage() {
		click(servicesBtn);
		click(insuranceBtn);
		moveToNewWindow();
		waitForVisibilityOf(migdalBanner);
	}

	// Validation to insurance page
	public boolean isInsurancePage() {
		return validitionByEl(migdalBanner);
	}

	// Open car rental page
	public void openCarRentalPage() {
		click(servicesBtn);
		click(carRentalBtn);
		moveToNewWindow();
		waitForVisibilityOf(carRentalTitle);
	}

	// Validation to car rental page
	public boolean isCarRentalPage() {
		return validitionByEl(carRentalTitle);
	}

	// Navigator - Bottom
	// About Us page
	public void openAboutPage() {
		waitForClickable(aboutUsBtn);
		click(aboutUsBtn);
		moveToNewWindow();
		waitForVisibilityOf(aboutPageTitle);
	}

	// Validation to about page
	public String isAboutPage() {
		return aboutPageTitle.getText();
	}

	// Click on - Create a vacation URL - Go to the home page
	public void createVacationUrl() {
		click(createVacationUrl);
		waitForVisibilityOf(homePageTitle);
	}

	// Validation to home page
	public boolean isHomePage() {
		return validitionByEl(homePageTitle);
	}

	// Contact us
	public void contactUs(String mail, String message) {
		waitForClickable(contactUsBtn);
		click(contactUsBtn);
		moveToNewWindow();
		waitForVisibilityOf(contactUstitle);
		fillText(mailField, mail);
		fillText(messageField, message);
		click(submitBtn);
		waitForVisibilityOf(successMsg);
	}

	// Validation that the message was sent
	public boolean isMsgSent() {
		String expected = "Message has been sent";
		if (validiateByText(successMsg, expected)) {
		}
		return true;
	}

	// Select a destination from a list of destinations by categories
	public void viewDestination(String city) {
		for (WebElement el : destinationslist) {
			if (el.getText().equals(city)) {
				waiting(2000);
				waitForClickable(el);
				moveToElemnt(el);
				waitForClickable(el);
			}
		}
		waitForVisibilityOf(pageDestinationTitle);
	}

	// Validation to destination page
	public String isDestinationPage() {
		String actual = pageDestinationTitle.getText();
		return actual;
	}

}
