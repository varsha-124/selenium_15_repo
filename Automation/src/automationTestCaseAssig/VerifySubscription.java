package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifySubscription {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	

		FileInputStream fis=new FileInputStream("./testdata/subscription.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		String email=prop.getProperty("email");

		driver.get(url);
		String title = driver.getTitle();
		System.out.println(title);

		if(title.contains("Automation Exercise")) {
			System.out.println("home page is visible successfully");
		}
		else {
			System.out.println("home page is not visible");
		}
		
		Actions act=new Actions(driver);
		WebElement subscription = driver.findElement(By.id("susbscribe_email"));
		act.scrollToElement(subscription);
		
		driver.findElement(By.id("susbscribe_email")).sendKeys(email);
		WebElement subscribe = driver.findElement(By.id("subscribe"));
	    subscribe.click();
	    
	    WebElement subscribe1=driver.findElement(By.id("success-subscribe"));
	    System.out.println(subscribe1.getText());

}
}
