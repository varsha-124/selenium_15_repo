package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathByContains {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.instagram.com/");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[contains(@aria-label,'username')]")).sendKeys("juhi.singh1511@gmail.com");
    driver.findElement(By.xpath("//span[contains(text(),'Contact Uploading')]")).click();
    driver.findElement(By.xpath("//span[contains(text(),'Instagram from Meta')]")).click();
	}

}
