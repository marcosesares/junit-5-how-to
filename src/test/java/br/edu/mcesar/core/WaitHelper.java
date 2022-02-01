package br.edu.mcesar.core;

import static br.edu.mcesar.core.CoreConstants.DEFAULT_TIMEOUT;
import static br.edu.mcesar.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	private WaitHelper() {
	}

	private static final Duration TIMEOUT = Duration.ofMillis(DEFAULT_TIMEOUT.getValor());

	public static WebElement waitForElementToBeDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

}
