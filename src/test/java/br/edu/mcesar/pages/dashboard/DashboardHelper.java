package br.edu.mcesar.pages.dashboard;

import br.edu.mcesar.core.BaseHelper;

public class DashboardHelper extends BaseHelper {

	private static DashboardHelper instance;
	private static DashboardPO po;

	protected DashboardHelper() {
		po = DashboardPO.getInstance();
	}

	public static DashboardHelper getInstance() {
		return instance == null ? instance = new DashboardHelper() : instance;
	}

	public void verifyDashboardSectionDisplayedStatus() {
		verifyDisplayedStatus(po.dashboardSection);;
	}
}
