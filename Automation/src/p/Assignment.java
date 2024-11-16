package p;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.facebook.com/reg/?next=%2FnopCommerce");
	driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Juhi");
	driver.findElement(By.name("lastname")).sendKeys("Singh");
	
	}
	}

