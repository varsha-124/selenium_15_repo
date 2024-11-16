package miniproject;

import java.io.File;

import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		String time = LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+time+"demowebsshop.png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("TestScript executed",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("TestScript skipped",true);
	}
	

}
