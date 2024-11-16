package p;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assig2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement username=driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys("Testing");
		
		WebElement password=driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("aghkld");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		
		String errorMsg=driver.findElement(By.xpath("(//span[text()='Invalid credentials'])[1]")).getText();
		System.out.println(errorMsg);
		if(errorMsg.contains("Invalid credentials")) {
			System.out.println("error msg is dispalyed");
		}
		else {
			System.out.println("error msg is not displayed");
		}
		
		String errorMsg1=driver.findElement(By.xpath("(//span[text()='Invalid credentials'])[1]")).getCssValue("color");
		System.out.println(errorMsg1);

	}

}
