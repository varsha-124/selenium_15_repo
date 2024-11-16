package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnClear {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement userName=driver.findElement(By.name("username"));
		Thread.sleep(2000);
		userName.clear();
		Thread.sleep(2000);
		userName.sendKeys("testing");
		
		WebElement password=driver.findElement(By.name("password"));
		Thread.sleep(2000);
		password.clear();
		Thread.sleep(2000);
		password.sendKeys("Juhi@123");

	}

}
