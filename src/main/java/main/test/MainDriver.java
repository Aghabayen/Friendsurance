package main.test;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import main.test.TestConstants.TestData;

public class MainDriver extends Base {
	//to intilize the web driver

	public static WebDriver driver = null;
	public static WebDriverWait waitobj = null;
	public static WebDriverWait mobwaitobj = null;
	public static JavascriptExecutor executor = null;
	public static Actions action = null;

	@BeforeClass
	public static WebDriver setupDriver() throws IOException {

		if (TestData.BROWSER.equals("safri")) {
			driver = new SafariDriver();
			driver.manage().window().maximize();

			waitobj = new WebDriverWait(driver, 50);
			executor = (JavascriptExecutor) driver;
			action = new Actions(driver);

		} else if (TestData.BROWSER.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("disable-gpu");
			options.addArguments("window-size=1200,1100");

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new RemoteWebDriver(new URL("http://chrome-dirver:4444/wd/hub"), cap);

			waitobj = new WebDriverWait(driver, 50);
			executor = (JavascriptExecutor) driver;
			action = new Actions(driver);
			
		} else if (TestData.BROWSER.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "path for FF driver");

			driver = new FirefoxDriver();
			waitobj = new WebDriverWait(driver, 50);
			executor = (JavascriptExecutor) driver;
			action = new Actions(driver);
		}

		return driver;

	}

	@AfterClass
	public void calledAfterTestSuite() {

		System.out.println("close browser");
		driver.close();
		driver = null;

	}
}
