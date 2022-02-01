package br.edu.mcesar.core.logger;

import static br.edu.mcesar.core.DriverFactory.getDriver;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class StepLogger {

	public static Logger logger;
	static Integer id;
	static Integer testCaseId;
	static Long testStart;
	static String stepIdVar = "";
	static String logMessages = "";
	static Boolean eachStepScreenshot = 
			System.getenv("EACH_STEP_SCREENSHOT") != null ? Boolean.valueOf(System.getenv("EACH_STEP_SCREENSHOT")) : true;

	public StepLogger() {
	}

	public static void setCaseId(Integer theCaseId) {
		testCaseId = theCaseId;
		logger = LogManager.getLogger("C" + theCaseId);
		logger.debug(logMessages);
		id = 1;
		logMessages = "";
		testStart = new Date().getTime();
	}

	public static void step(String stepName) {
		String operation = "Pre-Condition";
		if (testCaseId != null) {
			operation = "Step";
		}

		commonLogger(operation, stepName);

		if (eachStepScreenshot) {
			takeScreenShot("Step: " + stepName);
		}
	}

	public static void stepId(Integer optionalId) {
		id = optionalId != null ? optionalId : id + 1;
		commonLogger("Step Id", id.toString());
	}

	public static void verification(String verificationDescription) {
		commonLogger("Verification", verificationDescription);

		if (eachStepScreenshot) {
			takeScreenShot("Verification: " + verificationDescription);
		}
	}

	public static void preCondition(String preConditionDescription) {
		commonLogger("Pre-Condition", preConditionDescription);
	}

	public static void postCondition(String postConditionDescription) {
		commonLogger("Post-Condition", postConditionDescription);
	}
	
	public static void subStep(String stepName) {
		commonLogger("Sub-Step", stepName);
		if (eachStepScreenshot) {
			takeScreenShot("Sub-step: " + stepName);
		}
	}

	public static void subVerification(String verificationDescription) {
		commonLogger("Sub-Verification", verificationDescription);
	}

	@Attachment(value = "{0}", type = "image/png")
	public static byte[] takeScreenShot(String attachmentName) {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	public static void commonLogger(String operation, String step) {
		String message = stepIdVar + "- *" + operation + "* - " + step;
		if (testStart != null) {
			Long passed = new Date().getTime() - testStart;
			message = " +" + passed / 1000 + "s " + message;
		}
		if (logger != null) {
			logger.debug(message);
		} else {
			logMessages += message+"\n";
		}
	}

	public static void feature(String featureName) {
		Allure.feature(featureName);
	}
}
