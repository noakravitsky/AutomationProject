package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.NavigationPage;

public class BaseTest {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shichor.co.il/en");
		HomePage hp = new HomePage(driver);
		hp.pressMessageCookies();
	}

	@BeforeClass
	public void setupLogin() {
		NavigationPage np = new NavigationPage(driver);
		np.openLogInWindow();
		LoginPage lp = new LoginPage(driver);
		lp.login("noakrv@gmail.com", "Noakrv123");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
