package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnXpath {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demowebshop.tricentis.com/");

	driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("mobiles");
	driver.findElement(By.xpath("//input[@value='Search']")).click();

	}

}
