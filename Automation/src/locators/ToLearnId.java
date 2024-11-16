package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnId {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demowebshop.tricentis.com/login");
	
	driver.findElement(By.id("Email")).sendKeys("test@gmail.com");
    driver.findElement(By.id("Password")).sendKeys("7562948741");
	}

}
