package automationTestCaseAssig;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		FileInputStream fis=new FileInputStream("./testdata/register.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");

		driver.get(url);
		String title = driver.getTitle();
		System.out.println(title);

		if(title.contains("Automation Exercise")) {
			System.out.println("home page is visible successfully");
		}
		else {
			System.out.println("home page is not visible");
		}
		driver.findElement(By.partialLinkText("Products")).click();
		
		String currentUrl1 = driver.getCurrentUrl();
		System.out.println(currentUrl1);
		if(currentUrl1.contains("products")) {
			System.out.println("ALL PRODUCTS page successfully");
		}
		else {
			System.out.println("ALL PRODUCTS page is not displayed");
		}
		driver.findElement(By.id("search_product")).sendKeys("Blue Top");
		driver.findElement(By.id("submit_search")).click();
		String currentUrl2 = driver.getCurrentUrl();
		System.out.println(currentUrl2);
		
		String text2 = driver.findElement(By.xpath("(//p[text()='Blue Top'])[1]")).getText();
		System.out.println(text2);
	}

}
