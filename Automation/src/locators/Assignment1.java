package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/register");
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("juhi");
		driver.findElement(By.id("LastName")).sendKeys("Singh");
		driver.findElement(By.id("Email")).sendKeys("juhi.kumari151996@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Juhisingh@15");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Juhisingh@15");
		driver.findElement(By.name("register-button")).click();
	}

}
