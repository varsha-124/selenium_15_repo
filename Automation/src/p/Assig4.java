package p;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assig4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		
		WebElement subscribe = driver.findElement(By.id("newsletter-subscribe-button"));
		System.out.println(subscribe.isDisplayed());
		
	Point location = driver.findElement(By.id("newsletter-subscribe-button")).getLocation();
		System.out.println(location.getX());
		System.out.println(location.getY());
		
	}

}
