package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

public class VerifyScrollUpUsingArrowButtonNdScrollDown {

	public static void main(String[] args) throws IOException {
FileInputStream fis=new FileInputStream("./testdata/loginusercorrect.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		String title = driver.getTitle();
		System.out.println(title);

		if(title.contains("Automation Exercise")) {
			System.out.println("home page is visible successfully");
		}
		else {
			System.out.println("home page is not visible");
		}
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		String subscription = driver.findElement(By.xpath("//h2[text()='Subscription']")).getText();
		if(subscription.contains(subscription)) {
			System.out.println("'SUBSCRIPTION' is visible");
		}
		else {
			System.out.println("'SUBSCRIPTION' is not visible");
		}
		
		String scroll="scrollUp";
		WebElement scroll1 = driver.findElement(By.id(""+scroll+""));
		js.executeScript("arguments[0].click()", scroll1);
		
		String fullFledged = driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']")).getText();
		System.out.println(fullFledged+" text is visible on screen");
	}

}
