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
import org.openqa.selenium.interactions.Actions;

public class ViewCartBrandProducts {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
FileInputStream fis=new FileInputStream("./testdata/loginusercorrect.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		driver.get(url);
		driver.findElement(By.partialLinkText("Products")).click();
		String brand = driver.findElement(By.xpath("//h2[text()='Brands']")).getText();
		System.out.println(brand);
		if(brand.contains("BRANDS")) {
			System.out.println("Brands are visible on left side bar");
		}
		else {
			System.out.println("Brands are not visible on left side bar");
		}
		
		WebElement allProducts = driver.findElement(By.xpath("//h2[text()='All Products']"));
		Actions act=new Actions(driver);
		act.scrollToElement(allProducts).perform();
		
		
		String tshirt="Polo";
		WebElement tshirt1 = driver.findElement(By.xpath("//a[text()='"+tshirt+"']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", tshirt1);
		
		String brandPage = driver.getCurrentUrl();
		if(brandPage.contains("https://automationexercise.com/brand_products/Polo")) {
			System.out.println("navigated to brand page and brand products are displayed");
		}
		else {
			System.out.println("Not navigated to brand page and brand products are not displayed");
		}
		
		String tshirt2="H&M";
		WebElement tshirt3 = driver.findElement(By.xpath("//a[text()='"+tshirt2+"']"));
		js.executeScript("arguments[0].click()", tshirt3);
		
		String brandPage1 = driver.getCurrentUrl();
		if(brandPage1.contains("https://automationexercise.com/brand_products/H&M")) {
			System.out.println("navigated to that brand page and brand products are displayed");
		}
		else {
			System.out.println("Not navigated to that brand page and brand products are not displayed");
		}
		
		
		
	}

}
