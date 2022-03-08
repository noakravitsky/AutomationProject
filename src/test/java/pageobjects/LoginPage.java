package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends NavigationPage {

	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = ".form-submit.btn")
	private WebElement logInBtn;
	@FindBy(css = ".button-loader svg use")
	private WebElement loaderImg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String password) {

		fillText(emailField, email);
		fillText(passwordField, password);
		click(logInBtn);
		waitForInVisibilityOf(logInBtn);
	}

}
