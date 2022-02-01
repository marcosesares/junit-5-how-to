package br.edu.mcesar.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.edu.mcesar.core.BaseTest;
import br.edu.mcesar.core.logger.StepLogger;
import br.edu.mcesar.pages.dashboard.DashboardHelper;
import br.edu.mcesar.pages.login.LoginHelper;
import br.edu.mcesar.pages.models.User;
import io.qameta.allure.Feature;

@TestInstance(Lifecycle.PER_CLASS)
public class LoginTest extends BaseTest {

	private User user;
	private LoginHelper loginHelper;
	private DashboardHelper dashboardHelper;

	public LoginTest() {
		loginHelper = LoginHelper.getInstance();
		dashboardHelper = DashboardHelper.getInstance();
		user = new User("Marcos Cesar", "marcosesares@gmail.com", "a2@MyMoney211");
	}

	@BeforeAll
	public void initialize() {
		StepLogger.preCondition("Navigate to My Money App.");
		loginHelper.openMyMoneyApp();
		loginHelper.verifyAppLogoDisplayedStatus();
	}

	@Test
	@Feature("LoginTest")
	public void loginTest(TestInfo testInfo) throws InterruptedException {
		setTestInfo(testInfo);
		StepLogger.setCaseId(1001);
		StepLogger.stepId(1);
		StepLogger.step("Login to My Money App.");
		loginHelper.enterLoginInformation(user);
		StepLogger.verification("Verify Dashboard is displayed.");
		dashboardHelper.verifyDashboardSectionDisplayedStatus();
	}
}
