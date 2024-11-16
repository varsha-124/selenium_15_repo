package p;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign5 {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demoapp.skillrary.com/");
	
	WebElement subscribe = driver.findElement(By.xpath("//button[text()='Subscribe']"));
	System.out.println(subscribe.isEnabled());
	}

}
