package webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay {

	
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://www.shoppersstack.com/products_page/23");
			Thread.sleep(20000);
			driver.findElement(By.id("compare")).click();
			
			Set<String> allWindowIds = driver.getWindowHandles();
			for(String id:allWindowIds) {
				driver.switchTo().window(id);
				String currentUrl = driver.getCurrentUrl();
				if(currentUrl.contains("ebay")) {
					
		  Dimension size = driver.manage().window().getSize();
		    System.out.println(size);
				}
				
			}

		}

	}


