package br.edu.mcesar.core;

import static br.edu.mcesar.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePO {
	
	@FindBy(css = ".login-logo")
	WebElement appLogo;
	
	@FindBy(css = ".login-box-msg")
	WebElement loginBoxMsg;
	
	private static BasePO instance;

	protected BasePO() {
		super();
		PageFactory.initElements(getDriver(), this);
	}

	public static BasePO getInstance() {
		return instance == null ? instance = new BasePO() : instance;
	}

}
