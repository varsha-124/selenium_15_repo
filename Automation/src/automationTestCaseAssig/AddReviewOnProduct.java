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
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddReviewOnProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

		FileInputStream fis=new FileInputStream("./testdata/register.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		driver.get(url);
		
		driver.findElement(By.partialLinkText("Products")).click();
		
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("https://automationexercise.com/products")) {
			System.out.println("navigated to ALL PRODUCTS page successfully");
		}
		else {
			System.out.println("Not navigated to ALL PRODUCTS page");
		}
		String blueTop="Blue Top";
		String viewProduct="View Product";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//p[text()='"+blueTop+"'])[1]/../../..//a[text()='"+viewProduct+"']"));
		js.executeScript("arguments[0].click()", element);
		
		driver.findElement(By.id("name")).sendKeys("Juhi");
		driver.findElement(By.id("email")).sendKeys("juhi.kumari151996@gmail.com");
		driver.findElement(By.xpath("//textarea[@placeholder='Add Review Here!']")).sendKeys("Good Products");
		driver.findElement(By.id("button-review")).submit();
		
		Thread.sleep(1000);
		WebElement review = driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]"));
		System.out.println(review.getText());


	}

}
