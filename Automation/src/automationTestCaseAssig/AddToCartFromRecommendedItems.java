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

public class AddToCartFromRecommendedItems {

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
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	String recommItems = driver.findElement(By.xpath("//h2[text()='recommended items']")).getText();
		System.out.println(recommItems+"  are visible");
		
				
				String blueTop="Blue Top";
				String cart1="Add to cart";
				WebElement element0 = driver.findElement(By.xpath("	(//p[text()='"+blueTop+"'])[3]/..//a[text()='Add to cart']"));
				js.executeScript("arguments[0].click()", element0);

				String continueShopping="Continue Shopping";
				WebElement element1 = driver.findElement(By.xpath("//button[contains(text(),'"+continueShopping+"')]"));
				Thread.sleep(2000);
				element1.click();
				
				driver.findElement(By.partialLinkText("Cart")).click();
				String productName=driver.findElement(By.xpath("//a[text()='Blue Top']")).getText();
				System.out.println(productName+" displayed");
	}

}
