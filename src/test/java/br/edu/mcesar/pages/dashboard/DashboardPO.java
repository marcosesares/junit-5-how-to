package br.edu.mcesar.pages.dashboard;

import static br.edu.mcesar.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.edu.mcesar.core.BasePO;

public class DashboardPO extends BasePO {

	private static DashboardPO instance;

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	WebElement dashboardSection;

	protected DashboardPO() {
		PageFactory.initElements(getDriver(), this);
	}

	public static DashboardPO getInstance() {
		return instance == null ? instance = new DashboardPO() : instance;
	}

}
