package p;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReusableMethod {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.shoppersstack.com/products_page/15");
	Thread.sleep(15000);
	driver.findElement(By.id("compare")).click();
	 ReusableMethod.switchToWindow(driver,"Flipkart");
	 Point flipkartPosition=driver.manage().window().getPosition();
	 ReusableMethod.switchToWindow(driver,"ebay");
	 Point ebayPosition=driver.manage().window().getPosition();
	 switchToWindow(driver,"flipkart");
	 driver.manage().window().setPosition(ebayPosition);
	}
	 public static void switchToWindow(WebDriver driver, String url) {
		Set<String> allWindowIds= driver.getWindowHandles();
		for(String id:allWindowIds) {
		driver.switchTo().window(id);
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains(url)) {
			break;
		}
	 }

	 }
}


