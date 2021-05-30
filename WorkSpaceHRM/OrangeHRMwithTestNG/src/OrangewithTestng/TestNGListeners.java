package OrangewithTestng;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	public static WebDriver oBrowser;
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("The test is starting: "+ result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("The test was succesfully executed: "+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("The test was FAILED	: "+ result.getName());
		OrangewithTestng.getScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("The test is started succesfully : "+ context.getName());
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("The test is finished: "+ context.getName());
	}
	


}
