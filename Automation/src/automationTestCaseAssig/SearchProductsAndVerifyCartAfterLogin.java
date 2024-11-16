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

public class SearchProductsAndVerifyCartAfterLogin {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
FileInputStream fis=new FileInputStream("./testdata/loginusercorrect.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String email = prop.getProperty("email");
		String name = prop.getProperty("name");
		String password = prop.getProperty("password");
		
		driver.get(url);
		
		driver.findElement(By.partialLinkText("Products")).click();
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("https://automationexercise.com/products")) {
			System.out.println("navigated to ALL PRODUCTS page successfully");
		}
		else {
			System.out.println("Not navigated to ALL PRODUCTS page");
		}
		
		driver.findElement(By.id("search_product")).sendKeys("Blue Top");
		driver.findElement(By.id("submit_search")).click();
		
		String text2 = driver.findElement(By.xpath("(//p[text()='Blue Top'])[1]")).getText();
		System.out.println(text2);
		
		String blueTop="Blue Top";
		String cart1="Add to cart";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element0 = driver.findElement(By.xpath("//p[text()='"+blueTop+"']/..//a[text()='"+cart1+"']"));
		js.executeScript("arguments[0].click()", element0);

		String continueShopping="Continue Shopping";
		WebElement element1 = driver.findElement(By.xpath("//button[contains(text(),'"+continueShopping+"')]"));
		Thread.sleep(2000);
		element1.click();
		
		driver.findElement(By.partialLinkText("Cart")).click();
		String productName=driver.findElement(By.xpath("//a[text()='Blue Top']")).getText();
		System.out.println(productName+" displayed");
		
		driver.findElement(By.partialLinkText("Signup / Login")).click();
		String text = driver.findElement(By.xpath("//h2[text()='Login to your account']")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		driver.findElement(By.partialLinkText("Cart")).click();
		
		String productName1=driver.findElement(By.xpath("//a[text()='Blue Top']")).getText();
		System.out.println(productName1+" displayed");
		

	}

}
