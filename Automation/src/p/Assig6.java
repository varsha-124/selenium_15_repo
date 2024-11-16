package p;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Assig6 {

	public static void main(String[] args) throws InterruptedException {
   WebDriver driver=new ChromeDriver();
   driver.manage().window().maximize();
   
   driver.get("https://www.abhibus.com/");
   Thread.sleep(2000);
   driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Hyderabad",Keys.ENTER);
   
  driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Bangalore",Keys.ENTER);
  
    // driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("//button[text()='Search']")).click();
   Thread.sleep(3000);
   
   driver.findElement(By.xpath("//div[text()='Bus Partner']")).click();
   Thread.sleep(7000);

   WebElement a = driver.findElement(By.xpath("//label[text()='BSR TOURS & TRAVELS']/..//input[@type='checkbox']"));
   a.click();
   
   Thread.sleep(3000);
  List<WebElement> buses = driver.findElements(By.tagName("h5"));
System.out.println(buses.size());

Thread.sleep(4000);
List<WebElement> price= driver.findElements(By.xpath("//strong[@class='h5 fare']"));
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
System.out.println(((TreeSet) prices).last());
}
	}
}


