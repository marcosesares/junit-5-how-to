package br.edu.mcesar.core;

import static br.edu.mcesar.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;

public class BaseHelper {

	private static String PAGE_URL = "https://my-money-app-mocha.vercel.app";
	private static BaseHelper instance;
	private BasePO po;

	protected BaseHelper() {
		po = BasePO.getInstance();
	}

	public static BaseHelper getInstance() {
		return instance == null ? instance = new BaseHelper() : instance;
	}

	public void openMyMoneyApp() {
		getDriver().get(PAGE_URL);
	}

	public void verifyDisplayedStatus(WebElement targetElement) {
		ExpectationHelper.verifyDisplayedStatus(targetElement);
	}

	public void verifyAppLogoDisplayedStatus() {
		verifyDisplayedStatus(po.appLogo);;
	}
	
}