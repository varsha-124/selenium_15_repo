package webdriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnNavTo {

	public static void main(String[] args) throws InterruptedException, MalformedURLException{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://www.redbus.in/");
		//driver.navigate().to("https://www.redbus.in/");
		
		driver.navigate().to(new URL("https://www.redbus.in/"));
	 
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();

	

	}

}
