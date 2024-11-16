package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnXpathByTextFunction {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://www.instagram.com/");
		//driver.findElement(By.xpath("//div[text()='Log in']")).click();
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		

	}

}
