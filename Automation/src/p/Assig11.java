package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assig11 {

	public static void main(String[] args) {
   WebDriver driver=new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   
   driver.get("https://demoapps.qspiders.com/");
   driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
   driver.findElement(By.linkText("Button")).click();
   driver.findElement(By.linkText("Right Click")).click();
   
   WebElement rightClick = driver.findElement(By.id("btn30"));
   Actions act=new Actions(driver);
   act.contextClick(rightClick).perform();
   
   driver.findElement(By.xpath("//div[text()='Yes']")).click();
   WebElement successMsg = driver.findElement(By.xpath("//span[text()='You selected \"Yes\"']"));
   System.out.println(successMsg.getText());
   System.out.println(successMsg.getCssValue("color"));
   
	}

}
