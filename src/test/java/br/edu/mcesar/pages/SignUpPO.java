package br.edu.mcesar.pages;

import static br.edu.mcesar.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import br.edu.mcesar.core.BasePO;

public class SignUpPO extends BasePO {

	@FindBy(css = "input[placeholder='Confirm Password']")
	WebElement confirmPasswordTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Register']")
	WebElement registerButton;
	
	@FindBy(xpath = "//button[normalize-space()='Already registered? Login here!']")
	WebElement loginLink;
	
	public SignUpPO() {
		PageFactory.initElements(getDriver(), this);
	}

}
