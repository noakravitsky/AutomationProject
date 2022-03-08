package pageobjects;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	private String mainWindow;
	private Actions action;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		setAction(new Actions(driver));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	void fillText(WebElement el, String text) {
		highlightElement(el, "green", "yellow");
		el.clear();
		el.sendKeys(text);
	}

	void click(WebElement el) {
		highlightElement(el, "green", "yellow");
		el.click();
	}

	String getText(WebElement el) {
		highlightElement(el, "orange", "orange");
		return el.getText();
	}

	void selectByValue(WebElement el, String value) {
		Select s = new Select(el);
		s.selectByValue(value);
	}

	String getTitle() {
		return driver.getTitle();
	}

	// Alert
	void alertWithMessage(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	void alertOK() {
		driver.switchTo().alert().accept();
	}

	void alertCancel() {
		driver.switchTo().alert().dismiss();
	}

	// Mouse
	void dragAndDrop(WebElement src, WebElement target) {
		highlightElement(src, "yellow", "orange");
		highlightElement(target, "blue", "orange");
		getAction().moveToElement(src).clickAndHold().build().perform();
		waiting(1000);
		getAction().moveToElement(target).release().build().perform();
	}

	void dragAndDropBy(WebElement el, int y, int x) {
		getAction().moveToElement(el).clickAndHold().build().perform();
		waiting(1000);
		getAction().dragAndDropBy(el, y, x).release().build().perform();
	}

	void doubleClick(WebElement el) {
		highlightElement(el, "green", "yellow");
		getAction().doubleClick(el).build().perform();
	}

	void moveToElemnt(WebElement el) {
		highlightElement(el, "green", "yellow");
		getAction().moveToElement(el).click().build().perform();
	}

	// scroll
	public void scrollDown(WebElement element) {
		for (int i = 0; i < element.getLocation().getY(); i += 5) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + i + ")");
		}
	}

	// windows
	void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			System.out.println(win);
			driver.switchTo().window(win);
		}
	}

	void moveToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
		waiting(2000);
	}

	// Wait
	void waitForVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	void waitForInVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	void waitForClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waiting(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Validation

	// Test validation method - test that the element is displayed
	public boolean validitionByEl(WebElement element) {
		boolean actual = element.isDisplayed();
		return actual;
	}

	// Test validation method - Comparison of the text in the element against the
	// desired value
	public boolean validiateByText(WebElement element, String value) {
		if (element.getText().equalsIgnoreCase(value)) {
			return true;
		} else {
			return false;
		}
	}

	// Test validation method - The method takes 2 strings and compares them
	public boolean validiateByGetText(String string1, String string2) {
		if (string1.equalsIgnoreCase(string2)) {
			return true;
		} else {
			return false;
		}
	}

	// Test validation method - Check that the text in the element contains the
	// requested value
	public boolean validiateByTextContain(WebElement element, String value) {
		if (element.getText().contains(value)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	private void highlightElement(WebElement element, String color, String background) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:" + background + "; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

	public JavascriptExecutor getJs() {
		return js;
	}

	public void setJs(JavascriptExecutor js) {
		this.js = js;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

}
