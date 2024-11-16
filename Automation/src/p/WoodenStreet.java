package p;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WoodenStreet {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   
		   driver.get("https://www.woodenstreet.com/");
		   driver.findElement(By.id("loginclose1")).click();
		   
		   driver.findElement(By.xpath("//img[@alt='Wooden Sofa Set Furniture']")).click();
		   driver.findElement(By.xpath("//img[@alt='Wooden Sofa Sets']")).click();
		   driver.findElement(By.xpath("//img[@alt='teak wood sofa | new sofa set | sofa online shopping | simple wooden sofa design']")).click();
		  
		  Set<String> allWindowId = driver.getWindowHandles();
		  
		  for(String id:allWindowId) {
			  driver.switchTo().window(id);
			  String url = driver.getCurrentUrl();
			  if(url.contains("https://www.woodenstreet.com/product/olympia-3-Seater-wooden-sofa-walnut-finish")) {
				  break;
			  }
		  }
		   
		   
		 WebElement cartButton = driver.findElement(By.xpath("//a[@id='button-cart-buy-now']"));
		   cartButton.click();
		 driver.findElement(By.xpath("(//img[@title='Quartz 3 Seater Wooden Sofa (Honey Irish Cream)'])[1]")).click();
		 driver.findElement(By.xpath("//a[@id='button-cart-buy-now']")).click();
		 driver.findElement(By.xpath("(//img[@alt='Quartz 3 Seater Wooden Sofa (Honey Irish Cream)'])[10]")).click();
		 driver.findElement(By.xpath("//a[@id='button-cart-buy-now']")).click();
		 driver.findElement(By.xpath("(//img[@alt='Winster 3 Seater Wooden Sofa (Honey Irish Cream)'])[1]")).click();
		 driver.findElement(By.xpath("//a[@id='button-cart-buy-now']")).click();
		   driver.findElement(By.xpath("//a[@title='Cart']")).click();
		   
		
		   
		   
		   List<WebElement> price = driver.findElements(By.xpath("//div[@class='price']"));
		   System.out.println(price.size());
		   
		   Set prices=new TreeSet<>();
		   for (WebElement priceElement:price) {
		   	String priceText = priceElement.getText();
		   	if(!priceText.isEmpty()) {
		   		prices.add(priceText);
		   	}
		   }	
		   	if(prices instanceof TreeSet) {
		   	Thread.sleep(20000);
		   //System.out.println(((TreeSet) prices).last());
		    Object highest = ((TreeSet) prices).last();		   	
		    driver.findElement(By.xpath("//strong[text()='"+highest+"']/../..//p[title='Remove']")).click();
		   	}
		   	
}
}
