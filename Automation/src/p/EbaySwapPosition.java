package p;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbaySwapPosition {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.shoppersstack.com/products_page/23");
		String parentId=driver.getWindowHandle();
		Thread.sleep(20000);
		driver.findElement(By.id("compare")).click();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains("flipkart")) {
				driver.manage().window().setPosition(new Point(750,250));
			}
			else if(currentUrl.contains("ebay")) {
				driver.manage().window().setPosition(new Point(60,250));
			}
		}
			
			
	}
}
	