package br.edu.mcesar.core;

import static br.edu.mcesar.core.DriverFactory.getDriver;
import static br.edu.mcesar.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	private TestInfo testInfo;

	@AfterEach
	public void finalized() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File archive = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archive,
				new File("target" + File.separator + "screenshot" + File.separator + testInfo.getDisplayName() + ".jpg"));

		if (Properties.CLOSE_BROWSER) {
			killDriver();
		}
	}

	protected void setTestInfo(TestInfo testInfo) {
		this.testInfo = testInfo;
	}

}
