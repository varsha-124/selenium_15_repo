package webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartMax {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.shoppersstack.com/products_page/23");
		String parentId=driver.getWindowHandle();
		Thread.sleep(20000);
		driver.findElement(By.id("compare")).click();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains("flipkart")) {
				break;
			}
		}
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("mobiles");
		driver.close();
		
		driver.switchTo().window(parentId);
		driver.findElement(By.id("loginBtn")).click();

	}

}
