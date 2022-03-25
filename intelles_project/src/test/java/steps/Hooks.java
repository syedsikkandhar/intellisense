package steps;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class Hooks extends baseclass
{

	@AfterStep
	@Attachment(value = "Screenshot", type = "image/png")
	public void afterStep(Scenario scenario)
	{
		scenario.log("After Hook");
		Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
	
	}
}
	