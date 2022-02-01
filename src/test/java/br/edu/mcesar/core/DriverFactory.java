package br.edu.mcesar.core;

import static br.edu.mcesar.core.CoreConstants.DEFAULT_TIMEOUT_DURATION;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (Properties.browser) {
			case FIREFOX: driver = new FirefoxDriver(); break;
			case CHROME: driver = new ChromeDriver(); break;
			case IE:
				InternetExplorerOptions cap = new InternetExplorerOptions();
				cap.setCapability("nativeEvents", false);
				cap.setCapability("unexpectedAlertBehaviour", "accept");
				cap.setCapability("ignoreProtectedModeSettings", true);
				cap.setCapability("disable-popup-blocking", true);
				cap.setCapability("enablePersistentHover", true);
				cap.setCapability("ignoreZoomSetting", true);
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				cap.setPageLoadTimeout(DEFAULT_TIMEOUT_DURATION);
				cap.requireWindowFocus();
				driver = new InternetExplorerDriver(cap);
				break;
			}
			driver.manage().window().setSize(new Dimension(1280, 800));
		}
		return driver;
	}

	static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
