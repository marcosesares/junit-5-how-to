package br.edu.mcesar.pages.login;

import static br.edu.mcesar.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class LoginPO extends BasePO {

	@FindBy(css = "input[placeholder='Name']")
	WebElement nameTextField;
	
	@FindBy(css = "input[placeholder='Email']")
	WebElement emailTextField;

	@FindBy(css = "input[placeholder='Password']")
	WebElement passwordTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//button[normalize-space()='New User? Register here!']")
	WebElement signUpLink;
	
	private static LoginPO instance;

	protected LoginPO() {
		super();
		PageFactory.initElements(getDriver(), this);
	}

	public static LoginPO getInstance() {
		return instance == null ? instance = new LoginPO() : instance;
	}

}
