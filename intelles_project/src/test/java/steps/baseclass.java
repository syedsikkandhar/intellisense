package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.qameta.allure.Attachment;



public class baseclass 
{
	public static final ThreadLocal<RemoteWebDriver> remotewebdriver = new ThreadLocal<RemoteWebDriver>();
	
	
	public void setDriver()
	{
		remotewebdriver.set(new ChromeDriver());
	}
	public RemoteWebDriver getDriver()
	{
		return remotewebdriver.get();
	}
	

	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] getByteScreenshot()
	{
	    //return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
		return (byte[]) ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
/*
		
		File screenshotAs = getDriver().getScreenshotAs(OutputType.FILE);
		byte[] readFileToByteArray = null;
		try
		{
			readFileToByteArray = FileUtils.readFileToByteArray(screenshotAs);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return readFileToByteArray;
		
		*/
	}

}
