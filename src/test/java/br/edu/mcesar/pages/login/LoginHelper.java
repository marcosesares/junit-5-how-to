package br.edu.mcesar.pages.login;

import br.edu.mcesar.core.BaseHelper;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.models.User;

public class LoginHelper extends BaseHelper {

	private static LoginHelper instance;
	private static LoginPO po;

	protected LoginHelper() {
		po = LoginPO.getInstance();
	}

	public static LoginHelper getInstance() {
		return instance == null ? instance = new LoginHelper() : instance;
	}

	public void enterLoginInformation(User user) {
		StepLogger.subStep("Type the user email.");
		po.emailTextField.clear();
		po.emailTextField.sendKeys(user.getEmail());
		StepLogger.subStep("Type the user password.");
		po.passwordTextField.clear();
		po.passwordTextField.sendKeys(user.getPassword());
		StepLogger.subStep("Click the Login Button.");
		po.loginButton.click();
	}

}